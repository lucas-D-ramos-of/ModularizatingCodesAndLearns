package org.aula.java.classes;

public interface InterfaceAnimal {

    public void emitirSom();
    public void movimentar();

    default void piscar(){
        System.out.println("Piscou");
    }
}
