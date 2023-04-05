package  classes;

public class Requisicao {
    private Livro livro;
    private Leitor leitor;
    private Data dataRequesicao;
    private Data dataDevolucao;

    public Requisicao(Livro livro, Leitor leitor, Data dataRequesicao, Data dataDevolucao){
        this.livro = livro;
        this.leitor = leitor;
        this.dataRequesicao = dataRequesicao;
        this.dataDevolucao = dataDevolucao;
    }

    public Livro getLivro() {

        return livro;
    }

    public Data getDataRequesicao() {
        return dataRequesicao;
    }
}
