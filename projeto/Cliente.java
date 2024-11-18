enum Localizacao {
  Continente,
  Madeira,
  Acores
}

public class Cliente {
  protected String nome;
  protected String nif;
  protected Localizacao loc;

  Cliente() {
  }

  Cliente(String nome, String nif, Localizacao loc) {
    this.nome = nome;
    this.nif = nif;
    this.loc = loc;
  }

  public String getNome() {
    return nome;
  }

  public String getNif() {
    return nif;
  }

  public Localizacao getLocalizacao() {
    return this.loc;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setNif(String nif) {
    this.nif = nif;
  }

  public void setLocalizacao(Localizacao loc) {
    this.loc = loc;
  }

  public void editCliente(String nome, String nif, Localizacao loc) {
    setNome(nome);
    setNif(nif);
    setLocalizacao(loc);
  }

  public String toString() {
    return "Nome: " + this.getNome() + "\nNIF: " + this.getNif() + "\nLocalizacao: " + this.getLocalizacao();
  }

}
