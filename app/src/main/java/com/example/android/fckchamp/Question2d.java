package com.example.android.fckchamp;



/**
 * Created by Johannes on 10.10.2017.
 */

public class Question2d extends QuestionData {


    private String question;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;


    private boolean isACorrect;
    private boolean isBCorrect;
    private boolean isCCorrect;
    private boolean isDCorrect;


    public Question2d(int questionType, String question, String answerA, String answerB, String answerC, String answerD, boolean isACorrect, boolean isBCorrect, boolean isCCorrect, boolean isDCorrect) {
        super(questionType);
        this.question = question;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.isACorrect = isACorrect;
        this.isBCorrect = isBCorrect;
        this.isCCorrect = isCCorrect;
        this.isDCorrect= isDCorrect;
    }

    @Override
    public boolean questionHandler(){
        return true;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswerA() {
        return answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public boolean isACorrect() {
        return isACorrect;
    }

    public boolean isBCorrect() {
        return isBCorrect;
    }

    public boolean isCCorrect() {
        return isCCorrect;
    }

    public boolean isDCorrect() {
        return isDCorrect;
    }
}