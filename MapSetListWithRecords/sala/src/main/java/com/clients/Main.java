package com.clients;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.classes.Student;

public class Main {

    private static List<String> alunos = new ArrayList<>();
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Escolha o exercicio para visualizar:");
        System.out.println("| 1- Listar alunos");
        System.out.println("| 2- Listar votos para representante de sala");
        System.out.println("");
        int escolha = entrada.nextInt();
        
        String[] alunosDados;
        alunos = leituraArquivo("students.csv");

        switch(escolha){
            case 1 -> {

                Set<Student> alunosTurmas = new HashSet<>();


                for (String s : alunos){
                    alunosDados = s.split(",");

                    alunosTurmas.add(
                        new Student(Integer.parseInt(alunosDados[0]), alunosDados[1])
                    );
                }
                
                for (var a : alunosTurmas){
                    System.out.println(
                        String.format("Nome: %s, ID: %d", a.name(), a.id())
                        );
                }

            }
            case 2 -> {
                

                Map<Integer, Student> turmaAluno = new HashMap<>();
                Student student;

                for (String s : alunos){
                    alunosDados = s.split(",");

                    student = new Student(Integer.parseInt(alunosDados[0]), alunosDados[1], Integer.parseInt(alunosDados[2]));

                    if (!turmaAluno.containsKey(student.id())){
                        turmaAluno.put(
                            (Integer) student.id(),
                            student
                        );
                    } else {
                        int vote = turmaAluno.get(student.id()).votos();
                        vote += student.votos();
                        turmaAluno.remove(student.id());
                        
                        turmaAluno.put(
                            student.id(),
                            new Student( Integer.parseInt(alunosDados[0]),
                                alunosDados[1], vote
                            )
                        );
                    }

                }
                for (Student st : turmaAluno.values()){
                    System.out.println( String.format(
                            "Nome: %s, ID: %d, Votos: %d", 
                            st.name(), st.id(), st.votos() ));
                }
            }
            default -> {
                System.out.println("Escolha uma opção válida!");
            }
        }
    }

    public static List<String> leituraArquivo(String arquivo){

        String linha;
        List<String> alunos = new ArrayList<>();

        try (BufferedReader bf = new BufferedReader(
            new FileReader(
                "MapSetListWithRecords\\sala\\src\\main\\java\\com\\database\\"+arquivo
            )
        )){

            while ((linha = bf.readLine()) != null){
                alunos.add(linha);
            }

            bf.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        return alunos;
    }

}