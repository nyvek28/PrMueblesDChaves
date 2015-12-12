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

public class PanelModificarFabricante extends PanelFormaFabricante {

	private JComboBox comboBoxFabricantes;
	private ArrayList<TreeMap<String,String>> lista;
	
	public PanelModificarFabricante() throws Exception{
		
		super();
		
		(new Gestor()).inicializarPrograma();
		GridBagConstraints c = new GridBagConstraints();
		
		this.setLista((new Gestor()).listarFabricantes());
		
		this.setComboBoxFabricantes(new JComboBox());
		c.gridy = 0;
		c.gridx = 2;
		for(int i = 0; i < lista.size(); i++){	
			this.getComboBoxFabricantes().addItem(lista.get(i).get("nombre") + " " + lista.get(i).get("apellido"));	
		}
		this.getComboBoxFabricantes().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				seleccionarFabricante();
			}
		});
		this.add(this.getComboBoxFabricantes(), c);
		
		this.setVisible(false);
		
	}
	
	public void seleccionarFabricante(){
		
		int i;
		
		i = this.comboBoxFabricantes.getSelectedIndex();
		this.getTextFieldNombre().setText(lista.get(i).get("nombre"));
		this.getTextFieldApellido().setText(lista.get(i).get("apellido"));
		this.getTextFieldTelefono().setText(lista.get(i).get("telefono"));
		this.getTextFieldDireccion().setText(lista.get(i).get("direccion"));
		this.getTextFieldLinea().setText(lista.get(i).get("linea"));
		this.getTextFieldAnnos().setText(lista.get(i).get("annosExp"));
		
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
	
}
