import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Ventana extends JFrame {
	
	private PanelPrincipal panel;
	
	public Ventana(){
		
		super("Programa de Muebles");
		setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(850,500); 
		this.setLocationRelativeTo(null);
		try {
			panel = new PanelPrincipal();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getContentPane().add(panel);
		

	}
}
