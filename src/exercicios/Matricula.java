package exercicios;

import java.util.Scanner;

public class Matricula {
    private int idMatricula;
    private String data;
    private Aluno aluno;
    private Curso curso;
    
    public Matricula(){
        idMatricula=0;
        data="";
        aluno=new Aluno();
        curso=new Curso();
    }
    
    public Matricula(String data, Aluno aluno,Curso curso, int idMatricula){
        this.idMatricula=idMatricula;
        this.data=data;
        this.aluno=aluno;
        this.curso=curso;
    }
    
    public String criarCSV(){
        return this.aluno.criarCSV()+ ";"+ this.curso.criarCSV()+";"+this.data+";"+this.getIdMatricula();
    }
    
    public void matricular(Curso curso){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do aluno: ");
        aluno.setNome(scanner.nextLine());
        System.out.println("Digite o CPF do aluno: ");
        aluno.setCpf(scanner.nextLine());
        System.out.println("Digite a data: ");
        this.setData(scanner.nextLine());
        this.setCurso(curso);        
    }
    
    public void matricular(Aluno aluno, Curso curso,String data){
        this.setAluno(aluno);
        this.setCurso(curso);
        this.setData(data);
    }
    
    public void imprimir(){
        System.out.println("Nome: "+aluno.getNome()+"; Curso: "+curso.getNome()+"; Id: "+getIdMatricula()+"; data: "+ this.data);
    }
    
    public void imprimir(int cont){
        System.out.println("Nome: "+aluno.getNome()+"; Curso: "+curso.getNome()+"; Id: "+cont);
    }
    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the aluno
     */
    public Aluno getAluno() {
        return aluno;
    }

    /**
     * @param aluno the aluno to set
     */
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    /**
     * @return the curso
     */
    public Curso getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    /**
     * @return the idMatricula
     */
    public int getIdMatricula() {
        return idMatricula;
    }

    /**
     * @param idMatricula the idMatricula to set
     */
    public void setIdMatricula(int idMatricula) {
        this.idMatricula = idMatricula;
    }
    
    
}
