
public class Main {

	public static void main(String[] args) {

		Plano t = new Plano(9);
		
		RoboAndador roboAndador = new RoboAndador(1 ,"Andador", 'A',  t, 0, 0);
		RoboPeao roboPeao = new RoboPeao(2, "Peao", 'P', t, 0, 0);
		RoboTorre roboTorre = new RoboTorre(3, "Torre", 'T', t, 0, 0);
		
		t.imprimirTabuleiro();
		
		roboTorre.avancar(1);
		roboPeao.avancar();
		roboPeao.avancar();
		roboPeao.avancar();
		roboAndador.avancar(2);	
		roboAndador.avancar(2);	
		roboAndador.avancar(1);	
		System.out.println("\n");
		t.imprimirTabuleiro();
	
		roboTorre.retroceder(1);
		roboPeao.avancar();
		roboPeao.avancar();
		roboPeao.avancar();
		roboPeao.avancar();
		roboPeao.avancar();
		roboAndador.avancar(2);	
		roboAndador.avancar(5);	
		System.out.println("\n");
		t.imprimirTabuleiro();
		
		roboTorre.avancar(2);
		roboTorre.avancar(1);
		roboPeao.avancar();
		System.out.println("\n");
		t.imprimirTabuleiro();
		
		roboPeao.retroceder();
		roboTorre.retroceder(1);
		roboAndador.retroceder(1);
		System.out.println("\n");
		t.imprimirTabuleiro();
		
		System.out.println(roboAndador.stringPontuacao());
		System.out.println(roboPeao.stringPontuacao());
		System.out.println(roboTorre.stringPontuacao());
		
//		int[] coords = {-1,0};
//		coords = t.retornarCoordValida(coords);
//		System.out.println(coords[0] +" "+ coords[1]);
		
		//System.out.println(roboAndador.getCoord()[0] + " " + roboAndador.getCoord()[1]);
	}

}
