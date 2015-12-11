import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class UI {

	public static void main(String[] args) {
		
		motor();

	}
	
	private static void motor(){
		
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				
				JFrame ventanaPrincipal = new Ventana();
				ventanaPrincipal.setVisible(true);
				
			}
		});
	}

}
