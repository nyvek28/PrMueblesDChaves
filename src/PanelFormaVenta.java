import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelFormaVenta extends JPanel {

	private JTextField textFieldID;
	private JTextField textFieldJuego;
	private JTextField textFieldIdDistribuidor;
	private JTextField textFieldMonto;
	private JButton btnAceptar;
	private JButton btnCancelar;
	
	public PanelFormaVenta(){
		
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
		
		textFieldJuego = new JTextField(8);
		c.gridy++;
		this.add(textFieldJuego,c);
		//textFieldApellido.setColumns(10);
		
		textFieldIdDistribuidor = new JTextField(8);
		c.gridy++;
		this.add(textFieldIdDistribuidor,c);
		//textFieldTelefono.setColumns(10);
		
		textFieldMonto = new JTextField(8);
		c.gridy++;
		this.add(textFieldMonto,c);
		//textFieldTelefono.setColumns(10);
		
		
		
		
		btnAceptar = new JButton("Aceptar");
		c.gridy = 8;
		c.gridx = 5;
		this.add(btnAceptar,c);
		
		btnCancelar = new JButton("Cancelar");
		c.gridx = 4;
		this.add(btnCancelar,c);
		
		this.setVisible(true);
		
	}

	public JTextField getTextFieldID() {
		return textFieldID;
	}

	public void setTextFieldID(JTextField textFieldID) {
		this.textFieldID = textFieldID;
	}


	public JTextField getTextFieldJuego() {
		return textFieldJuego;
	}

	public void setTextFieldJuego(JTextField textFieldJuego) {
		this.textFieldJuego = textFieldJuego;
	}
	
	public JTextField getTextFieldAlto() {
		return textFieldIdDistribuidor;
	}

	public void setTextFieldIdDistribuidor(JTextField textFieldIdDistribuidor) {
		this.textFieldIdDistribuidor = textFieldIdDistribuidor;
	}
	
	public JTextField getTextFieldMonto() {
		return textFieldMonto;
	}

	public void setTextFieldMonto(JTextField textFieldMonto) {
		this.textFieldMonto = textFieldMonto;
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