package main.src;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // MOEDAS
//        setMoedas(10, 12, 3, 7, 2);
//
//        ArrayList<Integer> moedasNecessarias;
//
//        moedasNecessarias = MoedasUtil.melhorCombinacao(289);
//
//        System.out.println(moedasNecessarias.toString());



        //RAINHAS

        var scanner = new Scanner(System.in);
        System.out.println("Digite a quantidade de rainhas desejadas no tabuleiro: ");
        Tabuleiro tabuleiro = new Tabuleiro(scanner.nextInt());

        System.out.println(tabuleiro.alocaRainhas(0, 0));
        System.out.println(tabuleiro.print());
    }

    private static void setMoedas(int um, int cinco, int dez, int vinteCinco, int cem) {
        Moeda.setQntUM(um);
        Moeda.setQntCINCO(cinco);
        Moeda.setQntDEZ(dez);
        Moeda.setQntVINTE_CINCO(vinteCinco);
        Moeda.setQntCEM(cem);
    }

}
