public class RoboAndador extends RobosAbstract{

	public RoboAndador(String nome, char apelidoNoPlano, Plano plano, int posXInicial, int posYInicial) {
		super(nome, apelidoNoPlano, plano, posXInicial, posYInicial);
		formaDeMovimento = "vertical";
		qtdMaxDeCasasPorMov = "quantidade livre";
	}
	
	public int avancar(int qtd) {
		int coordTemp[] = this.movimentarRobo(coordRobo, 0, (-1)*qtd);
		coordRobo[0] = coordTemp[0];
		coordRobo[1] = coordTemp[1];
		
		return qtd;
	}
	
	public int retroceder(int qtd) {
		int coordTemp[] = this.movimentarRobo(coordRobo, 0, qtd);
		coordRobo[0] = coordTemp[0];
		coordRobo[1] = coordTemp[1];
		
		return qtd;
	}

	
	
	
	
	
}
