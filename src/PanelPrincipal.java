
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TreeMap;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelPrincipal extends JPanel{
	
	private PanelFormaFabricante modificarFabricante, registrarFabricante, consultarFabricante, eliminarFabricante;// = new PanelRegistrarFabricante();
	private PanelFormaDistribuidor modificarDistribuidor, registrarDistribuidor, consultarDistribuidor, eliminarDistribuidor, darMuebleaDistribuidor;
	private muestra m;
	private PanelMenuPrincipal menu;
	private PanelPlantillaCRUD menuFabricante, menuMontador, menuCliente, menuDistribuidor, menuVenta, menuMueble, menuJuego;
	private PanelFormaMontador registrarMontador,modificarMontador, consultarMontador, eliminarMontador;
	private PanelFormaCliente registrarCliente, modificarCliente, consultarCliente, eliminarCliente;
	private PanelFormaJuego registrarJuego, consultarJuego;
	private PanelFormaMueble registrarMueble, consultarMueble;
	private PanelFormaVenta consultarVenta;
	private PanelRealizarVenta registrarVenta;
	private PanelArmarJuego armarJuego;
	private PanelDarMuebleADistribuidor darMueble;
	
	
	public PanelPrincipal() throws Exception{
		
		registrarMueble= new PanelRegistrarMueble();
		this.registrarMueble.setVisible(false);
		this.add(registrarMueble);
		
		consultarMueble= new PanelConsultarMueble();
		this.consultarMueble.setVisible(false);
		this.add(consultarMueble);
		
		consultarVenta= new PanelConsultarVenta();
		this.consultarVenta.setVisible(false);
		this.add(consultarVenta);
		
		registrarVenta= new PanelRealizarVenta();
		this.registrarVenta.setVisible(false);
		this.add(registrarVenta);
		
		consultarJuego= new PanelConsultarJuego();
		this.consultarJuego.setVisible(false);
		this.add(consultarJuego);
		
		menu = new PanelMenuPrincipal();
		this.add(menu);
		this.menu.setVisible(true);
		
		menuVenta= new PanelPlantillaCRUD();
		this.add(menuVenta);
		this.menuVenta.setVisible(false);
		menuMueble= new PanelPlantillaCRUD();
		this.add(menuMueble);
		this.menuMueble.setVisible(false);
		
		menuJuego= new PanelPlantillaCRUD();
		this.add(menuJuego);
		this.menuJuego.setVisible(false);
		
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
		
		menuCliente = new PanelPlantillaCRUD();
		this.add(menuCliente);
		menuCliente.setVisible(false);
		
		menuDistribuidor = new PanelPlantillaCRUD();
		this.add(menuDistribuidor);
		menuDistribuidor.setVisible(false);
		
		darMuebleaDistribuidor=new PanelDarMuebleADistribuidor();
		this.add(darMuebleaDistribuidor);
		darMuebleaDistribuidor.setVisible(false);
		
		registrarDistribuidor = new PanelRegistrarDistribuidor();
		this.add(registrarDistribuidor);
		registrarDistribuidor.setVisible(false);
		
		modificarDistribuidor = new PanelModificarDistribuidor();
		this.add(modificarDistribuidor);
		modificarDistribuidor.setVisible(false);
		
		consultarDistribuidor = new PanelConsultarDistribuidor();
		this.add(consultarDistribuidor);
		consultarDistribuidor.setVisible(false);
		consultarDistribuidor.getBtnCancelar().setVisible(false);
		
		eliminarDistribuidor = new PanelConsultarDistribuidor();
		this.add(eliminarDistribuidor);
		eliminarDistribuidor.setVisible(false);
		
		armarJuego = new PanelArmarJuego();
		this.add(armarJuego);
		armarJuego.setVisible(false);
		
		darMueble= new PanelDarMuebleADistribuidor();
		this.add(darMueble);
		darMueble.setVisible(false);
		
		//this.registrarFabricante.setVisible(false);
		
		this.inicializarMenu();
		this.inicializarPanelesFabricante();
		this.inicializarPanelesDistribuidor();
		this.inicializarPanelesCliente();
		this.inicializarPanelesJuego();
		this.inicializarPanelesMontador();
		this.inicializarPanelesVenta();
		this.inicializarPanelesMueble();
	
			
	}

//================================================================================================================================//	
	
	private void inicializarMenu(){
		
		menu.getBtnFabricante().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				menu.setVisible(false);
				menuFabricante.setVisible(true);
			}
			
		});
		
		menu.getBtnJuego().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				menu.setVisible(false);
				menuJuego.setVisible(true);
				// TODO Auto-generated method stub
				
			}
			
		});
		
		menu.getBtnMueble().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				menu.setVisible(false);
				menuMueble.setVisible(true);
				
			}
			
		});
		
		menu.getBtnVenta().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				menu.setVisible(false);
				menuVenta.setVisible(true);
				
			}
			
		});
		
		menu.getBtnDistribuidor().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				menu.setVisible(false);
				menuDistribuidor.setVisible(true);
			}
			
		});
		
		
		menu.getBtnMontador().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				menu.setVisible(false);
				menuMontador.setVisible(true);
			}
			
		});
		
		menu.getBtnCliente().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				menu.setVisible(false);
				menuCliente.setVisible(true);
			}
			
		});
		
		menu.getBtnSalir().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
		
	}
	
