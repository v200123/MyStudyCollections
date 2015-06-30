package com.cheerdev.geoquiz;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends Activity {
    private Button mTrueButton;
    private Button mFalseButton;
    private ImageButton mNextButton;
    private ImageButton mBackButton;
    private TextView mQuestionTextView;

    private TrueFalse[ ] mQuestionBank = new TrueFalse[ ]{
            new TrueFalse(R.string.question_oceans,true),
            new TrueFalse(R.string.question_mideast,false),
            new TrueFalse(R.string.question_africa,false),
            new TrueFalse(R.string.question_americas,true),
            new TrueFalse(R.string.question_asia,true),
    };
    private int mCurrentIndex = 0;

    private void updateQuestion( ){
        int question = mQuestionBank[mCurrentIndex].getQuestion();
        mQuestionTextView.setText(question);
    }

    private void checkAnswer(boolean userPressedTrue){
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isTrueQuestion();
        int messageResId = 0;
        if(userPressedTrue == answerIsTrue){
            messageResId = R.string.correct_toast;
        }else{
            messageResId = R.string.incorrect_toast;
        }
        Toast.makeText(this,messageResId,Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_button);
        mQuestionTextView = (TextView)findViewById(R.id.question_text_view);
     //   int question = mQuestionBank[mCurrentIndex].getQuestion();
     //   mQuestionTextView.setText(question);

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
     //           Toast.makeText(QuizActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
                checkAnswer(true);
            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
    //            Toast.makeText(QuizActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
                checkAnswer(false);
            }
        });

        mNextButton = (ImageButton)findViewById(R.id.next_button2);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentIndex = (mCurrentIndex +1) % mQuestionBank.length;
     //           int question = mQuestionBank[mCurrentIndex].getQuestion();
     //           mQuestionTextView.setText(question);
                updateQuestion();
            }
        });
        updateQuestion();

        //挑战练习1

        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        mQuestionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentIndex=(mCurrentIndex +1) % mQuestionBank.length;

            }
        });
        updateQuestion();

        //挑战练习2

        mBackButton = (ImageButton) findViewById(R.id.back_button2);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mCurrentIndex % mQuestionBank.length == 0){
                    mCurrentIndex = mQuestionBank.length - 1;
                }else{
                    mCurrentIndex=(mCurrentIndex -1) % mQuestionBank.length;
                }
                updateQuestion();
            }
        });

    }
}
