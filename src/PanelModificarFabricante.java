import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeMap;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelModificarFabricante extends PanelFormaFabricante {

	private JComboBox comboBoxFabricantes;
	private ArrayList<TreeMap<String,String>> lista;
	private DefaultComboBoxModel dm;
	
	public PanelModificarFabricante() throws Exception{
		
		super();
		
		(new Gestor()).inicializarPrograma();
		GridBagConstraints c = new GridBagConstraints();
		
		this.setLista(null);
		
		this.setComboBoxFabricantes(new JComboBox());
		c.gridy = 0;
		c.gridx = 2;
		this.getComboBoxFabricantes().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					seleccionarFabricante();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		this.add(this.getComboBoxFabricantes(), c);
		
		this.setVisible(false);
		
	}
	
	public void seleccionarFabricante() throws Exception{
		
		int i;
		
		i = this.comboBoxFabricantes.getSelectedIndex();
		this.getTextFieldNombre().setText(this.getLista().get(i).get("nombre"));
		this.getTextFieldApellido().setText(this.getLista().get(i).get("apellido"));
		this.getTextFieldTelefono().setText(this.getLista().get(i).get("telefono"));
		this.getTextFieldDireccion().setText(this.getLista().get(i).get("direccion"));
		this.getTextFieldLinea().setText(this.getLista().get(i).get("linea"));
		this.getTextFieldAnnos().setText(this.getLista().get(i).get("annosExp"));
		
	}
	
	public void llenarSelect() throws Exception{
		
		this.setDm(new DefaultComboBoxModel());
		
		for(int i = 0; i < this.getLista().size(); i++){	
			this.getDm().addElement(this.getLista().get(i).get("nombre") + " " + this.getLista().get(i).get("apellido"));
			//this.getComboBoxFabricantes.addItem(this.getLista().get(i).get("nombre") + " " + this.getLista().get(i).get("apellido"));	
		}
		
		this.getComboBoxFabricantes().setModel(this.getDm());
	}

	public JComboBox getComboBoxFabricantes() {
		return comboBoxFabricantes;
	}

	public void setComboBoxFabricantes(JComboBox comboBoxFabricantes) {
		this.comboBoxFabricantes = comboBoxFabricantes;
	}

	public ArrayList<TreeMap<String, String>> getLista() throws Exception {
		ArrayList<TreeMap<String, String>> l;
		
		l = (new Gestor()).listarFabricantes();
		
		return l;
	}

	public void setLista(ArrayList<TreeMap<String, String>> lista) {
		this.lista = lista;
	}

	public DefaultComboBoxModel getDm() {
		return dm;
	}

	public void setDm(DefaultComboBoxModel dm) {
		this.dm = dm;
	}
	
}
