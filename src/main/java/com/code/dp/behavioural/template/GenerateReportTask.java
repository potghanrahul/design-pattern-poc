package com.code.dp.behavioural.template;

public class GenerateReportTask extends Task {
    public GenerateReportTask(AuditRecord auditRecord) {
        super(auditRecord);
    }

    @Override
    protected void doExecute() {
        System.out.println("GenerateReportTask.doExecute");
    }
}
