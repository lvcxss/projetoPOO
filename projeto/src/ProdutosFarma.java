 class ProdutosFarma extends Produtos {
        private boolean comPrescricao;


     public ProdutosFarma() {}

     public ProdutosFarma(int codigo,String nome_produto, String descricao, int quantidade, float valor_unitario, String taxa) {
         super(codigo,nome_produto,descricao,quantidade,valor_unitario,taxa);
     }
     public boolean isComPrescricao(){return comPrescricao;}
     public void setComPrescricao(boolean comPrescricao) {this.comPrescricao = comPrescricao;}
     public String imprimir() {
         return "";
     }

     @Override
     public String toString() {
         return super.toString();
     }
 }
