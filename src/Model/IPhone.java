package Model;

import Interfaces.Navegador;
import Interfaces.ReprodutorMusical;
import Interfaces.Telefone;

import java.sql.SQLOutput;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class IPhone implements ReprodutorMusical, Telefone, Navegador {
    private String anoLancamento;
    private String musicaAtual = "";
    private Boolean statusMusica = false;
    private int volume;
    private int abaAtual;

    private final LinkedHashMap<Integer, String> abas;


    public IPhone(String anoLancamento) {
        this.abas = new LinkedHashMap<>();
        this.anoLancamento = anoLancamento;
        this.abas.put(0, "Home");
        this.volume = 50;
        this.abaAtual = 0;
    }

    public String getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(String anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    @Override
    public void exibirPaginaAtual() {
        System.out.println(this.abas.get(this.abaAtual));
    }

    @Override
    public void adicionarNovaAba() {
        this.abas.put(this.abas.size()+1, "Home");
    }

    @Override
    public void verTodasAbas() {
        System.out.println(this.abas);
    }

    @Override
    public void fecharAbaAtual() {
        if(this.abas.size() > 1) {
            this.abas.remove(this.abaAtual);

            // Atualizar os IDs das abas restantes
            int newId = 0;
            LinkedHashMap<Integer, String> newAbas = new LinkedHashMap<>();
            for (Map.Entry<Integer, String> entry : this.abas.entrySet()) {
                newAbas.put(newId, entry.getValue());
                newId++;
            }
            this.abas.clear();
            this.abas.putAll(newAbas);

            this.abaAtual = this.abas.size() - 1;
        } else {
            System.out.println("É necessário ter ao menos uma aba");
        }
    }

    @Override
    public void trocarAbaAtual(int idAba) {
        if(idAba >= 0 && idAba < this.abas.size())
            this.abaAtual = idAba;
        else
            System.out.println("Página inválida");
    }

    @Override
    public void trocarUrlAbaAtual(String url) {
        this.abas.put(this.abaAtual, url);
    }

    @Override
    public void selecionarMusica(String musica) {
        this.musicaAtual = musica;
    }

    @Override
    public void tocarMusica() {
        if (!this.musicaAtual.isEmpty()) {
            System.out.println("Tocando " + musicaAtual);
            this.statusMusica = true;
        } else
            System.out.println("Nenhuma musica selecionada");
    }

    @Override
    public void pausarMusica() {
        if (!this.musicaAtual.isEmpty()) {
            System.out.println("Pausando " + musicaAtual);
            this.statusMusica = false;
        } else
            System.out.println("Nenhuma musica selecionada");
    }

    @Override
    public void aumentarVolume() {
        if (this.volume < 100)
            this.volume += 10;

        System.out.println("Volume atual: " + this.volume);
    }

    @Override
    public void diminuirVolume() {
        if (this.volume > 10)
            this.volume -= 10;

        System.out.println("Volume atual: " + this.volume);
    }

    @Override
    public void ligar(int numero) {
        System.out.println("Ligando para o numero " + numero);
    }

    @Override
    public void atender() {
        System.out.println("Atendendo ligação...");
    }

    @Override
    public void iniciarCorreioVoz() {
        System.out.println("Correio de voz iniciado... Você tem " + new Random().nextInt(6) + " novas mensagens para ser escutadas.");
    }
}
