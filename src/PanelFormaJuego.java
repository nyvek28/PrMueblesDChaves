import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelFormaJuego extends JPanel {

	private JTextField textFieldID;
	private JTextField textFieldMuebles;
	private JTextField textFieldMontador;
	private JTextField textFieldEstado;//Vendido o disponible
	private JButton btnAceptar;
	private JButton btnCancelar;
	
	public PanelFormaJuego(){
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		JLabel lblID = new JLabel("ID:");
		c.gridy = 1;
		c.gridx = 1;
		c.anchor = GridBagConstraints.LINE_END;
		this.add(lblID,c);
		
		JLabel lblMuebles = new JLabel("Muebles:");
		c.gridy++;
		this.add(lblMuebles,c);
		
		JLabel lblEstado = new JLabel("Estado:");
		c.gridy++;
		this.add(lblEstado,c);
		
		
		
		textFieldID = new JTextField(8);
		c.gridy = 1;
		c.gridx = 2;
		c.anchor = GridBagConstraints.LINE_START;
		this.add(textFieldID,c);
		//textFieldNombre.setColumns(10);
		
		textFieldID = new JTextField(8);
		c.gridy++;
		this.add(textFieldID,c);
		//textFieldApellido.setColumns(10);
		
		textFieldMuebles = new JTextField(8);
		c.gridy++;
		this.add(textFieldMuebles,c);
		//textFieldTelefono.setColumns(10);
		
		textFieldMontador = new JTextField(8);
		c.gridy++;
		this.add(textFieldMontador,c);
		//textFieldTelefono.setColumns(10)

		btnAceptar = new JButton("Aceptar");
		c.gridy = 8;
		c.gridx = 5;
		this.add(btnAceptar,c);
		
		btnCancelar = new JButton("Cancelar");
		c.gridx = 4;
		this.add(btnCancelar,c);
		
		this.setVisible(true);
		
	}

	public JTextField getTextFieldId() {
		return textFieldID;
	}

	public void setTextFieldID(JTextField textFieldID) {
		this.textFieldID = textFieldID;
	}


	

	public JTextField getTextFieldMuebles() {
		return textFieldMuebles;
	}

	public void setTextFieldMuebles(JTextField textFieldMuebles) {
		this.textFieldMuebles = textFieldMuebles;
	}

	public JTextField getTextFieldMontador() {
		return textFieldMontador;
	}

	public void setTextFieldMontador(JTextField textFieldMontador) {
		this.textFieldMontador = textFieldMontador;
	}

	public JTextField getTextFieldEstado() {
		return textFieldEstado;
	}

	public void setTextFieldEstado(JTextField textFieldEstado) {
		this.textFieldEstado = textFieldEstado;
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
