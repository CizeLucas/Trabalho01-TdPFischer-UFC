
public class Main {

	public static void main(String[] args) {
		
		
		
		Plano t = new Plano(7);
		
		RoboAndador roboAndador = new RoboAndador(1 ,"Andador", t, 0, 0);
		
		t.imprimirTabuleiro();
		
		roboAndador.avancar(5);	
		System.out.println();
		t.imprimirTabuleiro();
//		
//		System.out.println();
//		roboAndador.avancar(1);	
//		System.out.println();
//		t.imprimirTabuleiro();
//		
//		roboAndador.avancar(1);	
//		System.out.println();
//		t.imprimirTabuleiro();
//		
//		roboAndador.avancar(1);	
//		System.out.println();
//		t.imprimirTabuleiro();
//		
//		roboAndador.avancar(5);	
//		System.out.println();
//		t.imprimirTabuleiro();
//		
		System.out.println(roboAndador.getCoord()[0] + " " + roboAndador.getCoord()[1]);
	}

}
