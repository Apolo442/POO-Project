package Models;

public class Acervo {

    private int id;
    private String titulo;
    private String descricao;
    private String autor;
    private Boolean disponibilidade;

    public Acervo(Boolean disponibilidade, int id, String descricao, String autor, String titulo) {
        this.disponibilidade = disponibilidade;
        this.id = id;
        this.descricao = descricao;
        this.autor = autor;
        this.titulo = titulo;
    }


    public Boolean getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
