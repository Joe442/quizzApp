package com.example.android.fckchamp;


/**
 * Created by Johannes on 10.10.2017.
 */
public abstract class QuestionData {

    /**
     * question type 0: parent_view
     * qustion type 1: various_correct_answers
     * qustion type 2: text_answer
     */
    private int questionType;

    public QuestionData (int questionType){
        this.questionType=questionType;
    }



    public int getQuestionType() {
        return questionType;
    }

    public abstract boolean questionHandler();




}
