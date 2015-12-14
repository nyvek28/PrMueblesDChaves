
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeMap;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelPrincipal extends JPanel{
	
	private PanelFormaFabricante modificarFabricante, registrarFabricante, consultarFabricante;// = new PanelRegistrarFabricante();
	private muestra m;
	private PanelMenuPrincipal menu;
	private PanelPlantillaCRUD menuFabricante, menuMontador;
	private PanelFormaMontador registrarMontador;
	
	
	
	public PanelPrincipal() throws Exception{
		
		menu = new PanelMenuPrincipal();
		this.add(menu);
		this.menu.setVisible(true);
		
		registrarFabricante = new PanelRegistrarFabricante();
		this.add(registrarFabricante);
		registrarFabricante.setVisible(false);
		
		menuFabricante = new PanelPlantillaCRUD();
		this.add(menuFabricante);
		menuFabricante.setVisible(false);
		
		modificarFabricante = new PanelModificarFabricante();
		this.add(modificarFabricante);
		modificarFabricante.setVisible(false);
		
		menuMontador = new PanelPlantillaCRUD();
		this.add(menuMontador);
		menuMontador.setVisible(false);
		
		registrarMontador = new PanelRegistrarMontador();
		this.add(registrarMontador);
		registrarMontador.setVisible(false);
		
		consultarFabricante = new PanelConsultarFabricante();
		this.add(consultarFabricante);
		consultarFabricante.setVisible(false);
	
		
		
		//this.registrarFabricante.setVisible(false);
		
		menu.getBtnFabricante().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				menu.setVisible(false);
				menuFabricante.setVisible(true);
			}
			
		});
		
		
		
		modificarFabricante.getBtnAceptar().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				TreeMap info;
				String msj;
				
				try {
					info = (new Gestor()).modificarFabricante(Integer.parseInt(((PanelModificarFabricante) modificarFabricante).getLista().get(((PanelModificarFabricante) modificarFabricante).getComboBoxFabricantes().getSelectedIndex()).get("id")), 
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
				reiniciarPanelFabricante(modificarFabricante);
				modificarFabricante.setVisible(false);
				menu.setVisible(true);
			}
			
		});
		
		modificarFabricante.getBtnCancelar().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				modificarFabricante.setVisible(false);
				reiniciarPanelFabricante(modificarFabricante);
				menu.setVisible(true);
			}
			
		});
		
		this.menuFabricante.getBtnModificar().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				menuFabricante.setVisible(false);
				modificarFabricante.setVisible(true);
				
			}
		});
		
		this.menuFabricante.getBtnRegistrar().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				menuFabricante.setVisible(false);
				registrarFabricante.setVisible(true);
				
			}
		});
		
		this.menuFabricante.getBtnConsultar().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				menuFabricante.setVisible(false);
				consultarFabricante.setVisible(true);
				
			}
		});
		
		this.registrarFabricante.getBtnAceptar().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				TreeMap info;
				String msj;
				
				info = (new Gestor()).registrarFabricante(registrarFabricante.getTextFieldNombre().getText(),
						registrarFabricante.getTextFieldApellido().getText(),
						Integer.parseInt(registrarFabricante.getTextFieldTelefono().getText()), 
						registrarFabricante.getTextFieldDireccion().getText(), 
						Integer.parseInt(registrarFabricante.getTextFieldLinea().getText()), 
						Integer.parseInt(registrarFabricante.getTextFieldAnnos().getText())
						);
				if(info != null){
					msj = "Se registro el fabricante de Id " + info.get("id") + " correctamente";
					registrarFabricante.setVisible(false);
					reiniciarPanelFabricante(registrarFabricante);
					menu.setVisible(true);
				}else{
					msj = "No se logro registrar al fabricante!";
				}
				
				JOptionPane.showMessageDialog(null, msj);
				
			}
			
		});
		
		this.registrarFabricante.getBtnCancelar().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
					
				registrarFabricante.setVisible(false);
				reiniciarPanelFabricante(registrarFabricante);
				menu.setVisible(true);
			
			}
			
		});
		
		this.registrarMontador.getBtnAceptar().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				TreeMap info;
				String msj;
				
				info = (new Gestor()).registrarMontador(Integer.parseInt(registrarMontador.getTextFieldId().getText()),registrarMontador.getTextFieldNombre().getText(),
						registrarMontador.getTextFieldApellido().getText(),
						Integer.parseInt(registrarMontador.getTextFieldTelefono().getText()), 
						registrarMontador.getTextFieldDireccion().getText());
				if(info != null){
					msj = "Se registro el fabricante de Id " + info.get("id") + " correctamente";
					registrarMontador.setVisible(false);
					reiniciarPanelMontador(registrarMontador);
					menu.setVisible(true);
				}else{
					msj = "No se logro registrar al Montador!";
				}
				
				JOptionPane.showMessageDialog(null, msj);
				
			}
			
		});
		
		registrarMontador.getBtnAceptar().addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				
				registrarMontador.setVisible(false);
				menu.setVisible(true);
				
			}
			
		});
		
		menu.getBtnMontador().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				menu.setVisible(false);
				menuMontador.setVisible(true);
			}
			
		});
		
		this.menuMontador.getBtnRegistrar().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				menuMontador.setVisible(false);
				registrarMontador.setVisible(true);
				
			}
		});
		
		registrarMontador.getBtnCancelar().addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				
				registrarMontador.setVisible(false);
				menu.setVisible(true);
				
			}
			
		});
		
		((PanelConsultarFabricante)consultarFabricante).getBtnBuscar().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				TreeMap<String,String> info;
				
				try{
					
					info = (new Gestor()).consultarFabricante(Integer.parseInt(((PanelConsultarFabricante)consultarFabricante).getTxtId().getText()));
					consultarFabricante.getTextFieldNombre().setText(info.get("nombre"));
					consultarFabricante.getTextFieldApellido().setText(info.get("apellido"));
					consultarFabricante.getTextFieldTelefono().setText(info.get("telefono"));
					consultarFabricante.getTextFieldDireccion().setText(info.get("direccion"));
					consultarFabricante.getTextFieldLinea().setText(info.get("linea"));
					consultarFabricante.getTextFieldAnnos().setText(info.get("annosExp"));		
					
				}catch(Exception e2){
					JOptionPane.showMessageDialog(null, "Revise el Id");
				}
				
			}
			
		});
		
		consultarFabricante.getBtnAceptar().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				consultarFabricante.setVisible(false);
				((PanelConsultarFabricante)consultarFabricante).getTxtId().setText(null);
				reiniciarPanelFabricante(consultarFabricante);
				menu.setVisible(true);
			}
			
		});
		
	}
	
	private void reiniciarPanelFabricante(PanelFormaFabricante panelF){
		
		panelF.getTextFieldNombre().setText(null);
		panelF.getTextFieldApellido().setText(null);
		panelF.getTextFieldTelefono().setText(null);
		panelF.getTextFieldDireccion().setText(null);
		panelF.getTextFieldLinea().setText(null);
		panelF.getTextFieldAnnos().setText(null);
		
	}
	
	
	private void reiniciarPanelMontador(PanelFormaMontador panelM){
		
		panelM.getTextFieldNombre().setText(null);
		panelM.getTextFieldApellido().setText(null);
		panelM.getTextFieldTelefono().setText(null);
		panelM.getTextFieldDireccion().setText(null);
	}
	
}
