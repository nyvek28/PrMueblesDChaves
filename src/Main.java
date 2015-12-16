import java.util.ArrayList;
import java.util.TreeMap;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) throws Exception {

		(new Gestor()).inicializarPrograma();
		TreeMap datos;
		ArrayList<Integer> ids = new ArrayList<Integer>();
		for(int i = 6; i <= 9; i++){
			ids.add(i);
		}
		
		menu();
		
//		datos = (new Gestor()).venderJuego(1, 26, 9);
//		if(datos != null){
//			System.out.println(datos.get("idJuego"));
//			System.out.println(datos.get("cliente"));
//			System.out.println(datos.get("distribuidor"));
//			System.out.println(datos.get("monto"));
//		}else{
//			System.out.println("Error");
//		}
		
		
		//System.out.println((new MultiDistribuidor()).buscar(1).calcularCostoJuego((new MultiJuego()).buscarid(Integer.parseInt((String) datos.get("id")))));
		
//		datos = (new Gestor()).registrarMueble(1, "Blanco", 23, 12, 45, 1, 32900, 12);
//		System.out.println(datos.get("id"));
//		datos = (new Gestor()).registrarMueble(1, "Verde", 56, 76, 123, 2, 100500, 1, 12);
//		System.out.println(datos.get("id"));
		
		
	}
	
	// inicia metodo que se encarga de desplegar el menu

    public static void menu(){

    	String menu = "MENU \n 1.  Armar juego. \n 2.  Realizar venta. \n";
    	int opcion = 0;  	

        // evaluamos si hay error

        try{

            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));

        }catch(NumberFormatException ex){

            ingresarNumero();
            menu();
        }

    	// se le envia la opcion ingresada al switch  del menu

    	switchMenu(opcion);
    	menu();

    }

    // inicia metodo que se encarga de procesar la opcion ingresada por el usuario

    public static void switchMenu(int opcion){


    	switch(opcion){

    		case 1:


    			armarJuego();
    			break;

    		case 2:

    			// se valida si esta en ejecucion el juego o no;

    			realizarVenta();
    			break;


    		default:

    			incorrecto();
    			break;

    	}
    }
    
    public static void armarJuego(){
    	
    	ArrayList<TreeMap<String,String>> lista = null;
    	try {
			lista = ((new Gestor()).listarMontadores());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	obtenerMontador(lista);
    }
    
    public static void obtenerMontador(ArrayList<TreeMap<String,String>> lista){
    	
    	
    }
    
    public void realizarJuego(){
    	
    	
    }
    
 // inicia metodo que imprime error de tipo de dato ingresado

    public static void ingresarNumero(){

        JOptionPane.showMessageDialog(null, "Por favor ingrese unicamente numeros");
    }

    // inicia metodo que imprime opcion incorrecta

    public static void incorrecto(){

        JOptionPane.showMessageDialog(null, "Opcion incorrecta");

    }

}
