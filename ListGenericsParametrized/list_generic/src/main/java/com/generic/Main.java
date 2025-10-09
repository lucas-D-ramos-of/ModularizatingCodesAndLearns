package com.generic;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import com.object.Employee;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        //Todo: ler arquivo TEXTO, ordenar valores e exibir na tela
        //dados: nome, salário

        Path path = Paths.get( System.getProperty("user.dir")+"\\ListGenericsParametrized\\list_generic\\src\\main\\java\\com\\generic\\data\\employees.txt");

        BufferedReader bf;

        String line;
        String[] valueLine;

        List<Employee> employees = new ArrayList<>();

        try {
            bf = new BufferedReader( new FileReader(path.toString()));

            while ( (line = bf.readLine()) != null){

                valueLine = line.split(",");
                employees.add( new Employee(valueLine[0], Double.parseDouble(valueLine[1]) ));

            }

            Collections.sort(employees);

            for(var e : employees){
                System.out.println(e);
            }

            bf.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        

    }
}