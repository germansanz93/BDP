package state.impl;

import client.Player;
import state.State;
import state.impl.LockedState;

public class PlayingState implements State {

    private final Player player;

    public PlayingState(Player player) {
        System.out.println("Playing state.State");
        this.player = player;
    }

    @Override
    public String onLock() {
        player.changeState(new LockedState(player));
        player.setCurrentTrackAfterStop();
        return "Stop playing";
    }

    @Override
    public String onPlay() {
        player.changeState(new ReadyState(player));
        return "Paused...";
    }

    @Override
    public String onNext() {
        return player.nextTrack();
    }

    @Override
    public String onPrevious() {
        return player.previousTrack();
    }
}
