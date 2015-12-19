import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PanelArmarJuego extends JPanel {

	private JButton btnAgregar;
	private JTable tbLibres;
	private JTable tbSeleccionados;
	private DefaultTableModel dm1;
	private DefaultTableModel dm2;
	private JComboBox distribuidor;
	
	public PanelArmarJuego(){
		
		
		GridBagConstraints c = new GridBagConstraints();
		
		this.setTbLibres(new JTable());
		this.getTbLibres().setVisible(true);
		c.gridx = 2;
		c.gridy = 4;
		this.add(tbLibres, c);
		
		btnAgregar = new JButton();
		btnAgregar.setVisible(true);
		c.gridx++;
		this.add(btnAgregar, c);
		
		this.setTbSeleccionados(new JTable());
		this.getTbSeleccionados().setVisible(true);
		c.gridx++;
		this.add(tbSeleccionados, c);
		
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
	
}
