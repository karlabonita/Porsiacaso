



import java.awt.Color;
import javax.swing.JComponent;
import java.awt.Graphics;

public class Celda extends JComponent implements Constantes{
    private int x,y;
    private char tipo;
    
    
    public Celda(int _x, int _y, char _tipo){
        x = _x;
        y = _y;
        tipo = _tipo;
    }
    public char getTipo()   { return tipo;}

    public void setTipo(char _tipo){  tipo = _tipo;}
    
    public void setCeldaAPared()   {tipo = 'O';}
    
    public void setCeldaAObjetivo(){tipo = 'F';}
    
    public boolean esJugador(){ if(tipo=='J')return true; 
                                    return false;}
    
    public boolean noEsPared(){ if(tipo!='O')return true; 
                                    return false;}
    
    @Override
    public void paintComponent(Graphics g){
        switch(tipo){
            case 'J': g.setColor(COLOR_JUGADOR);g.fillRect(x, y, PIXEL_CELDA, PIXEL_CELDA);break; 
            case 'F': g.setColor(Color.BLACK);  g.drawLine(x, y, x+PIXEL_CELDA, y+PIXEL_CELDA); g.drawLine(x+PIXEL_CELDA, y, x, y+PIXEL_CELDA);     break;
            case 'P': g.setColor(Color.black);  g.drawOval(x, y,PIXEL_CELDA,PIXEL_CELDA);break; 
            case 'C': g.setColor(COLOR_CAMINO); g.drawRect(x, y, PIXEL_CELDA, PIXEL_CELDA); break;
        }
    }
}
