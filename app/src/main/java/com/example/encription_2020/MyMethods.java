package com.example.encription_2020;

public class MyMethods {

    String codifica (String a, String b) {
        String texto,llave,resultado;char[] arreglo,arreglollave;
        texto=a; llave=b;resultado=""; arreglo = texto.toCharArray();int key;
        arreglollave=llave.toCharArray();
        char auxca;int[]aux = new int[texto.length()];
        key=(int)arreglollave[0];
        for (int i = 0; i <texto.length() ; i++) {
            aux[i]=(int)arreglo[i];
            aux[i]=aux[i]+key;

            auxca=(char)aux[i];
            resultado = resultado + auxca;
        }

        return resultado;
    }

    String decodifica (String a, String b) {

        String texto,llave,resultado;char[] arreglo,arreglollave;int key;
        texto=a; llave=b;resultado=""; arreglo = texto.toCharArray();
        char auxca;int[]aux = new int[texto.length()];arreglollave=llave.toCharArray();
        key=(int)arreglollave[0];
        for (int i = 0; i <texto.length() ; i++) {
            aux[i]=(int)arreglo[i];
            aux[i]=aux[i]-key;

            auxca=(char)aux[i];
            resultado = resultado + auxca;
        }

        return resultado;

    }
}
