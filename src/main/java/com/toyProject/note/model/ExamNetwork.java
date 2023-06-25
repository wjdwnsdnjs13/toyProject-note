package com.toyProject.note.model;

import lombok.Data;

@Data
public class ExamNetwork {
    private int examId;
    private String examDescription;
    private int examType;
    private String answer;

    public ExamNetwork(){}
    public ExamNetwork(String examDescription, int examType, String answer){
        this.examDescription = examDescription;
        this.examType = examType;
        this.answer = answer;
    }


}