//================================================================================================================================//
	
	private void inicializarPanelesFabricante(){
		
		//======================= Modificar   ======================//
		
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
		
		//======================= Menu   ======================//
		
		this.menuFabricante.getBtnModificar().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				menuFabricante.setVisible(false);
				try {
					((PanelModificarFabricante) modificarFabricante).llenarSelect();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
		
		//======================= Registrar   ======================//
		
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
		
		//======================= Eliminar   ======================//
		
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
		
		//======================= Consultar   ======================//
		
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

//================================================================================================================================//
	
	private void inicializarPanelesDistribuidor(){
		
		
		//======================DarMuebles==========================//
		
		JButton BtnDarMueble= new JButton("Dar Mueble");
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 4;
		c.gridy = 5;
		c.anchor = GridBagConstraints.CENTER;
		
		
		this.menuDistribuidor.add(BtnDarMueble,c);
		BtnDarMueble.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				menuDistribuidor.setVisible(false);
				try {
					darMueble.iniciarPanel();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				darMuebleaDistribuidor.setVisible(true);
				
			}
				
		});

		darMuebleaDistribuidor.getBtnCancelar().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				darMuebleaDistribuidor.setVisible(false);
				menu.setVisible(true);
			}
			
		});
		
		darMuebleaDistribuidor.getBtnAceptar().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
		
		
		//======================= Modificar   ======================//
		
		
				modificarDistribuidor.getBtnAceptar().addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						TreeMap info;
						String msj;
						
						try {
							info = (new Gestor()).modificarDistribuidor(Integer.parseInt(((PanelModificarDistribuidor) modificarDistribuidor).getLista().get(((PanelModificarDistribuidor) modificarDistribuidor).getComboBoxDistribuidores().getSelectedIndex()).get("id")), 
											modificarDistribuidor.getTextFieldNombre().getText(), 
											modificarDistribuidor.getTextFieldDireccion().getText(), 
											Integer.parseInt(modificarDistribuidor.getTextFieldTelefono().getText()), 
											Double.parseDouble(modificarDistribuidor.getTextFieldPorcentaje().getText())
											);
						} catch (Exception e1) {
							info = null;
							e1.printStackTrace();
						}
						if(info != null){
							msj = "Se modifico el distribuidor de Id " + info.get("id") + " correctamente";
						}else{
							msj = "No se logro modificar al distribuidor!";
						}
						
						JOptionPane.showMessageDialog(null, msj);
						reiniciarPanelDistribuidor(modificarDistribuidor);
						modificarDistribuidor.setVisible(false);
						menu.setVisible(true);
					}
					
				});
				
				modificarDistribuidor.getBtnCancelar().addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						modificarDistribuidor.setVisible(false);
						reiniciarPanelDistribuidor(modificarDistribuidor);
						menu.setVisible(true);
					}
					
				});
				
				modificarDistribuidor.getBtnAceptar().addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						modificarDistribuidor.setVisible(false);
						
						menu.setVisible(true);
					}
					
				});
				
				
				
				//======================= Menu   ======================//
				
				
				
				
				this.menuDistribuidor.getBtnModificar().addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
						
						menuDistribuidor.setVisible(false);
						try {
							((PanelModificarDistribuidor) modificarDistribuidor).llenarSelect();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						modificarDistribuidor.setVisible(true);
						
					}
				});
				
				this.menuDistribuidor.getBtnRegistrar().addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
						
						menuDistribuidor.setVisible(false);
						registrarDistribuidor.setVisible(true);
						
					}
				});
				
				this.menuDistribuidor.getBtnConsultar().addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
						
						menuDistribuidor.setVisible(false);
						consultarDistribuidor.setVisible(true);
						
					}
				});
				
				this.menuDistribuidor.getBtnEliminar().addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
						
						menuDistribuidor.setVisible(false);
						eliminarDistribuidor.setVisible(true);
						
					}
				});
				
				//======================= Registrar   ======================//
				
				this.registrarDistribuidor.getBtnAceptar().addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						
						TreeMap info;
						String msj;
						
						info = (new Gestor()).registrarDistribuidor(registrarDistribuidor.getTextFieldNombre().getText(),
								registrarDistribuidor.getTextFieldDireccion().getText(), 
								Integer.parseInt(registrarDistribuidor.getTextFieldTelefono().getText()), 
								Double.parseDouble(registrarDistribuidor.getTextFieldPorcentaje().getText())
								);
						if(info != null){
							msj = "Se registro el distribuidor de Id " + info.get("id") + " correctamente";
							registrarDistribuidor.setVisible(false);
							reiniciarPanelDistribuidor(registrarDistribuidor);
							menu.setVisible(true);
						}else{
							msj = "No se logro registrar al distribuidor!";
						}
						
						JOptionPane.showMessageDialog(null, msj);
						
					}
					
				});
				
				this.registrarDistribuidor.getBtnCancelar().addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
							
						registrarDistribuidor.setVisible(false);
						reiniciarPanelDistribuidor(registrarDistribuidor);
						menu.setVisible(true);
					
					}
					
				});
				
				//======================= Eliminar   ======================//
				
				eliminarDistribuidor.getBtnAceptar().addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						
						String msj;
						
						try {
							(new Gestor()).eliminarDistribuidor(Integer.parseInt(((PanelConsultarDistribuidor)eliminarDistribuidor).getTxtId().getText()));
							eliminarDistribuidor.setVisible(false);
							((PanelConsultarDistribuidor)eliminarDistribuidor).getTxtId().setText(null);
							reiniciarPanelDistribuidor(eliminarDistribuidor);
							menu.setVisible(true);
							msj = "Se logro eliminar al distribuidor";
						} catch (Exception e1) {
							msj = "No se logro eliminar al distribuidor";
							e1.printStackTrace();
						}
						
						JOptionPane.showMessageDialog(null, msj);
						
					}
					
				});
				
				eliminarDistribuidor.getBtnCancelar().addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
				
						eliminarDistribuidor.setVisible(false);
						((PanelConsultarDistribuidor)eliminarDistribuidor).getTxtId().setText(null);
						reiniciarPanelDistribuidor(eliminarDistribuidor);
						menu.setVisible(true);
						
					}
					
				});
				
				((PanelConsultarDistribuidor)eliminarDistribuidor).getBtnBuscar().addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						TreeMap<String,String> info;
						
						try{
							
							info = (new Gestor()).eliminarDistribuidor(Integer.parseInt(((PanelConsultarDistribuidor)eliminarDistribuidor).getTxtId().getText()));
							eliminarDistribuidor.getTextFieldNombre().setText(info.get("nombre"));
							eliminarDistribuidor.getTextFieldTelefono().setText(info.get("telefono"));
							eliminarDistribuidor.getTextFieldDireccion().setText(info.get("direccion"));
							eliminarDistribuidor.getTextFieldPorcentaje().setText(info.get("linea"));	
							
						}catch(Exception e2){
							JOptionPane.showMessageDialog(null, "Revise el Id");
						}
						

					}
					
				});
				
				//======================= Consultar   ======================//
				
				consultarDistribuidor.getBtnAceptar().addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						consultarDistribuidor.setVisible(false);
						((PanelConsultarDistribuidor)consultarDistribuidor).getTxtId().setText(null);
						reiniciarPanelDistribuidor(consultarDistribuidor);

						menu.setVisible(true);
					}
					
				});
				

				((PanelConsultarDistribuidor)consultarDistribuidor).getBtnBuscar().addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						TreeMap<String,String> info;
						
						try{
							
							info = (new Gestor()).consultarDistribuidor(Integer.parseInt(((PanelConsultarDistribuidor)consultarDistribuidor).getTxtId().getText()));
							consultarDistribuidor.getTextFieldNombre().setText(info.get("nombre"));
							consultarDistribuidor.getTextFieldTelefono().setText(info.get("telefono"));
							consultarDistribuidor.getTextFieldDireccion().setText(info.get("direccion"));
							consultarDistribuidor.getTextFieldPorcentaje().setText(info.get("porcentaje"));		
							
						}catch(Exception e2){
							JOptionPane.showMessageDialog(null, "Revise el Id");
						}
						
					}
					
				});
		
	}
	
