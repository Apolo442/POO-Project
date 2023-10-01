package Models;

public class Livros extends Acervo{

    private String editora;
    private String numPaginas;
    private String idioma;
    private String dataPublicacao;

    public Livros(Boolean disponibilidade, int id, String descricao, String autor, String titulo, String editora, String numPaginas, String idioma, String dataPublicacao) {
        super(disponibilidade, id, descricao, autor, titulo);
        this.editora = editora;
        this.numPaginas = numPaginas;
        this.idioma = idioma;
        this.dataPublicacao = dataPublicacao;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(String numPaginas) {
        this.numPaginas = numPaginas;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(String dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    @Override
    public String toString() {
        String print =
                "\n============================================"+
                "\nTítulo: " + getTitulo() +
                "\nDescrição: " + getDescricao() +
                "\nAutor: "+ getAutor() +
                "\nId: " + getId() +
                "\nEditora: " + getEditora() +
                "\nNúmero de páginas: " + getNumPaginas() +
                "\nIdioma: " + getIdioma() +
                "\nData de publicação: " + getDataPublicacao() +
                "\nDisponível para empréstimo? " + getDisponibilidade();
        return print;
    }
}
