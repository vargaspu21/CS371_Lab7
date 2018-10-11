package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameState;

import android.util.Log;

import java.util.Random;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {
    PigGameState pgs;
    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        //TODO  You will implement this constructor
        pgs = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        //TODO  You will implement this method
        if(pgs.getPlayerTurn() == playerIdx) return true;
        else return false;
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        //TODO  You will implement this method
        if(!(action instanceof PigRollAction || action instanceof PigHoldAction)) return false;
        if(action instanceof  PigHoldAction)
        {
            if(pgs.getPlayerTurn() == 0)
            {
                pgs.setPlayer1Score(pgs.getPlayer1Score()+pgs.getCurrentTotal());
                pgs.setCurrentTotal(0);
                if(players.length > 1) pgs.setPlayerTurn(pgs.getPlayerTurn()+1);
                return true;
            }
            else
            {
                pgs.setPlayer2Score(pgs.getPlayer2Score()+pgs.getCurrentTotal());
                pgs.setCurrentTotal(0);
                if(players.length > 1) pgs.setPlayerTurn(pgs.getPlayerTurn()-1); //check that its more than one player
                return true;
            }
        }
        else
        {
            Random rand = new Random();
            int die = rand.nextInt(6) + 1;
            if(pgs.getPlayerTurn() == 0)
            {
                if(die != 1) pgs.setCurrentTotal(die + pgs.getCurrentTotal());
                else {
                    pgs.setCurrentTotal(0);

                    if (players.length > 1) pgs.setPlayerTurn(pgs.getPlayerTurn() + 1);
                    return true;
                }
            }
            else {
                if (die != 1) pgs.setCurrentTotal(die + pgs.getCurrentTotal());
                else {
                    pgs.setCurrentTotal(0);

                    if (players.length > 1)
                        pgs.setPlayerTurn(pgs.getPlayerTurn() - 1); //check that its more than one player
                    return true;
                }
            }
        }
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        //TODO  You will implement this method
        PigGameState newState = new PigGameState(pgs);
        p.sendInfo(newState);
    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        //TODO  You will implement this method
        if(pgs.getPlayer1Score() > 50) return "Player 1 has won the game with a score of " + pgs.getPlayer1Score()+"!";
        else if(pgs.getPlayer2Score() > 50 ) return "Player 2 has won the game with a score of"+pgs.getPlayer2Score()+"!";
        else return null;
    }

}// class PigLocalGame
