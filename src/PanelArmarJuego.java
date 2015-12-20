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

public class PanelArmarJuego extends JPanel {

	private JButton btnAgregar;
	private JTable tbLibres;
	private JTable tbSeleccionados;
	private DefaultTableModel dm1;
	private DefaultTableModel dm2;
	private JComboBox distribuidor;
	private DefaultComboBoxModel dm3;
	
	public PanelArmarJuego(){
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(3,3,5,3);
		
		this.setDistribuidor(new JComboBox());
		this.setVisible(true);
		c.gridx = 2;
		c.gridy = 0;
		this.add(this.getDistribuidor(), c);
		
		this.setTbLibres(new JTable());
		this.getTbLibres().setVisible(true);
		this.getTbLibres().setPreferredScrollableViewportSize(new Dimension(300, 200));
		JScrollPane p1 = new JScrollPane(this.getTbLibres());
		c.gridy = 2;
		c.gridx = 2;
		this.add(p1, c);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setVisible(true);
		c.gridx++;
		this.add(btnAgregar, c);
		
		this.setTbSeleccionados(new JTable());
		this.getTbSeleccionados().setVisible(true);
		this.getTbSeleccionados().setPreferredScrollableViewportSize(new Dimension(300, 200));
		JScrollPane p2 = new JScrollPane(this.getTbSeleccionados());
		c.gridx++;
		this.add(p2, c);
		
		this.getDistribuidor().addActionListener(new ActionListener(){

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
		
	}
	
	public void construirTablas(){
		
		this.setDm1(new DefaultTableModel());
		this.getDm1().addColumn("ID");
		this.getDm1().addColumn("Color");
		this.getDm1().addColumn("Ancho");
		this.getDm1().addColumn("Alto");
		this.getDm1().addColumn("Largo");
		this.getDm1().addColumn("Precio");
		this.getTbLibres().setModel(this.getDm1());
		
		this.setDm2(new DefaultTableModel());
		this.getDm2().addColumn("ID");
		this.getDm2().addColumn("Color");
		this.getDm2().addColumn("Ancho");
		this.getDm2().addColumn("Alto");
		this.getDm2().addColumn("Largo");
		this.getDm2().addColumn("Precio");
		this.getTbSeleccionados().setModel(this.getDm2());
		
	}
	
	public void iniciarPanel() throws NumberFormatException, Exception{
		
		this.llenarSelect();
		this.construirTablas();;
		
	}
	
	private void llenarLibres() throws NumberFormatException, Exception{
		
		ArrayList<TreeMap<String,String>> muebles;
		
		this.construirTablas();
		muebles = (new Gestor()).consultarMueblePorDistribuidor(Integer.parseInt((new Gestor()).listarDistribuidores().get(this.distribuidor.getSelectedIndex()).get("id")));
		if(muebles != null){
			for(int i = 0; i < muebles.size(); i++){
				String[] fila = {muebles.get(i).get("id"),muebles.get(i).get("color"),muebles.get(i).get("ancho"),muebles.get(i).get("alto"),
						muebles.get(i).get("largo"),muebles.get(i).get("precio")};
				this.getDm1().addRow(fila);
			}
		}else{
			JOptionPane.showMessageDialog(null, "Este distribuidor no tiene muebles");
		}
		
	}
	
	private void seleccionarDistribuidor() throws Exception{
		
		int i;
		
		i = this.distribuidor.getSelectedIndex();
//		this.getTextFieldNombre().setText((new Gestor()).listarDistribuidores().get(i).get("nombre"));
//		this.getTextFieldTelefono().setText((new Gestor()).listarDistribuidores().get(i).get("telefono"));
//		this.getTextFieldDireccion().setText((new Gestor()).listarDistribuidores().get(i).get("direccion"));
//		this.getTextFieldPorcentaje().setText((new Gestor()).listarDistribuidores().get(i).get("porcentaje"));
		
	}
	
	private void llenarSelect() throws Exception{
		
		this.setDm3(new DefaultComboBoxModel());
		
		for(int i = 0; i < (new Gestor()).listarDistribuidores().size(); i++){
			this.getDm3().addElement((new Gestor()).listarDistribuidores().get(i).get("nombre"));	
			//this.getComboBoxDistribuidores().addItem(this.getLista().get(i).get("nombre"));	
		}
		
		this.getDistribuidor().setModel(getDm3());
		
	}
	
	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public void setBtnAgregar(JButton btnAgregar) {
		this.btnAgregar = btnAgregar;
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

	public JComboBox getDistribuidor() {
		return distribuidor;
	}

	public void setDistribuidor(JComboBox distribuidor) {
		this.distribuidor = distribuidor;
	}

	public DefaultComboBoxModel getDm3() {
		return dm3;
	}

	public void setDm3(DefaultComboBoxModel dm3) {
		this.dm3 = dm3;
	}
	
}
