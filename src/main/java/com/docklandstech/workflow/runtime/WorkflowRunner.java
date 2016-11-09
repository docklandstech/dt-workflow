package com.docklandstech.workflow.runtime;

import com.docklandstech.workflow.domain.InMemoryGraph;
import com.docklandstech.workflow.domain.bpmn.AbstractBpmnGraphElement;
import com.docklandstech.workflow.domain.bpmn.BpmnEndEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.*;

public class WorkflowRunner {
    private InMemoryGraph graph;
    private final Logger logger = LoggerFactory.getLogger(WorkflowRunner.class);
    private final Queue taskQueue = new LinkedBlockingQueue();

    public WorkflowRunner(InMemoryGraph graph) {
        this.graph = graph;
    }

    public void run() {
        //TODO Make connected tasks wait for one another. Maybe use CompletableFutures?

        taskQueue.add(graph.getStartTask());
        AbstractBpmnGraphElement currentTask = graph.getStartTask();

        List<Future<Integer>> scripts = new LinkedList<>();
        ExecutorService executor = Executors.newFixedThreadPool(2);

        while (!(currentTask instanceof BpmnEndEvent)) {
            System.out.println("currentTask = " + currentTask.getClass());
            String name = currentTask.getId();
            Callable<Integer> script = () -> {
                String threadName = Thread.currentThread().getName();
                logger.info("Thread name: {}. Task Title: {}", threadName, name);
                Thread.sleep(1000); //FixMe We shouldn't use sleeps in code
                return 1;
            };
            scripts.add(executor.submit(script));
            String sequenceFlowId = currentTask.getNextTaskIDs().get(0);
            AbstractBpmnGraphElement sequenceFlow = graph.getGraphNodes().get(sequenceFlowId); //FixMe do a foreach, to cover multiple outgoing tasks from gateways
            String nextTaskId = sequenceFlow.getNextTaskIDs().get(0);
            currentTask = graph.getGraphNodes().get(nextTaskId);
        }
    }
}
