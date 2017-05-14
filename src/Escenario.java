/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Graphics;
import javax.swing.JComponent;

public class Escenario extends JComponent implements Constantes{
    public Celda[][] celdas;
    public Jugador jugador;
    public JugadorAuto jugadorAuto;
    public Pelota[] pelotas;
    public Lienzo dondeSeDibuja;
    
    public Escenario(Lienzo lienzo){
        dondeSeDibuja = lienzo;
        celdas = new Celda[NUMERO_CELDAS_ANCHO][NUMERO_CELDAS_LARGO];
        pelotas = new Pelota[NUMERO_CELDAS_ANCHO-3];
        
        for (int i = 0; i < NUMERO_CELDAS_ANCHO; i++) 
            for (int j = 0; j < NUMERO_CELDAS_LARGO; j++) 
               celdas[i][j] = new Celda(i+(i*PIXEL_CELDA),j+(j*PIXEL_CELDA),'C');
        
        
        int posX=2;
        for (int i = 0; i < NUMERO_CELDAS_ANCHO-3; i++)
            pelotas[i] = new Pelota(posX++,numeroAleatorio(0,NUMERO_CELDAS_LARGO-1),this);
        
        celdas[NUMERO_CELDAS_ANCHO-1][NUMERO_CELDAS_LARGO-1].setCeldaAObjetivo();
        
        jugadorAuto = new JugadorAuto(this);

    }
    
    @Override
    public void paintComponent(Graphics g){
        for (int i = 0; i < NUMERO_CELDAS_ANCHO; i++) 
            for (int j = 0; j < NUMERO_CELDAS_LARGO; j++) 
                celdas[i][j].paintComponent(g);
    }
}
