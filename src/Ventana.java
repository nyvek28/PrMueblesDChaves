import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Ventana extends JFrame {
	
	private PanelPrincipal panel;
	
	public Ventana(){
		
		super("Ventana");
		setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000,1000); 
		this.setLocationRelativeTo(null);
		panel = new PanelPrincipal();
		this.getContentPane().add(panel);
		

	}
}
