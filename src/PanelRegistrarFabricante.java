import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		JLabel lblNombre = new JLabel("Nombre:");
		c.gridy = 1;
		c.gridx = 1;
		c.anchor = GridBagConstraints.LINE_END;
		this.add(lblNombre,c);
		
		JLabel lblApellido = new JLabel("Apellido:");
		c.gridy++;
		this.add(lblApellido,c);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		c.gridy++;
		this.add(lblTelefono,c);
		
		JLabel lblLinea = new JLabel("Linea:");
		c.gridy++;
		this.add(lblLinea,c);
		
		JLabel lblAnnos = new JLabel("Annos Exp:");
		c.gridy++;
		this.add(lblAnnos,c);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		c.gridy++;
		this.add(lblDireccion,c);
		
		textFieldNombre = new JTextField(8);
		c.gridy = 1;
		c.gridx = 2;
		c.anchor = GridBagConstraints.LINE_START;
		this.add(textFieldNombre,c);
		//textFieldNombre.setColumns(10);
		
		textFieldApellido = new JTextField(8);
		c.gridy++;
		this.add(textFieldApellido,c);
		//textFieldApellido.setColumns(10);
		
		textFieldTelefono = new JTextField(8);
		c.gridy++;
		this.add(textFieldTelefono,c);
		//textFieldTelefono.setColumns(10);
		
		textFieldLinea = new JTextField(8);
		c.gridy++;
		this.add(textFieldLinea,c);
		//textFieldLinea.setColumns(10);
		
		textFieldAnnos = new JTextField(8);
		c.gridy++;
		this.add(textFieldAnnos,c);
		//textFieldAnnos.setColumns(10);
		
		textFieldDireccion = new JTextField(15);
		c.gridy++;
		this.add(textFieldDireccion,c);
		//textFieldDireccion.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				botonAceptar();
				
			}
		});
		c.gridy = 8;
		c.gridx = 5;
		this.add(btnAceptar,c);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				botonCancelar();
				
			}
		});
		c.gridx = 4;
		this.add(btnCancelar,c);
		
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
