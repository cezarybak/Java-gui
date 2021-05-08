package Day4Zad8;

import java.util.Iterator;


public class Day4Zad8 {
    public static void main(String[] args) {

        IterNap napis = new IterNap("prOgrAmoWanIe ObiEktOwe i Gui");

        Iterator<Character> iterator = napis.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        System.out.println();

        napis.ustawPoczatek(2);
        napis.ustawKrok(3);

        iterator = napis.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        System.out.println();
        System.out.println();

        napis.ustawPoczatek(2);
        iterator = napis.iterator();


//        napis.forEach((z) ->{System.out.print(z);});

        while (iterator.hasNext()) {
            System.out.print((iterator.next().toString().toLowerCase()) + " ");
        }




    }





     static class IterNap implements Iterable<Character> {
        private String input;
        private int start = 0;
        private int skip = 1;

        public IterNap(String input) {
            this.input = input;
        }

        public void ustawPoczatek(int start) {
            this.start = start;
        }

        public void ustawKrok(int skip) {
            this.skip = skip;
        }

        @Override
        public Iterator<Character> iterator() {

            return new Iterator<>() {

                public boolean hasNext() {
                    if( input.length() >= start + skip){
                        return  true;
                    }else {
                        return false;
                    }
                }

                public Character next() {
                    if (hasNext()) {
                        char letter = input.charAt(start);
                        start += skip;
                        return letter;
                    } else{
                        return null;
                    }
                }
            };
        }
    }
}

