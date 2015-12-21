import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeMap;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class PanelFormaJuego extends JPanel {

	private JTextField textFieldId;
	private JTextField textFieldMontador;
	private JTextField textFieldEstado;//Vendido o disponible
	private JTable tbMuebles;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private DefaultTableModel dm1;
	private JComboBox distribuidores;
	private DefaultComboBoxModel dm2;
	private TreeMap dSeleccionado;
	
	public PanelFormaJuego(){
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		JLabel lblID = new JLabel("ID:");
		c.gridy = 1;
		c.gridx = 1;
		c.anchor = GridBagConstraints.LINE_END;
		this.add(lblID,c);
		
		JLabel lblMuebles = new JLabel("Muebles:");
		c.gridy++;
		this.add(lblMuebles,c);
		
		JLabel lblMontador = new JLabel("Montador:");
		c.gridy++;
		this.add(lblMontador,c);
	
		this.setDistribuidores(new JComboBox());
		
		textFieldId = new JTextField(8);
		c.gridy = 1;
		c.gridx = 2;
		c.anchor = GridBagConstraints.LINE_START;
		this.add(textFieldId,c);
		//textFieldNombre.setColumns(10);
		
		textFieldEstado = new JTextField(8);
		c.gridy++;
		this.add(textFieldEstado,c);
		//textFieldApellido.setColumns(10);
		
		textFieldEstado = new JTextField(8);
		c.gridy++;
		this.add(textFieldEstado,c);
		//textFieldTelefono.setColumns(10);
		
		textFieldMontador = new JTextField(8);
		c.gridy++;
		this.add(textFieldMontador,c);
		//textFieldTelefono.setColumns(10)
		
		this.tbMuebles = new JTable();
		c.gridy++;
		this.add(tbMuebles, c);
		
		btnAceptar = new JButton("Aceptar");
		c.gridy = 8;
		c.gridx = 5;
		this.add(btnAceptar,c);
		
		btnCancelar = new JButton("Cancelar");
		c.gridx = 4;
		this.add(btnCancelar,c);
		
		this.setVisible(true);
		
		this.getDistribuidores().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					setdSeleccionado((new Gestor()).listarDistribuidores().get(getDistribuidores().getSelectedIndex()));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		
	}
	
	private void construirTabla(){
		
		this.setDm1(new DefaultTableModel());
		this.getDm1().addColumn("Id");
		this.getDm1().addColumn("Color");
		this.getDm1().addColumn("Dimensiones");
		this.getDm1().addColumn("Juego");
		this.getDm1().addColumn("Precio");
		this.getTbMuebles().setModel(this.getDm1());
		
	}
	
	public void iniciarPanel() throws NumberFormatException, Exception{
		
		this.llenarDistribuidor();
		this.construirTabla();
		JOptionPane.showMessageDialog( null, this.getDistribuidores(), "Elija un distribuidor", JOptionPane.QUESTION_MESSAGE);
		
	}
	
	private void llenarDistribuidor() throws Exception{
		
		this.setDm2(new DefaultComboBoxModel());
		
		for(int i = 0; i < (new Gestor()).listarDistribuidores().size(); i++){
			this.getDm2().addElement((new Gestor()).listarDistribuidores().get(i).get("nombre") + " " + (new Gestor()).listarDistribuidores().get(i).get("apellido"));
			//this.getComboBoxDistribuidores().addItem(this.getLista().get(i).get("nombre"));	
		}
		
		this.getDistribuidores().setModel(getDm2());
		
	}
	
	public JTextField getTextFieldEstado() {
		return textFieldEstado;
	}

	public void setTextFieldEstado(JTextField textFieldEstado) {
		this.textFieldEstado = textFieldEstado;
	}

	public JTextField getTextFieldID() {
		return textFieldId;
	}

	public void setTextFieldID(JTextField textFieldID) {
		this.textFieldId = textFieldID;
	}
	public JTextField getTextFieldMontador() {
		return textFieldMontador;
	}

	public void setTextFieldIdDistribuidor(JTextField textFieldMontador) {
		this.textFieldMontador = textFieldMontador;
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
	public JTextField getTextFieldId() {
		return textFieldId;
	}
	public void setTextFieldId(JTextField textFieldId) {
		this.textFieldId = textFieldId;
	}
	public JTable getTbMuebles() {
		return tbMuebles;
	}
	public void setTbMuebles(JTable tbMuebles) {
		this.tbMuebles = tbMuebles;
	}
	public DefaultTableModel getDm1() {
		return dm1;
	}
	public void setDm1(DefaultTableModel dm1) {
		this.dm1 = dm1;
	}
	public void setTextFieldMontador(JTextField textFieldMontador) {
		this.textFieldMontador = textFieldMontador;
	}

	public TreeMap getdSeleccionado() {
		return dSeleccionado;
	}

	public void setdSeleccionado(TreeMap dSeleccionado) {
		this.dSeleccionado = dSeleccionado;
	}

	public JComboBox getDistribuidores() {
		return distribuidores;
	}

	public void setDistribuidores(JComboBox distribuidores) {
		this.distribuidores = distribuidores;
	}

	public DefaultComboBoxModel getDm2() {
		return dm2;
	}

	public void setDm2(DefaultComboBoxModel dm2) {
		this.dm2 = dm2;
	}
	
}
