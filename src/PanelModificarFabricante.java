import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelModificarFabricante extends JPanel {

	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldTelefono;
	private JTextField textFieldDireccion;
	private JTextField textFieldLinea;
	private JTextField textFieldAnnos;
	private JComboBox comboBoxFabricantes;
	private ArrayList<TreeMap<String,String>> lista;
	
	public PanelModificarFabricante() throws Exception{
		
		this.setLayout(new GridBagLayout());
		
		(new Gestor()).inicializarPrograma();
		GridBagConstraints c = new GridBagConstraints();
		
		lista = (new Gestor()).listarFabricantes();
		
		comboBoxFabricantes = new JComboBox();
		c.gridy = 0;
		c.gridx = 1;
		for(int i = 0; i < lista.size(); i++){	
			comboBoxFabricantes.addItem(lista.get(i).get("nombre") + " " + lista.get(i).get("apellido"));	
		}
		comboBoxFabricantes.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				seleccionarFabricante();
			}
		});
		this.add(this.comboBoxFabricantes, c);
		JLabel lblNombre = new JLabel("Nombre:");
		c.gridy++;
		c.anchor = GridBagConstraints.LINE_END;
		this.add(lblNombre,c);
		
		JLabel lblApellido = new JLabel("Apellido:");
		c.gridy++;
		this.add(lblApellido,c);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		c.gridy++;
		this.add(lblTelefono,c);
		
		JLabel lblLinea = new JLabel("Linea:");
		c.gridy++;
		this.add(lblLinea,c);
		
		JLabel lblAnnos = new JLabel("Annos Exp:");
		c.gridy++;
		this.add(lblAnnos,c);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		c.gridy++;
		this.add(lblDireccion,c);
		
		textFieldNombre = new JTextField(8);
		c.gridy = 1;
		c.gridx = 2;
		c.anchor = GridBagConstraints.LINE_START;
		this.add(textFieldNombre,c);
		//textFieldNombre.setColumns(10);
		
		textFieldApellido = new JTextField(8);
		c.gridy++;
		this.add(textFieldApellido,c);
		//textFieldApellido.setColumns(10);
		
		textFieldTelefono = new JTextField(8);
		c.gridy++;
		this.add(textFieldTelefono,c);
		//textFieldTelefono.setColumns(10);
		
		textFieldLinea = new JTextField(8);
		c.gridy++;
		this.add(textFieldLinea,c);
		//textFieldLinea.setColumns(10);
		
		textFieldAnnos = new JTextField(8);
		c.gridy++;
		this.add(textFieldAnnos,c);
		//textFieldAnnos.setColumns(10);
		
		textFieldDireccion = new JTextField(15);
		c.gridy++;
		this.add(textFieldDireccion,c);
		//textFieldDireccion.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					botonAceptar();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		c.gridy = 8;
		c.gridx = 5;
		this.add(btnAceptar,c);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				botonCancelar();
				
			}
		});
		c.gridx = 4;
		this.add(btnCancelar,c);
		
		this.setVisible(false);
		
	}
	
	public void botonAceptar() throws NumberFormatException, SQLException, Exception{
		
		TreeMap info;
		String msj;
		
		info = (new Gestor()).modificarFabricante(Integer.parseInt(lista.get(this.comboBoxFabricantes.getSelectedIndex()).get("id")), 
						this.textFieldNombre.getText(), 
						this.textFieldApellido.getText(), 
						Integer.parseInt(this.textFieldTelefono.getText()), 
						this.textFieldDireccion.getText(), 
						Integer.parseInt(this.textFieldLinea.getText()), 
						Integer.parseInt(this.textFieldAnnos.getText())
						);
		if(info != null){
			msj = "Se modifico el fabricante de Id " + info.get("id") + " correctamente";
		}else{
			msj = "No se logro modificar al fabricante!";
		}
		
		JOptionPane.showMessageDialog(null, msj);
		this.setVisible(false);
		muestra p = new muestra();
		super.add(p);
		p.setVisible(true);
		
	}
	
	public void botonCancelar(){
		
		this.setVisible(false);
		
		
	}
	
	public void seleccionarFabricante(){
		
		int i;
		
		i = this.comboBoxFabricantes.getSelectedIndex();
		textFieldNombre.setText(lista.get(i).get("nombre"));
		textFieldApellido.setText(lista.get(i).get("apellido"));
		textFieldTelefono.setText(lista.get(i).get("telefono"));
		textFieldDireccion.setText(lista.get(i).get("direccion"));
		textFieldLinea.setText(lista.get(i).get("linea"));
		textFieldAnnos.setText(lista.get(i).get("annosExp"));
		
	}
	
	
}
