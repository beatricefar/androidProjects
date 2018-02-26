package com.beatricefarias.harrypotterquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int score;
    private String mWizardName;
    private EditText wizardNameInput;
    private TextView scoreView;
    private TextView scoreTitle;
    private TextView scoreMessageTextView;
    private EditText booksCountInput;

    /**
     * An array of all radio button group ids in order
     */
    private int[] allRadioGroups = {
            R.id.question_1_radio_group,
            R.id.question_3_radio_group,
            R.id.question_4_radio_group,
            R.id.question_5_radio_group,
            R.id.question_6_radio_group,
            R.id.question_7_radio_group
    };

    /**
     * An array of all checkboxes ids in order
     */
    private int[] allCheckboxes = {
            R.id.question_2_a,
            R.id.question_2_b,
            R.id.question_2_c,
            R.id.question_2_d
    };

    /**
     * An array of corect radio button answers in order
     */
    private int[] correctAnswersRadio = {
            R.id.question_1_a,
            R.id.question_3_c,
            R.id.question_4_b,
            R.id.question_5_c,
            R.id.question_6_c,
            R.id.question_7_c
    };

    /**
     * Correct checkboxes answers array
     */
    private int[] correctAnswersCheckboxes = {
            R.id.question_2_b,
            R.id.question_2_d,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button showResultButton = (Button) findViewById(R.id.show_result_button);

        scoreView = (TextView) findViewById(R.id.score_text_view);
        scoreTitle = (TextView) findViewById(R.id.score_title_text_view);
        scoreMessageTextView = (TextView) findViewById(R.id.score_message);

        // By default hide score text views
        scoreTitle.setVisibility(View.GONE);
        scoreView.setVisibility(View.GONE);
        scoreMessageTextView.setVisibility(View.GONE);

        wizardNameInput = (EditText) findViewById(R.id.wizzard_name_input);
        booksCountInput = (EditText) findViewById(R.id.books_count_input);

        showResult(showResultButton);
        resetScore();
    }

    /**
     * Method which sets on click listener to showResultButton and calculates user score
     *
     * @param showResultButton
     */
    private void showResult(Button showResultButton) {
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
                        }
                    }

                    for (int checkboxId : allCheckboxes) {
                        if (leaveLoop == true) {
                            break;
                        }

                        CheckBox checkbox = (CheckBox) findViewById(checkboxId);
                        boolean checkboxIsChecked = checkbox.isChecked();

                        isCorrect = false;

                        if (checkboxIsChecked) {
                            for (int correctAnswer : correctAnswersCheckboxes) {
                                if (correctAnswer == checkboxId) {
                                    isCorrect = true; // if the answer was correct, continue to the next part of code.
                                    numCorrectChecks += 1;
                                }
                            }
                            // Checking condition breaking entire loop if selected checkbox does not match any of the correct answers
                            if (!isCorrect) {
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

                    if (numCorrectChecks == correctAnswersCheckboxes.length && leaveLoop == false) {
                        score += 1;
                    }
                }

                checkBookInput();

                // Set score text to appropriate text views
                mWizardName = wizardNameInput.getText().toString();
                scoreView.setText(score + "/8");
                scoreMessageTextView.setText("Congratulations " + mWizardName + " you have got " + score + "/8 questions right!");

                // Make those text views visible
                scoreTitle.setVisibility(View.VISIBLE);
                scoreView.setVisibility(View.VISIBLE);
                scoreMessageTextView.setVisibility(View.VISIBLE);

                // Set toast message
                Toast toast = Toast.makeText(getApplicationContext(), "Your score is " + score, Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP, 0, 20);
                toast.show();
            }
        });
    }

    /**
     * Method to reset the score
     */
    private void resetScore() {
        Button resetScore = (Button) findViewById(R.id.reset_score_button);
        resetScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score = 0;
                scoreTitle.setVisibility(View.GONE);
                scoreView.setVisibility(View.GONE);
                scoreMessageTextView.setVisibility(View.GONE);
            }
        });
    }

    /**
     * Method to check if user input question is correct
     */
    private void checkBookInput() {
        String userBooksInput = booksCountInput.getText().toString();
        if (!userBooksInput.isEmpty()) {
            if ((userBooksInput.equals("7")) || (userBooksInput.equals("seven"))
                    || (userBooksInput.equals("Seven")) || (userBooksInput.equals("SEVEN"))) {
                score += 1;
            }
        } else {
            Toast incorrectAnswerToast = Toast.makeText(getApplicationContext(), "Question 8. Please do not leave books field empty.", Toast.LENGTH_SHORT);
            incorrectAnswerToast.setGravity(Gravity.TOP, 0, 170);
            incorrectAnswerToast.show();
        }
    }
}
