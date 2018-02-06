package com.beatricefarias.quizapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Random;

public class Questions extends AppCompatActivity {
    boolean correctAnswer;
    private int mScore = 0;
    private int mRandomIndex;
    private int mArrayListLength;
    private ArrayList<Integer> mIndexesOfClass;
    private boolean mClickableStatus = true;
    private QuizQuestions mQuestions = new QuizQuestions();
    private int mQuestionsLength = mQuestions.getQuestionsQuantity();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_activity);

        final TextView questionTextView = (TextView) findViewById(R.id.question_text_view);
        final TextView answerTextView = (TextView) findViewById(R.id.answer_text_view);
        final TextView answerStateTextView = (TextView) findViewById(R.id.answer_state_text_view);
        final Button trueButton = (Button) findViewById(R.id.button_true);
        final Button falseButton = (Button) findViewById(R.id.button_false);
        final Button nextButton = (Button) findViewById(R.id.button_next);


//        getDefaultRandomIndexAndListLength();
//        questionTextView.setText(mQuestions.getQuestion(mIndexesOfClass.get(mRandomIndex)));
//        answerTextView.setText("");
//        trueButton.setBackgroundResource(R.drawable.true_button);
//        falseButton.setBackgroundResource(R.drawable.false_button);
//        nextButton.setTextColor(Color.parseColor("#bc8c36"));

        setDefaultValues(questionTextView, answerTextView, trueButton, falseButton, nextButton,
                answerStateTextView);

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mClickableStatus && mArrayListLength != 0) {
                    mClickableStatus = false;
                    answerTextView.setText(mQuestions.getAnswer(mIndexesOfClass.get(mRandomIndex)));
                    correctAnswer = mQuestions.getCorrectAnswer(mIndexesOfClass.get(mRandomIndex));
                    if (correctAnswer == true){
                        answerStateTextView.setText("Correct");
                        answerStateTextView.setTextColor(Color.parseColor("#a7d163"));
                        mScore +=1;
                        Log.v("Correct", "Score is: " + mScore);
                    } else {
                        answerStateTextView.setText("Wrong");
                        answerStateTextView.setTextColor(Color.parseColor("#ff6f6f"));
                    }
                    removeUsedQuestion(mIndexesOfClass, mRandomIndex);
                    mRandomIndex = getRandomIndex(mArrayListLength);

                    trueButton.setEnabled(false);
                    falseButton.setEnabled(false);
                    falseButton.getBackground().setAlpha(180);
                    trueButton.getBackground().setAlpha(180);
                    nextButton.setEnabled(true);
                    nextButton.setTextColor(Color.parseColor("#FFE500"));
                    if (mArrayListLength == 0) {
                        nextButton.setText("Finish");
                    }
                }
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mClickableStatus && mArrayListLength != 0) {
                    mClickableStatus = false;
                    answerTextView.setText(mQuestions.getAnswer(mIndexesOfClass.get(mRandomIndex)));
                    correctAnswer = mQuestions.getCorrectAnswer(mIndexesOfClass.get(mRandomIndex));
                    if (correctAnswer == false){
                        answerStateTextView.setText("Correct");
                        answerStateTextView.setTextColor(Color.parseColor("#a7d163"));
                        mScore +=1;
                        Log.v("Correct", "Score is: " + mScore);
                    } else {
                        answerStateTextView.setText("Wrong");
                        answerStateTextView.setTextColor(Color.parseColor("#ff6f6f"));
                    }
                    removeUsedQuestion(mIndexesOfClass, mRandomIndex);
                    mRandomIndex = getRandomIndex(mArrayListLength);
                    trueButton.setEnabled(false);
                    falseButton.setEnabled(false);
                    falseButton.getBackground().setAlpha(180);
                    trueButton.getBackground().setAlpha(180);
                    nextButton.setEnabled(true);
                    nextButton.setTextColor(Color.parseColor("#FFE500"));
                    if (mArrayListLength == 0) {
                        nextButton.setText(">> Finish");
                    }
                }
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mClickableStatus && mArrayListLength != 0) {
                    questionTextView.setText(mQuestions.getQuestion(mIndexesOfClass.get(mRandomIndex)));
                    answerTextView.setText("");
                    answerStateTextView.setText("");
                    nextButton.getBackground().setAlpha(150);
                    nextButton.setTextColor(Color.parseColor("#bc8c36"));
                    mClickableStatus = true;
                    trueButton.setEnabled(true);
                    falseButton.setEnabled(true);

                    nextButton.setEnabled(false);

                    falseButton.getBackground().setAlpha(255);
                    trueButton.getBackground().setAlpha(255);
                }
                if (!mClickableStatus && mArrayListLength == 0) {
                    Intent startScoreActivity = new Intent (Questions.this, ScoreActivity.class);
                    startScoreActivity.putExtra("score", mScore);
                    startActivity(startScoreActivity);
                    finish();
                }
            }
        });
    }

    private int getRandomIndex(int arrayListLength) {
        int randInt;
        Random randomInteger = new Random();
        if (arrayListLength > 1) {
            randInt = randomInteger.nextInt(arrayListLength - 1);
        } else {
            randInt = 0;
        }
        return randInt;
    }

    private void removeUsedQuestion(ArrayList indexOfClass, int usedQuestionIndex) {
        indexOfClass.remove(usedQuestionIndex);
        mArrayListLength = indexOfClass.size();
    }

    private void getDefaultRandomIndexAndListLength() {
        mIndexesOfClass = new ArrayList<>();
        for (int i = 0; i < mQuestionsLength; i++) {
            mIndexesOfClass.add(i);
        }
        mArrayListLength = mIndexesOfClass.size();
        mRandomIndex = getRandomIndex(mArrayListLength);
    }

    private void setDefaultValues(TextView questionTextView, TextView answerTextView,
                                  Button trueButton, Button falseButton, Button nextButton,
                                  TextView answerStateTextView){
        answerStateTextView.setText("");
        getDefaultRandomIndexAndListLength();
        questionTextView.setText(mQuestions.getQuestion(mIndexesOfClass.get(mRandomIndex)));
        answerTextView.setText("");
        trueButton.setBackgroundResource(R.drawable.true_button);
        falseButton.setBackgroundResource(R.drawable.false_button);
        nextButton.setTextColor(Color.parseColor("#bc8c36"));
    }

}


