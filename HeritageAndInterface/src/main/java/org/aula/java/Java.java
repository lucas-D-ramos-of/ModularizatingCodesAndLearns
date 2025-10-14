
package org.aula.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.aula.java.classes.Animal;
import org.aula.java.classes.Cachorro;
import org.aula.java.classes.Gato;
import org.aula.java.classes.ID;
import org.aula.java.classes.Nome;
import org.aula.java.classes.Papagaio;

public class Java {

    public static void main(String[] args) {

        List<Animal> animais = new ArrayList<>();

        try(BufferedReader bf = new BufferedReader( 
            new FileReader ( 
                "HeritageAndInterface\\src\\main\\java\\org\\aula\\java\\data\\arquivos.csv"))){

            String[] animal;
            String linha;
            int i = 1;

            while ( (linha = bf.readLine()) != null){

                animal = linha.split(",");

                switch(animal[2]){
                    case "GATO" -> {
                        animais.add(new Gato(
                            new ID(i),
                            new Nome(animal[0])
                        ));
                    }
                    case "CACHORRO" -> {
                        animais.add(new Cachorro(
                            new ID(i),
                            new Nome(animal[0])
                        ));
                    }
                    case "PAPAGAIO" -> {
                        animais.add(new Papagaio(
                            new ID(i),
                            new Nome(animal[0])
                        ));
                    }
                    default -> {}
                }

                i++;
            }
            

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        Collections.sort(animais);
        
        for(Animal a : animais){
            System.out.println(a);
        }
    }
}
