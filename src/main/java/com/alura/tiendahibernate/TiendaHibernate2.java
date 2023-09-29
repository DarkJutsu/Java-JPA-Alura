/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alura.tiendahibernate;

import dao.CategoriaDAO;
import dao.ProductoDAO;
import entity.Categoria;
import entity.Producto;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import utils.JPAUtils;

/**
 *
 * @author samll
 */
public class TiendaHibernate2 {

    public static void main(String[] args) {

        registrarProd();

        EntityManager em = JPAUtils.getEntityManager();

        ProductoDAO prodDAO = new ProductoDAO(em);

        Producto prod1 = prodDAO.getProducId(1l);
        System.out.println(prod1);

        List<Producto> listProduc = prodDAO.getAllProduc();
        listProduc.forEach(prod -> System.out.println(prod.getId() + "->" + prod));
        
        List<Producto> nameProduc = prodDAO.getProducName("Motorola 500");
        nameProduc.forEach(prod -> System.out.println(prod));
        
        List<Producto> catProduc = prodDAO.getProducCat("Celulares");
        catProduc.forEach(prod -> System.out.println(prod));
        
        BigDecimal precProd = prodDAO.getProducPrec("iPhone 14 Pro Max");
        System.out.println("Precio $" + precProd);

    }

    private static void registrarProd() {
        Categoria cel = new Categoria("Celulares");

        Producto prod1 = new Producto();
        prod1.setNombre("iPhone 14 Pro Max");
        prod1.setDescripcion("265GB 8Ram GrayRed");
        prod1.setPrecio(new BigDecimal(1200));
        prod1.setCategoria(cel);

        Producto prod2 = new Producto("Motorola 500", "Telefono usado del 2009", new BigDecimal("589.99"), cel);

        EntityManager em = JPAUtils.getEntityManager();

        ProductoDAO prodDAO = new ProductoDAO(em);
        CategoriaDAO catDAO = new CategoriaDAO(em);

        em.getTransaction().begin();

        catDAO.addCateg(cel);
        prodDAO.addProduct(prod1);
        prodDAO.addProduct(prod2);

        em.getTransaction().commit();
        em.close();
    }
}
