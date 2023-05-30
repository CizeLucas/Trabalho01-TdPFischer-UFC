import java.util.ArrayList;

public abstract class RobosAbstract implements RobosInterface{
	
	private String nome;
	protected int coordRobo[];
	private char apelidoNoPlano;
	private int pontuacao;
	private Plano plano;
	protected String formaDeMovimento;
	protected String qtdMaxDeCasasPorMov;
	private int qtdAlunosColetados;
	private int qtdBugsColetados;
	private ArrayList<String> listaDeCoordenadas;
	
	public RobosAbstract(String nome, char apelidoNoPlano, Plano plano, int posXInicial, int posYInicial) {
		this.nome = nome;
		this.apelidoNoPlano = apelidoNoPlano;
		this.plano = plano;
		coordRobo = new int[2];
		coordRobo[0] = posXInicial;
		coordRobo[1] = posYInicial;
		pontuacao = 0;
		qtdAlunosColetados=0;
		qtdBugsColetados=0;
		plano.inicializarRobo(coordRobo, this);
		listaDeCoordenadas = new ArrayList<String>();
	} //fim construtor
	
	
	protected String descreverMovRobo() {
		return ("O "+this.toString()+" move-se na(s) "+this.formaDeMovimento+" em ate "+this.qtdMaxDeCasasPorMov+" casa(s).");
	}
	
	
	public String toString() {
		return "Robo "+nome+" ("+apelidoNoPlano+")";
	}
	
	
	protected int[] movimentarRobo(int coordInicial[], int incrementoEmX, int incrementoEmY) {
		int coordFinal[] = new int[2];
		coordFinal[0]=coordInicial[0] + incrementoEmX;
		coordFinal[1]=coordInicial[1] + incrementoEmY;
		coordFinal = plano.retornarCoordValida(coordFinal);
		//a atribuicao acima assegura que a coordenada inserida esta sempre nos limites do plano,
		//e caso nao esteja, corrige a coordenada para o maximo ou minimo valor possivel.
		
		if(coordInicial[0] == coordFinal[0] && coordInicial[1] == coordFinal[1]) { 
			return coordInicial;
		} else {
			plano.moverRobo(coordInicial, coordFinal, this);
			this.checarAlunoOuBugNaCelula(coordFinal);
			this.atualizarListaDeCoordenadas(coordFinal);
			return coordFinal;
		}
		//O if acima checa se houve mudanca nas coordenadas do robo (se houve movimento)
		// Caso haja movimento, o robo eh movido no plano, sua pontuacao eh aferida e retorna sua coordenada atual
		// Caso NAO haja movimento, apenas a coordenada incial eh retornada
	}
	
	
	protected void atualizarListaDeCoordenadas(int[] coord) {
		listaDeCoordenadas.add(String.format("["+coord[0]+", "+coord[1]+"], "));
	}
	
	
	protected ArrayList<String> getListaDeCoordenadas() {
		return listaDeCoordenadas;
	}
	
	
	protected void finalizarMovimentos() {
		plano.roboVisitouCelula(coordRobo);
	}
	
	
	private void checarAlunoOuBugNaCelula(int coord[]) {
		if(plano.celulaTemAluno(coord)) {
			this.atualizarPontuacao(10, true);
			qtdAlunosColetados++;
		}
		
		if(plano.celulaTemBug(coord)) {
			this.atualizarPontuacao(15, false);
			qtdBugsColetados++;
		}
	}
	
	
	public String interfaceUsuario(boolean selecMovimento, int qtd) {
		if(selecMovimento) {
			return ("O "+this.toString()+" vai avancar "+avancar(qtd)+" casa(s).\n");
		} else {
			return ("O "+this.toString()+" vai retroceder "+retroceder(qtd)+" casa(s).\n");
		}
	}
	
	protected char getApelidoNoPlano() {
		return apelidoNoPlano;
	}
	
	
	private void atualizarPontuacao(int qtd, boolean ganhou) {
		if(ganhou)
			pontuacao+=qtd;
		else
			pontuacao-=qtd;
	}
	
	
	protected int[] getCoord() {
		return coordRobo;
	}

	
	protected int getPontuacao() {
		return pontuacao;
	}
	
	
	protected String stringPontuacao() {
		return "O Robo "+nome+" ("+apelidoNoPlano+") tem "+pontuacao+" pontos.";
	}

	
	protected String getNome() {
		return nome;
	}
	
	
	protected int getQtdAlunosColetados() {
		return qtdAlunosColetados;
	}
	
	
	protected int getQtdBugsColetados() {
		return qtdBugsColetados;
	}
	
}
