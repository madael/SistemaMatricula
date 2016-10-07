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
public class CursoDAO{
    
    public static void update(Curso curso) {
        String sql = "UPDATE curso SET nome = ?, carga_horaria=? WHERE codigo_curso=?";
        try {
            PreparedStatement stmt = ConexaoBD.conexao().prepareStatement(sql);
            stmt.setString(1, curso.getNome());
            stmt.setDouble(2, curso.getCargaHorario());
            stmt.setLong(3, curso.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
    
    public static void remover(Curso curso) {
        String sql = "DELETE FROM curso WHERE codigo_curso = ?";
        try {
            PreparedStatement stmt = ConexaoBD.conexao().prepareStatement(sql);
            stmt.setLong(1, curso.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
    
    public static void adiciona(Curso curso) {
        String sql = "INSERT INTO curso(nome,carga_horaria) VALUES(?,?)";
        try {
            PreparedStatement stmt = ConexaoBD.conexao().prepareStatement(sql);
            stmt.setString(1, curso.getNome());
            stmt.setDouble(2, curso.getCargaHorario());
            stmt.execute();
            stmt.close();

        } catch (SQLException u) {
            System.out.println("Não foi possivel executar o sql curso");
        }
    }
    
    public static Curso buscar(int texto){
        Curso curso = new Curso();
        String sql = "Select * from curso where codigo_curso="+texto;
        try {
            PreparedStatement stmt = ConexaoBD.conexao().prepareStatement(sql);
            ResultSet resultset = stmt.executeQuery(); 
            resultset.next();
            curso= new Curso(resultset.getString(2), resultset.getDouble(3),resultset.getInt(1));
            resultset.close();
            stmt.execute();
            stmt.close();

        } catch (SQLException u) {
            System.out.println("Não foi possivel executar o sql curso");
        }
        return curso;
    }
    
    public static Curso buscar(String texto){
        Curso curso = new Curso();
        try {
            PreparedStatement stmt = ConexaoBD.conexao().prepareStatement(texto);
            ResultSet resultset = stmt.executeQuery(); 
            resultset.next();
            curso= new Curso(resultset.getString(2), resultset.getDouble(3),resultset.getInt(1));
            resultset.close();
            stmt.execute();
            stmt.close();

        } catch (SQLException u) {
            System.out.println("Não foi possivel executar o sql curso");
        }
        return curso;
    }
    
    public static ArrayList<Curso> consulta() {
        ArrayList<Curso> list = new ArrayList<>();

        String sql = "Select * from curso";
        try {
            PreparedStatement stmt = ConexaoBD.conexao().prepareStatement(sql);
            ResultSet resultset = stmt.executeQuery();
            while (resultset.next()) {
                Curso c = new Curso(resultset.getString(2), resultset.getDouble(3),resultset.getInt(1));
                list.add(c);
             }                           
            stmt.close();
        } catch (SQLException u) {
            System.out.println("Não foi possivel executar o sql");
        }

        return list;

    }
    
    public static Curso[] consultaJtable(ArrayList<Curso> list) {
        Curso[] curso = new Curso[list.size()];
        int cont = curso.length-1;
        for(int k=0;k<list.size();k++){
            curso[cont--]=list.get(k);
        }

        return curso;

    }
    
}
