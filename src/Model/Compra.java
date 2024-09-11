package Model;

import java.util.List;

public class Compra {
    private int idPagamento;
    private String filme;
    private List<String> Assento;
    private double valorTotal;
    private int quantidadeIngressos;

    public Compra(String filme, double valorTotal, List<String> Assento, int quantidadeIngressos) {
        this.idPagamento = idPagamento;
        this.filme = filme;
        this.valorTotal = valorTotal;
        this.Assento = Assento;
        this.quantidadeIngressos = quantidadeIngressos;
    }

    public int getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(int idPagamento) {
        this.idPagamento = idPagamento;
    }

    public String getFilme() {
        return filme;
    }

    public void setFilme(String filme) {
        this.filme = filme;
    }

    public List<String> getAssento() {
        return Assento;
    }

    public void setAssento(List<String> Assento) {
        this.Assento = Assento;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getQuantidadeIngressos() {
        return quantidadeIngressos;
    }

    public void setQuantidadeIngressos(int quantidadeIngressos) {
        this.quantidadeIngressos = quantidadeIngressos;
    }

	public void setTipoIngresso(String string) {
		
		
	}

	public Object getTipoIngresso() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
