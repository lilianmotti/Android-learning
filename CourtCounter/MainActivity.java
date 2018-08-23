package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA=0;
    int scoreTeamB=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayForTeamA(int scoreTeamA){
        TextView scoreViewA = findViewById(R.id.score_team_A);
        scoreViewA.setText(String.valueOf(scoreTeamA));
    }

    public void displayForTeamB(int scoreTeamA){
        TextView scoreViewB = findViewById(R.id.score_team_B);
        scoreViewB.setText(String.valueOf(scoreTeamB));
    }

    public void add1teamA(View view){
        scoreTeamA++;
        displayForTeamA(scoreTeamA);
    }
    public void add1teamB(View view){
        scoreTeamB++;
        displayForTeamB(scoreTeamB);
    }

    public void add2teamA(View view){
        scoreTeamA = scoreTeamA + 2;
        displayForTeamA(scoreTeamA);
    }
    public void add2teamB(View view){
        scoreTeamB = scoreTeamB + 2;
        displayForTeamB(scoreTeamB);
    }

    public void add3teamA(View view){
        scoreTeamA = scoreTeamA + 3;
        displayForTeamA(scoreTeamA);
    }
    public void add3teamB(View view){
        scoreTeamB = scoreTeamB + 3;
        displayForTeamB(scoreTeamB);
    }

    public void reset(View view){
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }
}
