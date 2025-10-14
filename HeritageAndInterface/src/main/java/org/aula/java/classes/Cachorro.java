package org.aula.java.classes;

public class Cachorro extends Animal {

    public Cachorro(ID id, Nome nome){
        super(id, nome);
    }

    public Cachorro(){
        super();
    }

    @Override
    public void movimentar(){
        
    }

    @Override
    public void emitirSom(){
        System.out.println("Au");
        System.out.println("Au");
    }

}

