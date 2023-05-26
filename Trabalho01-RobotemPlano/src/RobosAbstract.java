
public abstract class RobosAbstract {
	
	public int id;
	public String nome;
	public int coordRobo[];
	public char apelidoNoPlano;
	public int pontuacao;
	public Plano plano;
	
	public RobosAbstract(int id, String nome, char apelidoNoPlano, Plano plano, int posXInicial, int posYInicial) {
		this.id = id;
		this.nome = nome;
		this.apelidoNoPlano = apelidoNoPlano;
		this.plano = plano;
		coordRobo = new int[2];
		coordRobo[0] = posXInicial;
		coordRobo[1] = posYInicial;
		pontuacao = 0;
		plano.inicializarRobo(posXInicial, posYInicial, this);
	}
	
	public int[] movimentarRobo(int coordInicial[], int incrementoEmX, int incrementoEmY) {
		int coordFinal[] = new int[2];
		coordFinal[0]=coordInicial[0] + incrementoEmX;
		coordFinal[1]=coordInicial[1] + incrementoEmY;
		coordFinal = plano.retornarCoordValida(coordFinal);
		//a atribuicao acima assegura que a coordenada inserida esta sempre nos limites do plano,
		//e caso nao esteja, corrige a coordenada para o maximo ou minimo valor possivel.
			plano.moverRobo(coordInicial, coordFinal, this);
			return coordFinal;
	}
	
	/* >>>> VERSAO ANTIGA DO METODO MOVIMENTARROBO <<<<
		public int[] movimentarRobo(int coordInicial[], int incrementoEmX, int incrementoEmY) {
		int coordFinal[] = new int[2];
		coordFinal[0]=coordInicial[0] + incrementoEmX;
		coordFinal[1]=coordInicial[1] + incrementoEmY;
		if(plano.coordExiste(coordFinal)) {
			plano.moverRobo(coordInicial, coordFinal, this); //(1)
			return coordFinal; //(2)
			//se a nova coordenada existir, (1) o robo vai ocupar ela e o (2) metodo retorna a nova coordenada do robo
		}
		
		return coordInicial;
		//se a nova coordenada nao existir, o metodo apenas retorna a coordenada atual dele
	}
	  */
	
	public void checarAlunoOuBugNaCelula(int coord[]) {
		if(plano.celulaTemAluno(coord))
			this.atualizarPontuacao(10, true);
		
		if(plano.celulaTemBug(coord))
			this.atualizarPontuacao(15, false);
		
		plano.roboVisitouCelula(coord);
	}
	
	
	private void atualizarPontuacao(int qtd, boolean ganhou) {
		if(ganhou)
			pontuacao+=qtd;
		else
			pontuacao-=qtd;
	}
	
	public int[] getCoord() {
		return coordRobo;
	}

	public int getPontuacao() {
		return pontuacao;
	}
	
	public String stringPontuacao() {
		return "O Robo "+nome+" ("+apelidoNoPlano+") tem "+pontuacao+" pontos.";
	}

	public String getNome() {
		return nome;
	}
	
	
}
