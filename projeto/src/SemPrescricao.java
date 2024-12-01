 enum TipoMedicamento {
     beleza,
     bemEstar,
     bebes,
     animais,
     outro
 }

class SemPrescricao extends ProdutosFarma{

    private TipoMedicamento tipoMedicamento;

    public SemPrescricao(){}

    public SemPrescricao(int codigo,String nome_produto,String descricao, int quantidade, float valor_unitario, String taxa,TipoMedicamento tipoMedicamento) {
        super(codigo,nome_produto,descricao,quantidade,valor_unitario,taxa);
        this.tipoMedicamento = tipoMedicamento;
    }
    public TipoMedicamento getTipoMedicamento() {
        return tipoMedicamento;
    }
    public void setTipoMedicamento(TipoMedicamento tipoMedicamento) {
        this.tipoMedicamento = tipoMedicamento;
    }

    public String imprimir() {
        return toString();
    }

    @Override
    public String toString() {
        return String.format("%s;%s", super.toString(), tipoMedicamento);
    }
}
