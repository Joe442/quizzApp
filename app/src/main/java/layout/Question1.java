package layout;

;

import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.android.fckchamp.Question;
import com.example.android.fckchamp.R;

public class Question1 extends Fragment {

    String answeraString, answerbString, answercString, answerdString;
    int correctAnswer;
    RadioButton answera, answerb, answerc, answerd;
    Button submitAnswer;

    boolean answeredCorrectly = false;

    public Question1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question1, container, false);
        answera = (RadioButton) view.findViewById(R.id.answer_a);
        answerb = (RadioButton) view.findViewById(R.id.answer_b);
        answerc = (RadioButton) view.findViewById(R.id.answer_c);
        answerd = (RadioButton) view.findViewById(R.id.answer_d);
        submitAnswer = (Button) view.findViewById(R.id.submit1);

        answera.setText(answeraString);
        answerb.setText(answerbString);
        answerc.setText(answercString);
        answerd.setText(answerdString);

        // The OnCick listeners for the radio buttons
        // are made to implement that only one answer can be
        // selected

        answera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answera.setChecked(true);
                answerb.setChecked(false);
                answerc.setChecked(false);
                answerd.setChecked(false);
            }
        });

        answerb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerb.setChecked(true);
                answera.setChecked(false);
                answerc.setChecked(false);
                answerd.setChecked(false);
            }
        });


        answerc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerc.setChecked(true);
                answerb.setChecked(false);
                answera.setChecked(false);
                answerd.setChecked(false);
            }
        });


        answerd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerd.setChecked(true);
                answerb.setChecked(false);
                answerc.setChecked(false);
                answera.setChecked(false);
            }
        });

        // this onClickListener submits the answer and calls the answeredCorrectly Method in
        // the QuestionClass

        submitAnswer.setOnClickListener(new View.OnClickListener(){



            @Override
            public void onClick(View v){
                if (answera.isChecked() && (correctAnswer == 1)){
                    answeredCorrectly = true;
                }
                else if (answerb.isChecked() && (correctAnswer == 2)){
                    answeredCorrectly = true;
                }
                else if (answerc.isChecked() && (correctAnswer == 3)){
                    answeredCorrectly = true;
                }else if (answerd.isChecked() && (correctAnswer == 4)){
                    answeredCorrectly = true;
                }

                v.setEnabled(false);
                answera.setEnabled(false);
                answerb.setEnabled(false);
                answerc.setEnabled(false);
                answerd.setEnabled(false);

                displayCorrectAnswer (answeredCorrectly);
                ((Question)getActivity()).answeredCorrectly(answeredCorrectly);


            }
    });



        return  view;
    }

    /**
     * This method makes the correct answer green
     * @param answeredCorrectly
     */

    private void displayCorrectAnswer(boolean answeredCorrectly) {
        if (correctAnswer == 1){
            answera.setBackgroundColor(Color.GREEN);
        }else if (correctAnswer == 2) {
            answerb.setBackgroundColor(Color.GREEN);
        }else if (correctAnswer == 3) {
            answerc.setBackgroundColor(Color.GREEN);
        }else {
            answerd.setBackgroundColor(Color.GREEN);
        }
    }

    /**
     * Set Answers is called from Question class to initialize a Question1
     * @param a  Answer a
     * @param b  Answer b
     * @param c  Answer c
     * @param d  Answer d
     * @param correctanswer CorrectAnswer
     */
    public void setAnswers(String a, String b, String c, String d, int correctanswer){
        answeraString = a;
        answerbString = b;
        answercString = c;
        answerdString= d;
        correctAnswer = correctanswer;
    }





}
