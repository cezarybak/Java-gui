package Day4Zad7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day4Zad7 {

    public static void main(String[] args)
    {
//        Spiewak s1 = new Spiewak("Dietrich"){
//            @Override
//            String spiewaj() {
//                return  "We will, we will rock you";
//            }
//            /*<-  kod */
//        };
//
//        Spiewak s2 = new Spiewak("Piaf"){
//            @Override
//            String spiewaj() {
//                return  "Is this the real life?, Is this just fantasy?";
//            }
//            /*<-  kod */
//        };
//
//        Spiewak s3 = new Spiewak("Adele"){
//            @Override
//            String spiewaj() {
//                return "I want to break free";
//            }
//            /*<-  kod */
//        };
//
//        Spiewak sp[] = {s1, s2, s3};
//
//        for (Spiewak s : sp)
//            System.out.println(s);
//
//        System.out.println("\n" + Spiewak.najglosniej(sp));


        List<Spiewak> listaSpiewak = new ArrayList<Spiewak>();

        listaSpiewak.add(new Spiewak("Tomasz") {
            @Override
            String spiewaj() {
                return "asmdkanjasasbasbhafcix  ";
            }
        });


        listaSpiewak.add(new Spiewak("Maurycy") {
            @Override
            String spiewaj() {
                return "HOHOOHOHOHO";
            }
        });

        listaSpiewak.add(new Spiewak("Bogdan") {
            @Override
            String spiewaj() {
                return "HOHOOHOHOHO";
            }
        });

        listaSpiewak.add(new Spiewak("Anaa") {
            @Override
            String spiewaj() {
                return "Hiholtasd";
            }
        });

        Collections.sort(listaSpiewak, Collections.reverseOrder());

        System.out.println("Spiewacy po sortowaniu:");
        for (Spiewak o : listaSpiewak) {

            System.out.println(o);


        }


    }
}


abstract class Spiewak implements Comparable<Spiewak> {

    public String nazwisko;
    private int id;
    private static int count = 0;

    public Spiewak(String nazwisko) {
        this.nazwisko = nazwisko;
        count++;
        id = count;
    }


    public int najglosniej() {


        String song = this.spiewaj();
        ArrayList unique = new ArrayList();

        for (int i = 0; i < song.length(); i++)
            if (Character.isLetter(song.charAt(i)))
                if (!unique.contains(song.charAt(i)))
                    unique.add(song.charAt(i));
        System.out.println(unique.size());


        return unique.size();
    }

    abstract String spiewaj();

    @Override
    public String toString() {
        return "(" + this.id + ") " + this.nazwisko + ": " + spiewaj();
    }

    @Override
    public int compareTo(Spiewak o) {
        if (this.najglosniej() < o.najglosniej()) {
            return -1;
        } else if (this.najglosniej() == o.najglosniej()) {
            int compare = (this.nazwisko).compareTo(o.nazwisko);

            if (compare > 0) {
                return -1;
            }else if(compare < 0){
                return 1;
            } else{
                    return  this.id - o.id;
                }

        } else {
            return 1;
        }

    }
}



