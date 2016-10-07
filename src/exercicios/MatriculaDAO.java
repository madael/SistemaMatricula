/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Daniel Lucarelli
 */
public class MatriculaDAO {
    
    public static void update(Matricula matricula) {
        String sql = "UPDATE matricula SET codigo_curso = ?, codigo_aluno=?, data_matricula=?  WHERE codigo_matricula=?";
        try {
            PreparedStatement stmt = ConexaoBD.conexao().prepareStatement(sql);
            stmt.setInt(1, matricula.getCurso().getId());
            stmt.setInt(2, matricula.getAluno().getIdAluno());
            stmt.setString(3, matricula.getData());
            stmt.setInt(4, matricula.getIdMatricula());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
    
    public static void remover(Matricula matricula) {
        String sql = "DELETE FROM matricula WHERE codigo_matricula = ?";
        try {
            PreparedStatement stmt = ConexaoBD.conexao().prepareStatement(sql);
            stmt.setLong(1, matricula.getIdMatricula());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
    
    public static void adiciona(Matricula matricula) {
        String sql = "INSERT INTO matricula(codigo_curso,codigo_aluno,data_matricula) VALUES(?,?,?)";
        try {
            PreparedStatement stmt = ConexaoBD.conexao().prepareStatement(sql);
            stmt.setString(3, matricula.getData());
            stmt.setInt(2, matricula.getAluno().getIdAluno());
            stmt.setInt(1, matricula.getCurso().getId());
            stmt.execute();
            stmt.close();

        } catch (SQLException u) {
            System.out.println("Não foi possivel executar o sql matricula");
        }
    }
    
    public static Matricula buscar(int texto){
        Matricula matricula = new Matricula();
        String sql = "Select * from matricula where codigo_matricula="+texto;
        String sqlA,sqlC;
        try {
            PreparedStatement stmt = ConexaoBD.conexao().prepareStatement(sql);
            ResultSet resultset = stmt.executeQuery();
            resultset.next();
            sqlA = "select * from aluno where codigo_aluno="+resultset.getInt(3);                
            sqlC = "Select * from curso where codigo_curso="+resultset.getInt(2);
            matricula = new Matricula(resultset.getString(4),AlunoDAO.buscar(sqlA),CursoDAO.buscar(sqlC),resultset.getInt(1));
            resultset.close();
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            System.out.println("Não foi possivel executar o sql aluno" + u);
        }
        return matricula;
    }
    
    public static ArrayList<Matricula> consulta() {
        ArrayList<Matricula> list = new ArrayList<>();

        String sql = "Select * from matricula";
        String sqlA;
        String sqlC;
        try {
            PreparedStatement stmt = ConexaoBD.conexao().prepareStatement(sql);            
            ResultSet resultset = stmt.executeQuery();
            Aluno a;
            Curso c;
            while (resultset.next()) {
                sqlA = "select * from aluno where codigo_aluno="+resultset.getInt(3);                
                sqlC = "Select * from curso where codigo_curso="+resultset.getInt(2);
                a = AlunoDAO.buscar(sqlA);
                c = CursoDAO.buscar(sqlC);
                Matricula m = new Matricula(resultset.getString(4),a,c,resultset.getInt(1));
                list.add(m);
             }                           
            stmt.close();
        } catch (SQLException u) {
            System.out.println("Não foi possivel executar o sql matricula");
        }

        return list;

    }
    
    public static Matricula[] consultaJtable(ArrayList<Matricula> list) {
        Matricula[] matricula = new Matricula[list.size()];
        int cont = matricula.length-1;
        for(int k=0;k<list.size();k++){
            matricula[cont--]=list.get(k);
        }
        return matricula;

    }
    
   
    
}
