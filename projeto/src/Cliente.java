import java.io.Serializable;
import java.util.ArrayList;

enum Localizacao{
     PortugalContinental,
     Acores,
     Madeira
 }

public class Cliente implements Serializable {

    private String nome;
    private String numContribuinte;
    private Localizacao localizacao;
    private ArrayList<Fatura> faturas = new ArrayList<Fatura>();
    public Cliente(){}

    // void removeFatura(Fatura fatura){
    //    faturas.remove(fatura);
    //}

    //public void adicionaFatura(Fatura fatura){
    //    faturas.add(fatura);
    //}

    public ArrayList<Fatura> getFaturas() {
        return faturas;
    }
    public Cliente(String nome, String numContribuinte, Localizacao localizacao) {
        this.nome = nome;
        this.numContribuinte = numContribuinte;
        this.localizacao = localizacao;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getnumContribuinte() {
        return numContribuinte;
    }
    public void setNumContribuinte(String numContribuinte) {
        this.numContribuinte = numContribuinte;
    }
    public Localizacao getLocalizacao() {
        return localizacao;
    }
    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }
    @Override
    public String toString() {
        return nome + ";" + numContribuinte + ";" + localizacao;
    }
}