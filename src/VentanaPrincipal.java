


import java.awt.BorderLayout;
import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame implements Constantes{
    public Lienzo lienzo;
    
    
    public VentanaPrincipal(){
        super("Jueguito");
        
        lienzo = new Lienzo(this);
        
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(lienzo);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(ANCHURA_ESCENARIO, LARGO_ESCENARIO);
        setVisible(true);
    }
}