import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelFormaMontador extends JPanel {

	private JTextField textFieldId;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldTelefono;
	private JTextField textFieldDireccion;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JLabel lblId;
	
	public PanelFormaMontador(){
		
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
		
		JLabel lblDireccion = new JLabel("Direccion:");
		c.gridy++;
		this.add(lblDireccion,c);
		
		lblId = new JLabel("ID:");
		c.gridy++;
		this.add(lblId,c);
		
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
		
		
		textFieldDireccion = new JTextField(15);
		c.gridy++;
		this.add(textFieldDireccion,c);
		//textFieldDireccion.setColumns(10);
		
		textFieldId = new JTextField(8);
		c.gridy++;
		this.add(textFieldId,c);
		
		btnAceptar = new JButton("Aceptar");
		c.gridy = 8;
		c.gridx = 5;
		this.add(btnAceptar,c);
		
		btnCancelar = new JButton("Cancelar");
		c.gridx = 4;
		this.add(btnCancelar,c);
		
		this.setVisible(true);
		
	}

	public JTextField getTextFieldNombre() {
		return textFieldNombre;
	}

	public void setTextFieldNombre(JTextField textFieldNombre) {
		this.textFieldNombre = textFieldNombre;
	}

	public JTextField getTextFieldApellido() {
		return textFieldApellido;
	}

	public void setTextFieldApellido(JTextField textFieldApellido) {
		this.textFieldApellido = textFieldApellido;
	}

	public JTextField getTextFieldTelefono() {
		return textFieldTelefono;
	}

	public void setTextFieldTelefono(JTextField textFieldTelefono) {
		this.textFieldTelefono = textFieldTelefono;
	}

	public JTextField getTextFieldDireccion() {
		return textFieldDireccion;
	}

	public void setTextFieldDireccion(JTextField textFieldDireccion) {
		this.textFieldDireccion = textFieldDireccion;
	}
	
	public JTextField getTextFieldId() {
		return textFieldId;
	}

	public void setTextFieldId(JTextField textFieldId) {
		this.textFieldId = textFieldId;
	}
	
	public JLabel getLblId() {
		return lblId;
	}

	public void setLblId(JLabel plblId) {
		lblId = plblId;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public void setBtnAceptar(JButton btnAceptar) {
		this.btnAceptar = btnAceptar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}
	
}