//================================================================================================================================//
	
	private void inicializarPanelesJuego(){
		
		//======================= Menu ======================//
		
		menuJuego.getBtnConsultar().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				menuJuego.setVisible(false);
				try {
					consultarJuego.iniciarPanel();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				consultarJuego.setVisible(true);
				// TODO Auto-generated method stub
				
			}
			
		});
		
		menuJuego.getBtnRegistrar().setText("Armar Juego");
		menuJuego.getBtnRegistrar().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				menuJuego.setVisible(false);
				try {
					armarJuego.iniciarPanel();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				armarJuego.setVisible(true);
				// TODO Auto-generated method stub
				
			}
			
		});
		
		menuJuego.getBtnEliminar().setVisible(false);
		menuJuego.getBtnModificar().setVisible(false);
		
		//======================= Registrar   ======================//
		
		armarJuego.getBtnCancelar().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				armarJuego.setVisible(false);
				menu.setVisible(true);
			}
			
		});
		
		armarJuego.getBtnAceptar().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				boolean registro;
				
				try {
					registro = armarJuego.crearJuego();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Ocurrio un error, porfavor intentelo mas tarde");
					e1.printStackTrace();
					registro = true;
				}
				if(registro){
					armarJuego.setVisible(false);
					menu.setVisible(true);
				}
				
			}
			
		});
		
		//======================= Consultar   ======================//
		
		consultarJuego.getBtnAceptar().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				consultarJuego.setVisible(false);
				menu.setVisible(true);
			}
			
		});
		
		//======================= Modificar   ======================//
		
		
		
		//======================= Eliminar   ======================//
		
	}
	
