package com.applid.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.io.InputStream;

public class ShowActivity extends AppCompatActivity {

    private Button homeBtn, playAgainBtn;
    private TextView playerNameTxt;
    private TicTacToeBoard ticTacToeBoard;
    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        ticTacToeBoard = findViewById(R.id.ticTacToeBoard);

        playerNameTxt = findViewById(R.id.playerNameTxt);
        String[] playerNames = getIntent().getStringArrayExtra("PlayerNames");

        if(playerNames[0] != null)
        {
            playerNameTxt.setText((playerNames[0] + "'s Turn"));
            playerNameTxt.setTextColor(getResources().getColor(R.color.red));

        }

        homeBtn = findViewById(R.id.HomeBtn);
        homeBtn.setVisibility(View.GONE);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        playAgainBtn = findViewById(R.id.playAgainBtn);
        playAgainBtn.setVisibility(View.GONE);
        playAgainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ticTacToeBoard.resetGame();
                ticTacToeBoard.invalidate();
            }
        });

        ticTacToeBoard.setUpGame(playAgainBtn, homeBtn, playerNameTxt, playerNames);

        mAdView = findViewById(R.id.adView);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ShowActivity.this, PlayerSetup.class);
        startActivity(intent);
        super.onBackPressed();

    }
}