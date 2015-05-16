/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestShoppingCartSystem;

import ShoppingCartSystem.Cart;
import ShoppingCartSystem.Cashier;
import sellSubSystem.SellSystem;
import java.time.LocalDate;
import java.util.Hashtable;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author WINDOWS 7
 */
public class TestCar {
      private Cart cart;
      private Object itemCatalog;
 

    @Test
    public void testCartShouldBeEmptyOnCreate()
    {
         initializeCart();
        assertTrue(cart.isEmpty());
    }
  
    @Test
    public void testCartShouldAddItems()
    {
        initializeCart();       
        cart.addItems(itemCatalog,1);
        assertFalse(cart.isEmpty());
    }
    @Test
    public void testCartShouldNotAddUnkowItems()
    {
        initializeCart();               
        Object itemNotInCatalog = new Object();
        itemNotInCatalog="33333";
        
        try {
           cart.addItems(itemNotInCatalog,1);
           fail();
        } catch (Exception e) {
            assertEquals("This item is not in catalog", e.getMessage());
            assertTrue(cart.isEmpty());
        }
    }
    
    @Test
    public void testCarShouldAllowAddMoreThan1Item()
    {
        initializeCart();        
        cart.addItems(itemCatalog,3);          
        assertEquals(3,cart.getQuantityOfThisItem(itemCatalog));
    }
    
    @Test
    public void testCartSHouldNotAllowLessThanOneItem()
    {
        initializeCart();
        int itemsCount=0;
        
        
        try {
                itemsCount=cart.getQuantityOfThisItem(itemCatalog);
                cart.addItems(itemCatalog,-1);
            fail();
        } catch (Exception e) {
            assertEquals("cart only accept > 0 items", e.getMessage());
            assertEquals(itemsCount,cart.getQuantityOfThisItem(itemCatalog));
        }
    }
    
    @Test
    public void testCheckoutShouldNotBeAllowedOnEmptyCart()
    {
        initializeCart();        
        Cashier cashier = new Cashier(cart);
        
        try {
            cashier.checkOut();
            fail();
        } catch (Exception e) {
            assertEquals("Impossible to checkOut on empty cart", e.getMessage());
        }
    }
    
    @Test
    public void testCheckOutProductsFromCartShouldReturnTotalPurchase()
    {
        initializeCart();
        cart.addItems(itemCatalog, 3);
        Cashier cashier = new Cashier(cart); 
        
        assertEquals(10.5, cashier.checkOut(),0.01);
    }
    
    
    @Test
    public void testCheckOutShouldRegisterSell()
    {
         initializeCart();
         Cashier cashier = new Cashier(cart);
         cart.addItems(itemCatalog, 3);
         Double totalCheckOut=cashier.checkOut();
         cashier.buy();
         assertEquals(totalCheckOut,cashier.getSell().getTotalSell(),0.01);
    }
 
    
    
    
    private void initializeCart() {
        Hashtable<Object,Double> catalog = new Hashtable<Object,Double>();
        itemCatalog = new Object();
        itemCatalog="12345";
        catalog.put(itemCatalog,new Double(3.5));
        cart = new Cart(catalog);
    }
    
}
