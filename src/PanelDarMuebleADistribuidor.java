import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TreeMap;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class PanelDarMuebleADistribuidor extends PanelFormaDistribuidor {
	
	private JButton btnAgregar;
	private JButton btnDarMuebles;
	private JButton btnQuitar;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JTable tbLibres;
	private JTable tbSeleccionados;
	private DefaultTableModel dm1;
	private DefaultTableModel dm2;
	private JComboBox fabricante;
	private JComboBox distribuidor;
	private TreeMap mSeleccionado;
	private DefaultComboBoxModel dm3;
	private DefaultComboBoxModel dm4;
	
	

	

	
	public PanelDarMuebleADistribuidor(){
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(3,3,5,3);
		
		this.setFabricante(new JComboBox());
		this.setVisible(true);
		c.gridx = 2;
		c.gridy = 0;
		c.anchor = GridBagConstraints.WEST;
		this.add(this.getFabricante(), c);
		this.setDistribuidor(new JComboBox());
		
		
		
		this.setTbLibres(new JTable());
		this.getTbLibres().setVisible(true);
		this.getTbLibres().setPreferredScrollableViewportSize(new Dimension(300, 200));
		JScrollPane p1 = new JScrollPane(this.getTbLibres());
		c.gridy = 2;
		c.gridx = 2;
		this.add(p1, c);
		btnDarMuebles= new JButton("Dar Muebles");
		btnDarMuebles.setVisible(true);
		c.gridx++;
		this.add(btnDarMuebles, c);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setVisible(true);
		c.gridx++;
		this.add(btnAgregar, c);
		
		btnQuitar = new JButton("Quitar");
		btnQuitar.setVisible(true);
		c.anchor = GridBagConstraints.SOUTH;
		this.add(btnQuitar, c);
		
		this.setTbSeleccionados(new JTable());
		this.getTbSeleccionados().setVisible(true);
		this.getTbSeleccionados().setPreferredScrollableViewportSize(new Dimension(300, 200));
		JScrollPane p2 = new JScrollPane(this.getTbSeleccionados());
		c.gridx++;
		this.add(p2, c);
		
		this.setBtnCancelar(new JButton("Cancelar"));
		this.getBtnCancelar().setVisible(true);
		c.gridx = 4;
		c.gridy = 5;
		c.anchor = GridBagConstraints.EAST;
		this.add(btnCancelar, c);
		
		this.setBtnAceptar(new JButton("Aceptar"));
		this.getBtnAceptar().setVisible(true);
		c.gridx++;
		c.anchor = GridBagConstraints.WEST;
		this.add(btnAceptar, c);
		
		this.getFabricante().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					llenarLibres();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});
		this.getBtnAgregar().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				agregarASeleccionados();
			}
			
		});
		
		this.getBtnQuitar().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				quitarDeSeleccionados();
			}
			
		});
		
		
		
	
		//Revisar este metodo
		this.getDistribuidor().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					mSeleccionado = (new Gestor()).listarDistribuidores().get(distribuidor.getSelectedIndex());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		

		
		
	}
	private void agregarASeleccionados(){
		
		if(this.getTbLibres().getSelectedRow() >= 0){
			String[] datos = {(String) this.getTbLibres().getValueAt(this.getTbLibres().getSelectedRow(), 0),
					(String) this.getTbLibres().getValueAt(this.getTbLibres().getSelectedRow(), 1),
					(String) this.getTbLibres().getValueAt(this.getTbLibres().getSelectedRow(), 2),
					(String) this.getTbLibres().getValueAt(this.getTbLibres().getSelectedRow(), 3),
					(String) this.getTbLibres().getValueAt(this.getTbLibres().getSelectedRow(), 4)
					};
			
			this.getDm2().addRow(datos);
			this.getDm1().removeRow(this.getTbLibres().getSelectedRow());
		}else{
			JOptionPane.showMessageDialog(null, "Porfavor, seleccione una fila");
		}
		
	}
	private void quitarDeSeleccionados(){
	
	if(this.getTbSeleccionados().getSelectedRow() >= 0){
		String[] datos = {(String) this.getTbSeleccionados().getValueAt(this.getTbSeleccionados().getSelectedRow(), 0),
				(String) this.getTbSeleccionados().getValueAt(this.getTbSeleccionados().getSelectedRow(), 1),
				(String) this.getTbSeleccionados().getValueAt(this.getTbSeleccionados().getSelectedRow(), 2),
				(String) this.getTbSeleccionados().getValueAt(this.getTbSeleccionados().getSelectedRow(), 3),
				(String) this.getTbSeleccionados().getValueAt(this.getTbSeleccionados().getSelectedRow(), 4)
				};
		
		this.getDm1().addRow(datos);
		this.getDm2().removeRow(this.getTbSeleccionados().getSelectedRow());
	}else{
		JOptionPane.showMessageDialog(null, "Porfavor, seleccione una fila");
	}
	}
	
	public void construirTablas(){
		
		JOptionPane.showMessageDialog(null, "a ver si sirve");
		
		this.setDm1(new DefaultTableModel());
		this.getDm1().addColumn("Id");
		this.getDm1().addColumn("Color");
		this.getDm1().addColumn("Dimensiones");
		this.getDm1().addColumn("Precio");
		this.getDm1().addColumn("idDistribuidor");
		this.getTbLibres().setModel(this.getDm1());
		
		this.setDm2(new DefaultTableModel());
		this.getDm2().addColumn("Id");
		this.getDm2().addColumn("Color");
		this.getDm2().addColumn("Dimensiones");
		this.getDm2().addColumn("Precio");
		this.getDm1().addColumn("idDistribuidor");
		this.getTbSeleccionados().setModel(this.getDm2());
		
	}

	public void iniciarPanel() throws NumberFormatException, Exception{
	
		this.llenarSelect();
		this.llenarDistribuidor();
		this.construirTablas();
		JOptionPane.showMessageDialog( null, this.getDistribuidor(), "Elija un Distribuidor", JOptionPane.QUESTION_MESSAGE);
	
	}
	public void llenarSelect() throws Exception{
		
		this.setDm3(new DefaultComboBoxModel());
		
		for(int i = 0; i < (new Gestor()).listarDistribuidores().size(); i++){
			this.getDm3().addElement((new Gestor()).listarDistribuidores().get(i).get("nombre"));	
			//this.getComboBoxDistribuidores().addItem(this.getLista().get(i).get("nombre"));	
		}
		
		this.getDistribuidor().setModel(getDm3());
		
	}





	private void llenarLibres() throws NumberFormatException, Exception{
	
	ArrayList<TreeMap<String,String>> muebles;
	
	this.construirTablas();
	muebles = (new Gestor()).consultarMueblePorDistribuidor(Integer.parseInt((new Gestor()).listarDistribuidores().get(this.distribuidor.getSelectedIndex()).get("id")));
	if(muebles != null){
		for(int i = 0; i < muebles.size(); i++){
			String[] fila = {muebles.get(i).get("id"),muebles.get(i).get("color"),muebles.get(i).get("ancho")+"x"+muebles.get(i).get("alto")+"x"+
					muebles.get(i).get("largo"),muebles.get(i).get("idJuego"),muebles.get(i).get("precio")};
			this.getDm1().addRow(fila);
		}
	}else{
		JOptionPane.showMessageDialog(null, "Este fabricante no tiene muebles");
	}
	
	
	}
	private void llenarDistribuidor() throws Exception{
		
		this.setDm4(new DefaultComboBoxModel());
		
		for(int i = 0; i < (new Gestor()).listarDistribuidores().size(); i++){
			this.getDm4().addElement((new Gestor()).listarDistribuidores().get(i).get("nombre") + " " + (new Gestor()).listarDistribuidores().get(i).get("id"));
			System.out.println((new Gestor()).listarDistribuidores().get(i).get("nombre") + " " + (new Gestor()).listarDistribuidores().get(i).get("id"));
			//this.getComboBoxDistribuidores().addItem(this.getLista().get(i).get("nombre"));	
		}
		
		this.getDistribuidor().setModel(getDm4());
		
	}
	private void seleccionarDistribuidor() throws Exception{
		
		mSeleccionado = (new Gestor()).listarMontadores().get(this.getDistribuidor().getSelectedIndex());
		
	}
	public TreeMap<String, String> entregarMuebles(){
		TreeMap j;
		ArrayList<Integer> indices = new ArrayList<Integer>();
		boolean registro;
		
		for(int i = 0; i < this.getTbSeleccionados().getRowCount(); i++){
			
			indices.add(Integer.parseInt((String) this.getTbSeleccionados().getValueAt(i, 0)));
		}
		if(indices.size() > 0){
			);
			JOptionPane.showMessageDialog(null, "Se registro el juego de id " + j.get("id") + " con " + this.getTbSeleccionados().getRowCount() + " muebles");
			registro = true;
		}else{
			JOptionPane.showMessageDialog(null, "No se logro registrar el juego");
			registro = false;
		}
		
		return registro;
		
		
		
	}



