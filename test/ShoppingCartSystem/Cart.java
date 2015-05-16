/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoppingCartSystem;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 *
 * @author WINDOWS 7
 */
public class Cart {

  

    private List<Object> _items = new ArrayList<Object>();
    private Hashtable<Object,Double> _catalog;

   
    

    public Cart(Hashtable<Object,Double> catalog) {
       this._catalog=catalog;
    }

     public Hashtable<Object, Double> getCatalog() {
        return _catalog;
    }
     
    public List<Object> getItems() {
        return _items;
    }
   
    public boolean isEmpty() {
        return this._items.isEmpty();
    }

    public void addItems(Object item, int quantity) {
        validateIfAmountOfItemsIsGratherThan0(quantity);
        validateIfItemAddedToCartIsOnCatalog(item);
        processItemQuantityAditionToCart(item, quantity); 
    }

    private void processItemQuantityAditionToCart(Object item, int quantity) {
        for(int a=1;a<=quantity;a++)
            _items.add(item);
    }

    private void validateIfItemAddedToCartIsOnCatalog(Object item) {
        if(!_catalog.containsKey(item))
            throw new RuntimeException("This item is not in catalog");
    }

    private void validateIfAmountOfItemsIsGratherThan0(int quantity) {
        if(quantity<1)
            throw new RuntimeException("cart only accept > 0 items");
    }

    public int getQuantityOfThisItem(Object itemCatalog) {
        return (int)_items.stream().filter(item-> item==itemCatalog).count();
    }

    
    
}
