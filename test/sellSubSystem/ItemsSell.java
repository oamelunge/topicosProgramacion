/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sellSubSystem;

/**
 *
 * @author WINDOWS 7
 */
public class ItemsSell  {
    private  Object _item;
    private  int _itemQuantity;
    private  Double _itemPrice;

    public ItemsSell(Object item, int itemQuantity, Double itemPrice) {
        this._item=item;
        this._itemQuantity=itemQuantity;
        this._itemPrice=itemPrice;
    }
    
      public Object getItem() {
        return _item;
    }

    public int getItemQuantity() {
        return _itemQuantity;
    }

    public Double getItemPrice() {
        return _itemPrice;
    }
}
