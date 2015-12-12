import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class UI {

	public static void main(String[] args) {
		
		motor();

	}
	
	private static void motor(){
		
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				
				JFrame ventanaPrincipal;
				try {
					ventanaPrincipal = new Ventana();
				} catch (Exception e) {
					ventanaPrincipal = null;
					e.printStackTrace();
				}
				if(ventanaPrincipal != null){
					ventanaPrincipal.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null, "Error al inicializar");
				}
				
			}
		});
	}

}
