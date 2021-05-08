package Day5Zad10;

import java.util.Arrays;

public class Day5Zad10 {
    public static void main(String[] args) {

        ArrayBox<Osoba>  bo = new ArrayBox<Osoba>(2);

        bo.add(new Osoba("Kowalski", 19));                        // nazwisko = "Kowalki", wiek = 19
        bo.add(new Student("Kowalska", 28, 200));                    // nazwisko, wiek, grupa = 100
        bo.add(new Student("Kowalska", 28, 300));
        bo.print();

        Osoba[] to = new Osoba[] {new Osoba("Nowak", 18), new Student("Nowak", 32, 200)};
        bo.addAll(to);


        System.out.println(bo.min());                                           // Student 1: Kowalska, 18, 100

        ArrayBox<Student> bst = new ArrayBox<Student>(1);
        bst.add(new Student("Nowacka", 24, 100));
        bst.add(new Student("Nowacka", 24, 300));
        bst.add(new Student("Nowacka", 24, 200));
        bo.print();
        System.out.println(bst.max());                                          // Student 5: Nowacka, 24, 300

        ArrayBox<Integer> bi = new ArrayBox<Integer>(2);
        Integer[] ti = new Integer[] {Integer.valueOf(1), 2, 3};
        bi.addAll(ti);

        bi.print();                                                                          // 1, 2, 3

        ArrayBox<String> bs = new ArrayBox<String>(1);
        String[] ts = new String[] {"cpp", new String("java")};
        bs.addAll(ts);
        bs.swap(0,1);
        bs.print();                                                                         // java, cpp

    }
}



class ArrayBox <T extends Comparable> {

    Object[] arr;

    ArrayBox(int c)
    {
        arr = new Object[c];
        //...
    }
    // ...



    boolean add(T e) {

        for(int i = 0; i< arr.length; i++) {
            if (arr[i] == null) {
                arr[i] = e;
                return true;
            }
            if(arr[i].toString() == e.toString()) {
                return false;
            }
            }
        Object[] newarr = Arrays.copyOf(arr, (arr.length +1) );
        newarr[arr.length] = e;
        arr = newarr;
        return  true;

    }

    boolean addAll(T[] array)

    {

    int howMany = 0;

        for(int y = 0; y < array.length; y++) {
            for (int i = 0; i < arr.length; i++) {
                ;
                if (arr[i] == null) {
                        arr[i] = array[y];
                        howMany++;
                        break;
            }
            if (arr[i].toString() == array[y].toString()) {
                break;
            }
                if(arr[arr.length-1] != null){
                    Object[] newarr = Arrays.copyOf(arr, (arr.length +1) );
                    newarr[arr.length] = array[y];
                    howMany++;
                    arr = newarr;
                    break;
                }
            }

        }

        if(howMany > 0){
            return true;
        }else{
            return false;
        }
    }



    T min()
    {
        T min = (T)arr[0];

        for(int x = 0; x < arr.length; x++) {
        if (min.compareTo((T)arr[x]) < 0) {
            min = (T)arr[x];
            }
        };

        return min;
    }


    T max()
    {
        T max = (T)arr[0];;

        for(int x = 0; x < arr.length; x++) {
            if (max.compareTo((T)arr[x]) > 0){
                max = (T)arr[x];
            };
        }

        return max;
    }

    public void print() {
        for( Object arrPost : arr ){
            if(arrPost != null) {
                System.out.println(arrPost.toString());
            }
        }


    }

    public boolean swap(int i1, int i2) {

        if(arr.length >= i1 && arr.length >= i2) {
            if(arr[i1] != null && arr[i2] != null){
                Object helper = arr[i1];
                arr[i1] = arr[i2];
                arr[i2] = helper;
                return true;
            }
        }
        return false;
    }

    public boolean delete(T element) {

        for(int x = 0; x < arr.length; x++) {

            if (arr[x].toString().equals(element.toString())) {
                arr[x] = null;
                return true;
            }
        }
        return false;
    }


    public int search(T element) {
        for(int x = 0; x < arr.length; x++) {

            if (arr[x].toString().equals(element.toString())) {
                arr[x] = null;
                return x;
            }
        }
        return -1;
    }
}


class Student extends Osoba
{
    private int group;

    public Student(String name, int age, int group) {
        super(name, age);
        this.group = group;

    }



    public int compareTo(Student o)
    {

        if (this.name.length() > o.name.length()) {
            return -1;
        } else if (this.name.length() == o.name.length()) {
            if (this.age > o.age) {
                return -1;
            }else if(this.age == o.age){
                if(this.group > o.group){
                    return -1;
            }else {
                    return 1;
                }
            }else {
                return 1;
            }
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return this.name + "," + this.age + "," + this.group;
    }
}

class Osoba implements Comparable<Osoba> {

    public String name;
    public int age;

    public Osoba(String name, int age) {
        this.name = name;
        this.age = age;

    }

    // porównujemy 2 obiekty this, o
    // można korzystać z compareTo(...) z klasy String
    public int compareTo(Osoba o) {
        if (this.name.length() > o.name.length()) {
            return -1;
        } else if (this.name.length() == o.name.length()) {
            if (this.age > o.age) {
                return -1;
            }else {
                return 1;
            }
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return this.name + "," + this.age;
    }
}