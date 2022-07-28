package org.example.demo;

import org.example.entities.Aluno;
import org.example.models.AlunoModel;

import java.util.List;

public class GestaoCursosMain {
    public static void main(String[] args) {
        Aluno alunoModel = new Aluno();

        Aluno p1 = new Aluno();
        p1.setNomeCompleto("Maikon J F Soares");
        p1.setMatricula("2911MJ");
        p1.setEmail("jakson@teste.com");

        // 1) Criando um paluno
        AlunoModel.create(p1);

        //2) Buscando todos os produtos na base de dados
        List<Aluno> alunos = AlunoModel.findAll();
        System.out.println("Qtde de produtos encontrados : " + alunos.size());
    }
}