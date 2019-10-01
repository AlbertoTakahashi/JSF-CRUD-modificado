/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Bean;

import entidade.book;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import model.DAO.bookDAO;

/**
 *
 * @author alber
 */
@Named(value = "bookBean")
@SessionScoped
public class bookBean implements Serializable {

    private book livro = new book();
    private List<book> livros = new ArrayList<>();
    private bookDAO livroDAO = new bookDAO();

    
    public bookBean() {	
    }	
    
    public void adicionar() {
        livroDAO.CREATE(livro);
        livro = new book();
    }
    public void editar(book L) {
        livro = L;
    }
    
    public void apagar(book L) {
        try {
            livroDAO.DELETE(L);
        } finally {
            livros = livroDAO.SELECT();
        }
    }
    
    public void listar() {
        livros = livroDAO.SELECT();
    }
        
    public book getLivro() {
        return livro;
    }

    public void setLivro(book livro) {
        this.livro = livro;
    }

    public List<book> getLivros() {
        return livros;
    }

    public void setLivros(List<book> livros) {
        this.livros = livros;
    }
	

}
