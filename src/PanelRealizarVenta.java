import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
import javax.swing.JScrollPane;
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
		c.anchor = GridBagConstraints.NORTH;
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
		this.getTbMuebles().setVisible(true);
		this.getTbMuebles().setPreferredScrollableViewportSize(new Dimension(300, 200));
		JScrollPane p1 = new JScrollPane(this.getTbMuebles());
		c.gridy++;
		this.add(p1, c);
		
		this.setLblTotal(new JLabel("Total: "));
		c.anchor = GridBagConstraints.SOUTH;
		c.gridx++;
		this.add(this.getLblTotal(), c);
		
		this.setBtnBuscar1(new JButton("Buscar"));
		c.gridx = 3;
		c.gridy = 1;
		this.add(this.getBtnBuscar1(), c);
		
		this.setBtnBuscar2(new JButton("Buscar"));
		c.gridx = 3;
		c.gridy = 5;
		this.add(this.getBtnBuscar2(), c);
		
		this.setBtnCancelar(new JButton("Cancelar"));
		c.anchor = GridBagConstraints.SOUTH;
		c.gridx = 4;
		c.gridy = 9;
		this.add(this.getBtnCancelar(), c);
		
		this.setBtnAceptar(new JButton("Aceptar"));
		c.anchor = GridBagConstraints.SOUTH;
		c.gridx = 5;
		c.gridy = 9;
		this.add(this.getBtnAceptar(), c);
		
		this.getTxtNombre().setEditable(false);
		this.getTxtTelefono().setEditable(false);
		this.getTxtDireccion().setEditable(false);
		this.getTxtMontador().setEditable(false);
		this.getTxtPrecio().setEditable(false);
		
		this.setCbDistribuidores(new JComboBox());
		
		this.getCbDistribuidores().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					seleccionarDistribuidor();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
		this.getBtnBuscar1().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					buscarCliente();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
		this.getBtnBuscar2().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					buscarJuego();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
	}
	
	private void llenarDistribuidor() throws Exception{
		
		this.setDm1(new DefaultComboBoxModel());
		
		for(int i = 0; i < (new Gestor()).listarDistribuidores().size(); i++){
			this.getDm1().addElement((new Gestor()).listarDistribuidores().get(i).get("nombre"));
			//this.getComboBoxDistribuidores().addItem(this.getLista().get(i).get("nombre"));	
		}
		
		this.getCbDistribuidores().setModel(getDm1());
		
	}
	
	private void seleccionarDistribuidor() throws Exception{
		
		int indice;
		
		indice = this.getCbDistribuidores().getSelectedIndex();
		if(this.getCbDistribuidores().getSelectedIndex() == -1){
			indice = 0;
		}
		this.setdSeleccionado((new Gestor()).listarDistribuidores().get(indice));
		
	}
	
	private void buscarCliente() throws NumberFormatException, SQLException, Exception{
		
		if(this.getTxtIdCliente().getText() != null){
			TreeMap<String,String> cliente;
			cliente = (new Gestor()).consultarCliente(Integer.parseInt(this.getTxtIdCliente().getText()));
			if(cliente != null){
				this.getTxtNombre().setText(cliente.get("nombre") + " " + cliente.get("apellido"));
				this.getTxtTelefono().setText(cliente.get("telefono"));
				this.getTxtDireccion().setText("direccion");
			}else{
				JOptionPane.showMessageDialog(null, "Revise el id del Cliente");
			}
		}else{
			JOptionPane.showMessageDialog(null, "Ingrese un id valido");
		}
		
	}
	
	private void construirTabla(){
		
		this.setDm2(new DefaultTableModel());
		this.getDm2().addColumn("Id");
		this.getDm2().addColumn("Color");
		this.getDm2().addColumn("Dimensiones");
		this.getDm2().addColumn("Juego");
		this.getDm2().addColumn("Precio");
		this.getTbMuebles().setModel(this.getDm2());
		
	}
	
	private void buscarJuego() throws NumberFormatException, Exception{
		
		TreeMap<String,String> j;
		ArrayList<TreeMap<String,String>> muebles;
		
		
		j = (new Gestor()).consultarJuego(Integer.parseInt(this.getTxtIdJuego().getText()), 
				Integer.parseInt((String) this.getdSeleccionado().get("id"))
				);
		if(j != null){
			this.getTxtMontador().setText(j.get("montador"));
			this.getTxtPrecio().setText(j.get("precio"));
			muebles = (new Gestor()).consultarMueblePorJuego(Integer.parseInt(j.get("id")));
			if(muebles != null){
				this.llenarTabla(muebles);
			}else{
				JOptionPane.showMessageDialog(null, "Este juego no tiene muebles");
			}
			this.getLblTotal().setText("Total: "+(new Gestor().calcularCosto(Integer.parseInt((String) this.getdSeleccionado().get("id")), 
													Integer.parseInt(this.getTxtIdJuego().getText()))));
			
		}else{
			JOptionPane.showMessageDialog(null, "Revise el id");
		}
		
	}
	
	private void llenarTabla(ArrayList<TreeMap<String,String>> muebles){
		
		this.construirTabla();
		if(muebles != null){
			for(int i = 0; i < muebles.size(); i++){
				String[] fila = {muebles.get(i).get("id"),
							muebles.get(i).get("color"),
							muebles.get(i).get("ancho")+"x"+muebles.get(i).get("alto")+"x"+muebles.get(i).get("largo"),
							muebles.get(i).get("idJuego"),
							muebles.get(i).get("precio")
							};
				this.getDm2().addRow(fila);
			}
		}else{
			JOptionPane.showMessageDialog(null, "Este distribuidor no tiene muebles");
		}
		
	}
	
	public void iniciarPanel() throws Exception{
		
		this.llenarDistribuidor();
		this.construirTabla();
		JOptionPane.showMessageDialog( null, this.getCbDistribuidores(), "Elija un distribuidor", JOptionPane.QUESTION_MESSAGE);
		
	}
	
	public void realizarVenta() throws NumberFormatException, Exception{
		
		TreeMap <String,String> venta;
		
		venta = (new Gestor()).venderJuego(Integer.parseInt(this.getdSeleccionado().get("id")),
									Integer.parseInt(this.getTxtIdJuego().getText()), 
									Integer.parseInt(this.getTxtIdCliente().getText())
									);
		
		JOptionPane.showMessageDialog(null, "Se ralizo la venta de id " + venta.get("id") + " por un monto de " + venta.get("monto") + " colones");
		
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
