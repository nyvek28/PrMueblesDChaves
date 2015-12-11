import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Ventana extends JFrame {
	
	private PanelPrincipal panel;
	
	public Ventana(){
		
		super("Ventana");
		setLayout(new BorderLayout());
		panel = new PanelPrincipal();
		this.add(panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,450); 
		this.setLocationRelativeTo(null);
		
		
		
		
		/*registrarMontador.setVisible(true);
		a.setVisible(false);*/
		/*JButton button = new JButton("Do it!");
        c.add(button, BorderLayout.SOUTH);
        JPanel panel = new JPanel(new BorderLayout());
        String[] comboBoxItems2 = {"one", "two", "three"};
        JComboBox<String> jComboBox2 = new JComboBox<>(comboBoxItems2);
        panel.add(jComboBox2, BorderLayout.NORTH);
        JButton button2 = new JButton("jajaja!");
        panel.add(button2, BorderLayout.SOUTH);
        this.getContentPane().add(panel);
        panel.setVisible(false);*/
		
		
	}
}
