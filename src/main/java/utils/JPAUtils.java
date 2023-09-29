/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author samll
 */
public class JPAUtils {
    private static final EntityManagerFactory FACTORY=Persistence.createEntityManagerFactory("tienda");
    
    public static EntityManager getEntityManager(){
        return FACTORY.createEntityManager();
    }
}
