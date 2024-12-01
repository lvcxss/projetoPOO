import java.io.*;
import java.util.ArrayList;

public class ListaProdutos implements Serializable {
    ArrayList<Produtos> produtos = new ArrayList<>();

    public ListaProdutos() {}

    public ListaProdutos(ArrayList<Produtos> produtos) {
        this.produtos = produtos;
    }
    public ArrayList<Produtos> getProdutos() {
        return produtos;
    }
    public void setProdutos(ArrayList<Produtos> produtos) {
        this.produtos = produtos;
    }

    public void addProduto(Produtos produto) {
        produtos.add(produto);
    }

    public void print(){
        for(Produtos produto : produtos){
            System.out.println(produto);
        }
    }

    public void imprimir(BufferedWriter bw) throws IOException {
        for (Produtos p : produtos) {
            bw.write(p.imprimir());
            bw.newLine(); // Adiciona uma nova linha após cada produto
        }
    }
    public void mostra(){
        for(Produtos p : produtos){
            System.out.println(p);
        }
    }

    @Override
    public String toString() {
        return "Produtos{" + "produtos=" + produtos + '}';
    }
}
