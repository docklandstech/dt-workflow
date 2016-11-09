package com.docklandstech.workflow.domain.bpmn;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(namespace = "bpmn", localName = "endEvent")
public class BpmnEndEvent implements AbstractBpmnGraphElement {
  @JacksonXmlProperty(isAttribute = true)
  public String id;
  @JacksonXmlProperty(isAttribute = true)
  public String name;
  @JacksonXmlProperty(namespace = "bpmn", localName = "incoming")
  public BpmnIncoming incoming;

  @Override
  public String getId() {
    return id;
  }

  @Override
  public List<String> getNextTaskIDs() {
    throw new UnsupportedOperationException("An end event can't have next tasks");
  }
}
