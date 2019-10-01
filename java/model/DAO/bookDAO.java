/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import connection.conectaBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import entidade.book;

/**
 *
 * @author alber
 */
public class bookDAO{

    public void CREATE(book b) {
        Connection IdConexao = conectaBD.AbreConexao();
        PreparedStatement comandoSQL = null;
        try {
            comandoSQL = IdConexao.prepareStatement("INSERT INTO BOOK (name,author,category,year,price) VALUES (?,?,?,?,?,?)");
            comandoSQL.setString(1, b.getName());
            comandoSQL.setString(2, b.getAuthor());
            comandoSQL.setString(3, b.getCategory());
            comandoSQL.setInt(4, b.getYear());
            comandoSQL.setFloat(5, b.getPrice());
            comandoSQL.executeUpdate();
            JOptionPane.showMessageDialog(null, "Inserido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falhou tentativa de inserção " + ex);
        } finally {
            conectaBD.FechaConexao(IdConexao, comandoSQL);
        }
    }

    public List<book> SELECT() {
        Connection IdConexao = conectaBD.AbreConexao();
        PreparedStatement comandoSQL = null;
        ResultSet resultadoSELECT = null;
        List<book> livros = new ArrayList<>();

        try {
            comandoSQL = IdConexao.prepareStatement("SELECT * FROM BOOK");
            resultadoSELECT = comandoSQL.executeQuery();
            while (resultadoSELECT.next()) {
                book livro = new book();
                livro.setID(resultadoSELECT.getInt("ID"));
                livro.setName(resultadoSELECT.getString("name"));
                livro.setAuthor(resultadoSELECT.getString("author"));
                livro.setCategory(resultadoSELECT.getString("category"));
                livro.setYear(resultadoSELECT.getInt("year"));
                livro.setPrice(resultadoSELECT.getFloat("price"));
                livros.add(livro);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha na execução de SELECT " + ex);
        } finally {
            conectaBD.FechaConexao(IdConexao, comandoSQL, resultadoSELECT);
        }
        return livros;
    }

    public void UPDATE(book b) {
        Connection IdConexao = conectaBD.AbreConexao();
        PreparedStatement comandoSQL = null;

        try {
            comandoSQL = IdConexao.prepareStatement("UPDATE BOOK SET name=?, author=?, category=?, year=?, price=? WHERE ID=?");
            comandoSQL.setString(1, b.getName());
            comandoSQL.setString(2, b.getAuthor());
            comandoSQL.setString(3, b.getCategory());
            comandoSQL.setInt(4, b.getYear());
            comandoSQL.setFloat(5, b.getPrice());
            comandoSQL.setInt(6, b.getID());
            comandoSQL.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falhou tentativa de atualização " + ex);
        } finally {
            conectaBD.FechaConexao(IdConexao, comandoSQL);
        }
    }

    public void DELETE(book b) {
        Connection IdConexao = conectaBD.AbreConexao();
        PreparedStatement comandoSQL = null;
        try {
            comandoSQL = IdConexao.prepareStatement("DELETE FROM BOOK WHERE ID=?");
            comandoSQL.setInt(1, b.getID());
            comandoSQL.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluído com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falhou tentativa de excllusão " + ex);
        } finally {
            conectaBD.FechaConexao(IdConexao, comandoSQL);
        }
    }
}
