import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class muestra extends JPanel {
	
	private JButton boton;

	public muestra(){
		
		boton = new JButton("ACEPTAR");
		
		String[] comboBoxItems = {"jwjejeje", "two", "three"};
		JComboBox<String> jComboBox1 = new JComboBox<>(comboBoxItems);
		this.add(jComboBox1, BorderLayout.NORTH);
		add(boton,BorderLayout.PAGE_END);
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
