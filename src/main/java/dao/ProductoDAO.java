/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Producto;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author samll
 */
public class ProductoDAO {
    private final EntityManager em;

    public ProductoDAO(EntityManager em) {
        this.em = em;
    }
    
    public Producto getProducId(Long id){
        return this.em.find(Producto.class, id);
    }
    
    public List<Producto> getAllProduc(){
        String jpql="SELECT P FROM Producto AS P";
        return this.em.createQuery(jpql, Producto.class).getResultList();
    }
    
    public List<Producto> getProducName(String nom){
        String jpql="SELECT P FROM Producto AS P WHERE P.nombre=:nom";
        return this.em.createQuery(jpql).setParameter("nom", nom).getResultList();
    }
    
    public List<Producto> getProducCat(String cat){
        String jpql="SELECT P FROM Producto AS P WHERE P.categoria.nombre=:cat";
        return this.em.createQuery(jpql).setParameter("cat", cat).getResultList();
    }
    
    public BigDecimal getProducPrec(String nom){
        String jpql="SELECT P.precio FROM Producto AS P WHERE P.nombre=:nom";
        return this.em.createQuery(jpql, BigDecimal.class).setParameter("nom", nom).getSingleResult();
    }
    
    public void addProduct(Producto prod){
        this.em.persist(prod);
    }
    
}
