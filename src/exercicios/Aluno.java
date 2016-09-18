package exercicios;

public class Aluno {
    private int idAluno;
    private String nome;
    private String cpf;
    
    public Aluno(){
        idAluno = 0;
        nome="";
        cpf="";
    }
    
    public Aluno(String nome, String cpf, int id){
        this.idAluno=id;
        this.nome=nome;
        this.cpf=cpf;        
    }
    
    public void convertString(String texto){
        String[] split = texto.split(";");
        this.nome = split[0];
        this.cpf = split[1];
        this.idAluno = Integer.parseInt(split[2]);
    }
    
    
    public void imprimir(){
        System.out.println("Nome: "+this.getNome()+"; CPF: "+this.getCpf()+"; Id: "+this.idAluno);
    }    
    
    public void imprimir(int cont){
        System.out.println("Nome: "+this.getNome()+"; CPF: "+this.getCpf()+"; Id: "+cont);
    }    
    
    public String criarCSV(){
        return this.nome+";"+this.cpf+";";
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the idAluno
     */
    public int getIdAluno() {
        return idAluno;
    }

    /**
     * @param idAluno the idAluno to set
     */
    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }
    
}
