import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PanelConsultarDistribuidor extends PanelFormaDistribuidor {

	private JTextField txtId;
	private JButton btnBuscar;
	private JLabel lblId;
	
	public PanelConsultarDistribuidor(){
		
		super();
		GridBagConstraints c = new GridBagConstraints();
		
		this.setLblId(new JLabel("Digite un Id:"));
		c.gridx = 1;
		c.gridy = 0;
		this.add(this.getLblId(), c);
		
		this.setTxtId(new JTextField(8));
		c.gridx++;
		this.add(this.getTxtId(), c);
		
		this.setBtnBuscar(new JButton("Buscar"));
		c.gridx++;
		this.add(this.getBtnBuscar(), c);
		
		this.getTextFieldNombre().setEditable(false);
		this.getTextFieldTelefono().setEditable(false);
		this.getTextFieldPorcentaje().setEditable(false);
		this.getTextFieldDireccion().setEditable(false);
		
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

	public JLabel getLblId() {
		return lblId;
	}

	public void setLblId(JLabel lblId) {
		this.lblId = lblId;
	}
	
}

