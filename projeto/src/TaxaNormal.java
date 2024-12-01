import javax.lang.model.element.ModuleElement;

class TaxaNormal extends ProdutosAlimentares {

    public TaxaNormal(){}

    public TaxaNormal(int codigo,String nome_produto,String descricao, int quantidade, float valor_unitario, String taxa, boolean biologico){
        super(codigo,nome_produto,descricao,quantidade,valor_unitario,taxa,biologico);
    }

    public String imprimir() {
        return toString();
    }

     @Override
     public String toString() {
         return super.toString();
     }
 }