//================================================================================================================================//
	
	private void inicializarPanelesCliente(){
		
		//======================= Menu ======================//
		
		this.menuCliente.getBtnEliminar().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				menuCliente.setVisible(false);
				eliminarCliente.setVisible(true);
				
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
		
		this.menuCliente.getBtnConsultar().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				menuCliente.setVisible(false);
				consultarCliente.setVisible(true);
				
			}
		});
		
		//======================= Registrar   ======================//
		
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
		
		registrarCliente.getBtnCancelar().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
		
				registrarCliente.setVisible(false);
				reiniciarPanelCliente(registrarCliente);
				menu.setVisible(true);
				
			}
			
		});
		
		//======================= Consultar   ======================//
		
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
		
		//======================= Modificar   ======================//
		
		
		

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
		
		modificarCliente.getBtnCancelar().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
		
				modificarCliente.setVisible(false);
				reiniciarPanelCliente(modificarCliente);
				menu.setVisible(true);
				
			}
			
		});
		
		//======================= Eliminar   ======================//
		
		eliminarCliente.getBtnCancelar().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
		
				eliminarCliente.setVisible(false);
				((PanelConsultarCliente)eliminarCliente).getTxtId().setText(null);
				reiniciarPanelCliente(eliminarCliente);
				menu.setVisible(true);
				
			}
			
		});
		
		eliminarCliente.getBtnAceptar().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String msj;
				
				try {
					(new Gestor()).eliminarCliente(Integer.parseInt(((PanelConsultarCliente)eliminarCliente).getTxtId().getText()));
					eliminarCliente.setVisible(false);
					((PanelConsultarCliente)eliminarCliente).getTxtId().setText(null);
					reiniciarPanelCliente(eliminarCliente);
					menu.setVisible(true);
					msj = "Se logro eliminar al cliente";
				} catch (Exception e1) {
					msj = "No se logro eliminar al cliente";
					e1.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null, msj);
				
			}
			
		});
		
		((PanelConsultarCliente)eliminarCliente).getBtnBuscar().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				TreeMap<String,String> info;
				
				try{
					
					info = (new Gestor()).consultarCliente(Integer.parseInt(((PanelConsultarCliente)eliminarCliente).getTxtId().getText()));
					eliminarCliente.getTextFieldNombre().setText(info.get("nombre"));
					eliminarCliente.getTextFieldApellido().setText(info.get("apellido"));
					eliminarCliente.getTextFieldTelefono().setText(info.get("telefono"));
					eliminarCliente.getTextFieldDireccion().setText(info.get("direccion"));
					eliminarCliente.getTextFieldTrabajo().setText(info.get("trabajo"));
					eliminarCliente.getTextFieldTelTrabajo().setText(info.get("telTrabajo"));		
					
				}catch(Exception e2){
					JOptionPane.showMessageDialog(null, "Revise el Id");
				}
				

			}
			
		});
		
	}

