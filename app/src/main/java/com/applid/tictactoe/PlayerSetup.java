package com.applid.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PlayerSetup extends AppCompatActivity {

    private Button button;
    private EditText player1Name, player2Name;
    private String player1NameStr, player2NameStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_setup);

        button = findViewById(R.id.startGameBtn2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNames();
                Intent intent = new Intent(PlayerSetup.this, ShowActivity.class);
                intent.putExtra("PlayerNames", new String[] {player1NameStr, player2NameStr});
                startActivity(intent);
                finish();
            }
        });


    }

    private void getNames()
    {
        player1Name = findViewById(R.id.firstPlayerEditTxt);
        player2Name = findViewById(R.id.secondPlayerEditTxt);
        player1NameStr = player1Name.getText().toString();
        player2NameStr = player2Name.getText().toString();
        if(player1NameStr.length() == 0)
        {
            player1NameStr = "Player 1";
        }
        if(player2NameStr.length() == 0)
        {
            player2NameStr = "Player 2";
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(PlayerSetup.this, MainActivity.class);
        startActivity(intent);
        super.onBackPressed();
    }
}