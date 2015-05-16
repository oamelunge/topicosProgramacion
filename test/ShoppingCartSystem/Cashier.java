/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoppingCartSystem;

import sellSubSystem.SellSystem;
import java.util.Hashtable;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author WINDOWS 7
 */
public class Cashier {
    private  Cart _cart;
    private  SellSystem _sell;

  
    public Cashier(Cart cart) {
        this._cart = cart;
    }

    public double checkOut() {
        validateIfCartIsEmpty();
        double totalPrice=0;
        
        for(Object item:_cart.getItems())
        {
            totalPrice+=this._cart.getCatalog().get(item).doubleValue();
        }
       
        return totalPrice;
    }

    private void validateIfCartIsEmpty() throws RuntimeException {
        if(_cart.isEmpty())
            throw new RuntimeException("Impossible to checkOut on empty cart");
    }

    public SellSystem getSell() {
        return _sell;
    }

    public void buy() {
         _sell = new SellSystem();
         
         Map<Object,Long> itemsGrouped=_cart.getItems()
                 .stream()
                 .collect(
                      Collectors.groupingBy(
                              x->x,
                              Collectors.counting()));
         
        for (Map.Entry<Object,Long> entry : itemsGrouped.entrySet()) {    
            _sell.addSellItem(
                    entry.getKey(), 
                    entry.getValue().intValue(), 
                    this._cart.getCatalog().get(entry.getKey()).doubleValue());
        }
    }
    
}
