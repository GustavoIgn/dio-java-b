package list.CatalogoLivros;

public class Livro {

    private String titulo, autor;
    private int ano;

    public Livro(String titulo, String autor, int ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAno() {
        return ano;
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        return "Livro {"
                + "Titulo='" + titulo + '\''
                + ", Autor='" + autor + '\''
                + ", Ano=" + ano
                + '}';
    }
}
