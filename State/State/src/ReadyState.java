public class ReadyState implements State{
    private static final String LOCKED = "Locked...";


    private Player player;

    public ReadyState(Player player){
        System.out.println("Ready State");
        this.player = player;
    }

    @Override
    public String onLock() {
        player.changeState(new LockedState(player));
        return LOCKED;
    }

    @Override
    public String onPlay() {
        String action = player.startPlayback();
        player.changeState(new PlayingState(player));
        return action;
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
