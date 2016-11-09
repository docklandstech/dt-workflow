package com.docklandstech.workflow.domain.bpmn;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;
import java.util.stream.Collectors;

@JacksonXmlRootElement(namespace = "bpmn", localName = "exclusiveGateway")
public class BpmnExclusiveGateway implements AbstractBpmnGraphElement {
  @JacksonXmlProperty(isAttribute = true)
  public String id;
  @JacksonXmlProperty(isAttribute = true)
  public String name;
  @JacksonXmlProperty(namespace = "bpmn", localName = "incoming")
  @JacksonXmlElementWrapper(useWrapping = false)
  public List<BpmnIncoming> incomingFlows;
  @JacksonXmlProperty(namespace = "bpmn", localName = "outgoing")
  @JacksonXmlElementWrapper(useWrapping = false)
  public List<BpmnOutgoing> outgoingFlows;

  @Override
  public String getId() {
    return id;
  }

  @Override
  public List<String> getNextTaskIDs() {
    return outgoingFlows.stream().map(x -> x.value).collect(Collectors.toList());
  }
}
