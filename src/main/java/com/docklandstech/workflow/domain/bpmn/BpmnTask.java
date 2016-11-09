package com.docklandstech.workflow.domain.bpmn;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.Collections;
import java.util.List;

@JacksonXmlRootElement(namespace = "bpmn", localName = "tasks")
public class BpmnTask implements AbstractBpmnGraphElement {
  @JacksonXmlProperty(isAttribute = true)
  public String id;
  @JacksonXmlProperty(isAttribute = true)
  public String name;
  //FixMe https://github.com/docklandstech/dt-workflow/issues/22
  @JacksonXmlProperty(namespace = "bpmn", localName = "incoming")
  public BpmnIncoming incoming;
  @JacksonXmlProperty(namespace = "bpmn", localName = "outgoing")
  public BpmnOutgoing outgoing;

  @Override
  public String getId() {
    return id;
  }

  @Override
  public List<String> getNextTaskIDs() {
    return Collections.singletonList(outgoing.value);
  }
}
