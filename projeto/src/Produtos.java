import java.io.Serializable;

abstract class Produtos implements Serializable {

     protected int codigo;
     protected String nomeProduto;
     protected String descricao;
     protected int quantidade;
     protected double valorUnitario;
     protected String taxa;


     public Produtos() {}

     public Produtos(int codigo, String nomeProduto, String descricao, int quantidade, float valorUnitario, String taxa){
         this.codigo = codigo;
         this.nomeProduto = nomeProduto;
         this.descricao = descricao;
         this.quantidade = quantidade;
         this.valorUnitario = valorUnitario;
         this.taxa = taxa;
     }

     public int getCodigo() {
         return codigo;
     }
     public void setCodigo(int codigo) {
         this.codigo = codigo;
     }
     public String getNomeProduto() {
         return nomeProduto;
     }
     public void setNomeProduto(String nomeProduto) {
         this.nomeProduto = nomeProduto;
     }
     public String getDescricao() {
         return descricao;
     }
     public void setDescricao(String descricao) {
         this.descricao = descricao;
     }
     public int getQuantidade() {
         return quantidade;
     }
     public void setQuantidade(int quantidade) {
         this.quantidade = quantidade;
     }
     public double getValorUnitario() {
         return valorUnitario;
     }
     public void setValorUnitario(double valorUnitario) {
         this.valorUnitario = valorUnitario;
     }
     public String getTaxa() {
         return taxa;
     }
     public void setTaxa(String taxa) {
         this.taxa = taxa;
     }

     public abstract String imprimir();

     @Override
     public String toString() {
         return String.format("%d;%s;%s;%d;%.2f;%s", codigo, nomeProduto, descricao, quantidade, valorUnitario, taxa);
     }
 }
