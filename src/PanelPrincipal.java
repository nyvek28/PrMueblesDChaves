
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeMap;

import javax.swing.JOptionPane;
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
		
		modificarFabricante.getBtnAceptar().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				TreeMap info;
				String msj;
				
				try {
					info = (new Gestor()).modificarFabricante(Integer.parseInt(modificarFabricante.getLista().get(modificarFabricante.getComboBoxFabricantes().getSelectedIndex()).get("id")), 
									modificarFabricante.getTextFieldNombre().getText(), 
									modificarFabricante.getTextFieldApellido().getText(), 
									Integer.parseInt(modificarFabricante.getTextFieldTelefono().getText()), 
									modificarFabricante.getTextFieldDireccion().getText(), 
									Integer.parseInt(modificarFabricante.getTextFieldLinea().getText()), 
									Integer.parseInt(modificarFabricante.getTextFieldAnnos().getText())
									);
				} catch (Exception e1) {
					info = null;
					e1.printStackTrace();
				}
				if(info != null){
					msj = "Se modifico el fabricante de Id " + info.get("id") + " correctamente";
				}else{
					msj = "No se logro modificar al fabricante!";
				}
				
				JOptionPane.showMessageDialog(null, msj);
				modificarFabricante.getTextFieldApellido().removeAll();
				reiniciarPanelFabricante();
				modificarFabricante.setVisible(false);
				m.setVisible(true);
			}
			
		});
		
		modificarFabricante.getBtnCancelar().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				modificarFabricante.setVisible(false);
				reiniciarPanelFabricante();
				m.setVisible(true);
			}
			
		});
		
	}
	
	private void reiniciarPanelFabricante(){
		
		this.modificarFabricante.getTextFieldNombre().setText(null);
		this.modificarFabricante.getTextFieldApellido().setText(null);
		this.modificarFabricante.getTextFieldTelefono().setText(null);
		this.modificarFabricante.getTextFieldDireccion().setText(null);
		this.modificarFabricante.getTextFieldLinea().setText(null);
		this.modificarFabricante.getTextFieldAnnos().setText(null);
		
	}
	
}
