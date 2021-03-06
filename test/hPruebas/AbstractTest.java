/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hPruebas;

import java.util.Date;
import org.apache.derby.jdbc.EmbeddedDataSource;
import org.apache.naming.java.javaURLContextFactory;


import org.junit.AfterClass;
import org.junit.BeforeClass;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public abstract class AbstractTest {

 @BeforeClass
 public static void setUpClass() throws Exception {
  System.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
  System.setProperty(Context.URL_PKG_PREFIXES, "org.apache.naming");
  InitialContext ic = new InitialContext();

  ic.createSubcontext("java:");
  ic.createSubcontext("java:comp");
  ic.createSubcontext("java:comp/env");
  ic.createSubcontext("java:comp/env/jdbc");

  EmbeddedDataSource ds = new EmbeddedDataSource();
  ds.setDatabaseName("tutorialDB");
  // tell Derby to create the database if it does not already exist
  ds.setCreateDatabase("create");

  ic.bind("java:comp/env/jdbc/tutorialDS", ds);
 }

 @AfterClass
 public static void tearDownClass() throws Exception {

  InitialContext ic = new InitialContext();

  ic.unbind("java:comp/env/jdbc/tutorialDS");
 }
 
 @Test
    public void testNewUser() {

        EntityManager entityManager = Persistence.createEntityManagerFactory("tutorialPU").createEntityManager();

        entityManager.getTransaction().begin();

        User user = new User();

        user.setName(Long.toString(new Date().getTime()));

        entityManager.persist(user);

        entityManager.getTransaction().commit();

        // see that the ID of the user was set by Hibernate
        System.out.println("user=" + user + ", user.id=" + user.getId());

        User foundUser = entityManager.find(User.class, user.getId());

        // note that foundUser is the same instance as user and is a concrete class (not a proxy)
        System.out.println("foundUser=" + foundUser);

        assertEquals(user.getName(), foundUser.getName());

        entityManager.close();
    }
    
    
    @Test(expected = Exception.class)
   public void testNewUserWithTxn() throws Exception {

       EntityManager entityManager = Persistence.createEntityManagerFactory("tutorialPU").createEntityManager();

       entityManager.getTransaction().begin();
       try {
           User user = new User();

           user.setName(Long.toString(new Date().getTime()));

           entityManager.persist(user);

           if (true) {
               throw new Exception();
           }

           entityManager.getTransaction().commit();
       } catch (Exception e) {
           entityManager.getTransaction().rollback();
           throw e;
       }

       entityManager.close();
   }
}