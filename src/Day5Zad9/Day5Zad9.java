package Day5Zad9;

import java.util.Random;

public class Day5Zad9 {

    public static void main(String[] args)
    {
        Player p1 = new Player("ppj");
        Player p2 = new Player("gui");

        Referee ref = new Referee(10, new Player[]{p1,p2});

        ref.startGame();

        try {
            ref.join();

        } catch (InterruptedException exc){
            exc.printStackTrace();
        }
        ref.result();
    }
}


class Player extends Thread {

    public String name;
    public int score = 0;


    public Player(String name) {
        this.name = name;
    }


    public void run() {
        int howmanytime = 1;

        while (true) {

            int delay = new Random().nextInt(2000) + 1;
            int score = new Random().nextInt(100) + 1;


            System.out.println("Czas: " + howmanytime);
            System.out.println(this.name + ": " + score);

            try {
                sleep(delay);
            } catch (InterruptedException e) {
                return;
            }
            howmanytime++;
            this.score += score;
        }
    }
}

class Referee extends Thread {

    private long time;
    private Player[] players;

    public Referee(int time, Player[] players)
    {
        this.time = time;
        this.players = players;
    }

    void startGame(){



        players[0].start();
        players[1].start();

        try {
            sleep(time * 1000);
        } catch (InterruptedException e) {
            return;
        }
        players[0].interrupt();
        players[1].interrupt();


    }




    void result() {
        System.out.println();

        for(int x = 0; x < players.length; x++){
            System.out.println("wyniki: " + players[x].name + ": " + players[x].score);

        }
        System.out.println();

        if(players[0].score > players[1].score){
            System.out.println(players[0].name + " wygrał!");
        }else if(players[1].score > players[0].score){
            System.out.println(players[1].name + " wygrał!");
        }else{
            System.out.println("Remis");
        }
    }
}