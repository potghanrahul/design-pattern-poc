package com.code.dp.behavioural.template;

public abstract class Task {
    private final AuditRecord auditRecord;

    protected Task(AuditRecord auditRecord) {
        this.auditRecord = auditRecord;
    }

    public void execute() {
        auditRecord.record();
        doExecute();
    }

    protected abstract void doExecute();
}
