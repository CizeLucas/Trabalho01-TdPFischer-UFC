
public class Main {

	public static void main(String[] args) {
		
		
		
		Plano t = new Plano(9);
		
		RoboAndador roboAndador = new RoboAndador(1 ,"Andador", t, 0, 0);
		RoboPeao roboPeao = new RoboPeao(2, "Peao", t, 0, 0);
		
		t.imprimirTabuleiro();
		
		roboPeao.avancar();
		roboPeao.avancar();
		roboPeao.avancar();
		roboAndador.avancar(2);	
		roboAndador.avancar(2);	
		roboAndador.avancar(1);	
		System.out.println("\n");
		t.imprimirTabuleiro();
		
		roboPeao.avancar();
		roboPeao.avancar();
		roboPeao.avancar();
		roboPeao.avancar();
		roboPeao.avancar();
		roboAndador.avancar(2);	
		System.out.println("\n");
		t.imprimirTabuleiro();
		
		System.out.println(roboPeao.stringPontuacao());
		System.out.println(roboAndador.stringPontuacao());
		
		//System.out.println(roboAndador.getCoord()[0] + " " + roboAndador.getCoord()[1]);
	}

}
