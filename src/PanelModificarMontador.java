import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TreeMap;

import javax.swing.JComboBox;

public class PanelModificarMontador extends PanelFormaMontador{
	
	private JComboBox comboBoxMontadores;
	private ArrayList<TreeMap<String,String>> lista;
	
public PanelModificarMontador() throws Exception{
		
		super();
		
		(new Gestor()).inicializarPrograma();
		GridBagConstraints c = new GridBagConstraints();
		
		this.setLista((new Gestor()).listarMontadores());
		
		this.setComboBoxMontadores(new JComboBox());
		c.gridy = 0;
		c.gridx = 2;
		for(int i = 0; i < lista.size(); i++){	
			this.getComboBoxMontadores().addItem(lista.get(i).get("nombre") + " " + lista.get(i).get("apellido"));	
		}
		this.getComboBoxMontadores().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				seleccionarMontador();
			}
		});
		this.add(this.getComboBoxMontadores(), c);
		
		this.setVisible(false);
		
	}
	
	public void seleccionarMontador(){
		
		int i;
		
		i = this.comboBoxMontadores.getSelectedIndex();
		this.getTextFieldNombre().setText(lista.get(i).get("nombre"));
		this.getTextFieldApellido().setText(lista.get(i).get("apellido"));
		this.getTextFieldTelefono().setText(lista.get(i).get("telefono"));
		this.getTextFieldDireccion().setText(lista.get(i).get("direccion"));
	}
	
	
	public ArrayList<TreeMap<String, String>> getLista() {
		try {
			this.setLista((new Gestor()).listarMontadores());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

	public void setLista(ArrayList<TreeMap<String, String>> lista) {
		this.lista = lista;
	}
	
	public void setComboBoxMontadores(JComboBox comboBoxMontadores) {
		this.comboBoxMontadores = comboBoxMontadores;
	}
	
	public JComboBox getComboBoxMontadores() {
		return comboBoxMontadores;
	}

}
