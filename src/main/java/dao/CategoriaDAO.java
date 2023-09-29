/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Categoria;
import javax.persistence.EntityManager;

/**
 *
 * @author samll
 */
public class CategoriaDAO {
    private final EntityManager em;

    public CategoriaDAO(EntityManager em) {
        this.em = em;
    }
    
    public void addCateg(Categoria cat){
        this.em.persist(cat);
    }
    
    public void updateCateg(Categoria cat){
        this.em.merge(cat);
    }
    
    public void deleteCateg(Categoria cat){
        cat=this.em.merge(cat);
        this.em.remove(cat);
    }
}
