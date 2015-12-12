import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelModificarFabricante extends JPanel {

	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldTelefono;
	private JTextField textFieldDireccion;
	private JTextField textFieldLinea;
	private JTextField textFieldAnnos;
	private JComboBox comboBoxFabricantes;
	private ArrayList<TreeMap<String,String>> lista;
	private JButton btnAceptar;
	private JButton btnCancelar;
	
	public PanelModificarFabricante() throws Exception{
		
		this.setLayout(new GridBagLayout());
		
		(new Gestor()).inicializarPrograma();
		GridBagConstraints c = new GridBagConstraints();
		
		lista = (new Gestor()).listarFabricantes();
		
		comboBoxFabricantes = new JComboBox();
		c.gridy = 0;
		c.gridx = 1;
		for(int i = 0; i < lista.size(); i++){	
			comboBoxFabricantes.addItem(lista.get(i).get("nombre") + " " + lista.get(i).get("apellido"));	
		}
		comboBoxFabricantes.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				seleccionarFabricante();
			}
		});
		this.add(this.comboBoxFabricantes, c);
		
		JLabel lblNombre = new JLabel("Nombre:");
		c.gridy++;
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
		
		btnAceptar = new JButton("Aceptar");
		c.gridy = 8;
		c.gridx = 5;
		this.add(btnAceptar,c);
		
		btnCancelar = new JButton("Cancelar");
		c.gridx = 4;
		this.add(btnCancelar,c);
		
		this.setVisible(false);
		
	}
	
	public void seleccionarFabricante(){
		
		int i;
		
		i = this.comboBoxFabricantes.getSelectedIndex();
		textFieldNombre.setText(lista.get(i).get("nombre"));
		textFieldApellido.setText(lista.get(i).get("apellido"));
		textFieldTelefono.setText(lista.get(i).get("telefono"));
		textFieldDireccion.setText(lista.get(i).get("direccion"));
		textFieldLinea.setText(lista.get(i).get("linea"));
		textFieldAnnos.setText(lista.get(i).get("annosExp"));
		
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

	public JTextField getTextFieldLinea() {
		return textFieldLinea;
	}

	public void setTextFieldLinea(JTextField textFieldLinea) {
		this.textFieldLinea = textFieldLinea;
	}

	public JTextField getTextFieldAnnos() {
		return textFieldAnnos;
	}

	public void setTextFieldAnnos(JTextField textFieldAnnos) {
		this.textFieldAnnos = textFieldAnnos;
	}

	public JComboBox getComboBoxFabricantes() {
		return comboBoxFabricantes;
	}

	public void setComboBoxFabricantes(JComboBox comboBoxFabricantes) {
		this.comboBoxFabricantes = comboBoxFabricantes;
	}

	public ArrayList<TreeMap<String, String>> getLista() {
		return lista;
	}

	public void setLista(ArrayList<TreeMap<String, String>> lista) {
		this.lista = lista;
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
