package com.code.dp.behavioural.template;

public class TransferMoneyTask extends Task {
    public TransferMoneyTask(AuditRecord auditRecord) {
        super(auditRecord);
    }

    @Override
    protected void doExecute() {
        System.out.println("TransferMoneyTask.doExecute");
    }
}
