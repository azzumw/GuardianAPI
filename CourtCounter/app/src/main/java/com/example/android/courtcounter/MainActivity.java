package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import static android.R.attr.button;
import static android.R.attr.switchMinWidth;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(View view) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        TextView button_free = (TextView) findViewById(R.id.free_button_view);
        TextView two_point_btn = (TextView) findViewById(R.id.two_point_button);
        TextView three_point_btn = (TextView) findViewById(R.id.three_point_button);
        TextView reset_btn = (TextView) findViewById(R.id.reset_button_a);

        if(view == button_free){
            scoreTeamA+=1;
        }

        else if (view==two_point_btn){
            scoreTeamA+=2;
        }

        else if(view==three_point_btn){
            scoreTeamA+=3;
        }

        else if(view==reset_btn){
            scoreTeamA =0;
        }
        scoreView.setText(String.valueOf(scoreTeamA));
    }


    public void displayForTeamB(View view){
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        TextView button_free = (TextView) findViewById(R.id.free_button_view_b);
        TextView two_point_btn = (TextView) findViewById(R.id.two_point_button_b);
        TextView three_point_btn = (TextView) findViewById(R.id.three_point_button_b);
        TextView reset_btn = (TextView) findViewById(R.id.reset_button_b);

        if(view == button_free){
            scoreTeamB+=1;
        }

        else if (view==two_point_btn){
            scoreTeamB+=2;
        }

        else if(view==three_point_btn){
            scoreTeamB+=3;
        }

        else if(view==reset_btn){
            scoreTeamB =0;
        }
        scoreView.setText(String.valueOf(scoreTeamB));
    }

    public void resetScores(View view){
        TextView viewA = (TextView) findViewById(R.id.team_a_score);
        TextView viewB = (TextView) findViewById(R.id.team_b_score);
        scoreTeamA=0;
        scoreTeamB=0;
        viewA.setText(String.valueOf(scoreTeamA));
        viewB.setText(String.valueOf(scoreTeamB));
    }

}
