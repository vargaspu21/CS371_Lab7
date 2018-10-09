package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameInfo;

public class PigGameState extends GameInfo {
    int playerTurn, player1Score, player2Score, currentTotal,dieValue;

    public PigGameState()
    {
        player1Score=0;
        player2Score=0;
        currentTotal=0;
        dieValue=0;
        playerTurn=0;

    }

    PigGameState(PigGameState pgs)
    {
        System.out.println("Copy constructor called");
        player1Score=pgs.player1Score;
        player2Score=pgs.player2Score;
        currentTotal=pgs.currentTotal;
        dieValue=pgs.dieValue;
        playerTurn=pgs.playerTurn;
    }

    public int getPlayer1Score() {
        return player1Score;
    }

    public int getCurrentTotal() {
        return currentTotal;
    }

    public int getPlayer2Score() {
        return player2Score;
    }

    public int getDieValue() {
        return dieValue;
    }

    public int getPlayerTurn() {
        return playerTurn;
    }

    public void setPlayer1Score(int player1Score) {
        this.player1Score = player1Score;
    }

    public void setPlayer2Score(int player2Score) {
        this.player2Score = player2Score;
    }

    public void setCurrentTotal(int currentTotal) {
        this.currentTotal = currentTotal;
    }

    public void setDieValue(int dieValue) {
        this.dieValue = dieValue;
    }

    public void setPlayerTurn(int playerTurn) {
        this.playerTurn = playerTurn;
    }
}

