import java.util.ArrayList;

public class Celulas {

	private int x;
	private int y;
	private int id;
	private ArrayList<RobosAbstract> robos;
	private boolean temAluno;
	private boolean temBug;
	private boolean roboVisitou;
	
	public Celulas(int id, int x, int y) {
		robos = new ArrayList<RobosAbstract>();
		this.x = x;
		this.y = y;
		this.id = id;
		temAluno = false;
		temBug = false;
		roboVisitou = false;
	}

	public String imprimir() {
		if(roboVisitou) {
			if(temAluno) {
				return "!"; //robo visitou e tem um ALUNO
			}else if(temBug) {
				return "&"; //robo visitou e tem um BUG
			}else {
				return "@"; //robo visitou
			}
		}
			return "*"; //caso o robo nao tenha visitado a celula
	}
	
	public RobosAbstract getRobo() {
		return robos.get(robos.size()-1); //retorna o ultimo robo que entrou na celula
	}
	
	public void addRobo(RobosAbstract robo) {
		robos.add(robo);
	}
	
	public void removerRobo(RobosAbstract robo) {
		robos.remove(robo);
	}
	
	public void addAluno() {
		temAluno = true;
		temBug = false;
		// fazendo isso para asegurar que não vai ter aluno e bug na mesma celula
	}
	
	public void addBug() {
		temBug = true;
		temAluno = false;
		// fazendo isso para asegurar que não vai ter aluno e bug na mesma celula
	}
	
	public boolean temRobo() {
		return (!robos.isEmpty());
	}
	
	public boolean temAluno() {
		return temAluno;
	}

	public boolean temBug() {
		return temBug;
	}

	public boolean roboVisitou() {
		return roboVisitou;
	}
	
	public void setRoboVisitou(boolean estado) {
		roboVisitou = estado;
	}
	
	public void setTrueRoboVisitou() {
		roboVisitou=true;
	}
	
	public int[] getCoords() {
		int[] coords = {x,y};
		return coords;
	}
	
}
