package Clustering;

import clasificadores.CMeans;
import HerramientasClasificadores.Patron;
import HerramientasClasificadores.PatronRepresentativo;

import java.awt.*;
import java.util.ArrayList;

public class ClusteringMain {
    public static ArrayList<PatronRepresentativo> arrayParse( PatronRepresentativo[] centroides) {
        ArrayList<PatronRepresentativo> aux = new ArrayList<>();
        for (int i = 0; i < centroides.length; i++) {
            aux.add(centroides[i]);
        }
        return aux;
    }

    public static void main(String[] args){
        Image io = ImageManager.openImage();
        JFrameImage jFrameImage = new JFrameImage(io);
        ArrayList<Patron> instancias = ImageAdapter.obtenerInstancias(io);
        System.out.println("Lei instancias");
        CMeans cMeans = new CMeans(10);
        cMeans.entrenar(instancias);
        System.out.println("Entrene");
        cMeans.clasificar(instancias);
        System.out.println("Clasifique");
        ArrayList<PatronRepresentativo> centroides = ClusteringMain.arrayParse(cMeans.getCentroides());
        Image nueva = ImageAdapter.generarImagenClusterizada(centroides,instancias,new Dimension(io.getWidth(null),io.getHeight(null)));
        JFrameImage jFrameImageNuevo = new JFrameImage(nueva);
        System.out.println();
    }

}
