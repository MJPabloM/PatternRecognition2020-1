package HerramientasClasificadores;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Herramientas {
    public static ArrayList<Patron> instancias;
    public static File abre;


    public static void leerDatos(int[] config){
        instancias = new ArrayList<>();
        String texto, aux;
        LinkedList<String> lista = new LinkedList();

        try {

            if (abre == null){
                JFileChooser file = new JFileChooser();
                file.setCurrentDirectory(new File("./"));
                file.showOpenDialog(file);
                abre = file.getSelectedFile();

            }

            //abrimos el archivo seleccionado

            //recorremos el archivo y lo leemos
            if (abre != null) {
                FileReader archivos = new FileReader(abre);
                BufferedReader lee = new BufferedReader(archivos);

                while ((aux = lee.readLine()) != null) {
                    texto = aux;
                    lista.add(texto);
                }
                lee.close();
                //System.out.println(lista.size());

                ArrayList<String> lista2 = new ArrayList<>();
                String clase = "";
                for (int i = 0; i < lista.size(); i++) {
                    StringTokenizer st = new StringTokenizer(lista.get(i), ",");

                    while (st.hasMoreTokens()) {
                        lista2.add(st.nextToken());
                    }

                    double[] vector = new double[obtnerDimension(config)];
                    int j=0;
                    for (int x = 0; x < config.length; x++) {
                        if(config[x] == 1) {
                            vector[j] = Double.parseDouble(lista2.get(x));
                            j++;
                        }
                    }

                    clase = lista2.get(lista2.size()-1);
                    // a la coleccion de patrones se agrega un nuevo patron
                    instancias.add(new Patron(vector, clase));
                    // patrones.add();
                    lista2.clear();

                }

            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + ""
                            + "\nNo se ha encontrado el archivo",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);

        }



    }


    public static void leerDatos(){
        String texto, aux;
        LinkedList<String> lista = new LinkedList();

        try {
            //llamamos el metodo que permite cargar la ventana
            JFileChooser file = new JFileChooser();
            file.setCurrentDirectory(new File("./"));
            file.showOpenDialog(file);
            //abrimos el archivo seleccionado
            File abre = file.getSelectedFile();

            //recorremos el archivo y lo leemos
            instancias = new ArrayList<>();
            if (abre != null) {
                FileReader archivos = new FileReader(abre);
                BufferedReader lee = new BufferedReader(archivos);

                while ((aux = lee.readLine()) != null) {
                    texto = aux;
                    lista.add(texto);
                }
                lee.close();
                //System.out.println(lista.size());

                ArrayList<String> lista2 = new ArrayList<>();
                String clase = "";
                for (int i = 0; i < lista.size(); i++) {
                    StringTokenizer st = new StringTokenizer(lista.get(i), ",");

                    while (st.hasMoreTokens()) {
                        lista2.add(st.nextToken());
                    }

                    double[] vector = new double[lista2.size() - 1];

                    for (int x = 0; x < lista2.size() - 1; x++) {
                        vector[x] = Double.parseDouble(lista2.get(x));
                    }

                    clase = lista2.get(lista2.size()-1);
                    // a la coleccion de patrones se agrega un nuevo patron
                    instancias.add(new Patron(vector, clase));
                   // patrones.add();
                    lista2.clear();

                }
          
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + ""
                    + "\nNo se ha encontrado el archivo",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
            
        }
       
       
     
    }


    private static int obtnerDimension(int[] config) {
        int c=0;
        for (int x= 0; x< config.length; x++){
            if (config[x] == 1){
                c++;
            }
        }
        return  c;
    }


    public static double calcularDistanciaEuclidiana(Patron a, Patron b){
        double aux = 0;
        for (int x=0;x<a.getVector().length;x++){
            aux+=Math.pow((a.getVector()[x]-b.getVector()[x]),2);
        }
        return Math.sqrt(aux);
        
        
    }
    
    public static int[][] multiplicadorMatrices(int[][] a, int[][] b){
        int[][] c = new int[a.length][b[0].length];
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length ; j++) {
                c[i][j] = 0;
                for (int k = 0; k < a[0].length ; k++) {
                    c[i][j]+= a[i][k]*b[k][j];
                }
            }
        }
        return c;
    }

}
