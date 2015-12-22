import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelRegistrarMueble extends PanelFormaMueble {

	public PanelRegistrarMueble(){
		
		super();
		this.getLblID().setVisible(false);
		this.getTextFieldID().setVisible(false);
		this.getLblAlturaSobreSuelo().setVisible(false);
		this.getLblespesor().setVisible(false);
		this.getLblTipo().setVisible(false);
		this.getLblAcabado().setVisible(false);
		//this.getLblCategoria().setVisible(false);
		
		this.getTextFieldalturaSobreSuelo().setVisible(false);
		this.getTextFieldEspesor().setVisible(false);
		
		this.getComboBoxTipo().setVisible(false);
		this.getComboBoxAcabado().setVisible(false);
		//this.getComboBoxCategoria().setVisible(false);
		
	}
	
}