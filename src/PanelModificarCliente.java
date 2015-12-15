import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TreeMap;

import javax.swing.JComboBox;

public class PanelModificarCliente extends PanelFormaCliente{
	
	private JComboBox comboBoxClientes;
	private ArrayList<TreeMap<String,String>> lista;
	
	public PanelModificarCliente(){
		
		super();
		
		try {
			(new Gestor()).inicializarPrograma();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		GridBagConstraints c = new GridBagConstraints();
		
		try {
			this.setLista((new Gestor()).listarClientes());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		this.setComboBoxClientes(new JComboBox());
		c.gridy = 0;
		c.gridx = 2;
		for(int i = 0; i < lista.size(); i++){	
			this.getComboBoxClientes().addItem(lista.get(i).get("nombre") + " " + lista.get(i).get("apellido"));	
		}
		this.getComboBoxClientes().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				seleccionarCliente();
			}
		});
		this.add(this.getComboBoxClientes(), c);
		
		this.setVisible(false);
	}
	
	public void seleccionarCliente(){
		
		int i;
		
		i = this.comboBoxClientes.getSelectedIndex();
		this.getTextFieldNombre().setText(lista.get(i).get("nombre"));
		this.getTextFieldApellido().setText(lista.get(i).get("apellido"));
		this.getTextFieldTelefono().setText(lista.get(i).get("telefono"));
		this.getTextFieldDireccion().setText(lista.get(i).get("direccion"));
		this.getTextFieldTrabajo().setText(lista.get(i).get("trabajo"));
		this.getTextFieldTelTrabajo().setText(lista.get(i).get("telTrabajo"));
		
	}
	
	public JComboBox getComboBoxClientes() {
		return comboBoxClientes;
	}

	public void setComboBoxClientes(JComboBox comboBoxClientes) {
		this.comboBoxClientes = comboBoxClientes;
	}

	public ArrayList<TreeMap<String, String>> getLista() {
		return lista;
	}

	public void setLista(ArrayList<TreeMap<String, String>> lista) {
		this.lista = lista;
	}
}
