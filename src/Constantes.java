

import java.awt.Color;
import java.util.Random;

public interface Constantes {
    public final int PIXEL_CELDA = 32;
    public final int NUMERO_CELDAS_ANCHO = 15;    //Ancho matriz
    public final int NUMERO_CELDAS_LARGO = 10;    //Alto matriz
    public final int ANCHO_BORDE_VENTANA = 30;    //Alto matriz
    public final int LARGO_BORDE_VENTANA = 50;    //Alto matriz
    
    public final int ANCHURA_ESCENARIO = (PIXEL_CELDA*NUMERO_CELDAS_ANCHO) + ANCHO_BORDE_VENTANA;
    public final int LARGO_ESCENARIO   = (PIXEL_CELDA*NUMERO_CELDAS_LARGO) + LARGO_BORDE_VENTANA;
    
    public final char JUGADOR   = 'J';
    public final char PELOTA    = 'P';
    public final char CAMINO    = 'C';
    public final char FINAL     = 'F';
    
    public final Color COLOR_JUGADOR     = Color.BLACK;
    public final Color COLOR_CAMINO      = Color.WHITE;
    
    default int numeroAleatorio(int minimo, int maximo){
        Random rnd = new Random();
        return rnd.nextInt((maximo-minimo)+1)+minimo;
    }
}
