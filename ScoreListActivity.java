package com.example.nnelanut.snakeapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ScoreListActivity extends AppCompatActivity {

    private DatabaseManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_list);
        updateView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateView();
    }

    public void updateView() {

        ArrayList<UserScore> scoreArrayList = dbManager.selectAll();

        if (scoreArrayList.size() > 0) {

            String finalString = "";
            TextView scoreDisplay = (TextView) findViewById(R.id.scoreDisplay);

            for (UserScore uS : scoreArrayList) {
                finalString += uS.getName() + ": " + uS.getScore() + "\n";
            }
            scoreDisplay.setText(finalString);
        }

    }
}
