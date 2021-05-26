package rollinggame;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public static void main(String[] args) {
        List<IPlayer> players = new ArrayList<>();
        players.add(new Player("Dung"));
        players.add(new Player("Thang"));
        players.add(new Player("Duong"));
        players.add(new Player("Duc"));

        Dice dice = new Dice();
        // start game
        boolean isFinish = false;
        int turn = 0;
        while (!isFinish) {
            IPlayer player = players.get(turn++%players.size());
            System.out.println("Turn "+ turn);
            if(player.addPoint(dice.getDiceResult())) {
                System.out.println("player " + player.getName() + " is win");
                players.remove(player);
                for (IPlayer iPlayer : players) {
                    iPlayer.showFailure();
                }
                isFinish = true;
            }
        }
     }
}
