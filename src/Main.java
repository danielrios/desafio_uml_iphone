import Model.IPhone;

public class Main {
    public static void main(String[] args) {
        IPhone iphone = new IPhone("2007");

        // Adicionando algumas abas e exibindo todas as abas
        iphone.adicionarNovaAba();
        iphone.verTodasAbas();
        iphone.adicionarNovaAba();
        iphone.verTodasAbas();
        iphone.trocarUrlAbaAtual("https://www.google.com");
        iphone.exibirPaginaAtual();
        iphone.verTodasAbas();
        iphone.adicionarNovaAba();
        iphone.verTodasAbas();

        // Trocar para a segunda aba e exibir a página atual
        iphone.trocarAbaAtual(2);
        iphone.exibirPaginaAtual();

        // Trocar a URL da segunda aba e exibir a página atual
        iphone.trocarUrlAbaAtual("https://www.github.com");
        iphone.exibirPaginaAtual();

        // Fechar a segunda aba e ver todas as abas novamente
        iphone.fecharAbaAtual();
        iphone.verTodasAbas();

        // Trocar para a segunda ava novamente e exibir a página atual
        iphone.trocarAbaAtual(2);
        iphone.exibirPaginaAtual();

        // Trocar a URL da página atual
        iphone.trocarUrlAbaAtual("https://www.example.com");
        iphone.exibirPaginaAtual();

        // Trocar para a primeira aba e exibir a página atual
        iphone.trocarAbaAtual(0);
        iphone.exibirPaginaAtual();

        // Trocar para a terceira aba e exibir a página atual
        iphone.trocarAbaAtual(3);
        iphone.exibirPaginaAtual();
        iphone.verTodasAbas();

        // Selecionar uma música e tocar
        iphone.selecionarMusica("Música 1");
        iphone.tocarMusica();
        iphone.pausarMusica();

        // Aumentar e diminuir o volume
        iphone.aumentarVolume();
        iphone.diminuirVolume();

        // Fazer uma ligação
        iphone.ligar(123456789);
        iphone.atender();
        iphone.iniciarCorreioVoz();
    }
}