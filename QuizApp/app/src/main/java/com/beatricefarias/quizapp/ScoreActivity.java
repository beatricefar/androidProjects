package com.beatricefarias.quizapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        TextView scoreTextView = (TextView) findViewById(R.id.score_text_view);

        int score = getIntent().getIntExtra("score", 0);
        scoreTextView.setText(score + " / 10");

        TextView tryAgainTextView = (TextView) findViewById(R.id.try_again_text_view);

        tryAgainTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startQuizActivity = new Intent(ScoreActivity.this, Questions.class);
                startActivity(startQuizActivity);
                finish();
            }
        });
    }
}
