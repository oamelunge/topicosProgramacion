package TestShoppingCartSystem;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import sellSubSystem.SellSystem;
import java.time.LocalDate;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author WINDOWS 7
 */
public class SellTest {
    
 
 @Test
    public void testSellDateShouldBeGratherThanToday() {
        SellSystem sell = new SellSystem();
        LocalDate currentDate = LocalDate.now();
        currentDate.getMonth();
        assertTrue(sell.getSellDate().getMonth().equals(currentDate.getMonth()));
        assertTrue(sell.getSellDate().getYear() == currentDate.getYear());
        assertTrue(sell.getSellDate().getDayOfYear() == currentDate.getDayOfYear());
    }
   //Test for Sels
    @Test
    public void testSellShouldAddItemsWithCurrentPriceAndQuantity() {
        SellSystem sell = new SellSystem();
        Object item = "12345";
        int itemQuantity = 3;
        Double itemPrice = 8.8;
        sell.addSellItem(item, itemQuantity, itemPrice);
        assertEquals(1, sell.getItemsSell().size());
    }
    
   
    
    @Test
    public void tetSellShouldReturnTotalSell()
    {
        SellSystem sell = new SellSystem();
        Object item = "12345";
        int itemQuantity = 3;
        Double itemPrice = 8.8;//26.4
        sell.addSellItem(item, itemQuantity, itemPrice);
        
       
        Object item2 = "12343";
        int item2Quantity = 2;
        Double item2Price = 10.8;
        
        sell.addSellItem(item2, item2Quantity, item2Price);
        
        assertEquals(48.0, sell.getTotalSell(),0.02);
        
    }
}
