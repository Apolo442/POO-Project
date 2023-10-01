package Main;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import Models.*;


public class Main {

    private static ArrayList<Acervo> acervos = new ArrayList<>();
    private static ArrayList<Emprestimo> listaEmprestimos = new ArrayList<>();

    static Scanner scan = new Scanner(System.in);

    static int run = 1;

    public static void main(String[] args) {

        while (run==1){
            menu();
        }
        System.out.println("Fim do programa.");

    }

    private static void menu() {
        System.out.println();
        System.out.println("-=-=-=Acervos Digitais=-=-=-");
        System.out.println("1- Cadastrar.");
        System.out.println("2- Atualizar.");
        System.out.println("3- Exibir.");
        System.out.println("4- Remover.");
        System.out.println("5- Fazer empréstimo.");
        System.out.println("6- Devolver empréstimo.");
        System.out.println("7- Sair");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.print("Escolha: ");
        int escolha = scan.nextInt();
        buffer();

        switch(escolha){
            case 1:
                cadastrarAcervo();
                break;
            case 2:
                alterarDados();
                break;
            case 3:
                exibirAcervos();
                break;
            case 4:
                deletarAcervo();
                break;
            case 5:
                fazerEmprestimo();
                break;
            case 6:
                devolverEmprestimo();
                break;
            case 7:
                run = 0;
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }

    }

    private static void fazerEmprestimo(){
        System.out.println();
        System.out.println("-= Registrar Empréstimo =-");
        System.out.print("Id do acervo desejado: ");
        int id = scan.nextInt();
        buffer();

        if((acervos.get(id).getDisponibilidade())){
            acervos.get(id).setDisponibilidade(false);
            System.out.print("Nome: ");
            String nome = scan.nextLine();
            System.out.print("CPF: ");
            String cpf = scan.nextLine();
            System.out.print("Data do empréstimo: ");
            String dataEmprestimo = scan.nextLine();
            String dataDevolucao = "";

            int empretimoId = listaEmprestimos.size();
            Emprestimo emprestimo = new Emprestimo(acervos.get(id), cpf, nome, dataEmprestimo, dataDevolucao);
            listaEmprestimos.add(empretimoId,emprestimo);

            System.out.println("Acervo emprestado com sucesso.");
            System.out.println("Id do empréstimo: " + empretimoId);
        }else {
            System.out.println("Acervo indisponível");
        }

    }

    private static void devolverEmprestimo(){
        System.out.println();
        System.out.println("-= Devolver Empréstimo =-");
        System.out.print("Id acervo: ");
        int id = scan.nextInt();
        buffer();

        if((acervos.get(id).getDisponibilidade())==false){
            acervos.get(id).setDisponibilidade(true);
            System.out.print("Data da devolução: ");
            String dataDevolucao = scan.nextLine();

            System.out.println("Empréstimo devolvido com sucesso. ");
        } else {
            System.out.println("Esse acervo já está em estoque");
        }
    }

    private static void deletarAcervo(){
        System.out.println("-= Deletar acervo =-");
        System.out.print("Id do acervo: ");
        int id = scan.nextInt();
        buffer();

        if((acervos.get(id).getDisponibilidade())){
            acervos.remove(id);
            System.out.println("Acervo deletado com sucesso.");
        }
        else {
            System.out.println("Não foi possível deletar o acervo");
            System.out.println("Status do acervo: Emprestado");
        }
    }

