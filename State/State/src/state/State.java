package state;

public interface State {
    public String onLock();
    public String onPlay();
    public String onNext();
    public String onPrevious();
}
