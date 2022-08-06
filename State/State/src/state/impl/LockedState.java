package state.impl;

import client.Player;
import state.State;

public class LockedState implements State {

    private static final String LOCKED = "Locked...";
    private Player player;

    public LockedState(Player player) {
        System.out.println("Locked state.State");
        this.player = player;
        player.setPlaying(false);
    }

    @Override
    public String onLock() {
        if (player.isPlaying()){
            player.changeState(new ReadyState(player));
            return "Stop playing";
        } else {
            return LOCKED;
        }
    }

    @Override
    public String onPlay() {
        player.changeState(new ReadyState(player));
        return "Ready";
    }

    @Override
    public String onNext() {
        return LOCKED;
    }

    @Override
    public String onPrevious() {
        return LOCKED;
    }
}
