package com.hacker;

import java.util.Scanner;

import com.hacker.manage.FilesFacadeIO;

public class Main {
    public static void main(String[] args) {
        Scanner leituraEntrada = new Scanner(System.in);

        /* 
        System.out.println("Digite a forma de separação ");
        String separator = leituraEntrada.next();
        leituraEntrada.nextLine();*/

        FilesFacadeIO.differences();
    }
}