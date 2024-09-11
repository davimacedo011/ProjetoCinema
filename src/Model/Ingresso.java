 package Model;
 
public abstract class Ingresso {

 
  private double preco;
  private int quantidadeDisponivel;

  public Ingresso(double preco, int quantidadeDisponivel) {

    this.preco = preco;
    this.quantidadeDisponivel = quantidadeDisponivel;
  }

  public double getPreco() {
    return preco;
  }

  public void setPreco(double preco) {
    this.preco = preco;
  }

  public abstract String Beneficios();

  public abstract String tipoIngresso();
   
  
  public int getquantidadeDisponivel() {
    return quantidadeDisponivel;
  }

  public void setquantidadeDisponivel(int quantidadeDisponivel) {
    this.quantidadeDisponivel = quantidadeDisponivel;
  }
}