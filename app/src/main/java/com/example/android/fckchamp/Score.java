package com.example.android.fckchamp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Johannes on 13.10.2017.
 */

public class Score extends AppCompatActivity {

    private TextView scoreTextView;
    private int score;
    private int numerOfQuestions;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score);
        scoreTextView = (TextView) findViewById(R.id.score_status);
        Bundle extras = getIntent().getExtras();
        score = extras.getInt("Score",0);
        numerOfQuestions = extras.getInt("NumberOfQuestions",0);
        String message = "Du hast " + score + "/" + numerOfQuestions + " Fragen richtig beantwortet! Vielen Dank";
        scoreTextView.setText(message);
    }
}
