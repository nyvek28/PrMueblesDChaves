
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeMap;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelPrincipal extends JPanel{
	
	private PanelFormaFabricante modificarFabricante, registrarFabricante, consultarFabricante, eliminarFabricante;// = new PanelRegistrarFabricante();
	private muestra m;
	private PanelMenuPrincipal menu;
	private PanelPlantillaCRUD menuFabricante, menuMontador, menuCliente;
	private PanelFormaMontador registrarMontador,modificarMontador, consultarMontador, eliminarMontador;
	private PanelFormaCliente registrarCliente, modificarCliente, consultarCliente, eliminarCliente;
	
	
	
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
		
		consultarFabricante = new PanelConsultarFabricante();
		this.add(consultarFabricante);
		consultarFabricante.setVisible(false);
		consultarFabricante.getBtnCancelar().setVisible(false);
		
		eliminarFabricante = new PanelConsultarFabricante();
		this.add(eliminarFabricante);
		eliminarFabricante.setVisible(false);
		
		menuMontador = new PanelPlantillaCRUD();
		this.add(menuMontador);
		menuMontador.setVisible(false);
		
		registrarMontador = new PanelRegistrarMontador();
		this.add(registrarMontador);
		registrarMontador.setVisible(false);
		
		modificarMontador = new PanelModificarMontador();
		this.add(modificarMontador);
		modificarMontador.setVisible(false);
		
		consultarMontador = new PanelConsultarMontador();
		this.add(consultarMontador);
		consultarMontador.setVisible(false);
		consultarMontador.getBtnCancelar().setVisible(false);
		
		eliminarMontador = new PanelConsultarMontador();
		this.add(eliminarMontador);
		eliminarMontador.setVisible(false);
		
		registrarCliente = new PanelRegistrarCliente();
		this.add(registrarCliente);
		registrarCliente.setVisible(false);
		
		modificarCliente = new PanelModificarCliente();
		this.add(modificarCliente);
		modificarCliente.setVisible(false);
		
		consultarCliente = new PanelConsultarCliente();
		this.add(consultarCliente);
		consultarCliente.setVisible(false);
		consultarCliente.getBtnCancelar().setVisible(false);
		
		eliminarCliente = new PanelConsultarCliente();
		this.add(eliminarCliente);
		eliminarCliente.setVisible(false);
		
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
		
		this.menuFabricante.getBtnEliminar().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				menuFabricante.setVisible(false);
				eliminarFabricante.setVisible(true);
				
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
		
		menu.getBtnMontador().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				menu.setVisible(false);
				menuMontador.setVisible(true);
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
		
		
		this.menuMontador.getBtnModificar().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				menuMontador.setVisible(false);
				modificarMontador.setVisible(true);
				
			}
		});
		

		modificarMontador.getBtnAceptar().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				TreeMap info;
				String msj;
				
				try {
					info = (new Gestor()).modificarMontador(Integer.parseInt(((PanelModificarMontador) modificarMontador).getLista().get(((PanelModificarMontador) modificarMontador).getComboBoxMontadores().getSelectedIndex()).get("id")), 
									modificarMontador.getTextFieldNombre().getText(), 
									modificarMontador.getTextFieldApellido().getText(), 
									Integer.parseInt(modificarMontador.getTextFieldTelefono().getText()), 
									modificarMontador.getTextFieldDireccion().getText()
									);
				} catch (Exception e1) {
					info = null;
					e1.printStackTrace();
				}
				if(info != null){
					msj = "Se modifico el Montador de Id " + info.get("id") + " correctamente";
				}else{
					msj = "No se logro modificar al Montador!";
				}
				
				JOptionPane.showMessageDialog(null, msj);
				reiniciarPanelMontador(modificarMontador);
				modificarMontador.setVisible(false);
				menu.setVisible(true);
			}
		});
		
		this.menuMontador.getBtnConsultar().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				menuMontador.setVisible(false);
				consultarMontador.setVisible(true);
				
			}
		});
		
		consultarMontador.getBtnAceptar().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				consultarMontador.setVisible(false);
				((PanelConsultarMontador)consultarMontador).getTxtId().setText(null);
				reiniciarPanelMontador(consultarMontador);

				menu.setVisible(true);
			}
			
		});
		

		((PanelConsultarMontador)consultarMontador).getBtnBuscar().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				TreeMap<String,String> info;
				
				try{
					
					info = (new Gestor()).consultarMontador(Integer.parseInt(((PanelConsultarMontador)consultarMontador).getTxtId().getText()));
					consultarMontador.getTextFieldNombre().setText(info.get("nombre"));
					consultarMontador.getTextFieldApellido().setText(info.get("apellido"));
					consultarMontador.getTextFieldTelefono().setText(info.get("telefono"));
					consultarMontador.getTextFieldDireccion().setText(info.get("direccion"));
					
				}catch(Exception e2){
					JOptionPane.showMessageDialog(null, "Revise el Id");
				}
				
			}
			
		});
		
		eliminarMontador.getBtnAceptar().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String msj;
				
				try {
					(new Gestor()).eliminarMontador(Integer.parseInt(((PanelConsultarMontador)eliminarMontador).getTxtId().getText()));
					eliminarMontador.setVisible(false);
					((PanelConsultarMontador)eliminarMontador).getTxtId().setText(null);
					reiniciarPanelMontador(eliminarMontador);
					menu.setVisible(true);
					msj = "Se logro eliminar al Montador";
				} catch (Exception e1) {
					msj = "No se logro eliminar al montador";
					e1.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null, msj);
				
			}
			
		});
		
		((PanelConsultarMontador)eliminarMontador).getBtnBuscar().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				TreeMap<String,String> info;
				
				try{
					
					info = (new Gestor()).consultarMontador(Integer.parseInt(((PanelConsultarMontador)eliminarMontador).getTxtId().getText()));
					eliminarMontador.getTextFieldNombre().setText(info.get("nombre"));
					eliminarMontador.getTextFieldApellido().setText(info.get("apellido"));
					eliminarMontador.getTextFieldTelefono().setText(info.get("telefono"));
					eliminarMontador.getTextFieldDireccion().setText(info.get("direccion"));		
					
				}catch(Exception e2){
					JOptionPane.showMessageDialog(null, "Revise el Id");
				}
				

			}
			
		});
		
		eliminarMontador.getBtnCancelar().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
		
				eliminarMontador.setVisible(false);
				((PanelConsultarMontador)eliminarMontador).getTxtId().setText(null);
				reiniciarPanelMontador(eliminarMontador);
				menu.setVisible(true);
				
			}
			
		});
		
		this.menuMontador.getBtnEliminar().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				menuMontador.setVisible(false);
				eliminarMontador.setVisible(true);
				
			}
		});
		
		// ========================= aqui inicia cliente ====================//
		
		menu.getBtnCliente().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				menu.setVisible(false);
				menuCliente.setVisible(true);
			}
			
		});
		
		this.registrarCliente.getBtnAceptar().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				TreeMap info;
				String msj;
				
				info = (new Gestor()).registrarCliente(Integer.parseInt(registrarCliente.getTextFieldId().getText()),registrarCliente.getTextFieldNombre().getText(),
						registrarCliente.getTextFieldApellido().getText(),
						Integer.parseInt(registrarCliente.getTextFieldTelefono().getText()), 
						registrarCliente.getTextFieldDireccion().getText(),
						registrarCliente.getTextFieldTrabajo().getText(),
						Integer.parseInt(registrarCliente.getTextFieldTelTrabajo().getText()));
				if(info != null){
					msj = "Se registro el cliente de Id " + info.get("id") + " correctamente";
					registrarCliente.setVisible(false);
					reiniciarPanelCliente(registrarCliente);
					menu.setVisible(true);
				}else{
					msj = "No se logro registrar al Cliente!";
				}
				
				JOptionPane.showMessageDialog(null, msj);
				
			}
			
		});
		
		registrarCliente.getBtnAceptar().addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				
				registrarCliente.setVisible(false);
				menu.setVisible(true);
				
			}
			
		});
		
		this.menuCliente.getBtnRegistrar().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				menuCliente.setVisible(false);
				registrarCliente.setVisible(true);
				
			}
		});
		
		this.menuCliente.getBtnModificar().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				menuCliente.setVisible(false);
				modificarCliente.setVisible(true);
				
			}
		});
		

		modificarCliente.getBtnAceptar().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				TreeMap info;
				String msj;
				
				try {
					info = (new Gestor()).modificarCliente(Integer.parseInt(((PanelModificarCliente) modificarCliente).getLista().get(((PanelModificarCliente) modificarCliente).getComboBoxClientes().getSelectedIndex()).get("id")), 
									modificarCliente.getTextFieldNombre().getText(), 
									modificarCliente.getTextFieldApellido().getText(), 
									Integer.parseInt(modificarCliente.getTextFieldTelefono().getText()), 
									modificarCliente.getTextFieldDireccion().getText(),
									modificarCliente.getTextFieldTrabajo().getText(),
									Integer.parseInt(modificarCliente.getTextFieldTelTrabajo().getText())
									);
				} catch (Exception e1) {
					info = null;
					e1.printStackTrace();
				}
				if(info != null){
					msj = "Se modifico el Cliente de Id " + info.get("id") + " correctamente";
				}else{
					msj = "No se logro modificar al cliente!";
				}
				
				JOptionPane.showMessageDialog(null, msj);
				reiniciarPanelCliente(modificarCliente);
				modificarCliente.setVisible(false);
				menu.setVisible(true);
			}
		});
		
		this.menuCliente.getBtnConsultar().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				menuCliente.setVisible(false);
				consultarCliente.setVisible(true);
				
			}
		});
		
		consultarCliente.getBtnAceptar().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				consultarCliente.setVisible(false);
				((PanelConsultarCliente)consultarCliente).getTxtId().setText(null);
				reiniciarPanelCliente(consultarCliente);

				menu.setVisible(true);
			}
			
		});
		

		((PanelConsultarCliente)consultarCliente).getBtnBuscar().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				TreeMap<String,String> info;
				
				try{
					
					info = (new Gestor()).consultarCliente(Integer.parseInt(((PanelConsultarCliente)consultarCliente).getTxtId().getText()));
					consultarCliente.getTextFieldNombre().setText(info.get("nombre"));
					consultarCliente.getTextFieldApellido().setText(info.get("apellido"));
					consultarCliente.getTextFieldTelefono().setText(info.get("telefono"));
					consultarCliente.getTextFieldDireccion().setText(info.get("direccion"));
					consultarCliente.getTextFieldTrabajo().setText(info.get("trabajo"));
					consultarCliente.getTextFieldTelTrabajo().setText(info.get("telTrabajo"));
					
					
				}catch(Exception e2){
					JOptionPane.showMessageDialog(null, "Revise el Id");
				}
				
			}
			
		});
		
		eliminarMontador.getBtnCancelar().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
		
				eliminarMontador.setVisible(false);
				((PanelConsultarMontador)eliminarMontador).getTxtId().setText(null);
				reiniciarPanelMontador(eliminarMontador);
				menu.setVisible(true);
				
			}
			
		});
		
		this.menuMontador.getBtnEliminar().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				menuMontador.setVisible(false);
				eliminarMontador.setVisible(true);
				
			}
		});
		
		//======================= aqui empieza fabricante   ======================//

		eliminarFabricante.getBtnAceptar().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String msj;
				
				try {
					(new Gestor()).eliminarFabricante(Integer.parseInt(((PanelConsultarFabricante)eliminarFabricante).getTxtId().getText()));
					eliminarFabricante.setVisible(false);
					((PanelConsultarFabricante)eliminarFabricante).getTxtId().setText(null);
					reiniciarPanelFabricante(eliminarFabricante);
					menu.setVisible(true);
					msj = "Se logro eliminar al fabricante";
				} catch (Exception e1) {
					msj = "No se logro eliminar al fabricante";
					e1.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null, msj);
				
			}
			
		});
		
		eliminarFabricante.getBtnCancelar().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
		
				eliminarFabricante.setVisible(false);
				((PanelConsultarFabricante)eliminarFabricante).getTxtId().setText(null);
				reiniciarPanelFabricante(eliminarFabricante);
				menu.setVisible(true);
				
			}
			
		});
		
		((PanelConsultarFabricante)eliminarFabricante).getBtnBuscar().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				TreeMap<String,String> info;
				
				try{
					
					info = (new Gestor()).consultarFabricante(Integer.parseInt(((PanelConsultarFabricante)eliminarFabricante).getTxtId().getText()));
					eliminarFabricante.getTextFieldNombre().setText(info.get("nombre"));
					eliminarFabricante.getTextFieldApellido().setText(info.get("apellido"));
					eliminarFabricante.getTextFieldTelefono().setText(info.get("telefono"));
					eliminarFabricante.getTextFieldDireccion().setText(info.get("direccion"));
					eliminarFabricante.getTextFieldLinea().setText(info.get("linea"));
					eliminarFabricante.getTextFieldAnnos().setText(info.get("annosExp"));		
					
				}catch(Exception e2){
					JOptionPane.showMessageDialog(null, "Revise el Id");
				}
				

			}
			
		});
		

		modificarMontador.getBtnCancelar().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e){ 
				modificarMontador.setVisible(false);
				reiniciarPanelMontador(modificarMontador);
				menu.setVisible(true);
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
	
	private void reiniciarPanelCliente(PanelFormaCliente panelC){
		
		panelC.getTextFieldNombre().setText(null);
		panelC.getTextFieldApellido().setText(null);
		panelC.getTextFieldTelefono().setText(null);
		panelC.getTextFieldDireccion().setText(null);
		panelC.getTextFieldTrabajo().setText(null);
		panelC.getTextFieldTelTrabajo().setText(null);
		
	}
	
}
			
