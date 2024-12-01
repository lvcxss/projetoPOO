import java.util.ArrayList;

public class TaxaReduzida extends ProdutosAlimentares{

    private ArrayList<String> numCert = new ArrayList<>();

    public TaxaReduzida() {}

    public TaxaReduzida(int codigo,String nome_produto,String descricao, int quantidade, float valor_unitario, String taxa, boolean biologico,ArrayList<String> numCert){
        super(codigo,nome_produto,descricao,quantidade,valor_unitario,taxa,biologico);
        this.numCert = numCert;
    }
    public ArrayList<String> getNumCert(){
        return numCert;
    }
    public void setCertificacoes(ArrayList<String> numCert){
        this.numCert = numCert;
    }

    public String imprimir() {
        return toString();
    }

    public String toString(){
        return String.format("%s;%s", super.toString(), numCert);
    }
}
