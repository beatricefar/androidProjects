package com.beatricefarias.rugbyscorecounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private int scoreTeamA = 0;
    private int scoreTeamB = 0;
    private TextView teamAScore;
    private TextView teamBScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        teamAScore = (TextView) findViewById(R.id.teamAScore);
        teamBScore = (TextView) findViewById(R.id.teamBScore);

        ArrayList<Points> points = makeArrayList();

        setListeners(points);
        resetScore();
    }

    /**
     * Method which creates array list containing buttonID, point count, team name
     * @return points array list
     */
    private ArrayList makeArrayList() {
        ArrayList<Points> points = new ArrayList<>();
        points.add(new Points(R.id.tryTeamA, 4, "teamA"));
        points.add(new Points(R.id.tryTeamB, 4, "teamB"));
        points.add(new Points(R.id.goalKickTeamA, 2, "teamA"));
        points.add(new Points(R.id.goalKickTeamB, 2, "teamB"));
        points.add(new Points(R.id.penaltyTeamA, 2, "teamA"));
        points.add(new Points(R.id.penaltyTeamB, 2, "teamB"));
        points.add(new Points(R.id.dropGoalTeamA, 1, "teamA"));
        points.add(new Points(R.id.dropGoalTeamB, 1, "teamB"));

        return points;
    }

    /**
     * Method which sets listeners on appropriate buttons counting and updating scores of appropriate team
     * @param points array list containing buttonID, point count and team name information
     */
    private void setListeners(ArrayList<Points> points) {
        for (int i = 0; i < points.size(); i++) {
            Points currentElement = points.get(i);
            int buttonId = currentElement.getButtonId();
            final int totalPoints = currentElement.getPoints();
            String teamName = currentElement.getTeam();

            Button currentButton = (Button) findViewById(buttonId);

            if (teamName == "teamA") {
                currentButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        scoreTeamA = scoreTeamA + totalPoints;
                        teamAScore.setText(String.valueOf(scoreTeamA));
                    }
                });
            } else if (teamName == "teamB") {
                currentButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        scoreTeamB = scoreTeamB + totalPoints;
                        teamBScore.setText(String.valueOf(scoreTeamB));
                    }
                });
            }
        }
    }

    /**
     * Method to reset scores of each team
     */
    private void resetScore() {
        Button resetButton = (Button) findViewById(R.id.resetButton);

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreTeamA = 0;
                teamAScore.setText("0");
                scoreTeamB = 0;
                teamBScore.setText("0");
            }
        });
    }
}

