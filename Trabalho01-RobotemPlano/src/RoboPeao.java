
public class RoboPeao extends RobosAbstract{

	public RoboPeao(int id, String nome, char apelidoNoPlano, Plano plano, int posXInicial, int posYInicial) {
		super(id, nome, apelidoNoPlano, plano, posXInicial, posYInicial);
		//apelidoNoPlano = 'P';
	}

	
	public void avancar() {
		int coordTemp[] = this.movimentarRobo(coordRobo, 1, 0);
		if(!coordRobo.equals(coordTemp)) {
			this.checarAlunoOuBugNaCelula(coordRobo);
			
			//System.out.println("robo se moveu");
		}
		coordRobo[0] = coordTemp[0];
		coordRobo[1] = coordTemp[1];
		
	}

	public void retroceder() {
		int coordTemp[] = this.movimentarRobo(coordRobo, -1, 0);
		if(!coordRobo.equals(coordTemp)) {
			this.checarAlunoOuBugNaCelula(coordRobo);
			//System.out.println("robo se moveu");
		}
		coordRobo[0] = coordTemp[0];
		coordRobo[1] = coordTemp[1];
	}

}
