import java.io.*;
import java.util.ArrayList;

class Fatura implements Serializable{

    protected int numeroFatura;
    protected Data data;
    protected ListaProdutos lista;

    public Fatura() {}

    public Fatura(int numeroFatura, Data data, ListaProdutos lista) {
        this.numeroFatura = numeroFatura;
        this.data = data;
        this.lista = lista;
    }
    public ArrayList<Produtos> getProdutos() {
        return this.lista.getProdutos();
    }
    public int getNumeroFatura() {
        return numeroFatura;
    }

    public void setNumeroFatura(int numeroFatura) {
        this.numeroFatura = numeroFatura;
    }
    public void addProduto(Produtos produto) {
        this.lista.addProduto(produto);
    }

    public Data getData(){
        return data;
    }

    public void setData(Data data){
        this.data = data;
    }
    public ListaProdutos getLista() {
        return lista;
    }
    public void setLista(ListaProdutos lista) {
        this.lista = lista;
    }

    public void escreverFicheiro(){
        File f = new File("Faturas.txt");
        try{
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(numeroFatura + "$");
            bw.write(data.toString());
            bw.newLine();

            // Imprime os produtos associados à fatura
            lista.imprimir(bw);
            bw.close();
            fw.close();
        }catch(IOException e){
            System.out.println("Error " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Fatura{" + "numero_de_fatura=" + numeroFatura + ", data=" + data + "ListaProdutos = "+ lista + '}';
    }
    public void showFatura(){
        System.out.println("Numero de fatura: " + numeroFatura);
        System.out.println(data.toString());
        lista.mostra();
    }
}
