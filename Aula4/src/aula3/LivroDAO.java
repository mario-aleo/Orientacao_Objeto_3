/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Lab-H5~H7
 */
public class LivroDAO {
    private String url = "jdbc:mysql://localhost/aula3";
    private String username = "root";   // Usuário do BD
    private String password = "";       // Senha de acesso
    
    private Connection conexao;
    
    public LivroDAO() {
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
                    + "EXISTS livros("
                    + "id mediumint not null auto_increment"
                    + "nome varchar(255),"
                    + "autor varchar(255),"
                    + "edicao integer,"
                    + "categoria decimal(4,1)"
                    + "isbn varchar(13),"
                    + ");";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.execute();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void create(String nome, String autor, int edicao,
                       double categoria, String isbn) {
        String sql = "INSERT INTO livros( "
                    + "nome, autor, edicao, categoria, isbn)"
                    + "VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, autor);
            ps.setInt(3, edicao);
            ps.setDouble(4, categoria);
            ps.setString(5, isbn);
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void update(int id, String nome, String autor, int edicao,
                       double categoria, String isbn) {
        String sql = "UPDATE livros"
                    + " SET nome = ?, autor = ?,"
                    + " edicao = ?, categoria = ?, isbn = ?,"
                    + " WHERE id = ?";
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, autor);
            ps.setInt(3, edicao);
            ps.setDouble(4, categoria);
            ps.setString(5, isbn);
            ps.setInt(6, id);
            ps.execute();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void delete(int id) {
        String sql = "DELETE FROM livros"
                    + " WHERE id = ?";
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public ArrayList<Livro> getAllBooks () {
        ArrayList<Livro> livros = new ArrayList<Livro>();
        String sql = "SELECT id, nome, autor,"
                    + " edicao, categoria, isbn"
                    + " FROM livros";
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Livro livro = new Livro(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getDouble(5),
                    rs.getString(6));
                
                livros.add(livro);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return livros;
    };
    
    public ArrayList<Livro> searchByName(String nome) {
        ArrayList<Livro> livros = new ArrayList<Livro>();
        String sql = "SELECT id, nome, autor,"
                    + " edicao, categoria, isbn"
                    + " FROM livros"
                    + " WHERE nome = ?";
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Livro livro = new Livro(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getDouble(5),
                    rs.getString(6));
                
                livros.add(livro);
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        
        return livros;
    }
}
