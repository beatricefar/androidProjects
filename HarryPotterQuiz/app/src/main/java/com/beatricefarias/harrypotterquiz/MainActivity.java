package com.beatricefarias.harrypotterquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


// get selected checkboxes.
// see if these selected checkboxes have any that is not a correct answer
//      if one that was not answer, break loop and no score
// see if selected checkboxes had all the correct answers
//      if yes, then a score. else 0.

public class MainActivity extends AppCompatActivity {

    int score = 0;
    String mWizardName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRadioListeners(allRadioGroups);
        setCheckboxListeners(allCheckboxes);

        Button showResultButton = (Button) findViewById(R.id.show_result_button);

        //Log.v("Wizard name", "Wizard name is " + mWizardName);
        TextView scoreView = (TextView) findViewById(R.id.score_text_view);
        TextView scoreTitle = (TextView) findViewById(R.id.score_title_text_view);
        TextView scoreMessageTextView = (TextView) findViewById(R.id.score_message);

        scoreTitle.setVisibility(View.GONE);
        scoreView.setVisibility(View.GONE);
        scoreMessageTextView.setVisibility(View.GONE);

        final EditText wizzardNameInput = setWizardNameListener();
        //Log.v("Wizard name", "Wizard name is " + mWizardName);

        showResultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score = 0;

                boolean leaveLoop = false;
                boolean isCorrect = false;
                int numCorrectChecks = 0;

                for (int radioGroupId : allRadioGroups) {
                    RadioGroup radioGroup = (RadioGroup) findViewById(radioGroupId);
                    int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                    for (int correctAnswerId : correctAnswersRadio) {
                        if (correctAnswerId == checkedRadioButtonId) {
                            score += 1;
                            //Log.v("Score", "Score radio buttons:" + score);
                            //Log.v("Score after buttons", "Score " + score);
                        }
                    }

                    //Log.v("Score after buttons", "Score " + score);

                    for (int checkboxId : allCheckboxes) {
                        if (leaveLoop == true) {
                            break;
                        }

                        CheckBox checkbox = (CheckBox) findViewById(checkboxId);
                        boolean checkboxIsChecked = checkbox.isChecked();

                        isCorrect = false;

                        if (checkboxIsChecked) {
                            for (int correctAnswer : correctAnswersCheckboxes) { // was a correct answer, so we continue to the next.
                                if (correctAnswer == checkboxId) {
                                    isCorrect = true;
                                    numCorrectChecks += 1;
                                }
                            }
                            if(isCorrect == false)
                            {
                                //the selected checkbox does not match any of the correct answers. So it is wrong.
                                leaveLoop = true;
                            }
                        }

                        if (!checkboxIsChecked) {
                            for (int correctAnswer : correctAnswersCheckboxes) { // was a correct answer, so we continue to the next.
                                if (correctAnswer == checkboxId) {
                                    leaveLoop = true;
                                }
                            }
                        }

                    }
                    //Log.v("Number", "Number of correct checks: " + numCorrectChecks);
                    //Log.v("Correct answers", "Number of correct answers: " + correctAnswersCheckboxes.length);
                    //Log.v("Leave loop", "Leave loop state: " + leaveLoop);
                    if(numCorrectChecks == correctAnswersCheckboxes.length && leaveLoop == false) {
                        //Log.v("Score before checkbox", "Score " + score);
                        score += 1;

                    }
                }
                //Log.v("Score", "Score " + score);

                mWizardName = wizzardNameInput.getText().toString();

                TextView scoreTitle = (TextView) findViewById(R.id.score_title_text_view);

                TextView scoreView = (TextView) findViewById(R.id.score_text_view);
                scoreView.setText(score + "/7");

                TextView scoreMessageTextView = (TextView) findViewById(R.id.score_message);
                scoreMessageTextView.setText("Congratulations " + mWizardName + " you have got " + score +"/7 questions right!");

                scoreTitle.setVisibility(View.VISIBLE);
                scoreView.setVisibility(View.VISIBLE);
                scoreMessageTextView.setVisibility(View.VISIBLE);



            }
        });

    }



    int totalAnsweredQuestions = 0;

    private int[] allRadioGroups = {
            R.id.question_1_radio_group,
            R.id.question_3_radio_group,
            R.id.question_4_radio_group,
            R.id.question_5_radio_group,
            R.id.question_6_radio_group,
            R.id.question_7_radio_group
    };

    private int[] allCheckboxes = {
            R.id.question_2_a,
            R.id.question_2_b,
            R.id.question_2_c,
            R.id.question_2_d
    };

    private int[] correctAnswersRadio = {
            R.id.question_1_a,
            R.id.question_3_c,
            R.id.question_4_b,
            R.id.question_5_c,
            R.id.question_6_c,
            R.id.question_7_c
    };

    private int[] correctAnswersCheckboxes = {
            R.id.question_2_b,
            R.id.question_2_d,
    };


    private void setRadioListeners(int[] allRadioGroups) {
        for (int radioGroupId : allRadioGroups) {

            final RadioGroup radioGroup = (RadioGroup) findViewById(radioGroupId);

            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                    //Log.v("Answered questions", "Checked button ID :" + checkedRadioButtonId);

                    // compare if selected button matches a correct answer


                    // Increments total answered questions +1
                    //totalAnsweredQuestions += 1;
                    //Log.v("Answered questions", "Answered questions :" + totalAnsweredQuestions);
                    // Toast of answered questions
                }
            });
        }

    }

    private void setCheckboxListeners(int[] allCheckboxes) {
        for (int checkboxId : allCheckboxes) {

            final CheckBox checkbox = (CheckBox) findViewById(checkboxId);

            checkbox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }

    }

    private EditText setWizardNameListener(){
        final EditText wizardNameInput = (EditText) findViewById(R.id.wizzard_name_input);
        wizardNameInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        return wizardNameInput;
    }
}
