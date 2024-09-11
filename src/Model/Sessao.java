package Model;
public class Sessao {
    private String filme;
    private double preco;
    private String salaFilme;
    private int horarioFilme;

    public String getFilme() {
        return filme;
    }

    public void setFilme(String filme) {
        this.filme = filme;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getSalaFilme() {
        return salaFilme;
    }

    public void setSalaFilme(String salaFilme) {
        this.salaFilme = salaFilme;
    }

    public int getHorarioFilme() {
        return horarioFilme;
    }

    public void setHorarioFilme(int horarioFilme) {
        this.horarioFilme = horarioFilme;
    }
}
