 class ComPrescricao extends ProdutosFarma{

    private String nomeMedico;

    public ComPrescricao() {}

    public ComPrescricao( int codigo,String nome_produto,String descricao, int quantidade, float valor_unitario, String taxa,String nomeMedico){
        super(codigo,nome_produto,descricao,quantidade,valor_unitario,taxa);
        this.nomeMedico = nomeMedico;
    }
    public String getNomeMedico() {
        return nomeMedico;
    }
    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }
     public String imprimir() {
         return toString();
     }
    @Override
    public String toString() {
        return String.format("%s;%s", super.toString(), nomeMedico);
    }
}
