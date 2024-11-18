enum Tipo {
  Alimentar,
  Farmacia
}

abstract class Produto {
  protected String codigo;
  protected String nome;
  protected double preco;
  protected int quantidade;
  protected Tipo tipo;

  public Produto(String codigo, String nome, double preco, int quantidade, Tipo tipo) {
    this.codigo = codigo;
    this.nome = nome;
    this.preco = preco;
    this.quantidade = quantidade;
    this.tipo = tipo;
  }

  public String getCodigo() {
    return codigo;
  }

  public String getNome() {
    return nome;
  }

  public double getPreco() {

  }

  public int getQuantidade() {
    return quantidade;
  }

  public Tipo getTipo() {
    return tipo;
  }

  abstract double calcIva(Localizacao loc);

}
