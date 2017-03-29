/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Lab-H5~H7
 */
public class EmprestimoDAO {
    private String url = "jdbc:mysql://localhost/aula3";
    private String username = "root";   // Usuário do BD
    private String password = "";       // Senha de acesso
    
    private Connection conexao;
    
    public EmprestimoDAO() {
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
                    + "EXISTS emprestimos("
                    + "id mediumint not null auto_increment"
                    + "livroId integer,"
                    + "alunoMatricula varchar(255),"
                    + "dataEmprestimo date,"
                    + ");";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.execute();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void create(int livroId, String alunoMatricula,
                       Date dataEmprestimo) {
        String sql = "INSERT INTO emprestimos( "
                    + "livroId, alunoMatricula, dataEmprestimo)"
                    + "VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, livroId);
            ps.setString(2, alunoMatricula);
            ps.setDate(3, (java.sql.Date) dataEmprestimo);
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void update(int id, int livroId, String alunoMatricula,
                       Date dataEmprestimo) {
        String sql = "UPDATE emprestimos"
                    + " SET livroId = ?, alunoMatricula = ?,"
                    + " dataEmprestimo = ?,"
                    + " WHERE id = ?";
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, livroId);
            ps.setString(2, alunoMatricula);
            ps.setDate(3, (java.sql.Date) dataEmprestimo);
            ps.setInt(4, id);
            ps.execute();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void delete(int id) {
        String sql = "DELETE FROM emprestimos"
                    + " WHERE id = ?";
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public ArrayList<Emprestimo> getAllEmprestimos () {
        ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
        String sql = "SELECT id, livroId,"
                    + "alunoMatricula, dataEmprestimo"
                    + " FROM emprestimos";
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Emprestimo emprestimo = new Emprestimo(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getDate(4));
                
                emprestimos.add(emprestimo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return emprestimos;
    };
    
    public ArrayList<Emprestimo> searchByStudent(String matricula) {
        ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
        String sql = "SELECT id, livroId,"
                    + "alunoMatricula, dataEmprestimo"
                    + " FROM emprestimos"
                    + " WHERE alunoMatricula = ?";
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            
            ps.setString(1, matricula);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Emprestimo emprestimo = new Emprestimo(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getDate(4));
                
                emprestimos.add(emprestimo);
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        
        return emprestimos;
    }
}
