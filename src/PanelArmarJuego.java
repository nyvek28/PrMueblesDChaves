import java.awt.GridBagConstraints;

import javax.swing.JButton;

public class PanelArmarJuego extends PanelFormaMueble {

	private JButton btnAgregar;
	
	public PanelArmarJuego(){
		
		super();
		
		this.getTextFieldID().setEditable(false);
		this.getTextFieldAlto().setEditable(false);
		this.getTextFieldAncho().setEditable(false);
		this.getTextFieldLargo().setEditable(false);
		this.getTextFieldCategoria().setEditable(false);
		this.getTextFieldLinea().setEditable(false);
		this.getTextFieldPrecio().setEditable(false);
		
		GridBagConstraints c = new GridBagConstraints();
		
		btnAgregar = new JButton();
		btnAgregar.setVisible(true);
		c.gridx = 4;
		c.gridy = 0;
		this.add(btnAgregar, c);
		
	}
	
	public void refrescarSelect(){
		
		
		
	}
	
	private void llenarSelect(){
		
		
		
	}
	
}
