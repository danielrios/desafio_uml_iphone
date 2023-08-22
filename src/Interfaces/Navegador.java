package Interfaces;

public interface Navegador {
    public void exibirPaginaAtual();
    public void adicionarNovaAba();

    public void verTodasAbas();
    public void fecharAbaAtual();
    public void trocarAbaAtual(int idAba);
    public void trocarUrlAbaAtual(String url);
}
