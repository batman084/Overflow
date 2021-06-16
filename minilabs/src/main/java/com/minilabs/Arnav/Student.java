package com.minilabs.Arnav;
import java.util.ArrayList;

public class Student {

    String name; //Name of the student

    public Student(){
        name = "Student NO NAME";
    }
    public Student(String n) {
        name = n;
    }

    public Boolean registerforclass(String className)
    {

        System.out.println("Registering " + name + " for " + className);
        return Boolean.TRUE;

    }
    public Boolean getParentApproval() {

        return Boolean.TRUE;
    }

    public void test(){
        System.out.println("Hello");
        int arr1[] = new int[10];
        String arr2[] = new String[3];
        int xval[] = new int[10];
        int yval[] = new int[10];
        arr2[0] = "Str1";
        arr2[1] = "Str2";
        arr1[5] = 20;
        arr1[9] = 6;
        xval[0] = 5; yval[0]=7;
        int arr3[][]=new int[2][10];
        arr3[0][0] = 5; arr3[1][0] = 7;
        Coordinates arr4[] = new Coordinates[10];
        arr4[0] = new Coordinates(5,7);
        arr4[1] = new Coordinates(8,9);
        for (int i=0; i<10; i++) {
            System.out.println("arr1 item "+ i + " =" + arr1[i]);
        }
        for (int i=0; i<3; i++) {
            System.out.println("arr2 item "+ i + " =" + arr2[i]);
        }
        System.out.println("arr3 item [0][0]=" + arr3[0][0]);
        System.out.println("arr3 item [1][0]=" + arr3[1][0]);
        //System.out.println("arr4 item [0]=" + arr4[0].x + "," + arr4[0].y);
        System.out.println("arr4 item [0]=" + arr4[0]);
        //System.out.println("arr4 item [1]=" + arr4[1].x + "," + arr4[1].y);
        System.out.println("arr4 item [1]=" + arr4[1]);

        ArrayList<Integer> arrL = new ArrayList<>(3);
        arrL.add(5);
        arrL.add(6);
        arrL.add(7);
        arrL.add(7);
        arrL.add(7);
        arrL.add(7);
        arrL.add(3, 9);
        arrL.add(4, 6);
        System.out.println("arrL item [2]=" + arrL.get(2));
        System.out.println("arrL size=" + arrL.size());
        arrL.set(5, 8);

        for(int i=0; i<arrL.size(); i++) {
            //System.out.println("arrL item " + i + " = " + arrL[i]);
            System.out.println("arrL item " + i + " = " + arrL.get(i));
        }
        //System.out.println("arrL size after setting item 9=" + arrL.size());


    }

    private String recombine(String word1, String word2) {
        //String word1 = "apple";
        //String word2 = "pear";
        String w1f = word1.substring(0, word1.length()/2);
        String w2s = word2.substring(word2.length()/2, word2.length());
        //System.out.println("second substr = "  + w2s);
        return (w1f+w2s);
    }


    public String[] mixedWords(String[] words)
    {
        String[] ret = new String[words.length];
        for (int i=0 ; i<words.length; i+=2 ) {
            ret[i] = recombine(words[i], words[i+1]);
            ret[i+1] = recombine(words[i+1], words[i]);
        }
        return ret;
    }

    public void test1() {
        //String w1 = "apple";
        //String w2 = "pear";
        //String rw1 = recombine(w1, w2);
        //String rw2 = recombine(w2, w1);
        String[] w = new String[6];
        w[0] = "apple"; w[1] = "pear"; w[2]="mango"; w[3]="banana"; w[4] = "cherry"; w[5]= "orange";
        System.out.println("The words are:");
        for (String s: w) {
            System.out.println(s);
        }
        String[] mw = mixedWords(w);
        System.out.println("The mixedWords are:");
        for (String s: mw) {
            System.out.println(s);
        }
    }



    public static void main(String[] args) {
        Student Arnav = new HSStudent("Arnav", 12);
        Student S2 = new HSStudent();
        Student S3 = new Student();
        Student Shiven = new MSStudent("Shiven", 6);
        Student Papa = new Student("Papa");
        Student Humans = new Student("Humans");
        Arnav.registerforclass("Calculus");
        Shiven.registerforclass("Algebra");
        Papa.registerforclass("CS");
        Humans.registerforclass("Playtime");
        S2.registerforclass("ENGLISH");
        S3.test1();
    }

    public class Coordinates {
        //member data
        int x;
        int y;
        //constructor function
        public Coordinates(int x1, int y1) {
            x = x1; y=y1;
            int i, j, k, l;
        }
        //member function
        public String toString() {
            return ( x + ", " + y);
        }
        //member function
        public int maxVal() {
            if (x>y) return x;
            return y;
        }
    }
}
