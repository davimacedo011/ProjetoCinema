 package Model;

public class IngressoMeia extends Ingresso {
  private String beneficios;
  public IngressoMeia(String tipo, double preco, int quantidadeDisponivel, String beneficios) {
      super( preco, quantidadeDisponivel);
    this.beneficios = beneficios;
  }
  @Override
    public String Beneficios() {
        return "50% de desconto";
    }
  // 50% do valor 
  public double calcularPreco() {
      return getPreco() / 2;
  }
  @Override
  public String tipoIngresso() {
      return "Ingresso Meia";
  }
}