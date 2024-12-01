import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TesteFiles {
    public static void main(String[] args) throws IOException {
        String filePath = "testedados.txt";
        ArrayList<Cliente> clientes = new ArrayList<>();
        Cliente clienteAtual = null;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();

                if (line.equals("**")) { // Fim do cliente atual
                    if (clienteAtual != null) {
                        clientes.add(clienteAtual);
                        clienteAtual = null;
                    }
                } else if (line.contains(";") && clienteAtual == null) { // Novo cliente
                    String[] partes = line.split(";");
                    String nome = partes[0];
                    String nif = partes[1];
                    Localizacao localizacao = Localizacao.valueOf(partes[2]);
                    clienteAtual = new Cliente(nome, nif, localizacao);
                } else if (line.contains(";") && clienteAtual != null) { // Fatura ou Produto
                    if (line.matches("\\d+;\\d+'\\d+'\\d+")) { // Fatura
                        String[] partes = line.split(";");
                        int numeroFatura = Integer.parseInt(partes[0]);
                        String[] dataPartes = partes[1].split("'");
                        Data data = new Data(
                                Integer.parseInt(dataPartes[0]),
                                Integer.parseInt(dataPartes[1]),
                                Integer.parseInt(dataPartes[2])
                        );
                        ListaProdutos prods = new ListaProdutos();
                        Fatura fatura = new Fatura(numeroFatura, data,prods);
                        clienteAtual.getFaturas().add(fatura);
                    } else { //Produtos
                        Produtos produto = processaProduto(line);
                        if(!clienteAtual.getFaturas().isEmpty()) {
                            Fatura ultimaFatura = clienteAtual.getFaturas().get(clienteAtual.getFaturas().size() - 1);
                            ultimaFatura.getProdutos().add(produto);
                        }
                        else{
                            Fatura ultimaFatura = new Fatura();

                            ultimaFatura.addProduto(produto);
                        }
                    }
                }
            }
        }

        // Exemplo de exibição dos dados
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
            for(Fatura fatura : cliente.getFaturas()) {
                fatura.showFatura();
            }
        }
    }
    private static Produtos processaProduto(String line) {
        String[] partes = line.split(";");
        int codigo = Integer.parseInt(partes[0]);
        String nome = partes[1];
        String descricao = partes[2];
        int quantidade = Integer.parseInt(partes[3]);
        double valorUnitario = Double.parseDouble(partes[4]);

        if (partes[5].startsWith("Taxa")) { // Produto alimentar
            Produtos produto = null;
            if (partes[5].equals("TaxaReduzida")) {
                TaxaReduzida produtoReduzido = new TaxaReduzida();
                String[] certificacoesArray = partes[6].split("/");
                ArrayList<String> certificacoes = new ArrayList<>();
                for(String certificacao : certificacoesArray) {
                    certificacoes.add(certificacao);
                }
                produtoReduzido.setCertificacoes(certificacoes);
                produto = produtoReduzido;
            }else if (partes[5].equals("TaxaIntermedia")) {
                TaxaIntermedia produtoIntermedio = new TaxaIntermedia();
                produtoIntermedio.setAlimento(TipoAlimento.valueOf(partes[7]));
                produto = produtoIntermedio;
            }
            produto.setCodigo(codigo);
            produto.setNomeProduto(nome);
            produto.setDescricao(descricao);
            produto.setQuantidade(quantidade);
            produto.setValorUnitario(valorUnitario);
            produto.setTaxa(partes[5]);
            return produto;
        } else { // Produto de farmácia
            ProdutosFarma produto;
            if (partes[5].equals("ComPrescricao")) {
                ComPrescricao produtoComPrescricao = new ComPrescricao();
                produtoComPrescricao.setCodigo(codigo);
                produtoComPrescricao.setNomeProduto(nome);
                produtoComPrescricao.setDescricao(descricao);
                produtoComPrescricao.setQuantidade(quantidade);
                produtoComPrescricao.setValorUnitario(valorUnitario);
                produtoComPrescricao.setComPrescricao(true);
                produtoComPrescricao.setNomeMedico(partes[6]); // Setando o nome do médico

                produto = produtoComPrescricao;
            } else { // Produto sem prescrição
                SemPrescricao produtoSemPrescricao = new SemPrescricao();
                produtoSemPrescricao.setCodigo(codigo);
                produtoSemPrescricao.setNomeProduto(nome);
                produtoSemPrescricao.setDescricao(descricao);
                produtoSemPrescricao.setQuantidade(quantidade);
                produtoSemPrescricao.setValorUnitario(valorUnitario);
                produtoSemPrescricao.setComPrescricao(false);
                produtoSemPrescricao.setTipoMedicamento(TipoMedicamento.valueOf(partes[6])); // Setando o tipo do medicamento

                produto = produtoSemPrescricao;
            }
            return produto;
        }
    }
}

