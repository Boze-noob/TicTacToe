package com.applid.tictactoe;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

public class GameLogic {

    private int[][] gameBoard;
    private Button playAgainBtn, homeBtn;
    private TextView playerTurn;
    private String[] playerNames = {"Player 1", "Player 2"};
    private int[] winType = {-1, -1, -1};
    private Context context;

    private int player = 1;

    GameLogic(Context context){
        this.context = context;
        gameBoard = new int[3][3];
        for(int i = 0 ; i < 3; i++)
        {
            for(int j = 0 ; j < 3; j++){
                gameBoard[i][j] = 0;
            }
        }
    }

    public boolean updateGameBoard(int row, int col){
        if(gameBoard[row - 1 ][col - 1] == 0){
            gameBoard[row - 1 ][col - 1] = player;

            if(player == 1)
            {
                playerTurn.setText((playerNames[1] + "'s Turn"));
                playerTurn.setTextColor(context.getResources().getColor(R.color.blue));
            }
            else
            {
                playerTurn.setText((playerNames[0] + "'s Turn"));
                playerTurn.setTextColor(context.getResources().getColor(R.color.red));
            }


            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean winnerCheck()
    {
        boolean isWinner = false;


        for(int i = 0 ; i < 3; i++)
        {
            if(gameBoard[i][0] == gameBoard[i][1] && gameBoard[i][0] == gameBoard[i][2] && gameBoard[i][0] != 0){

                winType = new int[]{i, 0, 1};
                isWinner = true;
            }
        }

        for(int i = 0 ; i < 3; i++)
        {
            if(gameBoard[0][i] == gameBoard[1][i] && gameBoard[0][i] == gameBoard[2][i] && gameBoard[0][i] != 0){

                winType = new int[]{0, i, 2};
                isWinner = true;
            }
        }


        if(gameBoard[0][0] == gameBoard[1][1] && gameBoard[0][0] == gameBoard[2][2] && gameBoard[0][0] != 0){

            winType = new int[]{0, 2, 3};
            isWinner = true;
        }


        if(gameBoard[2][0] == gameBoard[1][1] && gameBoard[2][0] == gameBoard[0][2] && gameBoard[2][0] != 0){

            winType = new int[]{2, 2, 4};
            isWinner = true;
        }

        int boardFilled = 0;
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                if(gameBoard[i][j] != 0)
                {
                    boardFilled ++;
                }
            }
        }

        if(isWinner)
        {
            playAgainBtn.setVisibility(View.VISIBLE);
            homeBtn.setVisibility(View.VISIBLE);
            if(player - 1 == 1) {
                playerTurn.setTextColor(context.getResources().getColor(R.color.white));
                playerTurn.setText((playerNames[player - 1] + " WON!! " + playerNames[0] + " is LOSERR!"));
            }
            else if(player - 1 == 0) {
                playerTurn.setTextColor(context.getResources().getColor(R.color.white));
                playerTurn.setText((playerNames[player - 1] + " WON!! " + playerNames[1] + " is LOSERR!"));
            }
                return true;
        }
        else if(boardFilled == 9)
        {
            playAgainBtn.setVisibility(View.VISIBLE);
            homeBtn.setVisibility(View.VISIBLE);
            playerTurn.setTextColor(context.getResources().getColor(R.color.white));
            playerTurn.setText("Tie Game!!!!");
            return true;
        }
        else
        {
            return false;
        }

    }



    public void resetGame()
    {
        for(int i = 0 ; i < 3; i++)
        {
            for(int j = 0 ; j < 3; j++){
                gameBoard[i][j] = 0;
            }
        }

        player = 1;
        playAgainBtn.setVisibility(View.GONE);
        homeBtn.setVisibility(View.GONE);
        playerTurn.setTextColor(context.getResources().getColor(R.color.white));
        playerTurn.setText((playerNames[0] + "'s Turn"));
        winType = new int[] {-1, -1, -1};
    }

    public void setPlayAgainBtn(Button playAgainBtn)
    {
        this.playAgainBtn = playAgainBtn;
    }

    public void setHomeBtn(Button homeBtn) {
        this.homeBtn = homeBtn;
    }

    public void setPlayerTurn(TextView playerTurn) {
        this.playerTurn = playerTurn;
    }

    public void setPlayerNames(String[] playerNames) {
        this.playerNames = playerNames;
    }

    public int[][] getGameBoard()
    {
       return gameBoard;
    }

    public void setPlayer(int player){
        this.player = player;
    }

    public  int getPlayer(){
        return player;
    }

    public int[] getWinType() {
        return winType;
    }

    public void setWinType(int[] winType) {
        this.winType = winType;
    }
}
