package layout;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;

import com.example.android.fckchamp.Question;
import com.example.android.fckchamp.R;


public class Question2 extends Fragment {


    String answeraString, answerbString, answercString, answerdString;
    boolean isACorrect, isBCorrect, isCCorrect, isDCorrect;
    CheckBox answera, answerb, answerc, answerd;
    Button submitAnswer;

    boolean answeredCorrectly = true;

    public Question2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question2, container, false);
        answera = (CheckBox) view.findViewById(R.id.option_a);
        answerb = (CheckBox) view.findViewById(R.id.option_b);
        answerc = (CheckBox) view.findViewById(R.id.option_c);
        answerd = (CheckBox) view.findViewById(R.id.option_d);
        submitAnswer = (Button) view.findViewById(R.id.submit2);

        answera.setText(answeraString);
        answerb.setText(answerbString);
        answerc.setText(answercString);
        answerd.setText(answerdString);



        // this onClickListener submits the answer and calls the answeredCorrectly Method in
        // the QuestionClass

        submitAnswer.setOnClickListener(new View.OnClickListener(){



            @Override
            public void onClick(View v){

                if (answera.isChecked() && (!(isACorrect))){
                    answeredCorrectly = false;
                }
                if (answerb.isChecked() && (!(isBCorrect))){
                    answeredCorrectly = false;
                }
                if (answerc.isChecked() && (!(isCCorrect))){
                    answeredCorrectly = false;
                }
                if (answerd.isChecked() && (!(isDCorrect))){
                    answeredCorrectly = false;
                }
                if ((!answera.isChecked()) && (isACorrect)){
                    answeredCorrectly = false;
                }
                if (!(answerb.isChecked()) && (isBCorrect)){
                    answeredCorrectly = false;
                }
                if (!(answerc.isChecked()) && (!(isCCorrect))){
                    answeredCorrectly = false;
                }
                if (!(answerd.isChecked()) && (isDCorrect)){
                    answeredCorrectly = false;
                }
                if ((!(answera.isChecked())) && (!(answerb.isChecked())) && (!(answerc.isChecked())) && (!(answerd.isChecked()))){
                    answeredCorrectly = false;
                }

                v.setEnabled(false);
                answera.setEnabled(false);
                answerb.setEnabled(false);
                answerc.setEnabled(false);
                answerd.setEnabled(false);

                displayCorrectAnswer (isACorrect,isBCorrect,isCCorrect,isDCorrect);
                ((Question)getActivity()).answeredCorrectly(answeredCorrectly);


            }
        });



        return  view;
    }

    /**
     * This method makes the correct answers green
     *
     */

    private void displayCorrectAnswer(boolean a, boolean b, boolean c, boolean d) {
        if (a){
            answera.setBackgroundColor(Color.GREEN);
        }
        if (b) {
            answerb.setBackgroundColor(Color.GREEN);
        }
        if (c) {
            answerc.setBackgroundColor(Color.GREEN);
        }
        if (d){
            answerd.setBackgroundColor(Color.GREEN);
        }
    }

    /**
     * Set Answers is called from Question class to initialize a Question1
     * @param a  Answer a
     * @param b  Answer b
     * @param c  Answer c
     * @param d  Answer d
     * booleans CorrectAnswers
     */
    public void setAnswers(String a, String b, String c, String d, boolean isACorrect, boolean isBCorrect, boolean isCCorrect, boolean isDCorrect){
        this.answeraString = a;
        this.answerbString = b;
        this.answercString = c;
        this.answerdString= d;
        this.isACorrect = isACorrect;
        this.isBCorrect = isBCorrect;
        this.isCCorrect = isCCorrect;
        this.isDCorrect = isDCorrect;
    }



}
