enum TipoAlimento {
    congelados,
    enlatados,
    vinho
}

class TaxaIntermedia extends ProdutosAlimentares {

    private TipoAlimento alimento;

    public TaxaIntermedia() {}

    public TaxaIntermedia(int codigo, String nomeProduto,String descricao, int quantidade, float valorUnitario, String taxa, boolean biologico,TipoAlimento alimento) {
        super(codigo,nomeProduto,descricao,quantidade,valorUnitario,taxa,biologico);
        this.alimento = alimento;
    }
    public TipoAlimento getAlimento() {
        return alimento;
    }
    public void setAlimento(TipoAlimento alimento) {
        this.alimento = alimento;
    }

    public String imprimir() {
        return toString();
    }

    @Override
    public String toString() {
        return String.format("%s;%s", super.toString(), alimento);
    }
}
