package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Filmes extends Acervo{
    static Scanner scan = new Scanner(System.in);

    private String atores;
    private String dataLancamento;
    private String nomeDiretor;

    public Filmes(Boolean disponibilidade, int id, String descricao, String autor, String titulo, String dataLancamento, String nomeDiretor, String atores) {
        super(disponibilidade, id, descricao, autor, titulo);
        this.dataLancamento = dataLancamento;
        this.nomeDiretor = nomeDiretor;
        this.atores = atores;
    }

    public String getAtores() {
        return atores;
    }

    public void setAtores(String atores) {
        this.atores = atores;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getNomeDiretor() {
        return nomeDiretor;
    }

    public void setNomeDiretor(String nomeDiretor) {
        this.nomeDiretor = nomeDiretor;
    }

    @Override
    public String toString() {
        String print =
                "\n============================================"+
                "\nTítulo: " + getTitulo() +
                "\nDescrição: " + getDescricao() +
                "\nAutor: " + getAutor() +
                "\nId: " + getId() +
                "\nData de lançamento: " + getDataLancamento() +
                "\nNome do Diretor: " + getNomeDiretor() +
                "\nDisponível para empréstimo? " + getDisponibilidade()+
                "\n**LISTA DE ATORES**\n" + getAtores();
        return print;
    }
}
