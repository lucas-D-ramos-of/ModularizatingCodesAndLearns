package com.hacker.manage;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FilesFacadeIO {

    private static final String INPUT = "inputfile.txt";
    private static final String OUTPUT = "outputfile.txt";
    private static final String RELATIVE_PATH = "testcaseverifydifference\\src\\main\\java\\com\\hacker\\iofiles\\";

    public static List<String> readFiles(String path){

        List<String> result = new ArrayList<>();

        try (BufferedReader bf = new BufferedReader(
            new FileReader(RELATIVE_PATH+path))){

                String line;

                while ( (line = bf.readLine()) != null){

                    result.add(line);
                }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        return result;
    }
    public static void differences(){

        List<String> input = readFiles(INPUT);
        List<String> output = readFiles(OUTPUT);

        for(int i = 0; i < input.size(); i++){

            if ( !input.get(i).equals(output.get(i))){
                System.out.println(
                    String.format("ID: %d\n Input: %s\nOutput: %s\n\n", i, input.get(i), output.get(i))
                );
            }

        }

    }
}
