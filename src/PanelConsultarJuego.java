import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PanelConsultarJuego extends PanelFormaJuego{
	
	private JTextField txtId;
	private JButton btnBuscar;
	private JLabel lblID;
	
	public PanelConsultarJuego(){
		
		super();
		GridBagConstraints c = new GridBagConstraints();

		
		this.setBtnBuscar(new JButton("Buscar"));
		c.gridx = 3;
		c.gridy = 1;
		this.add(this.getBtnBuscar(), c);
		
		this.getTextFieldID().setEditable(false);
		this.getTextFieldMontador().setEditable(false);
		this.getTextFieldEstado().setEditable(false);
		
		this.getBtnBuscar().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(getTxtId().getText() != null || getTxtId().getText() != ""){
					try {
						llenarCampos();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else{
					JOptionPane.showMessageDialog(null, "Digite un Id valido");
				}
			}
			
		});
		
	}
	
	private void llenarCampos() throws NumberFormatException, Exception{
		
		TreeMap<String,String> j;
		ArrayList<TreeMap<String,String>> muebles;
		
		j = (new Gestor()).consultarJuego(Integer.parseInt(this.getTxtId().getText()), Integer.parseInt((String) this.getdSeleccionado().get("id")));
		if(j != null){
			this.getTextFieldMontador().setText(j.get("montador"));
			this.getTextFieldEstado().setText(j.get("vendido"));
			muebles = (new Gestor()).consultarMueblePorJuego(Integer.parseInt(j.get("id")));
			if(muebles != null){
				this.llenarTabla(muebles);
			}else{
				JOptionPane.showMessageDialog(null, "Este juego no tiene muebles");
			}
		}else{
			JOptionPane.showMessageDialog(null, "Revise el id");
		}
		
	}
	
	private void llenarTabla(ArrayList muebles){
		
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

