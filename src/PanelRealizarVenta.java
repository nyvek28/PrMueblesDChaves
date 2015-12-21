import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.TreeMap;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class PanelRealizarVenta extends JPanel {

	private JTextField txtIdCliente;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTextField txtIdJuego;
	private JTextField txtMontador;
	private JTextField txtPrecio;
	private JTable tbMuebles;
	private JComboBox cbDistribuidores;
	private DefaultComboBoxModel dm1;
	private DefaultTableModel dm2;
	private JButton btnBuscar1;
	private JButton btnBuscar2;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private TreeMap<String,String> dSeleccionado;
	private JLabel lblTotal;
	
	public PanelRealizarVenta(){
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(3,3,5,3);
		
		JLabel lblIdCliente = new JLabel("IdCliente:");
		c.gridx = 1;
		c.gridy = 1;
		this.add(lblIdCliente, c);
		
		JLabel lblNombre = new JLabel("Nombre:");
		c.gridy++;
		this.add(lblNombre, c);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		c.gridy++;
		this.add(lblTelefono, c);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		c.gridy++;
		this.add(lblDireccion, c);
		
		JLabel lblIdJuego = new JLabel("IdJuego:");
		c.gridy++;
		this.add(lblIdJuego, c);
		
		JLabel lblMontador = new JLabel("Montador:");
		c.gridy++;
		this.add(lblMontador, c);
		
		JLabel lblPrecio = new JLabel("Precio:");
		c.gridy++;
		this.add(lblPrecio, c);
		
		JLabel lblMueble = new JLabel("Muebles:");
		c.gridy++;
		this.add(lblMueble, c);
		
		this.setTxtIdCliente(new JTextField(8));
		c.gridx++;
		c.gridy = 1;
		this.add(this.getTxtIdCliente(), c);
		
		this.setTxtNombre(new JTextField(8));
		c.gridy++;
		this.add(this.getTxtNombre(), c);
		
		this.setTxtTelefono(new JTextField(8));
		c.gridy++;
		this.add(this.getTxtTelefono(), c);
		
		this.setTxtDireccion(new JTextField(8));
		c.gridy++;
		this.add(this.getTxtDireccion(), c);
		
		this.setTxtIdJuego(new JTextField(8));
		c.gridy++;
		this.add(this.getTxtIdJuego(), c);
		
		this.setTxtMontador(new JTextField(8));
		c.gridy++;
		this.add(this.getTxtMontador(), c);
		
		this.setTxtPrecio(new JTextField(8));
		c.gridy++;
		this.add(this.getTxtPrecio(), c);
		
		this.setTbMuebles(new JTable());
		c.gridy++;
		this.add(this.getTbMuebles(), c);
		
		this.getTxtNombre().setEditable(false);
		this.getTxtTelefono().setEditable(false);
		this.getTxtDireccion().setEditable(false);
		this.getTxtMontador().setEditable(false);
		this.getTxtPrecio().setEditable(false);
		
	}

	public JTextField getTxtIdCliente() {
		return txtIdCliente;
	}

	public void setTxtIdCliente(JTextField txtIdCliente) {
		this.txtIdCliente = txtIdCliente;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtTelefono() {
		return txtTelefono;
	}

	public void setTxtTelefono(JTextField txtTelefono) {
		this.txtTelefono = txtTelefono;
	}

	public JTextField getTxtDireccion() {
		return txtDireccion;
	}

	public void setTxtDireccion(JTextField txtDireccion) {
		this.txtDireccion = txtDireccion;
	}

	public JTextField getTxtIdJuego() {
		return txtIdJuego;
	}

	public void setTxtIdJuego(JTextField txtIdJuego) {
		this.txtIdJuego = txtIdJuego;
	}

	public JTextField getTxtMontador() {
		return txtMontador;
	}

	public void setTxtMontador(JTextField txtMontador) {
		this.txtMontador = txtMontador;
	}

	public JTextField getTxtPrecio() {
		return txtPrecio;
	}

	public void setTxtPrecio(JTextField txtPrecio) {
		this.txtPrecio = txtPrecio;
	}

	public JTable getTbMuebles() {
		return tbMuebles;
	}

	public void setTbMuebles(JTable tbMuebles) {
		this.tbMuebles = tbMuebles;
	}

	public JComboBox getCbDistribuidores() {
		return cbDistribuidores;
	}

	public void setCbDistribuidores(JComboBox cbDistribuidores) {
		this.cbDistribuidores = cbDistribuidores;
	}

	public DefaultComboBoxModel getDm1() {
		return dm1;
	}

	public void setDm1(DefaultComboBoxModel dm1) {
		this.dm1 = dm1;
	}

	public DefaultTableModel getDm2() {
		return dm2;
	}

	public void setDm2(DefaultTableModel dm2) {
		this.dm2 = dm2;
	}

	public JButton getBtnBuscar1() {
		return btnBuscar1;
	}

	public void setBtnBuscar1(JButton btnBuscar1) {
		this.btnBuscar1 = btnBuscar1;
	}

	public JButton getBtnBuscar2() {
		return btnBuscar2;
	}

	public void setBtnBuscar2(JButton btnBuscar2) {
		this.btnBuscar2 = btnBuscar2;
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

	public TreeMap<String, String> getdSeleccionado() {
		return dSeleccionado;
	}

	public void setdSeleccionado(TreeMap<String, String> dSeleccionado) {
		this.dSeleccionado = dSeleccionado;
	}

	public JLabel getLblTotal() {
		return lblTotal;
	}

	public void setLblTotal(JLabel lblTotal) {
		this.lblTotal = lblTotal;
	}
	
}