//================================================================================================================================//
	
	private void inicializarPanelesMontador(){
	
		//======================= Menu ======================//
		
		this.menuMontador.getBtnRegistrar().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				menuMontador.setVisible(false);
				registrarMontador.setVisible(true);
				
			}
		});
		
		this.menuMontador.getBtnModificar().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				menuMontador.setVisible(false);
				modificarMontador.setVisible(true);
				
			}
		});
		

		
		
		this.menuMontador.getBtnConsultar().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				menuMontador.setVisible(false);
				consultarMontador.setVisible(true);
				
			}
		});
		
		this.menuMontador.getBtnEliminar().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				menuMontador.setVisible(false);
				eliminarMontador.setVisible(true);
				
			}
		});
		
		//======================= Registrar   ======================//
		
		registrarMontador.getBtnCancelar().addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				
				registrarMontador.setVisible(false);
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
		
		//======================= Consultar   ======================//
		
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
		
		//======================= Modificar   ======================//
		
		modificarMontador.getBtnCancelar().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e){ 
				modificarMontador.setVisible(false);
				reiniciarPanelMontador(modificarMontador);
				menu.setVisible(true);
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
		
		//======================= Eliminar   ======================//
	
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
		
	}
	
//================================================================================================================================//
	
	private void inicializarPanelesVenta(){
		
		//======================= Menu ======================//
		
		menuVenta.getBtnConsultar().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				menuVenta.setVisible(false);
				consultarVenta.setVisible(true);
				// TODO Auto-generated method stub
				
			}
			
		});
		menuVenta.getBtnRegistrar().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				menuVenta.setVisible(false);
				registrarVenta.setVisible(true);
				// TODO Auto-generated method stub
				
			}
			
		});
		
		//======================= Registrar   ======================//
		
		
		
		//======================= Consultar   ======================//
		
		
		
		//======================= Modificar   ======================//
		
		
		
		//======================= Eliminar   ======================//
	
	}
	
