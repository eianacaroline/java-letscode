package com.letscode;

import java.util.Arrays;
import java.util.Random;

public class Battleship {
    public static void main (String[] args) {
        int tamanhoTabuleiro = 10;
        char navio = 'N';
        char tiroCerteiro = '*';
        char agua = '-';
        char acerto = 'X';
        char aguaNavio = 'n';
        int naviosTotal = 10;
        char[][] tabuleiro = createTabuleiro(tamanhoTabuleiro, agua, navio, naviosTotal);
        printTabuleiro(tabuleiro, agua, navio);
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
