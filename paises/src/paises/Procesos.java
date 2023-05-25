package paises;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class Procesos {
	public void iniciar() {
		String menu="GESTION ESTUDIANTES\n";
		menu+="1. Registrar pais\n";
		menu+="2. Registrar ciudades\n";
		menu+="3. consultar ciudades por pais\n";
		menu+="4. consultar ciudad\n";
		menu+="5. Salir\n";
		menu+="Ingrese una opcion:\n";

		int opc=0;
		do {
			opc=Integer.parseInt(JOptionPane.showInputDialog(menu));
			
			validarMenu(opc);
			
		} while (opc!=10);
	}
	HashMap<String, ArrayList> cAndC = new HashMap<String, ArrayList>();
	
	public void validarMenu(int opc) {
		
		switch (opc) {
		case 1:
			 añadirPais();
			 break;
		case 2:
			añadirCiudad();
		 	break;
		case 3:
			consultarCiudadesPorPais();
		 	break;
		case 4:
			consultarCiudad();
			break;
		case 5:
			System.out.println("Chao!");
			break;
		
		default:
			System.out.println("Ingrese una opcion valida");
			break;
		}
	
	}
	public void añadirPais() {
		String pais = JOptionPane.showInputDialog("Ingrese el nombre del pais");
		ArrayList<String> ciudad = new ArrayList<String>();
		cAndC.put(pais, ciudad);
		System.out.println(cAndC);
	}
	
	public void añadirCiudad() {
		int valid;
		String pais = JOptionPane.showInputDialog("Ingrese el pais donde desea registrar la ciudad");
		if(cAndC.containsKey(pais)) {
			String ciudad = JOptionPane.showInputDialog("Ingrese el nombre de la ciudad");
			cAndC.get(pais).add(ciudad);
			
		}else {
			JOptionPane.showMessageDialog(null, "El pais no se encuentra registrado");
			valid = JOptionPane.showConfirmDialog(null, "¿Desea registrar el pais?");
			if(valid == 0) {
				añadirPais();
			}else {
				añadirCiudad();
			}
		}
		System.out.println(cAndC);
		
	}
	
	public void consultarCiudadesPorPais(){
		int valid;
		String pais = JOptionPane.showInputDialog("Ingrese el pais donde desea consultar las ciudades");
		if(cAndC.containsKey(pais)) {
			System.out.println("Ciudades de "+ pais + ":");
			 for (int i = 0; i < cAndC.get(pais).size(); i++) {
				System.out.println(cAndC.get(pais).get(i));
			}
		}else {
			JOptionPane.showMessageDialog(null, "El pais no se encuentra registrado");
			valid = JOptionPane.showConfirmDialog(null, "¿Desea registrar el pais?");
			if(valid == 0) {
				añadirPais();
			}else {
				añadirCiudad();
			}
		}
	}
	
	public void consultarCiudad() {
	    String ciudad = JOptionPane.showInputDialog("Ingrese el nombre de la ciudad que desea consultar");
	    boolean encontrado = false;
	    for (String pais : cAndC.keySet()) {
	        if (cAndC.get(pais).contains(ciudad)) {
	            System.out.println(ciudad + " pertenece a " + pais);
	            encontrado = true;
	        }
	    }
	    if (!encontrado) {
	        System.out.println(ciudad + " no se encuentra registrada en ningún país");
	    }
	}
}
