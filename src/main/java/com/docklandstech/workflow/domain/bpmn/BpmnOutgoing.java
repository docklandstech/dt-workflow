package com.docklandstech.workflow.domain.bpmn;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

import java.util.List;

@JacksonXmlRootElement(namespace = "bpmn", localName = "outgoing")
public class BpmnOutgoing implements AbstractBpmnGraphElement {

  public BpmnOutgoing(String value) {
    this.value = value;
  }

  @JacksonXmlText()
  public String value;


  @Override
  public String getId() {
    return "";
  }

  @Override
  public List<String> getNextTaskIDs() {
    throw new UnsupportedOperationException("A sequence flow can't have outgoing links.");
  }
}
