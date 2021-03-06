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
	
	private JButton btnBuscar;
	private JLabel lblID;
	
	public PanelConsultarJuego(){
		
		super();
		GridBagConstraints c = new GridBagConstraints();

		this.getBtnCancelar().setVisible(false);
		
		this.setBtnBuscar(new JButton("Buscar"));
		c.gridx = 3;
		c.gridy = 1;
		this.add(this.getBtnBuscar(), c);
		
		
		this.getTextFieldMontador().setEditable(false);
		this.getTextFieldEstado().setEditable(false);
		
		this.getBtnBuscar().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					llenarCampos();
				} catch (Exception e1) {
					System.out.println("Error en buscar");
					e1.printStackTrace();
				}
			}
			
		});
		
	}
	
	private void llenarCampos() throws NumberFormatException, Exception{
		
		TreeMap<String,String> j;
		ArrayList<TreeMap<String,String>> muebles;
		
		System.out.println("Id: "+this.getTextFieldId().getText());
		System.out.println("Id distribuidor: "+(String) this.getdSeleccionado().get("id"));
		
		j = (new Gestor()).consultarJuego(Integer.parseInt(this.getTextFieldId().getText()), 
				Integer.parseInt((String) this.getdSeleccionado().get("id"))
				);
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
				this.getDm1().addRow(fila);
			}
		}else{
			JOptionPane.showMessageDialog(null, "Este distribuidor no tiene muebles");
		}
		
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

