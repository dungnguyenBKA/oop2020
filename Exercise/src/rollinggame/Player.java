package rollinggame;

public class Player implements IPlayer{
    private int point;
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void showFailure() {
        System.out.println(name + ": ahhhh i'm lose");
    }

    @Override
    public boolean addPoint(int diceNum) {
        point += diceNum;
        if(point == 21) return true;
        if(point > 21) {
            point = 0;
        }
        return false;
    }
}
