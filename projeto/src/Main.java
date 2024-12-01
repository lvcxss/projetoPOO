import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {

        ListaClientes clientes = ManageFiles.importInfo();

        System.out.println("Bem vindo ao programa!");

        while (true) {
            switch (menu()) {
                case 1:
                    switch (menuClientes()) {
                        case 1:
                            System.out.println("---------------------");
                            criarCliente(clientes);
                            break;
                        case 2:
                            System.out.println("---------------------");
                            editarCliente(clientes);
                            break;
                        case 3:
                            System.out.println("---------------------");
                            clientes.imprimir();
                            break;
                        default:
                            System.out.println("Opção inválida no menu de clientes.");
                    }
                    break;
                case 2:
                    switch (menuFatura()) {
                        case 1:
                            System.out.println("---------------------");
                            break;
                        case 2:
                            System.out.println("--------------------");
                            break;
                        default:
                            System.out.println("Opção inválida no menu de clientes.");
                    }
                    break;
                case 4:
                    ManageFiles.exportInfo(clientes);
                    return;
                default:
                    System.out.println("Opção inválida no menu principal.");
            }
        }
    }

    public static int menu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("----------------------");
        System.out.println("1 - Clientes");
        System.out.println("2 - Fatura");
        System.out.println("4 - Sair");
        System.out.print("Escolha a sua opção: ");
        while(!sc.hasNextInt()){
            sc.next();
            System.out.println("Insira um numero!");
        }
        return sc.nextInt();
    }

    public static int menuClientes(){
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------");
        System.out.println("1 - Criar Cliente");
        System.out.println("2 - Editar Cliente");
        System.out.println("3 - Listar Clientes");
        System.out.print("Escolha a sua opção: ");
        while(!sc.hasNextInt()){
            sc.next();
            System.out.println("Insira um numero!");
        }
        return sc.nextInt();
    }

    public static int menuFatura(){
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------");
        System.out.println("1 - Criar Fatura");
        System.out.println("2 - Editar Fatura");
        System.out.println("3 - Listar Faturas");
        System.out.print("Escolha a sua opção: ");
        while(!sc.hasNextInt()){
            sc.next();
            System.out.println("Insira um numero!");
        }
        return sc.nextInt();
    }


    // alternativa para verificar se uma string tem apenas letras: regex
     public static boolean isAlpha(String str) {
        return str.matches("[a-zA-Z\s]+");
    }
    // para os numeros :
     public static boolean isDigit(String str) {
       return str.matches("\\d+");
   }


    public static void criarCliente(ListaClientes clientes){
        Scanner sc = new Scanner(System.in);
        System.out.print("Insira o nome: ");
//        String numeros = "1234567890";
//        String nome = sc.nextLine();
//        while(comparaString(nome,numeros)){
//            System.out.println("opção invalida!");
//            nome = sc.nextLine();
//        }
        String nome = sc.nextLine();
        while(!isAlpha(nome)){
            System.out.println("opção invalida!");
            nome = sc.nextLine();
        }
        System.out.print("Insira o numero de Contribuinte: ");
        String letras = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numeroContribuinte = sc.nextLine();
        while(comparaLetra(numeroContribuinte,letras) || numeroContribuinte.length() != 9){
            System.out.println("opção invalida!");
            numeroContribuinte = sc.nextLine();
        }
        Localizacao localizacao = receberLocalizacao(sc);
        Cliente novo = new Cliente(nome, numeroContribuinte, localizacao);
        clientes.addCliente(novo);

    }

    public static void editarCliente(ListaClientes clientes){
        Scanner sc = new Scanner(System.in);
        boolean valido = false;
        while(!valido) {
            System.out.print("Insira o numero de Contribuinte do cliente que pretende editar: ");
            String letras = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String numeroContribuinte = sc.nextLine();
            while(comparaLetra(numeroContribuinte,letras) || numeroContribuinte.length() != 9){
                System.out.println("opção invalida!");
                numeroContribuinte = sc.nextLine();
            }
            for (Cliente cliente : clientes.getClientes()) {
                if (Objects.equals(cliente.getnumContribuinte(), numeroContribuinte)) {
                    valido = true;
                    System.out.print("Insira o nome: ");
                    String numeros = "1234567890";
                    String nome = sc.nextLine();
                    while(comparaString(nome,numeros)){
                        System.out.println("opção invalida!");
                        nome = sc.nextLine();
                    }
                    cliente.setNome(nome);
                    System.out.print("Insira o numero de Contribuinte: ");
                    numeroContribuinte = sc.nextLine();
                    while(comparaLetra(numeroContribuinte,letras) || numeroContribuinte.length() != 9){
                        System.out.println("opção invalida!");
                        numeroContribuinte = sc.nextLine();
                    }
                    cliente.setNumContribuinte(numeroContribuinte);
                    Localizacao localizacao = receberLocalizacao(sc);
                    cliente.setLocalizacao(localizacao);
                }
            }
            if (!valido)
                System.out.println("Não existe cliente com esse numero!");
        }
    }

    private static Localizacao receberLocalizacao(Scanner sc) {
        Localizacao localizacao;
        while (true) {
            System.out.println("Escolha a localizacao:");
            System.out.println("1 - Portugal Continental");
            System.out.println("2 - Madeira");
            System.out.println("3 - Acores");
            System.out.print("Insira a sua opção: ");

            while (!sc.hasNextInt()) {
                sc.next();
                System.out.println("Insira um numero!");
            }

            int numero = sc.nextInt();
            switch (numero) {
                case 1:
                    localizacao = Localizacao.PortugalContinental;
                    break;
                case 2:
                    localizacao = Localizacao.Madeira;
                    break;
                case 3:
                    localizacao = Localizacao.Acores;
                    break;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
                    continue;
            }
            break;
        }
        return localizacao;
    }

    public static boolean comparaString(String nome,String comparable) {
        for (char c : comparable.toCharArray()) {
            if (nome.indexOf(c) >= 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean comparaLetra(String nome,String comparable) {
        for (char c : comparable.toCharArray()) {
            if (nome.indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }
}
