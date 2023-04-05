package classes;

public class Livro {
    private String titulo;
    private String autor;

    public Livro(String titulo, String nomeautor){
        this.titulo = titulo;
        this.autor = nomeautor;

    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        return "Livro{ " +
                "titulo: '" + titulo + '\'' +
                ", autor: '" + autor + '\'' +
                '}' + "\n";
    }
}
