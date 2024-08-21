# Projeto iPhone UML

Este projeto contém a modelagem UML e implementação em Java das funcionalidades do iPhone como Reprodutor Musical, Aparelho Telefônico e Navegador na Internet.

## Diagrama UML do iPhone

Este é o diagrama UML representando as funcionalidades do iPhone como Reprodutor Musical, Aparelho Telefônico e Navegador na Internet.

```mermaid
classDiagram
    class ReprodutorMusical {
        <<interface>>
        +tocar()
        +pausar()
        +selecionarMusica(String musica)
    }
    
    class AparelhoTelefonico {
        <<interface>>
        +ligar(String numero)
        +atender()
        +iniciarCorreioVoz()
    }
    
    class NavegadorInternet {
        <<interface>>
        +exibirPagina(String url)
        +adicionarNovaAba()
        +atualizarPagina()
    }
    
    class iPhone {
        -modelo: String
        -numeroDeSerie: String
        -musicas: List<String>
        -musicaAtual: String
        -contatos: Map<String, String>
        -chamadaAtual: String
        -abas: List<String>
        -abaAtual: String
        +iPhone(modelo: String, numeroDeSerie: String)
        +tocar()
        +pausar()
        +selecionarMusica(String musica)
        +ligar(String numero)
        +atender()
        +iniciarCorreioVoz()
        +exibirPagina(String url)
        +adicionarNovaAba()
        +atualizarPagina()
    }
    
    iPhone ..|> ReprodutorMusical
    iPhone ..|> AparelhoTelefonico
    iPhone ..|> NavegadorInternet
