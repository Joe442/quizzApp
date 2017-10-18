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
import android.widget.EditText;

import com.example.android.fckchamp.Question;
import com.example.android.fckchamp.R;


public class Question3 extends Fragment {

    private String correctAnswer;
    private Button submitAnswer;
    private boolean answeredCorrectly = false;
    private EditText submittedAnswerTextField;

    public Question3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question3, container, false);

        submitAnswer = (Button) view.findViewById(R.id.submit3);
        submittedAnswerTextField = (EditText) view.findViewById(R.id.text_answer);

        submitAnswer.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                String submittedAnswer = submittedAnswerTextField.getText().toString();

                if (correctAnswer.equals(submittedAnswer)){
                    answeredCorrectly = true;
                }

                v.setEnabled(false);

                displayCorrectAnswer (answeredCorrectly);
                ((Question)getActivity()).answeredCorrectly(answeredCorrectly,correctAnswer);


            }
        });

        return view;

    }

    public void displayCorrectAnswer(boolean a){
        if (a){
            submittedAnswerTextField.setBackgroundColor(Color.GREEN);
        }else{
            submittedAnswerTextField.setBackgroundColor(Color.RED);
        }
    }

    public void setAnswer (String correctAnswer){
        this.correctAnswer = correctAnswer;
    }




}
