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

public class PanelModificarDistribuidor extends PanelFormaDistribuidor {

	private JComboBox comboBoxDistribuidores;
	private ArrayList<TreeMap<String,String>> lista;
	
	public PanelModificarDistribuidor() throws Exception{
		
		super();
		
		(new Gestor()).inicializarPrograma();
		GridBagConstraints c = new GridBagConstraints();
		
		this.setLista(null);
		
		this.setComboBoxDistribuidores(new JComboBox());
		c.gridy = 0;
		c.gridx = 2;
		this.llenarSelect();
		this.getComboBoxDistribuidores().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					seleccionarFabricante();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		this.add(this.getComboBoxDistribuidores(), c);
		
		this.setVisible(false);
		
	}
	
	public void seleccionarFabricante() throws Exception{
		
		int i;
		
		i = this.comboBoxDistribuidores.getSelectedIndex();
		this.getTextFieldNombre().setText(this.getLista().get(i).get("nombre"));
		this.getTextFieldTelefono().setText(this.getLista().get(i).get("telefono"));
		this.getTextFieldDireccion().setText(this.getLista().get(i).get("direccion"));
		this.getTextFieldPorcentaje().setText(this.getLista().get(i).get("porcentaje"));
		
	}
	
	private void llenarSelect() throws Exception{
		
		for(int i = 0; i < this.getLista().size(); i++){	
			this.getComboBoxDistribuidores().addItem(this.getLista().get(i).get("nombre"));	
		}
		
	}

	public JComboBox getComboBoxDistribuidores() {
		return comboBoxDistribuidores;
	}

	public void setComboBoxDistribuidores(JComboBox comboBoxFabricantes) {
		this.comboBoxDistribuidores = comboBoxFabricantes;
	}

	public ArrayList<TreeMap<String, String>> getLista() throws Exception {
		ArrayList<TreeMap<String, String>> l;
		
		l = (new Gestor()).listarDistribuidores();
		
		return l;
	}

	public void setLista(ArrayList<TreeMap<String, String>> lista) {
		this.lista = lista;
	}
	
}

