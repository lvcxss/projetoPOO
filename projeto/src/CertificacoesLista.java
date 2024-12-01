import java.util.ArrayList;

public class CertificacoesLista {
    ArrayList<String> certificacoes = new ArrayList<>();

    public CertificacoesLista() {}

    public CertificacoesLista(ArrayList<String> certificacoes) {
        this.certificacoes = certificacoes;
    }
    public ArrayList<String> getCertificacoesLista() {
        return certificacoes;
    }
    public void setCertificacoesLista(ArrayList<String> certificacoes) {
        this.certificacoes = certificacoes;
    }

    public void addCertificacao(ArrayList<String> certificacoes,String certificacao) {
        for(String cert: certificacoes) {
            if(!certificacao.equals(cert)) {
                if(!certificacao.equals("ISO22000") && !certificacao.equals("GMP") && !certificacao.equals("HACCP") && !certificacao.equals("FSSP22000"))
                    certificacoes.add(certificacao);
            }
        }
    }

    @Override
    public String toString() {
        return "Produtos{" +
                "produtos=" + certificacoes +
                '}';
    }
}
