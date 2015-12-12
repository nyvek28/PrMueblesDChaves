
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class PanelPrincipal extends JPanel{
	
	private PanelRegistrarMontador registrarMontador;//= new PanelRegistrarMontador();
	private PanelRegistrarFabricante registrarFabricante;
	private PanelModificarFabricante modificarFabricante;// = new PanelRegistrarFabricante();
	private muestra m;
	
	
	public PanelPrincipal(){
		registrarMontador = new PanelRegistrarMontador();
		this.add(registrarMontador);
		this.registrarMontador.setVisible(true);
		registrarFabricante = new PanelRegistrarFabricante();
		this.add(registrarFabricante);
		registrarFabricante.setVisible(false);
		try {
			modificarFabricante = new PanelModificarFabricante();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.add(modificarFabricante);
		modificarFabricante.setVisible(false);
		m = new muestra();
		this.add(m);
		m.setVisible(false);
	
		
		
		//this.registrarFabricante.setVisible(false);
		
		registrarMontador.getBoton().addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				
				registrarMontador.setVisible(false);
				m.setVisible(true);
				
			}
			
		});
		
		m.getBoton().addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				
				m.setVisible(false);
				modificarFabricante.setVisible(true);
				
			}
			
		});
		
	}
	
}
