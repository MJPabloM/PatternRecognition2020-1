package patternrecognition2020.pkg1;

import HerramientasClasificadores.Herramientas;
import clasificadores.MinimaDistancia;
import HerramientasClasificadores.Patron;
import HerramientasClasificadores.PatronRepresentativo;
import clasificadores.Knn;
import java.util.ArrayList;

public class PatternRecognition20201 {


    public static void main(String[] args) {
       
        Herramientas.leerDatos(new int[]{1,1,1});
        
        MinimaDistancia md = new MinimaDistancia();
        md.entrenar(Herramientas.instancias);
        md.clasificar(Herramientas.instancias);
        System.out.println(md.getMc().toString());
        Knn knn = new Knn(2);
        knn.entrenar(Herramientas.instancias);
        knn.clasificar((ArrayList<Patron>)Herramientas.instancias.clone());
        System.out.println(knn.getMc().toString());
    }
    
}
