import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class UI {

	public static void main(String[] args) {
		
		motor();

	}
	
	private static void motor(){
		
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				
				JFrame guiFrame = new JFrame("hello world");
				guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
				guiFrame.setTitle("Example GUI"); 
				guiFrame.setSize(300,250); 
				guiFrame.setLocationRelativeTo(null);
				guiFrame.setVisible(true);
				
			}
		});
	}

}
