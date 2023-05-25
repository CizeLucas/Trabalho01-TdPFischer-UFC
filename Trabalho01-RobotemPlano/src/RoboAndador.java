
public class RoboAndador extends RobosAbstract implements RobosInterface {

	public RoboAndador(int id, String nome, Plano plano, int posXInicial, int posYInicial) {
		super(id, nome, plano, posXInicial, posYInicial);
		apelidoNoPlano = 'A';
	}
	
	public void avancar(int qtd) {
		int coordTemp[] = this.movimentarRobo(coord, 0, qtd);
		if(!coord.equals(coordTemp)) {
			this.checarAlunoOuBugNaCelula(coord);
			//System.out.println("robo se moveu");
		}
		coord[0] = coordTemp[0];
		coord[1] = coordTemp[1];
	}
	
	public void retroceder(int qtd) {
		int coordTemp[] = this.movimentarRobo(coord, 0, (-1)*qtd);
		if(!coord.equals(coordTemp)) {
			this.checarAlunoOuBugNaCelula(coord);
			//System.out.println("robo se moveu");
		}
		coord[0] = coordTemp[0];
		coord[1] = coordTemp[1];
	}
	
}
