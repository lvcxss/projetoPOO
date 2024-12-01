class ProdutosAlimentares extends Produtos {
    protected  boolean biologico;

    public ProdutosAlimentares(){}

    public ProdutosAlimentares(int codigo,String nome_produto, String descricao, int quantidade, float valor_unitario, String taxa, boolean biologico){
        super(codigo,nome_produto,descricao,quantidade,valor_unitario,taxa);
        this.biologico = biologico;
    }
    public boolean getbiologico(){
        return biologico;
    }
    public void setbiologico(boolean biologico){
        this.biologico = biologico;
    }

    public String imprimir() {
        return "";
    }
    @Override
    public String toString() {
        return String.format("%s;%b", super.toString(), biologico);
    }
}
