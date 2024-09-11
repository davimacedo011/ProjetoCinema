package Model.beans;

public class IngressoBean {
    private static int quantidadeComum;
    private static int quantidadeMeia;
    private static int quantidadeVip;

    private static double precoComum = 50.0;
    private static double precoMeia = 25.0;
    private static double precoVip = 75.0;

    public int getQuantidadeComum() {
        return quantidadeComum;
    }

    public void setQuantidadeComum(int quantidadeComum) {
        this.quantidadeComum = quantidadeComum;
    }

    public int getQuantidadeMeia() {
        return quantidadeMeia;
    }

    public void setQuantidadeMeia(int quantidadeMeia) {
        this.quantidadeMeia = quantidadeMeia;
    }

    public int getQuantidadeVip() {
        return quantidadeVip;
    }

    public void setQuantidadeVip(int quantidadeVip) {
        this.quantidadeVip = quantidadeVip;
    }

    public static double calcularValorTotal() {
        return (quantidadeComum * precoComum) + (quantidadeMeia * precoMeia) + (quantidadeVip * precoVip);
    }
}
