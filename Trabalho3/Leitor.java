package classes;

public class Leitor {
    private int numeroUtente;
    private String nome;

    public Leitor(int numeroUtente,  String nome) {
        this.numeroUtente = numeroUtente;
        this.nome = nome;
    }

    public int getNumeroUtente() {
        return numeroUtente;
    }

    public void setNumeroUtente(int numeroUtente) {
        this.numeroUtente = numeroUtente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
