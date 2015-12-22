import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelFormaMueble extends JPanel {

	private JTextField textFieldID;
	private JTextField textFieldLinea;
	private JTextField textFieldColor;
	private JTextField textFieldAncho;
	private JTextField textFieldAlto;
	private JTextField textFieldLargo;
	private JTextField textFieldCategoria;
	private JTextField textFieldPrecio;
	private JTextField textFieldalturaSobreSuelo;
	private JTextField textFieldEspesor;
	
	private JLabel lblPrecio;
	private JLabel lblAlturaSobreSuelo;
	private JLabel lblespesor;
	private JLabel lblTipo;
	private JLabel lblAcabado;
	private JLabel lblCategoria;
	private JLabel lblID;

	private JComboBox comboBoxCategoria;
	private JComboBox comboBoxAcabado;
	private JComboBox comboBoxTipo;
	
	private String[] listaCategorias;
	private String[] listaTipos;
	private String[] listaAcabados;

	private JButton btnAceptar;
	private JButton btnCancelar;
	

	public PanelFormaMueble(){
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		listaCategorias = new String[]{"alto","bajo","encimera","panel"};
		listaTipos = new String[]{"Marmol","Aglomerado"};
		listaAcabados = new String[]{"Regular","Normal","Fino","Muy Fino"};
		
		lblID = new JLabel("ID:");
		c.gridy = 1;
		c.gridx = 1;
		c.anchor = GridBagConstraints.LINE_END;
		this.add(lblID,c);
		
		JLabel lblLinea = new JLabel("Linea:");
		c.gridy++;
		this.add(lblLinea,c);
		
		JLabel lblColor = new JLabel("Color:");
		c.gridy++;
		this.add(lblColor,c);
		
		JLabel lblAncho = new JLabel("Ancho:");
		c.gridy++;
		this.add(lblAncho,c);
		
		JLabel lblAlto = new JLabel("Alto:");
		c.gridy++;
		this.add(lblAlto,c);
		
		JLabel lblLargo = new JLabel("Largo:");
		c.gridy++;
		this.add(lblLargo,c);
		
		
		lblCategoria = new JLabel("Categoria :");
		c.gridy++;
		this.add(lblCategoria,c);
		
		lblPrecio = new JLabel("Precio:");
		c.gridy++;
		this.add(lblPrecio,c);
		
		lblAlturaSobreSuelo = new JLabel("Altura Sobre suelo:");
		c.gridy++;
		this.add(lblAlturaSobreSuelo,c);
		
		lblespesor = new JLabel("Espesor:");
		c.gridy++;
		this.add(lblespesor,c);
		lblTipo = new JLabel("Tipo:");
		c.gridy++;
		this.add(lblTipo,c);
		
		lblAcabado = new JLabel("Acabado:");
		c.gridy++;
		this.add(lblAcabado,c);
		
		textFieldID = new JTextField(8);
		c.gridy = 1;
		c.gridx = 2;
		c.anchor = GridBagConstraints.LINE_START;
		this.add(textFieldID,c);
		//textFieldNombre.setColumns(10);
		
		textFieldLinea = new JTextField(8);
		c.gridy++;
		this.add(textFieldLinea,c);
		
		textFieldColor = new JTextField(8);
		c.gridy++;
		this.add(textFieldColor,c);
		//textFieldApellido.setColumns(10);
		
		textFieldAncho = new JTextField(8);
		c.gridy++;
		this.add(textFieldAncho,c);
		//textFieldTelefono.setColumns(10);
		
		textFieldAlto = new JTextField(8);
		c.gridy++;
		this.add(textFieldAlto,c);
		//textFieldTelefono.setColumns(10);
		
		textFieldLargo = new JTextField(8);
		c.gridy++;
		this.add(textFieldLargo,c);
		//textFieldTelefono.setColumns(10);
		
		this.setComboBoxCategoria(new JComboBox());
		c.gridy++;
		this.add(this.getComboBoxCategoria(), c);
		//textFieldLinea.setColumns(10);
		
		textFieldPrecio = new JTextField(8);
		c.gridy++;
		this.add(textFieldPrecio,c);
		//textFieldAnnos.setColumns(10);
		
		textFieldalturaSobreSuelo = new JTextField(8);
		c.gridy++;
		this.add(textFieldalturaSobreSuelo,c);
		//textFieldApellido.setColumns(10);
		
		textFieldEspesor = new JTextField(8);
		c.gridy++;
		this.add(textFieldEspesor,c);
		//textFieldTelefono.setColumns(10);
		this.setComboBoxTipo(new JComboBox());
		c.gridy++;
		this.add(this.getComboBoxTipo(), c);
		
		this.setComboBoxAcabado(new JComboBox());
		c.gridy++;
		this.add(this.getComboBoxAcabado(), c);
		
		
				
		
		btnAceptar = new JButton("Aceptar");
		c.gridy = 13;
		c.gridx = 5;
		this.add(btnAceptar,c);
		
		btnCancelar = new JButton("Cancelar");
		c.gridx = 4;
		this.add(btnCancelar,c);
		
		llenarComboBoxTipo();
		llenarComboBoxCategoria();
		llenarComboBoxAcabados();
		
		this.setVisible(true);
		
	}

	public JTextField getTextFieldID() {
		return textFieldID;
	}

	public void setTextFieldID(JTextField textFieldID) {
		this.textFieldID = textFieldID;
	}


	public JTextField getTextFieldAncho() {
		return textFieldAncho;
	}

	public void setTextFieldAncho(JTextField textFieldAncho) {
		this.textFieldAncho = textFieldAncho;
	}
	
	public JTextField getTextFieldAlto() {
		return textFieldAlto;
	}

	public void setTextFieldAlto(JTextField textFieldAlto) {
		this.textFieldAlto = textFieldAlto;
	}
	
	public JTextField getTextFieldLargo() {
		return textFieldLargo;
	}

	public void setTextFieldLargo(JTextField textFieldLargo) {
		this.textFieldLargo = textFieldLargo;
	}

	public JTextField getTextFieldCategoria() {
		return textFieldCategoria;
	}

	public void setTextFieldCategoria(JTextField textFieldCategoria) {
		this.textFieldCategoria = textFieldCategoria;
	}

	public JTextField getTextFieldLinea() {
		return textFieldLinea;
	}

	public void setTextFieldLinea(JTextField textFieldLinea) {
		this.textFieldLinea = textFieldLinea;
	}

	public JTextField getTextFieldPrecio() {
		return textFieldPrecio;
	}

	public void setTextFieldAnnos(JTextField textFieldPrecio) {
		this.textFieldPrecio = textFieldPrecio;
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
	
	public void setComboBoxTipo(JComboBox comboBoxMontadores) {
		this.comboBoxTipo = comboBoxMontadores;
	}
	
	public JComboBox getComboBoxTipo() {
		return comboBoxTipo;
	}
	
	/**
	 * @return the listaTipos
	 */
	public String[] getListaTipos() {
		return listaTipos;
	}
	
	/**
	 * @return the comboBoxCtegoria
	 */
	public JComboBox getComboBoxCategoria() {
		return comboBoxCategoria;
	}

	/**
	 * @param comboBoxCtegoria the comboBoxCtegoria to set
	 */
	public void setComboBoxCategoria(JComboBox comboBoxCtegoria) {
		this.comboBoxCategoria = comboBoxCtegoria;
	}

	
	/**
	 * @param listaTipos the listaTipos to set
	 */
	public void setListaTipos(String[] listaTipos) {
		this.listaTipos = listaTipos;
	}
	
	/**
	 * @return the listaCategorias
	 */
	public String[] getListaCategorias() {
		return listaCategorias;
	}

	/**
	 * @param listaCategorias the listaCategorias to set
	 */
	public void setListaCategorias(String[] listaCategorias) {
		this.listaCategorias = listaCategorias;
	}
	
	/**
	 * @return the lblAlturaSobreSuelo
	 */
	public JLabel getLblAlturaSobreSuelo() {
		return lblAlturaSobreSuelo;
	}

	/**
	 * @param lblAlturaSobreSuelo the lblAlturaSobreSuelo to set
	 */
	public void setLblAlturaSobreSuelo(JLabel lblAlturaSobreSuelo) {
		this.lblAlturaSobreSuelo = lblAlturaSobreSuelo;
	}

	/**
	 * @return the lblespesor
	 */
	public JLabel getLblespesor() {
		return lblespesor;
	}

	/**
	 * @param lblespesor the lblespesor to set
	 */
	public void setLblespesor(JLabel lblespesor) {
		this.lblespesor = lblespesor;
	}

	/**
	 * @return the textFieldalturaSobreSuelo
	 */
	public JTextField getTextFieldalturaSobreSuelo() {
		return textFieldalturaSobreSuelo;
	}

	/**
	 * @param textFieldalturaSobreSuelo the textFieldalturaSobreSuelo to set
	 */
	public void setTextFieldalturaSobreSuelo(JTextField textFieldalturaSobreSuelo) {
		this.textFieldalturaSobreSuelo = textFieldalturaSobreSuelo;
	}

	/**
	 * @return the textFieldEspesor
	 */
	public JTextField getTextFieldEspesor() {
		return textFieldEspesor;
	}

	/**
	 * @param textFieldEspesor the textFieldEspesor to set
	 */
	public void setTextFieldEspesor(JTextField textFieldEspesor) {
		this.textFieldEspesor = textFieldEspesor;
	}
	
	/**
	 * @return the listaAcabados
	 */
	public String[] getListaAcabados() {
		return listaAcabados;
	}

	/**
	 * @param listaAcabados the listaAcabados to set
	 */
	public void setListaAcabados(String[] listaAcabados) {
		this.listaAcabados = listaAcabados;
	}
	
	/**
	 * @return the comboBoxAcabado
	 */
	public JComboBox getComboBoxAcabado() {
		return comboBoxAcabado;
	}

	/**
	 * @param comboBoxAcabado the comboBoxAcabado to set
	 */
	public void setComboBoxAcabado(JComboBox comboBoxAcabado) {
		this.comboBoxAcabado = comboBoxAcabado;
	}
	
	/**
	 * @return the lblTipo
	 */
	public JLabel getLblTipo() {
		return lblTipo;
	}

	/**
	 * @param lblTipo the lblTipo to set
	 */
	public void setLblTipo(JLabel lblTipo) {
		this.lblTipo = lblTipo;
	}
	
	/**
	 * @return the lblAcabado
	 */
	public JLabel getLblAcabado() {
		return lblAcabado;
	}

	/**
	 * @param lblAcabado the lblAcabado to set
	 */
	public void setLblAcabado(JLabel lblAcabado) {
		this.lblAcabado = lblAcabado;
	}


	/**
	 * @return the lblCategoria
	 */
	public JLabel getLblCategoria() {
		return lblCategoria;
	}

	/**
	 * @param lblCategoria the lblCategoria to set
	 */
	public void setLblCategoria(JLabel lblCategoria) {
		this.lblCategoria = lblCategoria;
	}
	
	/**
	 * @return the textFieldColor
	 */
	public JTextField getTextFieldColor() {
		return textFieldColor;
	}

	/**
	 * @param textFieldColor the textFieldColor to set
	 */
	public void setTextFieldColor(JTextField textFieldColor) {
		this.textFieldColor = textFieldColor;
	}


	
	private void llenarComboBoxTipo(){
		
		for(int i = 0; i < listaTipos.length; i++){	
			this.getComboBoxTipo().addItem(this.getListaTipos()[i]);	
		}
	}
	
	private void llenarComboBoxCategoria(){
		
		for(int i = 0; i < listaCategorias.length; i++){	
			this.getComboBoxCategoria().addItem(this.getListaCategorias()[i]);	
		}
	}
	
private void llenarComboBoxAcabados(){
		
		for(int i = 0; i < listaAcabados.length; i++){	
			this.getComboBoxAcabado().addItem(this.getListaAcabados()[i]);	
		}
	}
	

	/**
	 * @return the lblID
	 */
	public JLabel getLblID() {
		return lblID;
	}

	/**
	 * @param lblID the lblID to set
	 */
	public void setLblID(JLabel lblID) {
		this.lblID = lblID;
	}
}
