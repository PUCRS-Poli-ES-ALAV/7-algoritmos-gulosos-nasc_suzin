package main.src;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Stack;

public class Tabuleiro {

    public static final int TAM_TABULEIRO = 7;

    private Stack<Rainha> pilha;

    private int numero_rainhas;

    private ArrayList<Rainha> listaRainhas;

    private ArrayList<ArrayList<PosicaoTabuleiro>> matriz;

    private int contadorRainhas;


    public Tabuleiro(int numero_rainhas) {

        if(numero_rainhas>7 || numero_rainhas <2){
            throw new InvalidParameterException("Numero de rainhas deve ser maior que 1 e menor que 8");
        }

        this.contadorRainhas = 0;
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
            this.listaRainhas.add(new Rainha(i));
        }
    }

    public boolean alocaRainhas(int coluna, int linha){
        // se a pilha estiver cheia, retorna true
        if(this.pilha.size()==numero_rainhas){
            return true;
        }

        // caso a pilha nao esteja cheia, procura a posicao para a proxima rainha;

        for (int i = linha; i < TAM_TABULEIRO; i++) {
            for (int j = coluna; j < TAM_TABULEIRO; j++) {
                if (!this.matriz.get(i).get(j).isEstaOcupado()) {
                    var rainha = this.listaRainhas.get(this.contadorRainhas++);
                    rainha.setPosicao(linha,coluna);
                    this.matriz.get(i).get(j).setRainha(rainha);
                    this.pilha.push(rainha);
                    ocupaCampos(rainha);
                }
            }
        }


        return true;
    }

    private void ocupaCampos(Rainha rainha) {
        ocupaLinha(rainha.getLinha());
        ocupaColuna(rainha.getColuna());
        ocupaDiagonal(rainha);
    }

    private void ocupaDiagonal(Rainha rainha) {
        for (int i = rainha.getColuna(); i < TAM_TABULEIRO; i++) {
            for (int j = rainha.getLinha(); j < TAM_TABULEIRO; j++) {

            }
        }

        for (int i = rainha.getColuna(); i < TAM_TABULEIRO; i++) {
            for (int j = rainha.getLinha(); j > 0; j--) {

            }
        }

        for (int i = rainha.getColuna(); i > 0; i--) {
            for (int j = rainha.getLinha(); j < TAM_TABULEIRO; j++) {

            }
        }

        for (int i = rainha.getColuna(); i > 0 ; i--) {
            for (int j = rainha.getLinha(); j > 0; j--) {

            }
        }

    }

    private void ocupaColuna(int coluna) {
        for (int i = 0; i < TAM_TABULEIRO; i++) {
            this.matriz.get(coluna).get(i).setEstaOcupado(true);
        }
    }

    private void ocupaLinha(int linha) {
        for (int i = 0; i < TAM_TABULEIRO; i++) {
            this.matriz.get(i).get(linha).setEstaOcupado(true);
        }
    }
}
