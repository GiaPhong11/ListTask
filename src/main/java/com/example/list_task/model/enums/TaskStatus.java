package com.example.list_task.model.enums;

public enum TaskStatus {
    OPEN("Open"),
    IN_PROGRESS("Inprogress"),
    DONE("Done" );

    private final String code;

    TaskStatus(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}


