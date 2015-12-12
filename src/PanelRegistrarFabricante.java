import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelRegistrarFabricante extends JPanel {

	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldTelefono;
	private JTextField textFieldDireccion;
	private JTextField textFieldLinea;
	private JTextField textFieldAnnos;
	
	public PanelRegistrarFabricante(){
		
		//this.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(41, 44, 61, 16);
		this.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(41, 72, 61, 16);
		this.add(lblApellido);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(41, 100, 61, 16);
		this.add(lblTelefono);
		
		JLabel lblLinea = new JLabel("Linea:");
		lblLinea.setBounds(41, 128, 61, 16);
		this.add(lblLinea);
		
		JLabel lblAnnos = new JLabel("Annos Exp:");
		lblAnnos.setBounds(41, 156, 84, 16);
		this.add(lblAnnos);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(41, 184, 84, 16);
		this.add(lblDireccion);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(137, 38, 134, 28);
		this.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(137, 66, 134, 28);
		this.add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setBounds(137, 94, 134, 28);
		this.add(textFieldTelefono);
		textFieldTelefono.setColumns(10);
		
		textFieldLinea = new JTextField();
		textFieldLinea.setBounds(137, 122, 134, 28);
		this.add(textFieldLinea);
		textFieldLinea.setColumns(10);
		
		textFieldAnnos = new JTextField();
		textFieldAnnos.setBounds(137, 150, 134, 28);
		this.add(textFieldAnnos);
		textFieldAnnos.setColumns(10);
		
		textFieldDireccion = new JTextField();
		textFieldDireccion.setBounds(137, 178, 252, 89);
		this.add(textFieldDireccion);
		textFieldDireccion.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				botonAceptar();
				
			}
		});
		btnAceptar.setBounds(344, 364, 117, 29);
		this.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				botonCancelar();
				
			}
		});
		btnCancelar.setBounds(215, 364, 117, 29);
		this.add(btnCancelar);
		
		this.setVisible(true);
		
	}
	
	public void botonAceptar(){
		
		TreeMap info;
		String msj;
		
		info = (new Gestor()).registrarFabricante(textFieldNombre.getText(),
				textFieldApellido.getText(),
				Integer.parseInt(textFieldTelefono.getText()), 
				textFieldDireccion.getText(), 
				Integer.parseInt(textFieldLinea.getText()), 
				Integer.parseInt(textFieldAnnos.getText())
				);
		if(info != null){
			msj = "Se registro el fabricante de Id " + info.get("id") + " correctamente";
		}else{
			msj = "No se logro registrar al fabricante!";
		}
		
		JOptionPane.showMessageDialog(null, msj);
		this.setVisible(false);
		(new PanelPrincipal()).setVisible(true);
		
	}
	
	public void botonCancelar(){
		
		this.setVisible(false);
		(new PanelPrincipal()).setVisible(true);
		
	}
	
}
