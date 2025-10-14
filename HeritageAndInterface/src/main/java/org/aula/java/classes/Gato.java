package org.aula.java.classes;

public class Gato extends Animal {

    public Gato(ID id, Nome nome){
        super(id, nome);
    }

    public Gato(){
        super();
    }

    @Override
    public void movimentar(){
        
    }

    @Override
    public void emitirSom(){
        System.out.println("Miau");
    }
}
