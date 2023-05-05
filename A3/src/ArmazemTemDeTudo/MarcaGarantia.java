package ArmazemTemDeTudo;

public class MarcaGarantia {
	//criação de atributos
	private String Marca;
	private String Garantia;
	
	//construtor padrão
	public MarcaGarantia() {
		
	}
	
	//construtor passando os parâmetros
	public MarcaGarantia(String marca, String garantia) {
		Marca = marca;
		Garantia = garantia;
	}

	public String getMarca() {
		return Marca;
	}

	public void setMarca(String marca) {
		Marca = marca;
	}

	public String getGarantia() {
		return Garantia;
	}

	public void setGarantia(String garantia) {
		Garantia = garantia;
	}
}