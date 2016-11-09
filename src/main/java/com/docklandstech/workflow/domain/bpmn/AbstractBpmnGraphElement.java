package com.docklandstech.workflow.domain.bpmn;

import java.util.List;

public interface AbstractBpmnGraphElement {
  String getId();
  List<String> getNextTaskIDs();
}
