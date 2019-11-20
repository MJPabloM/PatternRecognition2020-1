package patternrecognition2020.pkg1;
import clasificadores.Knn;
import HerramientasClasificadores.Herramientas;
import clasificadores.MinimaDistancia;
import HerramientasClasificadores.Patron;


import java.util.ArrayList;


public class SupervisadoMain {

    public static int[] arregloBinario(int n){
        String bin= Integer.toBinaryString(n);
        String[] aux= bin.split("");
        int[] binario = new int[aux.length];
        for (int i = aux.length -1; i > -1 ; i--) {
            binario[i]= Integer.parseInt(aux[i]) ;
        }
        return binario;
    }

    public static void main(String[] args) {
        MinimaDistancia md = new MinimaDistancia();
        Knn knn= new Knn(3);
        Herramientas.leerDatos();
        md.entrenar(Herramientas.instancias);
        knn.entrenar(Herramientas.instancias);
        Herramientas.leerDatos();
        md.clasificar(Herramientas.instancias);
        knn.clasificar((ArrayList<Patron>)Herramientas.instancias.clone());
        System.out.println(md.getMc().toString());
        System.out.println(knn.getMc().toString());
    }
    
}
