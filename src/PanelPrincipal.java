import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class PanelPrincipal extends JPanel{
	
	private PanelRegistrarMontador registrarMontador;
	muestra a;
	
	public PanelPrincipal(){
		
		registrarMontador = new PanelRegistrarMontador();
		a = new muestra();
		
		this.add(registrarMontador);
		this.add(a);
		a.setVisible(false);
		this.setMaximumSize(getMaximumSize());
		
		registrarMontador.getBoton().addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				
				registrarMontador.setVisible(false);
				
				a.setVisible(true);
				
			}
		});
	}
}
