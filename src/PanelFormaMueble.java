import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelFormaMueble extends JPanel {

	private JTextField textFieldID;
	private JTextField textFieldLinea;
	private JTextField textFieldAncho;
	private JTextField textFieldAlto;
	private JTextField textFieldLargo;
	private JTextField textFieldCategoria;
	private JTextField textFieldPrecio;
	private JButton btnAceptar;
	private JButton btnCancelar;
	
	public PanelFormaMueble(){
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		JLabel lblID = new JLabel("ID:");
		c.gridy = 1;
		c.gridx = 1;
		c.anchor = GridBagConstraints.LINE_END;
		this.add(lblID,c);
		
		JLabel lblLinea = new JLabel("Linea:");
		c.gridy++;
		this.add(lblLinea,c);
		
		JLabel lblAncho = new JLabel("Ancho:");
		c.gridy++;
		this.add(lblAncho,c);
		
		JLabel lblAlto = new JLabel("Alto:");
		c.gridy++;
		this.add(lblAlto,c);
		
		JLabel lblLargo = new JLabel("Largo:");
		c.gridy++;
		this.add(lblLargo,c);
		
		
		JLabel lblCategoria = new JLabel("Categoria :");
		c.gridy++;
		this.add(lblCategoria,c);
		
		JLabel lblPrecio = new JLabel("Precio:");
		c.gridy++;
		this.add(lblPrecio,c);
		
		textFieldID = new JTextField(8);
		c.gridy = 1;
		c.gridx = 2;
		c.anchor = GridBagConstraints.LINE_START;
		this.add(textFieldID,c);
		//textFieldNombre.setColumns(10);
		
		textFieldLinea = new JTextField(8);
		c.gridy++;
		this.add(textFieldLinea,c);
		//textFieldApellido.setColumns(10);
		
		textFieldAncho = new JTextField(8);
		c.gridy++;
		this.add(textFieldAncho,c);
		//textFieldTelefono.setColumns(10);
		
		textFieldAlto = new JTextField(8);
		c.gridy++;
		this.add(textFieldAlto,c);
		//textFieldTelefono.setColumns(10);
		
		textFieldLargo = new JTextField(8);
		c.gridy++;
		this.add(textFieldLargo,c);
		//textFieldTelefono.setColumns(10);
		
		textFieldCategoria = new JTextField(8);
		textFieldCategoria.setEditable(false);
		c.gridy++;
		this.add(textFieldCategoria,c);
		//textFieldLinea.setColumns(10);
		
		textFieldPrecio = new JTextField(8);
		c.gridy++;
		this.add(textFieldPrecio,c);
		//textFieldAnnos.setColumns(10);
		
		
		
		btnAceptar = new JButton("Aceptar");
		c.gridy = 8;
		c.gridx = 5;
		this.add(btnAceptar,c);
		
		btnCancelar = new JButton("Cancelar");
		c.gridx = 4;
		this.add(btnCancelar,c);
		
		this.setVisible(true);
		
	}

	public JTextField getTextFieldI() {
		return textFieldID;
	}

	public void setTextFieldID(JTextField textFieldID) {
		this.textFieldID = textFieldID;
	}


	public JTextField getTextFieldAncho() {
		return textFieldAncho;
	}

	public void setTextFieldAncho(JTextField textFieldAncho) {
		this.textFieldAncho = textFieldAncho;
	}
	
	public JTextField getTextFieldAlto() {
		return textFieldAlto;
	}

	public void setTextFieldAlto(JTextField textFieldAlto) {
		this.textFieldAlto = textFieldAlto;
	}
	
	public JTextField getTextFieldLargo() {
		return textFieldLargo;
	}

	public void setTextFieldLargo(JTextField textFieldLargo) {
		this.textFieldLargo = textFieldLargo;
	}

	public JTextField getTextFieldCategoria() {
		return textFieldCategoria;
	}

	public void setTextFieldCategoria(JTextField textFieldCategoria) {
		this.textFieldCategoria = textFieldCategoria;
	}

	public JTextField getTextFieldLinea() {
		return textFieldLinea;
	}

	public void setTextFieldLinea(JTextField textFieldLinea) {
		this.textFieldLinea = textFieldLinea;
	}

	public JTextField getTextFieldPrecio() {
		return textFieldPrecio;
	}

	public void setTextFieldAnnos(JTextField textFieldPrecio) {
		this.textFieldPrecio = textFieldPrecio;
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
