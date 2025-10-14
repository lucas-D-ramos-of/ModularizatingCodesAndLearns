package org.aula.java.classes;

public abstract class Animal implements Comparable<Animal>, InterfaceAnimal{

    private ID id;
    private Nome nome;

    public Animal(ID id, Nome nome){

        this.id = id;
        this.nome = nome;
    }

    public Animal(){
        id = new ID(-1);
        nome = new Nome("-");
    }

    @Override
    public String toString(){
        return String.format("ID: %d, Nome: %s", id.ID(), nome.NOME());
    }
    
    @Override
    public int compareTo(Animal outro) {
        return this.nome.NOME().compareTo( outro.nome.NOME());
    }

}
