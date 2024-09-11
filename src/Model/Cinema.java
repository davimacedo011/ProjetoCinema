 package Model;
import java.util.ArrayList;
public class Cinema {

    private String filme;
    private int ingressos;
  
    public String getFilme() {
        return filme;
    }    
    public void setFilme(String filme){
        this.filme = filme;
    }

    public int getIgressos() {
        return ingressos;
    }
    public void setIngressos(int ingressos){
        this.ingressos = ingressos;
    }
    
    
    public String verIngresso(){
        return "Filme: " + filme + "\n" + "Ingressos disponíveis: " + ingressos;
    }
    public String historicoDeCompras(){
        return "Filme: " + filme + "\n" + "Ingressos vendidos: " + ingressos;
    }
}