 package Model;
public class IngressoNormal extends Ingresso {
  private String beneficios;
  public IngressoNormal(String tipo, double preco, int quantidadeDisponivel, String beneficios) {
      super(preco, quantidadeDisponivel);
    this.beneficios = beneficios;
  }
  @Override
    public String Beneficios() {
        return "Sem benefícios";
    }
  //preco cheio do ingresso
  public double calcularPreco() {
      return getPreco();
  }
  @Override
  public String tipoIngresso() {
      return "Ingresso Normal";
  }
}