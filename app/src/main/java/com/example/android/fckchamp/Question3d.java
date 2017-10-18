package com.example.android.fckchamp;

/**
 * Created by Johannes on 10.10.2017.
 */

public class Question3d extends QuestionData {

    private String question;
    private String correctAnswer;


    public Question3d(int questionType, String question, String correctAnswer) {
        super(questionType);
        this.question = question;
        this.correctAnswer = correctAnswer;
    }


    @Override
    public boolean questionHandler(){
        return true;
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
