package com.example.appkajava1;

public class Question {
    private int questionId;
    private boolean trueAnswer;

    public Question(int questionId,boolean trueAnswer)
    {
        this.trueAnswer=trueAnswer;
        this.questionId=questionId;
    }
    public boolean isTrue()
    {
        return this.trueAnswer;
    }

    public int getQuestionId() {
        return questionId;
    }
}
