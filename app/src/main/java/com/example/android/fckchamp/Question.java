package com.example.android.fckchamp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;

import android.os.Handler;

import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import org.w3c.dom.Text;

import layout.Question1;
import layout.Question2;
import layout.Question3;

import static android.R.attr.fragment;
import static android.os.Build.VERSION_CODES.M;


/**
 * Created by Johannes on 10.10.2017.
 */

public class Question extends AppCompatActivity {


    private ArrayList<QuestionData> questions = new ArrayList<QuestionData>();
    private int score = 0;
    private Handler handler = new Handler();
    private int questionCounter = 0;
    private TextView questionStatus;


    /**
     * This runnable is used to wait 3 secondes until the next question
     * gets displayed.
     */
    final Runnable runnable = new Runnable() {
        @Override
        public void run() {
            displayQuestion(questionCounter);
            questionStatus.setText(questionCounter + "/" + questions.size());

        }
    };

    /**
     * This runnable starts the score activity after all questions were answered.
     */

    final Runnable runnable2 = new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent (getApplicationContext(),Score.class);
            intent.putExtra("Score",(int) score);
            intent.putExtra("NumberOfQuestions",(int)questions.size());
            startActivity(intent);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parent_view);
        questionStatus = (TextView) findViewById(R.id.question_status);
        questionCreator();
        displayQuestion(questionCounter);
        questionStatus.setText(questionCounter + "/" + questions.size());
    }


    /**
     * Displays a Question on the Screen
     * depending on the Question Type
     *
     * @param question The question accesed in List Order
     */

    private void displayQuestion(int question) {
        QuestionData q = questions.get(question);
        if (q.getQuestionType() == 1) {
            Question1d currentQuestion = (Question1d) questions.get(question);
            TextView questionView = (TextView) findViewById(R.id.question1);
            questionView.setText(currentQuestion.getQuestion());
            changeFragmentToQtype1(currentQuestion);
        } else if (q.getQuestionType() == 2) {
            Question2d currentQuestion = (Question2d) questions.get(question);
            TextView questionView = (TextView) findViewById(R.id.question1);
            questionView.setText(currentQuestion.getQuestion());
            changeFragmentToQtype2(currentQuestion);
        } else {
            Question3d currentQuestion = (Question3d) questions.get(question);
            TextView questionView = (TextView) findViewById(R.id.question1);
            questionView.setText(currentQuestion.getQuestion());
            changeFragmentToQtype3(currentQuestion);
        }
        questionCounter = question + 1;
    }


    /**
     * This method is called from the Fragment (Question1, Question2) classes.
     * The implementation of the question is done there
     *
     * At the end the next Question gets displayed on the screen.
     *
     * @param answeredCorrectly boolean which is set in the Fragment classes
     */

    public void answeredCorrectly (boolean answeredCorrectly){
        if (answeredCorrectly){
            score +=1;
            Toast.makeText(this,"Richtige Antwort",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"Falsche Antwort",Toast.LENGTH_LONG).show();
        }
        if (questionCounter < questions.size()){
            handler.postDelayed(runnable,3000);
        }else{
            handler.postDelayed(runnable2,3000);

        }
    }

    /**
     * This method is called from the Fragment (Question3) class.
     * The implementation of the question is done there
     *
     * At the end the next Question gets displayed on the screen.
     *
     * @param answeredCorrectly boolean which is set in the Fragment classes
     */

    public void answeredCorrectly (boolean answeredCorrectly, String correctanswer){
        if (answeredCorrectly){
            score +=1;
            Toast.makeText(this,"Richtige Antwort",Toast.LENGTH_LONG).show();
        }else{
            String message = "Falsche Antwort -- Richtig: " + correctanswer;
            Toast.makeText(this,message,Toast.LENGTH_LONG).show();
        }
        if (questionCounter < questions.size()){
            handler.postDelayed(runnable,3000);
        }else{
            handler.postDelayed(runnable2,3000);

        }
    }


    /**
     *
     * this methods actually initialise the Fragment
     * and replaces the answer area depending in the Question TYpe
     * The logic if an anwer is correct or not is implemented in the Fragment classes
     * From there the method answeredCorrectly is called to receive the score.
     *
     * @param question
     */


    public void changeFragmentToQtype1 (Question1d question){
        String answera = question.getAnswerA();
        String answerb = question.getAnswerB();
        String answerc = question.getAnswerC();
        String answerd = question.getAnswerD();
        int correctanswer = question.getCorrectanswer();
        Question1 fragment1 = new Question1();
        fragment1.setAnswers (answera, answerb,answerc ,answerd, correctanswer);
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_place,fragment1);
        ft.commit();
    }

    public void changeFragmentToQtype2 (Question2d question){
        String answera = question.getAnswerA();
        String answerb = question.getAnswerB();
        String answerc = question.getAnswerC();
        String answerd = question.getAnswerD();
        boolean isACorrect = question.isACorrect();
        boolean isBCorrect = question.isBCorrect();
        boolean isCCorrect = question.isCCorrect();
        boolean isDCorrect = question.isDCorrect();
        Question2 fragment2 = new Question2();
        fragment2.setAnswers (answera, answerb,answerc ,answerd, isACorrect,isBCorrect,isCCorrect,isDCorrect);
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_place, fragment2);
        ft.commit();

    }

    public void changeFragmentToQtype3 (Question3d question){
        String correctAnswer = question.getCorrectAnswer();
        Question3 fragment3 = new Question3();
        fragment3.setAnswer(correctAnswer);
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_place, fragment3);
        ft.commit();

    }




    /**
     * creates all the questions which the App contains
     */


    private void questionCreator() {
        Question1d question1 = new Question1d(1, "Welcher Spieler war am 18. Mai fleißig wie gewohnt?", "Axel Bellinghausen", "Josh Simpson", "Stefan Lexa", "Georges Mandjeck", 1);
        Question2d question2 = new Question2d(2, "Welcher Spieler bildeten zumeist die Doppelspitze im Aufstiegsjahr unter Kurz?", "Adam Nemec", "Srdjan Lakic", "Erik Jendrisek", "Jiri Bilek", true, false, true, false);
        Question3d question3 = new Question3d(3, "Wie viele nationalen Titel hat der Fck?", "6");
        Question3d question4 = new Question3d(3, "Welche Rückennummer trug Erik Jendrisek?", "26");
        Question1d question5 = new Question1d(1, "Welche Nationalität hat Osayamen Osawe?", "Frankreich", "Nigeria", "England", "Burkina Faso", 3);
        Question1d question6 = new Question1d(1, "Warum wurde Ex Profi Marcelo Pletsch angeklagt?", "Drogenhandel", "Steuerhinterziehung", "Totschlag", "Drunkenheit am Steuer", 1);
        Question2d question7 = new Question2d(2, "Welche dieser Lautrer Spieler stammen aus Kamerun", "Jaques Zoua", "Dorge Kouemaha", "Mo Idrissou", "Lembi", true, true, true, false);
        Question3d question8 = new Question3d(3, "Wie ist das ofizielle Fassungsvermögen des Fritz Walter Stadions", "49780");
        Question2d question9 = new Question2d(2, "Welche Rückennummern trug Miro Klose bei Lautern und in der Nationalmannschaft?", "24", "11", "25", "18", false, true, true, true);
        Question1d question10 = new Question1d(1, "Welchem Verein gelang das Kunststück als Aufsteiger deutscher Meister zu werden?", "Erzgebirge Aue", "Waldhof Mannheim", "FCK", "Fc Bayern", 3);







        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        questions.add(question4);
        questions.add(question5);
        questions.add(question6);
        questions.add(question7);
        questions.add(question8);
        questions.add(question9);
        questions.add(question10);




    }



}