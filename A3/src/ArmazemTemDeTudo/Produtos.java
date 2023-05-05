package ArmazemTemDeTudo;


public class Produtos extends MarcaGarantia {
	
	//Cria��o de atributos
	private int id;
	private String nome;
	private static final float frete = (float) 20.00; //Constante criada para que o valor do frete seja fixo
	private int qtdEmEstoque;
	private double Preco;
	
	
	
	//Construtor pad�o
	public Produtos() {
		
	}
	
	//Construtor passando os par�metros
	public Produtos(int id, String nome, int qtdEmEstoque, double preco, String marca, String garantia) {
		setMarca(marca);
		setGarantia(garantia);
		this.id = id;
		this.nome = nome; 
		this.qtdEmEstoque = qtdEmEstoque;
		this.Preco = preco;
	}


	//M�tdos para manipular variav�s privadas
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getQtdEmEstoque() {
		return qtdEmEstoque;
	}

	public void setQtdEmEstoque(int qtdEmEstoque) {
		this.qtdEmEstoque = qtdEmEstoque;
	}

	public double getPreco() {
		return Preco;
	}

	public void setPreco(double preco) {
		Preco = preco;
	}

	public float getFrete() {
		return frete;
	}
	
	

//Formata��o de objeto
	public String toString() {
		return "Produtos [id = " + id + ", nome = " + nome + ", frete = " + frete + ", qtdEmEstoque = " + qtdEmEstoque
				+ ", Preco = " + Preco + ", Marca = " + getMarca() + ", Garantia = " + getGarantia() + "]";
	}
}