

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;


public class Jugador implements Constantes{
    public int posX;
    public int posY;
    public Escenario escenario;
    
    public Jugador(Escenario _escenario){
        posX = 0;
        posY = 0;
        escenario = _escenario;        
    }
    
    public void moverArriba(){
        if (posY-1 > -1) {
            if(escenario.celdas[posX][posY-1].getTipo() == 'P'){
                JOptionPane.showMessageDialog(null, "Has perdido", "Mensaje", JOptionPane.WARNING_MESSAGE);
                escenario.dondeSeDibuja.ventana.dispose();
            }
            if(escenario.celdas[posX][posY-1].getTipo() == 'F'){
                escenario.celdas[posX][posY].setTipo('C');
                escenario.celdas[posX][posY-1].setTipo('J');
                escenario.dondeSeDibuja.repaint();
                JOptionPane.showMessageDialog(null, "Has ganado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                escenario.dondeSeDibuja.ventana.dispose();
            }
            
            escenario.celdas[posX][posY].setTipo('C');
            escenario.celdas[posX][--posY].setTipo('J');
        }
    }
    public void moverAbajo(){
        if (posY+1<NUMERO_CELDAS_LARGO) {
            if(escenario.celdas[posX][posY+1].getTipo() == 'P'){
                JOptionPane.showMessageDialog(null, "Has perdido", "Mensaje", JOptionPane.WARNING_MESSAGE);
                escenario.dondeSeDibuja.ventana.dispose();
            }
            if(escenario.celdas[posX][posY+1].getTipo() == 'F'){
                escenario.celdas[posX][posY].setTipo('C');
                escenario.celdas[posX][posY+1].setTipo('J');
                escenario.dondeSeDibuja.repaint();
                JOptionPane.showMessageDialog(null, "Has ganado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                escenario.dondeSeDibuja.ventana.dispose();
            }           
            escenario.celdas[posX][posY].setTipo('C');
            escenario.celdas[posX][++posY].setTipo('J');
        }
    }
    public void moverIzquierda(){
        if (posX-1 > -1) {
            if(escenario.celdas[posX-1][posY].getTipo() == 'P'){
                JOptionPane.showMessageDialog(null, "Has perdido", "Mensaje", JOptionPane.WARNING_MESSAGE);
                escenario.dondeSeDibuja.ventana.dispose();
            }
            if(escenario.celdas[posX-1][posY].getTipo() == 'F'){
                escenario.celdas[posX][posY].setTipo('C');
                escenario.celdas[posX-1][posY].setTipo('J');
                escenario.dondeSeDibuja.repaint();
                JOptionPane.showMessageDialog(null, "Has ganado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                escenario.dondeSeDibuja.ventana.dispose();
            }
            escenario.celdas[posX][posY].setTipo('C');
            escenario.celdas[--posX][posY].setTipo('J');
        }
    }
    public void moverDerecha(){
        if (posX+1 < NUMERO_CELDAS_ANCHO) {
            if(escenario.celdas[posX+1][posY].getTipo() == 'P'){
                JOptionPane.showMessageDialog(null, "Has perdido", "Mensaje", JOptionPane.WARNING_MESSAGE);
                escenario.dondeSeDibuja.ventana.dispose();
            }
            if(escenario.celdas[posX+1][posY].getTipo() == 'F'){                
                escenario.celdas[posX][posY].setTipo('C');
                escenario.celdas[posX+1][posY].setTipo('J');
                escenario.dondeSeDibuja.repaint();
                JOptionPane.showMessageDialog(null, "Has ganado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                escenario.dondeSeDibuja.ventana.dispose();
            }
            escenario.celdas[posX][posY].setTipo('C');
            escenario.celdas[++posX][posY].setTipo('J');
        }
    }
    
    public void moverCelda(KeyEvent e){
        switch(e.getKeyCode()){
            case KeyEvent.VK_UP:
                moverArriba();
                break;
            case KeyEvent.VK_DOWN:
                moverAbajo();
                break;
            case KeyEvent.VK_RIGHT:
                moverDerecha();
                break;
            case KeyEvent.VK_LEFT:
                moverIzquierda();                
                break;
            }
        
        escenario.dondeSeDibuja.repaint();
    }
}


