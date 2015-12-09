import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class UIRegistrarMontador extends JFrame {
	
	public UIRegistrarMontador(){
		
		super("Registrar Montador");
		setLayout(new BorderLayout());
		JTextArea campoTexto = new JTextArea();
		JButton boton = new JButton("ACEPTAR");
		Container c = getContentPane();
		c.add(campoTexto,BorderLayout.CENTER);
		c.add(boton,BorderLayout.SOUTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setTitle("Registrar Montador"); 
		this.setSize(500,450); 
		this.setLocationRelativeTo(null);

		boton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				
				campoTexto.append("hi!!");
			}
		});
	}
}
