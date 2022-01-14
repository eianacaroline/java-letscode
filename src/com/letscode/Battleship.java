package com.letscode;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Battleship {
    public static void main (String[] args) {
        int tamanhoTabuleiro = 10;
        char navio = 'N';
        char agua = '-';
        char acerto = 'X';
        char erro = 'O';
        int naviosTotal = 10;
        char[][] tabuleiro = createTabuleiro(tamanhoTabuleiro, agua, navio, naviosTotal);
        printTabuleiro(tabuleiro, agua, navio);
        int naviosEscondidos = naviosTotal;
        while (naviosEscondidos > 0) {
            int[] guessCoordenadas = getCoodernadasJogador(tamanhoTabuleiro);
            char localizacaoUpdate = evaluateGuesAndGetTarget(guessCoordenadas, tabuleiro, navio, agua, acerto, erro);
            if (localizacaoUpdate == acerto) {
                naviosEscondidos--;
            }
            tabuleiro = updateTabuleiro(tabuleiro, guessCoordenadas, localizacaoUpdate);
            printTabuleiro(tabuleiro, agua, navio);
        }
        System.out.print("VocÊ ganhou!");
    }

    private static char[][] updateTabuleiro(char[][] tabuleiro, int[] guessCoordenadas, char localizacaoUpdate) {
        int row = guessCoordenadas[0];
        int col = guessCoordenadas[1];

        tabuleiro[row][col] = localizacaoUpdate;
        return tabuleiro;
    }

    private static char evaluateGuesAndGetTarget(int[] guessCoordenadas, char[][] tabuleiro, char navio, char agua, char acerto, char erro) {
        String mensagem;
        int row = guessCoordenadas[0];
        int col = guessCoordenadas[1];
        char target = tabuleiro[row][col];
        if (target == navio) {
            mensagem = "Acertou!";
            target = acerto;
        }

        else if (target == agua){
            mensagem = "Errou!";
            target = erro;
        }

        else {
            mensagem = "Atire!";
        }
        System.out.println(mensagem);
        return target;
    }

    private static int[] getCoodernadasJogador(int tamanhoTabuleiro) {
        int row;
        int col;
        do {
            System.out.print("Linha: ");
            row = new Scanner(System.in).nextInt();
        }
        while ( row < 0 || row > tamanhoTabuleiro);
        do {
            System.out.print("Coluna: ");
            col = new Scanner(System.in).nextInt();
        } while (col < 0 || col > tamanhoTabuleiro);
        return new int[] {row, col};
    }

    private static void printTabuleiro(char[][] tabuleiro, char agua, char navio) {
        int tamanhoTabuleiro = tabuleiro.length;
        System.out.println("---------------------------------------------");
        System.out.println("                JOGADOR");
        System.out.println("---------------------------------------------");
        System.out.print("    | ");
        for (int i = 0; i < tamanhoTabuleiro; i++){
            System.out.print(i + " | ");
        }
        System.out.println();
        for (int row = 0; row < tamanhoTabuleiro; row++) {
            String[] alfabeto = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
            System.out.print("| " + alfabeto[row] + " | ");
            for (int col = 0; col < tamanhoTabuleiro; col++) {
                char posicao = tabuleiro[row][col];
                if (posicao == navio) {
                    System.out.print(agua + " | ");
                }
                else {
                    System.out.print(posicao + " | ");
                }
            }
            System.out.println();
        }
        System.out.println("---------------------------------------------");
    }

    private static char[][] createTabuleiro(int tamanhoTabuleiro, char agua, char navio, int naviosTotal) {
        char[][] tabuleiro = new char[tamanhoTabuleiro][tamanhoTabuleiro];
        for (char[] row: tabuleiro) {
            Arrays.fill(row, agua);
        }
        return spawNavios(tabuleiro, naviosTotal, agua, navio);
    }

    private static char[][] spawNavios(char[][] tabuleiro, int naviosTotal, char agua, char navio) {
        int naviosColocados = 0;
        int tamanhoTabuleiro = tabuleiro.length;
        while(naviosColocados < naviosTotal) {
            int[] location = generateNavios(tamanhoTabuleiro);
            char espaco = tabuleiro[location[0]][location[1]];
            if (espaco == agua) {
                tabuleiro[location[0]][location[1]] = navio;
                naviosColocados++;
            }
        }
        return tabuleiro;
    }

    private static int[] generateNavios(int tamanhoTabuleiro) {
        int[] coordenadas = new int[2];
        for (int i = 0; i < coordenadas.length; i++) {
            coordenadas[i] = new Random().nextInt(tamanhoTabuleiro);
        }
        return coordenadas;
    }
}