//================================================================================================================================//
	
	private void inicializarPanelesMueble(){
		
		//======================= Menu ======================//
		
				menuMueble.getBtnConsultar().addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						menuMueble.setVisible(false);
						consultarMueble.setVisible(true);
						
					}
					
				});
				
				menuMueble.getBtnRegistrar().addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						
						
						menuMueble.setVisible(false);
						registrarMueble.setVisible(true);
						// TODO Auto-generated method stub
						
					}
					
				});
				
				
				//======================= Registrar   ======================//
				
				
				
				registrarMueble.getBtnAceptar().addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						
						String msj;
						int idFabricante;
						int i;
						DefaultComboBoxModel dm = new DefaultComboBoxModel();
						JComboBox jcb = new JComboBox();
						ArrayList<TreeMap<String, String>> lista = null;
						jcb.setModel(dm);
						try {
							lista = (new Gestor()).listarFabricantes();
						} catch (Exception e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						
						
						for(int z = 0; z < lista.size(); z++){	
							dm.addElement(lista.get(z).get("nombre") + " " + lista.get(z).get("apellido"));
							//this.getComboBoxFabricantes.addItem(this.getLista().get(i).get("nombre") + " " + this.getLista().get(i).get("apellido"));	
						}
						
						JOptionPane.showMessageDialog(null,jcb,"seleccione un fabricante",JOptionPane.QUESTION_MESSAGE);
						
						jcb.setModel(dm);
						i = jcb.getSelectedIndex();
						i = Integer.parseInt(lista.get(i).get("id"));
						int j;
						
						j = ((PanelRegistrarMueble)registrarMueble).getComboBoxCategoria().getSelectedIndex();
						
						switch(j){
						
							case 0:
								
							try {
								(new Gestor()).registrarMueble(i,((PanelRegistrarMueble)registrarMueble).getTextFieldColor().getText(),
										Double.parseDouble(((PanelRegistrarMueble)registrarMueble).getTextFieldAncho().getText()),
										Double.parseDouble(((PanelRegistrarMueble)registrarMueble).getTextFieldAlto().getText()),
										Double.parseDouble(((PanelRegistrarMueble)registrarMueble).getTextFieldLargo().getText()),
										((PanelRegistrarMueble)registrarMueble).getComboBoxCategoria().getSelectedIndex(),
										Double.parseDouble(((PanelRegistrarMueble)registrarMueble).getTextFieldPrecio().getText()));
							} catch (NumberFormatException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							break;
							
							case 1:
								
							try {
								(new Gestor()).registrarMueble(i,((PanelRegistrarMueble)registrarMueble).getTextFieldColor().getText(),
										Double.parseDouble(((PanelRegistrarMueble)registrarMueble).getTextFieldAncho().getText()),
										Double.parseDouble(((PanelRegistrarMueble)registrarMueble).getTextFieldAlto().getText()),
										Double.parseDouble(((PanelRegistrarMueble)registrarMueble).getTextFieldLargo().getText()),
										((PanelRegistrarMueble)registrarMueble).getComboBoxCategoria().getSelectedIndex(),
										Double.parseDouble(((PanelRegistrarMueble)registrarMueble).getTextFieldPrecio().getText()),
										Double.parseDouble(((PanelRegistrarMueble)registrarMueble).getTextFieldalturaSobreSuelo().getText()));
							} catch (NumberFormatException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							break;
							
							case 2:
								
								try {
									(new Gestor()).registrarMueble(i,((PanelRegistrarMueble)registrarMueble).getTextFieldColor().getText(),
											Double.parseDouble(((PanelRegistrarMueble)registrarMueble).getTextFieldAncho().getText()),
											Double.parseDouble(((PanelRegistrarMueble)registrarMueble).getTextFieldAlto().getText()),
											Double.parseDouble(((PanelRegistrarMueble)registrarMueble).getTextFieldLargo().getText()),
											((PanelRegistrarMueble)registrarMueble).getComboBoxCategoria().getSelectedIndex(),
											Double.parseDouble(((PanelRegistrarMueble)registrarMueble).getTextFieldPrecio().getText()),
											((PanelRegistrarMueble)registrarMueble).getComboBoxTipo().getSelectedIndex(),
											Double.parseDouble(((PanelRegistrarMueble)registrarMueble).getTextFieldEspesor().getText()));
								} catch (NumberFormatException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
								break;
								
							case 3:
								
								try {
									(new Gestor()).registrarMueble(i,((PanelRegistrarMueble)registrarMueble).getTextFieldColor().getText(),
											Double.parseDouble(((PanelRegistrarMueble)registrarMueble).getTextFieldAncho().getText()),
											Double.parseDouble(((PanelRegistrarMueble)registrarMueble).getTextFieldAlto().getText()),
											Double.parseDouble(((PanelRegistrarMueble)registrarMueble).getTextFieldLargo().getText()),
											((PanelRegistrarMueble)registrarMueble).getComboBoxCategoria().getSelectedIndex(),
											Double.parseDouble(((PanelRegistrarMueble)registrarMueble).getTextFieldPrecio().getText()),
											((PanelRegistrarMueble)registrarMueble).getComboBoxAcabado().getSelectedIndex());
								} catch (NumberFormatException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
								break;
							
						}
						
						
						
						/*jcb.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e) {
								
								try {
									
									
									
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						});*/
						
						
						registrarMueble.setVisible(false);
						//reiniciarPanelMueble(registrarMueble);
						menu.setVisible(true);
					}
					
				});
				
				((PanelRegistrarMueble)registrarMueble).getComboBoxCategoria().addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						int i;
						
						i = ((PanelRegistrarMueble)registrarMueble).getComboBoxCategoria().getSelectedIndex();
						switchCategoria(i);
					}
				});
				
				registrarMueble.getBtnCancelar().addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
				
						registrarMueble.setVisible(false);

						menu.setVisible(true);
						
					}
					
				});
		
		//======================= Consultar   ======================//
		
		
		
		//======================= Modificar   ======================//
		
		
		
		//======================= Eliminar   ======================//
	
		
	}
	
