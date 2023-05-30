

public class RoboTorre extends RobosAbstract{

	public RoboTorre(String nome, char apelidoNoPlano, Plano plano, int posXInicial, int posYInicial) {
		super(nome, apelidoNoPlano, plano, posXInicial, posYInicial);
		formaDeMovimento = "vertical";
		qtdMaxDeCasasPorMov="2";
	}

	
	public int avancar(int qtd) {
		if(qtd>Integer.parseInt(qtdMaxDeCasasPorMov))
			qtd=Integer.parseInt(qtdMaxDeCasasPorMov);
		int coordTemp[] = this.movimentarRobo(coordRobo, 0, (-1)*qtd);
		coordRobo[0] = coordTemp[0];
		coordRobo[1] = coordTemp[1];
		return qtd;
	}

	
	public int retroceder(int qtd) {
		if(qtd>Integer.parseInt(qtdMaxDeCasasPorMov))
			qtd=Integer.parseInt(qtdMaxDeCasasPorMov);
		int coordTemp[] = this.movimentarRobo(coordRobo, 0, qtd);
		coordRobo[0] = coordTemp[0];
		coordRobo[1] = coordTemp[1];
		return qtd;
	}

}
