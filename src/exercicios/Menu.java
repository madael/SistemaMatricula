/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicios;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Daniel Lucarelli
 */
public class Menu {

    static void menu1() {
        System.out.println("1. Cadastra curso ");
        System.out.println("2. Cadastra aluno ");
        System.out.println("3. Matricular aluno ");
        System.out.println("4. Jogo de dados ");
        System.out.println("5. Salvar alunos, cursos e matriculas em arquivo ");
        System.out.println("6. Importar alunos e cursos para matricular  ");
        System.out.println("7. Imprimir ");
        System.out.println("8. Salvar no BD ");
        System.out.println("9. Importa do BD ");
        System.out.println("0. Sair");
        System.out.println("Informe sua opção: ");
    }

    public static void rodar() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Matricula> matriculas = new ArrayList<>();
        ArrayList<Aluno> alunos = new ArrayList<>();
        ArrayList<Curso> cursos = new ArrayList<>();
        int X = 1;
        Curso curso;
        Aluno aluno;
        Matricula matricula;
        while (X != 0) {
            menu1();
            X = scanner.nextInt();
            aluno = new Aluno();
            curso = new Curso();
            matricula = new Matricula();
            switch (X) {
                case 1:
                    System.out.println("Informe o nome do curso: ");
                    curso.setNome(scanner.next());
                    System.out.println("Informe a carga horaria: ");
                    curso.setCargaHorario(scanner.nextInt());
                    cursos.add(curso);
                    break;
                case 2:
                    System.out.println("Informe o nome do aluno: ");
                    aluno.setNome(scanner.next());
                    System.out.println("Informe o cpf do aluno: ");
                    aluno.setCpf(scanner.next());
                    alunos.add(aluno);
                    break;
                case 3:
                    int CONT = 0;
                    for (Aluno a : alunos) {
                        a.imprimir();
                    }
                    CONT = 0;
                    for (Curso c : cursos) {
                        c.imprimir();
                    }
                    System.out.println("Escolha o codigo do curso e o codigo do aluno para matricular-lo no curso: ");
                    System.out.print("Digite o codigo do aluno: ");
                    matricula.setAluno(alunos.get(scanner.nextInt()));
                    System.out.print("Digite o codigo do curso: ");
                    matricula.setCurso(cursos.get(scanner.nextInt()));
                    matricula.setData("00/00/0000");
                    matriculas.add(matricula);
                    break;
                case 4:
                    String p1,
                     p2;
                    System.out.println("Digite o nome do jogador 1:");
                    p1 = scanner.next();
                    System.out.println("Digite o nome do jogador 2:");
                    p2 = scanner.next();
                    Aleatorio.jogarDado(p1, p2);
                    break;
                case 5:
                    String alun = "Alunos[nome, cpf, id]: \r\n",
                     matri = "Matriculas[cod_aluno, cod_curso, data, id]: \r\n",
                     curs = "Cursos[nome, carga_horaria, id]: \r\n",
                     endereco;
                    for (Aluno a : alunos) {
                        alun += a.criarCSV() + "\r\n";
                    }
                    for (Curso c : cursos) {
                        curs += c.criarCSV() + "\r\n";
                    }
                    for (Matricula m : matriculas) {
                        matri += m.criarCSV() + "\r\n";
                    }
                    System.out.println(alun + matri + curs);
                    System.out.println("Digite o endereço do arquivo: ");
                    endereco = scanner.next();
                    Arquivo.escrever(alun, endereco + "\\Aluno.txt", false);
                    Arquivo.escrever(curs, endereco + "\\Curso.txt", false);
                    Arquivo.escrever(matri, endereco + "\\Matricula.txt", false);
                    break;
                case 6:
                    CONT=0;
                    System.out.println("Digite o endereço do arquivo: ");
                    endereco = scanner.next();
                    String endAux = endereco;
                    String[] texto = Arquivo.ler(endAux += "\\Aluno.txt").split("\n");  
                    System.out.println(texto.length);
                    for (int i = 0; i < texto.length; i++) {                        
                        aluno.convertString(texto[i]);
                        alunos.add(aluno);
                        aluno.imprimir(CONT++);
                        aluno=new Aluno();
                    }
                    CONT=0;
                    endAux = endereco;
                    texto = Arquivo.ler(endAux += "\\Curso.txt").split("\n");
                    for (int i = 0; i < texto.length; i += 2) {
                        curso.convertString(texto[i]);
                        cursos.add(curso);
                        curso.imprimir(CONT++);
                        curso = new Curso();
                    }
                    CONT=0;
                    System.out.println("Escolha o codigo do curso e o codigo do aluno para matricular-lo no curso: ");
                    System.out.print("Digite o codigo do aluno: ");
                    matricula.setAluno(alunos.get(scanner.nextInt()));
                    System.out.print("Digite o codigo do curso: ");
                    matricula.setCurso(cursos.get(scanner.nextInt()));
                    matricula.setIdMatricula(CONT++);
                    matricula.setData("00/00/0000");
                    matriculas.add(matricula);
                    break;
                case 7:
                    System.out.println("Alunos; ");
                    for (Aluno a : alunos) {
                        a.imprimir();
                    }
                    System.out.println("Cursos; ");
                    for (Curso c : cursos) {
                        c.imprimir();
                    }
                    System.out.println("Matriculas; ");
                    for (Matricula m : matriculas) {
                        m.imprimir();
                    }
                    break;
                case 8:
                    if (ConexaoBD.conexao() != null) {
                        for (Aluno a : alunos) {
                            AlunoDAO.adiciona(a);
                        }
                        for (Curso c : cursos) {
                            CursoDAO.adiciona(c);
                        }
                        for (Matricula m : matriculas) {
                            MatriculaDAO.adiciona(m);
                        }
                    }
                    break;
                case 9:
                    if (ConexaoBD.conexao() != null) {
                        alunos = AlunoDAO.consulta();
                        cursos = CursoDAO.consulta();
                        matriculas = MatriculaDAO.consulta();
                    }
                case 0:
                    break;
                default:
                    System.out.println(">>> Opção invalida <<< ");
                    break;
            }
        }
        //
        // TODO code application logic here
    }
}
