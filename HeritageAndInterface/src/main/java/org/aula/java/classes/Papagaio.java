package org.aula.java.classes;

public class Papagaio extends Animal {

    public Papagaio(ID id, Nome nome){
        super(id, nome);
    }

    public Papagaio(){
        super();
    }

    @Override
    public void movimentar(){
        
    }

    @Override
    public void emitirSom(){
        System.out.println("Pruu");
    }
}
