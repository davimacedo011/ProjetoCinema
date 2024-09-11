 package Model;
public class IngressoVip extends Ingresso {
    private String beneficios;

    public IngressoVip(String tipo, double preco, int quantidadeDisponivel, String beneficios) {   
   super(preco, quantidadeDisponivel);
   this.beneficios = beneficios;
    }

  @Override
    public String Beneficios() {
        return "Cadeira VIP";
    }
  //Acrecimo de 50% no ingresso VIP
  public double calcularPreco() {
      return getPreco() + (getPreco() * 0.5);
  }
    @Override
    public String tipoIngresso() {
        return "Ingresso VIP";
    }
}