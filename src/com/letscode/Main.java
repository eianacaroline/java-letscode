package com.letscode;

import com.letscode.aula2.AreaQuadrado;
import com.letscode.aula2.Avatar;
import com.letscode.aula2.Media;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//	    String name = "Ana";
//        int idade = 21;
//        float altura = 1.68f;
//        System.out.printf("Meu nome é %s, tenho %d anos e %.2f de altura %n", name, idade, altura);
//
//        AreaQuadrado areaQuadrado = new AreaQuadrado();
//        System.out.println("Valor da área: " + areaQuadrado.area);
//
//        Media media = new Media();
//        System.out.println("Valor da média: " + media.total);
//
//        System.out.println("Estes são os elementos de avatar: " + java.util.Arrays.asList(Avatar.Elements.values()));

        Scanner inputUser = new Scanner(System.in);

        System.out.println("Digite abaixo o primeiro número: ");
        int numeroUm = inputUser.nextInt();

        System.out.println("Digite abaixo o segundo número: ");
        int numeroDois = inputUser.nextInt();

        System.out.printf("Soma: %d %nSubtração: %d %nMultiplicação: %d %nDivisão: %d%n", numeroUm+numeroDois, numeroUm-numeroDois, numeroUm*numeroDois, numeroUm/numeroDois);

//        final double convertLb = 2.20462;
//        final double kilo = 1000;
//        System.out.printf("%skg convertidos para libra ficam em %slb", kilo, kilo*convertLb);

        //final float dolar = 5.65f;
        //final float euro = 6.39f;

        //System.out.println("Informe a seguir o valor em real que deseja converter: ");
        //float real = inputUser.nextFloat();

        //System.out.printf("O valor informado foi: R$%.2f%nVocê possui $%.2f dólares e €%.2f euros", real, real/dolar, real/euro);


//        System.out.println("Informe seu nome: ");
//        String nameUser = inputUser.nextLine();
//
//        System.out.println("Informe sua idade: ");
//        int ageUser = inputUser.nextInt();
//
//        System.out.printf("Seu nome é %S! %n", nameUser);
//        System.out.printf("Sua idade é %d, %s!", ageUser, nameUser);


    }
}
