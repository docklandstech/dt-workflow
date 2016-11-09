package com.docklandstech.workflow.domain.bpmn;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.Collections;
import java.util.List;

@JacksonXmlRootElement(namespace = "bpmn", localName = "sequenceFlow")
public class BpmnSequenceFlow implements AbstractBpmnGraphElement {
  @JacksonXmlProperty(isAttribute = true)
  public String id;
  @JacksonXmlProperty(isAttribute = true)
  public String sourceRef;
  @JacksonXmlProperty(isAttribute = true)
  public String targetRef;

  @Override
  public String getId() {
    return id;
  }

  @Override
  public List<String> getNextTaskIDs() {
    return Collections.singletonList(this.targetRef);
  }
}
