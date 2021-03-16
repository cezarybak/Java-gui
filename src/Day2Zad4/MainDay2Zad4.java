package Day2Zad4;

public class MainDay2Zad4 {
    public static void main(String[] args){

        Figura fig[] = new Figura[2];
        fig[0] = new Kolo(10, 10, 5);                    // położenie koła = srodek = (10,10), promień = 5
        fig[1] = new Prostokat(20, 20, 15, 10);    // położenie prostokąta = lewy górny wierzchołek = (20,20), szerokość = 15, wysokość = 10

        // polimorficzne wywołanie metody toString() z klas Kolo/Prostokat,
        // a nie z klasy Figura
        for (Figura f : fig)              // pętla for-each
            System.out.println(f.toString());    // System.out.println(f.toString());

        System.out.println(fig[0].pozycja(12, 12));
        System.out.println(fig[1].pozycja(25, 3));


        System.out.println(fig[1].pole());
        System.out.println(fig[1].obwód());

        System.out.println(fig[0].pole());
        System.out.println(fig[0].obwód());

        Figura p2 = new Prostokat2(20, 20, 10, 5, '*');
        ((Prostokat2)p2).rysuj();

        Kolo2 k2 = new Kolo2(15, 20, 5);

        k2.przesunDo(50, 40);    // przesunięcie środka koła do punktu (50, 40)
        System.out.println(k2);

        k2.powrot();                    // powrót do poprzedniej pozycji (bezpośrednio przed przesunięciem) środka koła
        System.out.println(k2);

    }
}
abstract class Figura implements Obliczenie {

    protected int x;
    protected int y;

    // konstruktor
    public Figura(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    // metody abstrakcyjne
    public abstract String fig();
    public abstract String pozycja(int x, int y);


    @Override
    public String toString()
    {
        return fig();
    }

    @Override
    public abstract double pole();

    @Override
    public abstract double obwód();
}

class Kolo extends Figura implements Obliczenie {

    private int promien;

    // konstruktor
    public Kolo(int x, int y, int r)
    {
        super(x,y);
        this.promien = r;
    }

    @Override
    public String fig() {
        return "Koło";
    }

    @Override
    public String pozycja(int x, int y)
    {
        boolean heler = false;
        String isEqueal = "";


        if(x-promien <= this.x && y-promien <= this.y){
            heler = true;
        }

        if(heler){
            isEqueal = "wewnątrz";
        }else{
            isEqueal = "na zewnątrz";
        }

        return "Punkt ("+x+","+y+") "+"znajduje się "+isEqueal+" koła" + "\n";
    }

    @Override
    public String toString()
    {
        return super.toString() + "\nŚrodek - (" + x + ',' + y + ")" + "\nPromień: " + promien + "\n";
    }

    @Override
    public double obwód() {
        return (2 * Math.PI * promien);
    }

    @Override
    public double pole() {
        return (Math.pow(promien, 2) * Math.PI);
    }
}

class Kolo2 extends Kolo implements Transformacja{

    private int helperx, helpery;

    public Kolo2(int x, int y, int r) {
        super(x, y, r);
    }

    @Override
    public void przesunDo(int x, int y) {
        helperx = this.x;
        helpery = this.y;

        this.x = x;
        this.y = y;

    }

    @Override
    public void powrot() {
        x = helperx;
        y = helpery;
    }


}

class Prostokat extends Figura implements Obliczenie {

    protected int szer, wys;

    // konstruktor
    public Prostokat(int x, int y, int s, int w)
    {
        super(x, y);

        this.szer = s;
        this.wys = w;
    }

    @Override
    public String fig() {
        return "Prostokat";
    }

    @Override
    public String pozycja(int x, int y)
    {
        boolean heler = false;
        String isEqueal = "";

        if((this.x <= x && x <= this.x+szer) && (this.y >= y && this.y-wys <= y)){
            heler = true;
        }

        if(heler){
            isEqueal = "wewnątrz";
        }else{
            isEqueal = "na zewnątrz";
        }

        return "Punkt ("+x+","+y+") "+"znajduje się "+isEqueal+" prostokąta" + "\n";
    }

    @Override
    public String toString()
    {
        return super.toString() + "\nLewy górny - (" + x + ',' + y + ")" + "\nSzerokość: " + szer + ", " + "Wysokość: " + wys + "\n";
    }

    @Override
    public double pole() {
        return (szer*wys);
    }

    @Override
    public double obwód() {
        return (2*szer + 2*wys);
    }
}

class Prostokat2 extends Prostokat implements  Rysowanie{

    public char c;


    public Prostokat2(int x, int y, int s, int w, char c) {
        super(x, y, s, w);
        this.c = c;
    }

    @Override
    public void rysuj() {
        for(int x = 0; x < wys; x++){
            for(int y = 0; y <  szer; y++){
                System.out.print(c);
            }
            System.out.println();
        }
    }
}

interface Obliczenie{
    public double obwód();
    public double pole();
}

interface Rysowanie{
    public void rysuj();
}

interface Transformacja{

    public void przesunDo(int x, int y);
    public void powrot();
}