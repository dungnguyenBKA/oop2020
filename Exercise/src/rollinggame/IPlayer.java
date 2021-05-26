package rollinggame;

public interface IPlayer {
    String getName();
    void showFailure();
    /**
     * add point to player
     * @return true if player win, false if player still not win
    * */
    boolean addPoint(int point);
}
