
public class RoboTorre extends RobosAbstract implements RobosInterface{

	public RoboTorre(int id, String nome, char apelidoNoPlano, Plano plano, int posXInicial, int posYInicial) {
		super(id, nome, apelidoNoPlano, plano, posXInicial, posYInicial);
		//apelidoNoPlano = 'T';
	}

	
	public void avancar(int qtd) {
		if(qtd>2)
			qtd=2;
		int coordTemp[] = this.movimentarRobo(coordRobo, 0, qtd);
		if(!coordRobo.equals(coordTemp)) {
			this.checarAlunoOuBugNaCelula(coordRobo);
		}
		coordRobo[0] = coordTemp[0];
		coordRobo[1] = coordTemp[1];
	}

	
	public void retroceder(int qtd) {
		if(qtd>2)
			qtd=2;
		int coordTemp[] = this.movimentarRobo(coordRobo, 0, (-1)*qtd);
		if(!coordRobo.equals(coordTemp)) {
			this.checarAlunoOuBugNaCelula(coordRobo);
		}
		coordRobo[0] = coordTemp[0];
		coordRobo[1] = coordTemp[1];
	}

}
