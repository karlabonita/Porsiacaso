

import java.util.TimerTask;
import javax.swing.JOptionPane;

public class JugadorAuto extends TimerTask implements Constantes{
    public int posX;
    public int posY;
    public Escenario escenario;
    
    public JugadorAuto(Escenario _escenario){
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
            
            if(escenario.celdas[posX][posY-1].getTipo() != 'P'){
                escenario.celdas[posX][posY].setTipo('C');
                escenario.celdas[posX][--posY].setTipo('J');   
                escenario.dondeSeDibuja.repaint();
            }
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
            if(escenario.celdas[posX][posY+1].getTipo() != 'P'){
                escenario.celdas[posX][posY].setTipo('C');
                escenario.celdas[posX][++posY].setTipo('J');
                escenario.dondeSeDibuja.repaint();
            }
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
            if(escenario.celdas[posX-1][posY].getTipo() != 'P'){
                escenario.celdas[posX][posY].setTipo('C');
                escenario.celdas[--posX][posY].setTipo('J');
                escenario.dondeSeDibuja.repaint();
            }
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
            if(escenario.celdas[posX+1][posY].getTipo() != 'P'){
                escenario.celdas[posX][posY].setTipo('C');
                escenario.celdas[++posX][posY].setTipo('J');
                escenario.dondeSeDibuja.repaint();
            }
        }
    }

    @Override
    public void run() {
       moverDerecha();
       moverIzquierda();
       moverArriba();
       moverAbajo();
    }
}
