package Day5Zad9;

public class Day5Zad9 {

    public static void main(String[] args)
    {
        Player p1 = new Player("ppj");                                            // tworzenie gracza ze swoim identyfikatorem
        Player p2 = new Player("gui");

        Referee ref = new Referee(10, new Player[]{p1,p2});       //  arbiter ustala czas gry (w sekundach), "rejestruje" tablicę graczy

        ref.startGame();                                                                   // arbiter startuje swój wątek: mierzy czas oraz daje sygnał startu graczom

        try {
            ref.join();                                                                          // czekamy, aż wątek arbitra zakończy swoją pracę, tzn. po upływie określonego czasu przerywa pracę wątków wszystkich graczy

            // join() jest metodą z klasy Thread

        } catch (InterruptedException exc){

            exc.printStackTrace();

        }

        ref.result();                                                                            // arbiter ogłasza wynik gry

    }
}


class Player extends Thread {

    public String name;
    public int score = 0;

    public Player(String name)
    {
        this.name = name;
    }

    public void run()
    {

    }

}


class Referee extends Thread {

    private int time;
    private  Player[] players;

    public Referee(int time, Player[] players) {
        this.players = players;

    }

    public void startGame() {

    }

    public void result() {

        System.out.println("wyniki " + players[0].name + ": " + players[0].score);
        System.out.println("wyniki " + players[1].name + ": " + players[1].score);
        System.out.println();
        if(players[0].score > players[1].score){
            System.out.println(players[0].score);
        }else{
            System.out.println(players[1].score);
        }

    }
}
