import java.util.*;

public class Iphone implements ReprodutorMusical, AparelhoTelefonico, NavegadorInternet {

    private String modelo;
    private String numeroDeSerie;
    private List<String> musicas = new ArrayList<>();
    private String musicaAtual;
    private Map<String, String> contatos = new HashMap<>();
    private String chamadaAtual;
    private List<String> abas = new ArrayList<>();
    private String abaAtual;

    public Iphone(String modelo, String numeroDeSerie) {
        this.modelo = modelo;
        this.numeroDeSerie = numeroDeSerie;
    }

    // Implementação dos métodos da interface ReprodutorMusical
    @Override
    public void tocar() {
        if (musicaAtual != null) {
            System.out.println("Reproduzindo música: " + musicaAtual);
        } else {
            System.out.println("Nenhuma música selecionada.");
        }
    }

    @Override
    public void pausar() {
        if (musicaAtual != null) {
            System.out.println("Música pausada: " + musicaAtual);
        } else {
            System.out.println("Nenhuma música está tocando.");
        }
    }

    @Override
    public void selecionarMusica(String musica) {
        this.musicaAtual = musica;
        System.out.println("Selecionando a música: " + musica);
    }

    // Implementação dos métodos da interface AparelhoTelefonico
    @Override
    public void ligar(String numero) {
        this.chamadaAtual = numero;
        System.out.println("Ligando para: " + numero);
    }

    @Override
    public void atender() {
        if (chamadaAtual != null) {
            System.out.println("Atendendo a chamada de: " + chamadaAtual);
        } else {
            System.out.println("Nenhuma chamada para atender.");
        }
    }

    @Override
    public void iniciarCorreioVoz() {
        System.out.println("Iniciando o correio de voz.");
    }

    // Implementação dos métodos da interface NavegadorInternet
    @Override
    public void exibirPagina(String url) {
        this.abaAtual = url;
        abas.add(url);
        System.out.println("Exibindo a página: " + url);
    }

    @Override
    public void adicionarNovaAba() {
        this.abaAtual = null;
        System.out.println("Adicionando uma nova aba.");
    }

    @Override
    public void atualizarPagina() {
        if (abaAtual != null) {
            System.out.println("Atualizando a página: " + abaAtual);
        } else {
            System.out.println("Nenhuma página para atualizar.");
        }
    }

    // Métodos adicionais para simular funcionalidades mais complexas
    public void adicionarContato(String nome, String numero) {
        contatos.put(nome, numero);
        System.out.println("Contato adicionado: " + nome + " - " + numero);
    }

    public void listarContatos() {
        System.out.println("Lista de contatos:");
        for (Map.Entry<String, String> contato : contatos.entrySet()) {
            System.out.println(contato.getKey() + " - " + contato.getValue());
        }
    }

    public void listarMusicas() {
        System.out.println("Lista de músicas:");
        for (String musica : musicas) {
            System.out.println(musica);
        }
    }

    public void listarAbas() {
        System.out.println("Lista de abas:");
        for (String aba : abas) {
            System.out.println(aba);
        }
    }
}
