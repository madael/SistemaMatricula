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
public class AlunoDAO {
    
    public static void update(Aluno aluno) {
        String sql = "UPDATE aluno SET nome = ?, cpf=? WHERE codigo_aluno=?";
        try {
            PreparedStatement stmt = ConexaoBD.conexao().prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCpf());
            stmt.setLong(3, aluno.getIdAluno());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
    
    public static void remover(Aluno aluno) {
        String sql = "DELETE FROM aluno WHERE codigo_aluno = ?";
        try {
            PreparedStatement stmt = ConexaoBD.conexao().prepareStatement(sql);
            stmt.setLong(1, aluno.getIdAluno());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
    
    public static void adiciona(Aluno aluno) {
        String sql = "INSERT INTO aluno(nome,cpf) VALUES(?,?)";
        try {
            PreparedStatement stmt = ConexaoBD.conexao().prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCpf());
            stmt.execute();
            stmt.close();

        } catch (SQLException u) {
            System.out.println("Não foi possivel executar o sql aluno");
        }
    }
    
    public static Aluno buscar(int texto){
        Aluno aluno = new Aluno();
        String sql = "Select * from aluno where codigo_aluno="+texto;
        try {
            PreparedStatement stmt = ConexaoBD.conexao().prepareStatement(sql);
            ResultSet resultset = stmt.executeQuery();
            resultset.next();
            aluno = new Aluno(resultset.getString(2), resultset.getString(3), resultset.getInt(1));
            resultset.close();
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            System.out.println("Não foi possivel executar o sql aluno" + u);
        }
        return aluno;
    }
    
    public static Aluno buscar(String texto){
        Aluno aluno = new Aluno();
        try {
            PreparedStatement stmt = ConexaoBD.conexao().prepareStatement(texto);
            ResultSet resultset = stmt.executeQuery();
            resultset.next();
            aluno = new Aluno(resultset.getString(2), resultset.getString(3), resultset.getInt(1));
            resultset.close();
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            System.out.println("Não foi possivel executar o sql aluno" + u);
        }
        return aluno;
    }
    
    public static ArrayList<Aluno> consulta() {
        ArrayList<Aluno> list = new ArrayList<>();

        String sql = "Select * from aluno";
        try {
            PreparedStatement stmt = ConexaoBD.conexao().prepareStatement(sql);
            ResultSet resultset = stmt.executeQuery();
            while (resultset.next()) {
                Aluno a = new Aluno(resultset.getString(2), resultset.getString(3), resultset.getInt(1));
                list.add(a);
             }                           
            stmt.close();
        } catch (SQLException u) {
            System.out.println("Não foi possivel executar o sql aluno");
        }

        return list;

    }

}
