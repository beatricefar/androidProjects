package com.beatricefarias.rugbyscorecounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreHome = 0;
    int scoreVisitors = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForHome(scoreHome);
        displayForVisitors(scoreVisitors);
    }

    /**
     * Add 4 points to final score to Home team.
     */
    public void tryHome (View view){
        scoreHome = scoreHome + 4;
        displayForHome(scoreHome);
    }

    /**
     * Add 2 points to final score to Home team.
     */
    public void goalKickHome (View view){
        scoreHome = scoreHome + 2;
        displayForHome(scoreHome);
    }

    /**
     * Add 2 points to final score to Home team.
     */
    public void penaltyHome (View view){
        scoreHome = scoreHome + 2;
        displayForHome(scoreHome);
    }

    /**
     * Add 1 points to final score to Home team.
     */
    public void dropGoalHome (View view){
        scoreHome = scoreHome + 1;
        displayForHome(scoreHome);
    }

    /**
     * Adds 4 points to final score to Visitors team.
     */
    public void tryVisitors (View view){
        scoreVisitors = scoreVisitors + 4;
        displayForVisitors(scoreVisitors);
    }

    /**
     * Add 2 points to final score to Visitors team.
     */
    public void goalKickVisitors (View view){
        scoreVisitors = scoreVisitors + 2;
        displayForVisitors(scoreVisitors);
    }

    /**
     * Add 2 points to final score to Visitors team.
     */
    public void penaltyVisitors (View view){
        scoreVisitors = scoreVisitors + 2;
        displayForVisitors(scoreVisitors);
    }

    /**
     * Add 1 points to final score to Visitors team.
     */
    public void dropGoalVisitors (View view){
        scoreVisitors = scoreVisitors + 1;
        displayForVisitors(scoreVisitors);
    }

    /**
     * Method resets current score count to 0.
     */
    public void reset (View view){
        scoreHome = 0;
        scoreVisitors = 0;
        displayForHome(scoreHome);
        displayForVisitors(scoreVisitors);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForHome(int score) {
        TextView scoreView = (TextView) findViewById(R.id.score_home);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForVisitors(int score) {
        TextView scoreView = (TextView) findViewById(R.id.score_visitors);
        scoreView.setText(String.valueOf(score));
    }
}

