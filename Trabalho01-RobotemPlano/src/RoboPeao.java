

public class RoboPeao extends RobosAbstract{

	public RoboPeao(String nome, char apelidoNoPlano, Plano plano, int posXInicial, int posYInicial) {
		super(nome, apelidoNoPlano, plano, posXInicial, posYInicial);
		formaDeMovimento = "vertical";
		qtdMaxDeCasasPorMov = "1";
	}

	
	public int avancar(int qtd) {
		int coordTemp[] = this.movimentarRobo(coordRobo, 1, 0);
		coordRobo[0] = coordTemp[0];
		coordRobo[1] = coordTemp[1];
		
		return qtd;
	}

	public int retroceder(int qtd) {
		int coordTemp[] = this.movimentarRobo(coordRobo, -1, 0);
		coordRobo[0] = coordTemp[0];
		coordRobo[1] = coordTemp[1];
		
		return qtd;
	}

	public String interfaceUsuario(boolean selecMovimento, int qtd) {
		if(selecMovimento) {
			avancar(qtd);
			return ("O "+this.toString()+" vai avancar 1 casa\n");
		} else {
			retroceder(qtd);
			return ("O "+this.toString()+" vai retroceder 1 casa\n");
		}
	}
}
