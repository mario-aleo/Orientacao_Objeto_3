/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula3;

/**
 *
 * @author l
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AlunoJDBC {
    
    private String url = "jdbc:mysql://"
            + "localhost/testando";
    private String username = "root";   // Usuário do BD      
    private String password = "";       // Senha de acesso    
    private Connection conexao;
    
    public AlunoJDBC() {
        try {
            conexao = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        if(conexao == null)
            System.out.println("Erro de conexão");
        else
            System.out.println("Conectado com sucesso");
    }
    
    public void createTable() {
        String sql = "CREATE TABLE IF NOT "
                    + "EXISTS alunos(nome "
                    + "varchar(255), sobrenome "
                    + "varchar(255), matricula "
                    + "varchar(12), cod_curso  "
                    + "decimal(4,1), semestre "
                    + "integer);";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.execute();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void save(String nome, String sobrenome, String matricula,
                     double codCurso, int semestre) {
        String sql = "INSERT INTO alunos( "
                    + "nome, sobrenome, matricula, "
                    + "cod_curso, semestre) VALUES "
                    + "(?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, sobrenome);
            ps.setString(3, matricula);
            ps.setDouble(4, codCurso);
            ps.setInt(5, semestre);
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public ArrayList<Aluno> list() {
        ArrayList<Aluno> alunos = new ArrayList<Aluno>();
        String sql = "SELECT nome, sobrenome,"
                    + " matricula, cod_curso,"
                    + "semestre FROM alunos";
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                Aluno aluno = new Aluno(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getDouble(4), 
                    rs.getInt(5));
                alunos.add(aluno);
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return alunos;
    }
    
    public void update(String nome, String sobrenome, String matricula,
                       double codCurso, int semestre) {
        String sql = "UPDATE alunos"
                    + " SET nome = ?, sobrenome = ?,"
                    + " cod_curso = ?, semestre = ?,"
                    + " WHERE matricula = ?";
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, sobrenome);
            ps.setDouble(3, codCurso);
            ps.setInt(4, semestre);
            ps.setString(5, matricula);
            ps.execute();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void delete(String matricula) {
        String sql = "DELETE FROM alunos"
                    + " WHERE matricula = ?";
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, matricula);
            ps.execute();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public Aluno searchByMatricula(String matricula) {
        Aluno aluno = null;
        String sql = "SELECT nome, sobrenome,"
                    + " matricula, cod_curso,"
                    + " semestre FROM alunos"
                    + " WHERE matricula = ?";
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            
            ps.setString(1, matricula);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                aluno = new Aluno(
                   rs.getString(1), rs
                   .getString(2), rs
                   .getString(3), rs
                   .getDouble(4),rs.getInt(5));
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return aluno;
    }    
}
