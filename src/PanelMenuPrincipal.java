import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelMenuPrincipal extends JPanel {

	private JButton btnCliente;
	private JButton btnDistribuidor;
	private JButton btnFabricante;
	private JButton btnJuego;
	private JButton btnMontador;
	private JButton btnMueble;
	private JButton btnVenta;
	
	public PanelMenuPrincipal(){
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(3,3,5,3);
		
		this.setBtnCliente(new JButton("Opciones Cliente"));
		c.gridx = 4;
		c.gridy = 1;
		this.getBtnCliente().setPreferredSize(new Dimension(200,25));
		this.add(this.getBtnCliente(),c);
		
		this.setBtnDistribuidor(new JButton("Opciones Distribuidor"));
		c.gridy++;
		this.getBtnDistribuidor().setPreferredSize(new Dimension(200,25));
		this.add(this.getBtnDistribuidor(),c);
		
		this.setBtnFabricante(new JButton("Opciones Fabricante"));
		c.gridy++;
		this.getBtnFabricante().setPreferredSize(new Dimension(200,25));
		this.add(this.getBtnFabricante(),c);

		this.setBtnJuego(new JButton("Opciones Juego"));
		c.gridy++;
		this.getBtnJuego().setPreferredSize(new Dimension(200,25));
		this.add(this.getBtnJuego(),c);
		
		this.setBtnMontador(new JButton("Opciones Montador"));
		c.gridy++;
		this.getBtnMontador().setPreferredSize(new Dimension(200,25));
		this.add(this.getBtnMontador(),c);
		
		this.setBtnMueble(new JButton("Opciones Mueble"));
		c.gridy++;
		this.getBtnMueble().setPreferredSize(new Dimension(200,25));
		this.add(this.getBtnMueble(),c);
		
		this.setBtnVenta(new JButton("Opciones Venta"));
		c.gridy++;
		this.getBtnVenta().setPreferredSize(new Dimension(200,25));
		this.add(this.getBtnVenta(),c);
		
	}

	public JButton getBtnCliente() {
		return btnCliente;
	}

	public void setBtnCliente(JButton btnCliente) {
		this.btnCliente = btnCliente;
	}

	public JButton getBtnDistribuidor() {
		return btnDistribuidor;
	}

	public void setBtnDistribuidor(JButton btnDistribuidor) {
		this.btnDistribuidor = btnDistribuidor;
	}

	public JButton getBtnFabricante() {
		return btnFabricante;
	}

	public void setBtnFabricante(JButton btnFabricante) {
		this.btnFabricante = btnFabricante;
	}

	public JButton getBtnJuego() {
		return btnJuego;
	}

	public void setBtnJuego(JButton btnJuego) {
		this.btnJuego = btnJuego;
	}

	public JButton getBtnMontador() {
		return btnMontador;
	}

	public void setBtnMontador(JButton btnMontador) {
		this.btnMontador = btnMontador;
	}

	public JButton getBtnMueble() {
		return btnMueble;
	}

	public void setBtnMueble(JButton btnMueble) {
		this.btnMueble = btnMueble;
	}

	public JButton getBtnVenta() {
		return btnVenta;
	}

	public void setBtnVenta(JButton btnVenta) {
		this.btnVenta = btnVenta;
	}
	
}
