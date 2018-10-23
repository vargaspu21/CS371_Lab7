package edu.up.cs301.pig;

import java.util.Random;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.util.Tickable;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigSmartComputerPlayer extends GameComputerPlayer {

    /**
     * ctor does nothing extra
     */
    public PigSmartComputerPlayer(String name) {
        super(name);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        // TODO  You will implement this method
        PigGameState pgs;
        if(info instanceof PigGameState) {
            pgs = (PigGameState) info;

            if (pgs.getPlayerTurn() != this.playerNum) return; // not turn, return
            else {
                if(pgs.getPlayer1Score() - pgs.getPlayer2Score() < 20
                        || pgs.getCurrentTotal() >10
                        || 50 - pgs.getPlayer2Score() < 15)
                {
                    PigHoldAction pg = new PigHoldAction(this);
                    if(game instanceof LocalGame)
                    {
                        LocalGame lg = (LocalGame) game;
                        lg.sendAction(pg);
                    }
                }
                else
                {
                    PigRollAction pg = new PigRollAction(this);
                    if(game instanceof LocalGame)
                    {
                        LocalGame lg = (LocalGame) game;
                        lg.sendAction(pg);
                    }
                }
            }
        }
    }//receiveInfo

}