public JComboBox getDistribuidor() {
	return distribuidor;
}

public void setDistribuidor(JComboBox distribuidor) {
	this.distribuidor = distribuidor;
}
public JComboBox getFabricante() {
	return fabricante;
}

public void setFabricante(JComboBox fabricante) {
	this.fabricante = fabricante;
}
public JButton getBtnAgregar() {
	return btnAgregar;
}

public void setBtnAgregar(JButton btnAgregar) {
	this.btnAgregar = btnAgregar;
}

public JButton getBtnQuitar() {
	return btnQuitar;
}

public void setBtnQuitar(JButton btnQuitar) {
	this.btnQuitar = btnQuitar;
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

public JTable getTbLibres() {
	return tbLibres;
}

public void setTbLibres(JTable tbLibres) {
	this.tbLibres = tbLibres;
}

public JTable getTbSeleccionados() {
	return tbSeleccionados;
}

public void setTbSeleccionados(JTable tbSeleccionados) {
	this.tbSeleccionados = tbSeleccionados;
}

public DefaultTableModel getDm1() {
	return dm1;
}

public void setDm1(DefaultTableModel dm1) {
	this.dm1 = dm1;
}

public DefaultTableModel getDm2() {
	return dm2;
}

public void setDm2(DefaultTableModel dm2) {
	this.dm2 = dm2;
}

public TreeMap getmSeleccionado() {
	return mSeleccionado;
}
public void setmSeleccionado(TreeMap mSeleccionado) {
	this.mSeleccionado = mSeleccionado;
}
public DefaultComboBoxModel getDm3() {
	return dm3;
}
public void setDm3(DefaultComboBoxModel dm3) {
	this.dm3 = dm3;
}
public DefaultComboBoxModel getDm4() {
	return dm4;
}
public void setDm4(DefaultComboBoxModel dm4) {
	this.dm4 = dm4;
}
public JButton getBtnDarMuebles() {
	return btnDarMuebles;
}
public void setBtnDarMuebles(JButton btnDarMuebles) {
	this.btnDarMuebles = btnDarMuebles;
}
	
	
	
	
	
	
	
	

}
