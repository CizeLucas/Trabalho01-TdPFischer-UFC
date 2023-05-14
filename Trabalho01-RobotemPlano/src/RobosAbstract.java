
public abstract class RobosAbstract {
	
	public int id;
	public String nome;
	public int coord[];
	public char apelidoNoPlano;
	public int pontuacao;
	public Plano plano;
	
	public RobosAbstract(int id, String nome, Plano plano, int posXInicial, int posYInicial) {
		this.nome = nome;
		this.plano = plano;
		coord = new int[2];
		coord[0] = posXInicial;
		coord[1] = posYInicial;
		pontuacao = 0;
		plano.inicializarRobo(posXInicial, posYInicial, this);
	}
	
	public int[] movimentarRobo(int coordInicial[], int incrementoEmX, int incrementoEmY) {
		int coordFinal[] = new int[2];
		coordFinal[0]=coordInicial[0] + incrementoEmX;
		coordFinal[1]=coordInicial[1] + incrementoEmY;
		if(plano.coordExiste(coordFinal)) {
			plano.moverRobo(coordInicial, coordFinal, this);
			return coordFinal; 
			//se a nova coordenada existir, o robo vai ocupa ela e o metodo retorna a nova coordenada do robo
		}
		
		return coordInicial;
		//se a nova coordenada nao existir, o metodo apenas retorna a coordenada atual dele
	}
	
	public void checarAlunoOuBug(int coord[]) {
		if(plano.celulaTemAluno(coord))
			this.atualizarPontuacao(10, true);
		
		if(plano.celulaTemBug(coord))
			this.atualizarPontuacao(15, false);
	}
	
	
	public void atualizarPontuacao(int qtd, boolean ganhou) {
		if(ganhou)
			pontuacao+=qtd;
		else
			pontuacao-=qtd;
	}
	
	public int[] getCoord() {
		return coord;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public String getNome() {
		return nome;
	}
	
	
}