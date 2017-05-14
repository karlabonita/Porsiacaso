


import java.util.TimerTask;
import javax.swing.JOptionPane;


public class Pelota extends TimerTask implements Constantes{
    public int posX;
    public int posY;
    public Escenario escenario;
        
    public Pelota(int _posX, int _posY,Escenario _escenario){
        posX = _posX;
        posY = _posY;
        
        escenario = _escenario;
        escenario.celdas[posX][posY].setTipo('P');
    }
    
    @Override
    public void run() {
               
        escenario.celdas[posX][posY].setTipo('C');
        
        posY++;
        if (posY == NUMERO_CELDAS_LARGO)
            posY=0;
        
        if(escenario.celdas[posX][posY].getTipo() == 'J'){
            JOptionPane.showMessageDialog(null, "Has perdido", "Mensaje", JOptionPane.WARNING_MESSAGE);
            escenario.celdas[posX][posY].setTipo('P');
            escenario.dondeSeDibuja.repaint();
            escenario.dondeSeDibuja.ventana.dispose();
        }
        
        escenario.celdas[posX][posY].setTipo('P');
        
        escenario.dondeSeDibuja.repaint();
    }
    
}
