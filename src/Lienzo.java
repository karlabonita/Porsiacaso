/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;

public class Lienzo extends Canvas implements Constantes{
    public Escenario escenario;
    public Timer lanzadorTareas;
    public VentanaPrincipal ventana;
    
    public Lienzo(VentanaPrincipal _ventana){
        ventana = _ventana;
        escenario = new Escenario(this);
        lanzadorTareas = new Timer();
        
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                escenario.jugador.moverCelda(e);
                repaint();
            }
        });
        
        for (int i = 0; i < NUMERO_CELDAS_ANCHO-3; i++) 
            lanzadorTareas.scheduleAtFixedRate(escenario.pelotas[i], 0 , 1000);
        
        lanzadorTareas.scheduleAtFixedRate(escenario.jugadorAuto, 0 , 100);
    }
    
    @Override
    public void paint(Graphics g){
        escenario.paintComponent(g);
    }
}