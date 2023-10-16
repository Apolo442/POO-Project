package Models;

public class Emprestimo {



    private Acervo acervoEmprestimo;
    private String cpf;
    private String nome;
    private String dataEmprestimo;
    private String dataDevolucao;

    public Emprestimo(Acervo acervoEmprestimo, String cpf, String nome, String dataEmprestimo, String dataDevolucao) {
        this.acervoEmprestimo = acervoEmprestimo;
        this.cpf = cpf;
        this.nome = nome;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public Acervo getAcervoEmprestimo() {
        return acervoEmprestimo;
    }

    public void setAcervoEmprestimo(Acervo acervoEmprestimo) {
        this.acervoEmprestimo = acervoEmprestimo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
}