//================================================================================================================================//
	
	private void reiniciarPanelFabricante(PanelFormaFabricante panelF){
		
		panelF.getTextFieldNombre().setText(null);
		panelF.getTextFieldApellido().setText(null);
		panelF.getTextFieldTelefono().setText(null);
		panelF.getTextFieldDireccion().setText(null);
		panelF.getTextFieldLinea().setText(null);
		panelF.getTextFieldAnnos().setText(null);
		
	}
	
	private void reiniciarPanelDistribuidor(PanelFormaDistribuidor panelF){
		
		panelF.getTextFieldNombre().setText(null);
		panelF.getTextFieldTelefono().setText(null);
		panelF.getTextFieldDireccion().setText(null);
		panelF.getTextFieldPorcentaje().setText(null);
		
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
	
	private void switchCategoria(int i){
		
		this.setBajoComponents(false);
		this.setEncimeraComponents(false);
		this.setPanelComponente(false);
		
		switch(i){
					
			case 1:
				this.setBajoComponents(true);
				break;
				
			case 2:
				this.setEncimeraComponents(true);
				break;
			
			case 3:
				this.setPanelComponente(true);
				break;
	
		}
	}
	
	private void setBajoComponents(boolean estado){
		
		this.registrarMueble.getLblAlturaSobreSuelo().setVisible(estado);
		this.registrarMueble.getTextFieldalturaSobreSuelo().setVisible(estado);
		
	}
	
	private void setEncimeraComponents(boolean estado){
		
		this.registrarMueble.getComboBoxTipo().setVisible(estado);
		this.registrarMueble.getLblTipo().setVisible(estado);
		this.registrarMueble.getLblespesor().setVisible(estado);
		this.registrarMueble.getTextFieldEspesor().setVisible(estado);
		
	}
	
	
	private void setPanelComponente(boolean estado){
		
		this.registrarMueble.getLblAcabado().setVisible(estado);
		this.registrarMueble.getComboBoxAcabado().setVisible(estado);
	}
	
}
			
