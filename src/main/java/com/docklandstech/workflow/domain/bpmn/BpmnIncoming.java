package com.docklandstech.workflow.domain.bpmn;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

import java.util.Collections;
import java.util.List;

@JacksonXmlRootElement(namespace = "bpmn", localName = "incoming")
public class BpmnIncoming implements AbstractBpmnGraphElement {

  public BpmnIncoming(String value) {
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
    return Collections.singletonList(this.value);
  }
}
