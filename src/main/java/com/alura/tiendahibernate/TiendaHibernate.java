/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.alura.tiendahibernate;

import dao.CategoriaDAO;
import dao.ProductoDAO;
import entity.Categoria;
import entity.Producto;
import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import utils.JPAUtils;

/**
 *
 * @author samll
 */
public class TiendaHibernate {

    public static void main(String[] args) {

        Categoria cel = new Categoria("Celulares");

//        Producto prod1=new Producto();
//        prod1.setNombre("iPhone 14 Pro Max");
//        prod1.setDescripcion("265GB 8Ram GrayRed");
//        prod1.setPrecio(new BigDecimal(1200));
//        
//        Producto prod2=new Producto("Motorola 500", "Telefono usado del 2009", new BigDecimal("589.99"), cel);
        EntityManager em = JPAUtils.getEntityManager();

//        ProductoDAO prodDAO=new ProductoDAO(em);
//        CategoriaDAO catDAO=new CategoriaDAO(em);
        em.getTransaction().begin();

        em.persist(cel);
        cel.setNombre("iPhone 15");

//        catDAO.addCateg(cel);
//        prodDAO.addProduct(prod1);
//        prodDAO.addProduct(prod2);
        em.flush();
        em.clear();

        cel = em.merge(cel);

        cel.setNombre("Samsugn S23");

        em.flush();
        em.clear();

        cel = em.merge(cel);
        em.remove(cel);

        em.flush();

    }
}
