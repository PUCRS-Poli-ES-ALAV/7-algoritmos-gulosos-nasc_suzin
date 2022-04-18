package main.src;

import javax.management.StandardMBean;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Stack;

import static java.util.Objects.nonNull;

public class Tabuleiro {

    public static final int TAM_TABULEIRO = 7;

    private Stack<Rainha> pilha;

    private int numero_rainhas;

    private ArrayList<Rainha> listaRainhas;

    private ArrayList<ArrayList<PosicaoTabuleiro>> matriz;


    public Tabuleiro(int numero_rainhas) {

        if(numero_rainhas>7 || numero_rainhas <2){
            throw new InvalidParameterException("Numero de rainhas deve ser maior que 1 e menor que 8");
        }

        this.numero_rainhas = numero_rainhas;
        this.pilha = new Stack<>();
        this.matriz = new ArrayList<>();
        for (int i = 0; i < TAM_TABULEIRO; i++) {
            this.matriz.add(new ArrayList<>());
            for (int j = 0; j < TAM_TABULEIRO; j++) {
                this.matriz.get(i).add(new PosicaoTabuleiro());
            }
        }

        this.listaRainhas = new ArrayList<>(numero_rainhas);
        for (int i = 0; i < numero_rainhas; i++) {
            var rainha = new Rainha(i);
            this.listaRainhas.add(rainha);
            this.pilha.push(rainha);
        }
    }

    public int alocaRainhas(int linha_param,int coluna_param){
        // se a pilha estiver cheia, retorna true
        if(this.pilha.size()==0){
            return this.numero_rainhas;
        }
        // caso a pilha nao esteja cheia, procura a posicao para a proxima rainha;
        int col = coluna_param;
        for (int lin = linha_param; lin < TAM_TABULEIRO; lin++) {
            for (col = 0; col < TAM_TABULEIRO; col++) {
                if (!this.matriz.get(lin).get(col).isEstaOcupado()) {
                        var rainha = this.pilha.pop();
                        rainha.setPosicao(lin,col);
                        this.matriz.get(lin).get(col).setRainha(rainha);
                        ocupaCampos(rainha);
                        return alocaRainhas(lin+1,col);
                }
            }
        }

        if(!this.pilha.empty()){

        }

        return this.numero_rainhas - this.pilha.size();
    }

    private void ocupaCampos(Rainha rainha) {
        ocupaLinha(rainha.getLinha());
        System.out.println(print());
        ocupaColuna(rainha.getColuna());
        System.out.println(print());
        ocupaDiagonal(rainha);
        System.out.println(print());
    }

    private void ocupaDiagonal(Rainha rainha) {
        int linha = rainha.getLinha();
        for (int coluna = rainha.getColuna(); coluna < TAM_TABULEIRO && linha < TAM_TABULEIRO; coluna++) {
            this.matriz.get(linha).get(coluna).setEstaOcupado(true);
            linha++;
        }

        linha = rainha.getLinha();
        for (int coluna = rainha.getColuna(); coluna < TAM_TABULEIRO && linha > 0; coluna++) {
            this.matriz.get(linha).get(coluna).setEstaOcupado(true);
            linha--;
        }

        linha = rainha.getLinha();
        for (int coluna = rainha.getColuna(); coluna > 0 && linha < TAM_TABULEIRO; coluna--) {
            this.matriz.get(linha).get(coluna).setEstaOcupado(true);
            linha++;
        }

        linha = rainha.getLinha();
        for (int coluna = rainha.getColuna(); coluna > 0 && linha > 0; coluna--) {
            this.matriz.get(linha).get(coluna).setEstaOcupado(true);
            linha--;
        }

    }

    private void ocupaColuna(int coluna) {
        for (int linha = 0; linha < TAM_TABULEIRO; linha++) {
            this.matriz.get(linha).get(coluna).setEstaOcupado(true);
        }
    }

    private void ocupaLinha(int linha) {
        for (int coluna = 0; coluna < TAM_TABULEIRO; coluna++) {
            this.matriz.get(linha).get(coluna).setEstaOcupado(true);
        }
    }

    public String print() {
        StringBuilder sb = new StringBuilder();

        sb.append("..........................................").append("\n");
        for (int linha = 0; linha < TAM_TABULEIRO; linha++) {
            sb.append("\n");
            for (int coluna = 0; coluna < TAM_TABULEIRO; coluna++) {
                sb.append(" | ").append(nonNull(this.matriz.get(linha).get(coluna).getRainha()) ? this.matriz.get(linha).get(coluna).getRainha().getId() : (this.matriz.get(linha).get(coluna).isEstaOcupado()?"*":" "));

            }

        }
        sb.append("\n...........................................");
        return sb.toString();
    }
}
