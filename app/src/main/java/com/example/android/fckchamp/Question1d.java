package com.example.android.fckchamp;


import android.widget.Button;

/**
 * Created by Johannes on 10.10.2017.
 * Question with only one correct answer
 *
 */

public class Question1d extends QuestionData {


    private String question;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;

    /**
     * 1-4 means a-d
     */
    private int correctanswer;

    public Question1d(int questionType, String question, String answerA, String answerB, String answerC, String answerD, int correctanswer) {
        super(questionType);
        this.question = question;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.correctanswer = correctanswer;
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

    public int getCorrectanswer() {
        return correctanswer;
    }





}
