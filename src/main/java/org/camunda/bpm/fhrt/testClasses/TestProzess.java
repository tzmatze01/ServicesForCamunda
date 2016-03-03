package org.camunda.bpm.fhrt.testClasses;

import org.camunda.bpm.application.ProcessApplication;
import org.camunda.bpm.application.impl.ServletProcessApplication;

@ProcessApplication("Loan Approval App")
public class TestProzess extends ServletProcessApplication {}