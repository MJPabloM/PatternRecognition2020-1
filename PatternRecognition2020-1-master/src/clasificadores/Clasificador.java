package clasificadores;

import HerramientasClasificadores.Patron;

import java.util.ArrayList;

public interface Clasificador {
    
    void entrenar(ArrayList<Patron> instancias);
    void clasificar(Patron patron);
    void clasificar(ArrayList<Patron> patrones);
}
