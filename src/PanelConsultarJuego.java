import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PanelConsultarJuego extends PanelFormaJuego{
	
	private JTextField txtId;
	private JButton btnBuscar;
	private JLabel lblID;
	
	public PanelConsultarJuego(){
		
		super();
		GridBagConstraints c = new GridBagConstraints();
		
		this.setLblID(new JLabel("Digite un Id:"));
		c.gridx = 1;
		c.gridy = 0;
		this.add(this.getLblID(), c);
		
		this.setTxtId(new JTextField(8));
		c.gridx++;
		this.add(this.getTxtId(), c);
		
		this.setBtnBuscar(new JButton("Buscar"));
		c.gridx++;
		this.add(this.getBtnBuscar(), c);
		
		this.getTextFieldID().setEditable(false);
		this.getTextFieldMuebles().setEditable(false);
		this.getTextFieldMontador().setEditable(false);
		this.getTextFieldEstado().setEditable(false);
		
	}
	
	public JTextField getTxtId() {
		return txtId;
	}

	public void setTxtId(JTextField txtId) {
		this.txtId = txtId;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}

	public JLabel getLblID() {
		return lblID;
	}

	public void setLblID(JLabel lblID) {
		this.lblID = lblID;
	}
	
}

