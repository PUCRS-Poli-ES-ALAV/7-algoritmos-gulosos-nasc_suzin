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

    public int alocaRainhas(int coluna, int linha){
        // se a pilha estiver cheia, retorna true
        if(this.pilha.size()==0){
            return this.numero_rainhas;
        }
        // caso a pilha nao esteja cheia, procura a posicao para a proxima rainha;

        for (int i = linha; i < TAM_TABULEIRO; i++) {
            for (int j = coluna; j < TAM_TABULEIRO; j++) {
                if (!this.matriz.get(i).get(j).isEstaOcupado()) {
                        var rainha = this.pilha.pop();
                        rainha.setPosicao(i,j);
                        this.matriz.get(j).get(i).setRainha(rainha);
                        ocupaCampos(rainha);
                        return alocaRainhas(i, j+1);
                }
            }
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
        int j = rainha.getLinha();
        for (int i = rainha.getColuna(); i < TAM_TABULEIRO && j < TAM_TABULEIRO; i++) {
            this.matriz.get(i).get(j).setEstaOcupado(true);
            j++;
        }

        j = rainha.getLinha();
        for (int i = rainha.getColuna(); i < TAM_TABULEIRO && j > 0; i++) {
            this.matriz.get(i).get(j).setEstaOcupado(true);
            j--;
        }

        j = rainha.getLinha();
        for (int i = rainha.getColuna(); i > 0 && j < TAM_TABULEIRO; i--) {
            this.matriz.get(i).get(j).setEstaOcupado(true);
            j++;
        }

        j = rainha.getLinha();
        for (int i = rainha.getColuna(); i > 0 && j > 0; i--) {
            this.matriz.get(i).get(j).setEstaOcupado(true);
            j--;
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

    public String print() {
        StringBuilder sb = new StringBuilder();

        sb.append("..........................................").append("\n");
        for (int i = 0; i < TAM_TABULEIRO; i++) {
            sb.append("\n");
            for (int j = 0; j < TAM_TABULEIRO; j++) {
                sb.append(" | ").append(nonNull(this.matriz.get(j).get(i).getRainha()) ? this.matriz.get(j).get(i).getRainha().getId() : (this.matriz.get(j).get(i).isEstaOcupado()?"*":" "));

            }

        }
        sb.append("\n...........................................");
        return sb.toString();
    }
}
