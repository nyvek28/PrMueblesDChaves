import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelPrincipal extends JPanel{
	
	private JButton btnFabricante;
	private PanelRegistrarMontador registrarMontador;
	private PanelRegistrarFabricante registrarFabricante = new PanelRegistrarFabricante();
	
	
	public PanelPrincipal(){
		
		this.setLayout(null);
		this.add(registrarFabricante);
		//this.add(registrarMontador);
		
		btnFabricante = new JButton("Fabricante");
		btnFabricante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				botonFabricante();
				
			}
		});
		btnFabricante.setBounds(344, 364, 117, 29);
		this.add(btnFabricante);
		
		this.setVisible(true);
	}
	
	public void botonFabricante(){
		
		//registrarFabricante = new PanelRegistrarFabricante();
		this.setVisible(false);
		registrarFabricante.setVisible(true);
		JOptionPane.showMessageDialog(null, "Hola mundo!");
		
	}
	
}
