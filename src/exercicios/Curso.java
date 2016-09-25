package exercicios;

public class Curso{
    private int idCurso;
    private String nome;
    private double cargaHorario;
    
    public Curso(){
        idCurso= 0; 
        nome="";
        cargaHorario=0;
    }
    
    public Curso(String nome, Double cargaHorario,int id){
        this.idCurso=id;
        this.nome=nome;
        this.cargaHorario=cargaHorario;
    }
    
    public void imprimir(){
        System.out.println("Curso: "+this.getNome()+"; Carga horaria: "+this.getCargaHorario()+"; Id: "+this.idCurso);
    }
    
    public void imprimir(int cont){
        System.out.println("Curso: "+this.getNome()+"; Carga horaria: "+this.getCargaHorario()+"; Id: "+cont);
    }
    
    public String criarCSV(){
        return this.nome+";"+Double.toString(this.cargaHorario)+";";
    }
    
    public void convertString(String texto){
        String[] split = texto.split(";");
        this.nome = split[0];
        this.cargaHorario = Double.parseDouble(split[1]);
        this.idCurso = Integer.parseInt(split[2]);
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
     * @return the cargaHorario
     */
    public double getCargaHorario() {
        return cargaHorario;
    }

    /**
     * @param cargaHorario the cargaHorario to set
     */
    public void setCargaHorario(double cargaHorario) {
        this.cargaHorario = cargaHorario;
    }

    /**
     * @return the idCurso
     */
    public int getId() {
        return idCurso;
    }

    /**
     * @param id the idCurso to set
     */
    public void setId(int id) {
        this.idCurso = id;
    }
    
}
