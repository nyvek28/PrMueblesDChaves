import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelRegistrarMontador extends JPanel {
	
	private JButton boton;
	private JLabel statusLabel;
	JComboBox<String> jComboBox1;


	public PanelRegistrarMontador(){
	
		statusLabel = new JLabel("holaaaaaaaaaaaaa");
		/*statusLabel.setAlignmentX(1000);;
	    statusLabel.setSize(100,100);*/
		boton = new JButton("ACEPTAR");
		String[] comboBoxItems = {"jajaj", "two", "three"};
		jComboBox1 = new JComboBox<>(comboBoxItems);
		this.add(jComboBox1, BorderLayout.NORTH);
		this.add(boton,BorderLayout.SOUTH);
		this.add(statusLabel,BorderLayout.EAST);
		
		

		this.setLayout(new FlowLayout());
		
	}
	
	/**
	 * @return the boton
	 */
	public JButton getBoton() {
		return boton;
	}

	/**
	 * @param boton the boton to set
	 */
	public void setBoton(JButton boton) {
		this.boton = boton;
	}
}
