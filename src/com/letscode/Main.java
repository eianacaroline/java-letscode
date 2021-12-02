package com.letscode;

import com.letscode.aula2.AreaQuadrado;
import com.letscode.aula2.Avatar;
import com.letscode.aula2.Media;

public class Main {

    public static void main(String[] args) {
	    String name = "Ana";
        System.out.println("Hello World, " + name);

        AreaQuadrado areaQuadrado = new AreaQuadrado();
        System.out.println("Valor da área: " + areaQuadrado.area);

        Media media = new Media();
        System.out.println("Valor da média: " + media.total);

        System.out.println("Estes são os elementos de avatar: " + java.util.Arrays.asList(Avatar.Elements.values()));
    }
}