    private static void cadastrarAcervo() {

        System.out.println();
        System.out.println("-= Cadastrar acervo =-");
        System.out.print("Título: ");
        String titulo = scan.nextLine();
        System.out.print("Descricao: ");
        String descricao = scan.nextLine();
        System.out.print("Autor: ");
        String autor = scan.nextLine();
        int id = acervos.size();
        boolean disponibilidade = true;

        System.out.println("-= Tipo do acervo =-");
        System.out.println("1- Filme");
        System.out.println("2- Livro");
        System.out.print("Escolha: ");
        int opc = scan.nextInt();
        buffer();

        switch (opc) {
            case 1:
                System.out.print("Data de lançamento: ");
                String dataLancamento = scan.nextLine();

                System.out.print("Nome do diretor: ");
                String nomeDiretor = scan.nextLine();


                System.out.print("Quantidade de atores: ");
                int qtdAtores = scan.nextInt();
                buffer();

                String atores = "";
                for(int i=0; i<qtdAtores; i++){
                    System.out.print("Nome do ator: ");
                    String ator = scan.nextLine();
                    atores += ator+" / ";
                }

                Filmes filme = new Filmes(disponibilidade, id, descricao, autor, titulo, dataLancamento, nomeDiretor, atores);

                acervos.add(id,filme);
                break;
            case 2:
                System.out.print("Editora: ");
                String editora = scan.nextLine();
                System.out.print("Número de páginas: ");
                String numPaginas = scan.nextLine();
                System.out.print("Idioma: ");
                String idioma = scan.nextLine();
                System.out.print("Data de Publicação:");
                String dataPublicacao = scan.nextLine();

                Livros livro = new Livros(disponibilidade, id, descricao, autor, titulo, editora, numPaginas, idioma, dataPublicacao);

                acervos.add(id,livro);
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
        System.out.println("Acervo registrado com sucesso! ");
        System.out.println("ID do acervo: " + id);
    }

    private static void alterarDados() {
        System.out.println();
        System.out.println("-=Alterar dados=-");
        System.out.println("Id do acervo: ");
        int id = scan.nextInt();
        buffer();

        System.out.println("-=Tipo do acervo=-");
        System.out.println("1- Filme");
        System.out.println("2- Livro");
        System.out.print("Escolha: ");
        int opc = scan.nextInt();
        buffer();
        System.out.println("-=-=-=-=-=-=-=-=-=-");

        switch (opc) {
            case 1:
                Filmes fi = (Filmes) acervos.get(id);

                System.out.println("Campo a ser alterado: ");
                System.out.println("1- Título");
                System.out.println("2- Descrição");
                System.out.println("3- Autor");
                System.out.println("4- Data de lançamento");
                System.out.println("5- Nome do diretor");
                System.out.println("6- Atores");
                System.out.print("Escolha: ");
                int opcFi = scan.nextInt();
                buffer();

                if(opcFi==6){
                    System.out.print("Quantidade de atores: ");
                    int qtdAtores = scan.nextInt();
                    buffer();

                    String atores = "";
                    for(int i=0; i<qtdAtores; i++){
                        System.out.print("Nome do ator: ");
                        String ator = scan.nextLine();
                        atores += ator+" / ";
                    }
                    fi.setAtores(atores);
                }else {

                }

                System.out.print("Digite sua alteração: ");
                String alteracaoFilme = scan.nextLine();

                switch (opcFi) {
                    case 1:
                        fi.setTitulo(alteracaoFilme);
                        break;
                    case 2:
                        fi.setDescricao(alteracaoFilme);
                        break;
                    case 3:
                        fi.setAutor(alteracaoFilme);
                        break;
                    case 4:
                        fi.setDataLancamento(alteracaoFilme);
                        break;
                    case 5:
                        fi.setNomeDiretor(alteracaoFilme);
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
                break;
            case 2:
                Livros li = (Livros) acervos.get(id);

                System.out.println("Campo a ser alterado: ");
                System.out.println("1- Título");
                System.out.println("2- Descrição");
                System.out.println("3- Autor");
                System.out.println("4- Editora");
                System.out.println("5- Número de páginas");
                System.out.println("6- Idioma");
                System.out.println("7- Data de publicação");
                System.out.print("Escolha: ");
                int opcLi = scan.nextInt();
                buffer();

                System.out.print("Digite sua alteração: ");
                String alteracaoLivro = scan.nextLine();

                switch (opcLi) {
                    case 1:
                        li.setTitulo(alteracaoLivro);
                        break;
                    case 2:
                        li.setDescricao(alteracaoLivro);
                        break;
                    case 3:
                        li.setAutor(alteracaoLivro);
                        break;
                    case 4:
                        li.setEditora(alteracaoLivro);
                        break;
                    case 5:
                        li.setNumPaginas(alteracaoLivro);
                        break;
                    case 6:
                        li.setIdioma(alteracaoLivro);
                        break;
                    case 7:
                        li.setDataPublicacao(alteracaoLivro);
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }


        }
    }

    private static void exibirAcervos(){
        System.out.println();
        System.out.println("-=-=Exibir Acervo=-=-");
        System.out.println("1- Exibir Filmes");
        System.out.println("2- Exibir Livros");
        System.out.print("Escolha: ");

        int opc = scan.nextInt();
        buffer();

        switch (opc){
            case 1:
                for(Acervo acervo : acervos){
                    if(acervo instanceof Filmes){
                        Filmes fi = (Filmes) acervo;
                        System.out.println(fi);
                    }
                }
                break;
            case 2:
                for(Acervo acervo : acervos){
                    if(acervo instanceof Livros){
                        Livros li = (Livros) acervo;
                        System.out.println(li);
                    }
                }
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }

    private static void buffer(){
        scan.nextLine();
    }
}
