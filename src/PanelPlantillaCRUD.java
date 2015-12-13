import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelPlantillaCRUD extends JPanel {

	private JButton btnRegistrar;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	
	public PanelPlantillaCRUD(){
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		this.setBtnRegistrar(new JButton("Registrar"));
		c.gridx = 4;
		c.gridy = 1;
		this.add(this.getBtnRegistrar(), c);
		
		this.setBtnConsultar(new JButton("Consultar"));
		c.gridy++;
		this.add(this.getBtnConsultar(), c);
		
		this.setBtnModificar(new JButton("Modificar"));
		c.gridy++;
		this.add(this.getBtnModificar(), c);
		
		this.setBtnEliminar(new JButton("Eliminar"));
		c.gridy++;
		this.add(this.getBtnEliminar(), c);
		
	}

	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}

	public void setBtnRegistrar(JButton btnRgistrar) {
		this.btnRegistrar = btnRgistrar;
	}

	public JButton getBtnConsultar() {
		return btnConsultar;
	}

	public void setBtnConsultar(JButton btnConsultar) {
		this.btnConsultar = btnConsultar;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public void setBtnModificar(JButton btnModificar) {
		this.btnModificar = btnModificar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}
	
}
