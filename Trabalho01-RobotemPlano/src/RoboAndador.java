
public class RoboAndador extends RobosAbstract implements RobosInterface {

	public RoboAndador(int id, String nome, char apelidoNoPlano, Plano plano, int posXInicial, int posYInicial) {
		super(id, nome, apelidoNoPlano, plano, posXInicial, posYInicial);
		//apelidoNoPlano = 'A';
	}
	
	public void avancar(int qtd) {
		int coordTemp[] = this.movimentarRobo(coordRobo, 0, qtd);
		if(!coordRobo.equals(coordTemp)) {
			this.checarAlunoOuBugNaCelula(coordRobo);
			//System.out.println("robo se moveu");
		}
		coordRobo[0] = coordTemp[0];
		coordRobo[1] = coordTemp[1];
	}
	
	public void retroceder(int qtd) {
		int coordTemp[] = this.movimentarRobo(coordRobo, 0, (-1)*qtd);
		if(!coordRobo.equals(coordTemp)) {
			this.checarAlunoOuBugNaCelula(coordRobo);
			//System.out.println("robo se moveu");
		}
		coordRobo[0] = coordTemp[0];
		coordRobo[1] = coordTemp[1];
	}
	
}
