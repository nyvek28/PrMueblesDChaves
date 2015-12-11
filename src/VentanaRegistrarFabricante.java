import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.TreeMap;
import java.awt.event.ActionEvent;

public class VentanaRegistrarFabricante extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldTelefono;
	private JTextField textFieldDireccion;
	private JTextField textFieldLinea;
	private JTextField textFieldAnnos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistrarFabricante frame = new VentanaRegistrarFabricante();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaRegistrarFabricante() {
		setTitle("Registrar Fabricante");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(41, 44, 61, 16);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(41, 72, 61, 16);
		contentPane.add(lblApellido);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(41, 100, 61, 16);
		contentPane.add(lblTelefono);
		
		JLabel lblLinea = new JLabel("Linea:");
		lblLinea.setBounds(41, 128, 61, 16);
		contentPane.add(lblLinea);
		
		JLabel lblAnnos = new JLabel("Annos Exp:");
		lblAnnos.setBounds(41, 156, 84, 16);
		contentPane.add(lblAnnos);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(41, 184, 84, 16);
		contentPane.add(lblDireccion);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(137, 38, 134, 28);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(137, 66, 134, 28);
		contentPane.add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setBounds(137, 94, 134, 28);
		contentPane.add(textFieldTelefono);
		textFieldTelefono.setColumns(10);
		
		textFieldLinea = new JTextField();
		textFieldLinea.setBounds(137, 122, 134, 28);
		contentPane.add(textFieldLinea);
		textFieldLinea.setColumns(10);
		
		textFieldAnnos = new JTextField();
		textFieldAnnos.setBounds(137, 150, 134, 28);
		contentPane.add(textFieldAnnos);
		textFieldAnnos.setColumns(10);
		
		textFieldDireccion = new JTextField();
		textFieldDireccion.setBounds(137, 178, 252, 89);
		contentPane.add(textFieldDireccion);
		textFieldDireccion.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TreeMap info;
				String msj;
				
				info = (new Gestor()).registrarFabricante(textFieldNombre.getText(),
						textFieldApellido.getText(),
						Integer.parseInt(textFieldTelefono.getText()), 
						textFieldDireccion.getText(), 
						Integer.parseInt(textFieldLinea.getText()), 
						Integer.parseInt(textFieldAnnos.getText())
						);
				if(info != null){
					msj = "Se registro el fabricante de Id " + info.get("id") + " correctamente";
				}else{
					msj = "No se logro registrar al fabricante!";
				}
				
				JOptionPane.showMessageDialog(null, msj);
				frame.setVisible(false);
				
			}
		});
		btnAceptar.setBounds(344, 364, 117, 29);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				
			}
			
		});
		btnCancelar.setBounds(215, 364, 117, 29);
		contentPane.add(btnCancelar);
	}
}
