public class RoboRei extends RobosAbstract{

	public RoboRei(String nome, char apelidoNoPlano, Plano plano, int posXInicial, int posYInicial) {
		super(nome, apelidoNoPlano, plano, posXInicial, posYInicial);
		formaDeMovimento = "diagonais";
		qtdMaxDeCasasPorMov="4";
	}

	public int avancar(int qtd) {
		if(qtd>Integer.parseInt(qtdMaxDeCasasPorMov))
			qtd=Integer.parseInt(qtdMaxDeCasasPorMov);
			
		int coordTemp[] = this.movimentarRobo(coordRobo, qtd, (-1)*qtd);
		coordRobo[0] = coordTemp[0];
		coordRobo[1] = coordTemp[1];
		
		return qtd;
	}

	
	public int retroceder(int qtd) {
		if(qtd>Integer.parseInt(qtdMaxDeCasasPorMov))
			qtd=Integer.parseInt(qtdMaxDeCasasPorMov);
		
		int coordTemp[] = this.movimentarRobo(coordRobo, (-1)*qtd, qtd);
		coordRobo[0] = coordTemp[0];
		coordRobo[1] = coordTemp[1];
		
		return qtd;
	}

}
