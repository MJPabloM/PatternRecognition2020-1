package CAP;

import LearnMatrix.Learnmatrix;
import java.util.ArrayList;


public class Main {

    public static void lernmatrix(){
        int[][] x = new int[3][5];
        int[][] y = new int[3][3];
        x[0]= new int[]{1,0,1,0,1};
        x[1]= new int[]{1,1,0,0,1};
        x[2]= new int[]{1,0,1,1,0};
        y[0]= new int[]{1,0,0};
        y[1]= new int[]{0,1,0};
        y[2]= new int[]{0,0,1};


        Learnmatrix lm = new Learnmatrix(x,y,1);
        lm.aprendizaje();
        lm.mostrarM();
        System.out.println("Efectividad: "+lm.recuperacion(x));
    }
    public static void cap(){
        ArrayList<Patron> conjFundamental = new ArrayList<>();
        //conjFundamental.add(new Patron(new double[]{2.1,3.8},"uno"));
        //conjFundamental.add(new Patron(new double[]{6.3,3.8},"dos"));
        conjFundamental.add(new Patron(new double[]{-4.1,3.8},"uno"));
        conjFundamental.add(new Patron(new double[]{-6.3,-3.8},"dos"));
        conjFundamental.add(new Patron(new double[]{-4.8,4.2},"uno"));
        conjFundamental.add(new Patron(new double[]{-6.2,-6.2},"dos"));
        Cap cap = new Cap(conjFundamental);
        cap.aprendizaje();
        cap.mostrarMemoria();
        System.out.println();
        cap.recuperacion(conjFundamental);
    }
    public static void main(String[] args) {
        Main.cap();


    }
}