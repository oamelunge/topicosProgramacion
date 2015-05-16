/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sellSubSystem;

import sellSubSystem.ItemsSell;
import sellSubSystem.ISell;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WINDOWS 7
 */
public class SellSystem implements ISell {
    private List<ItemsSell> _itemsSell = new ArrayList<ItemsSell>();
    private LocalDate _sellDate;
    
    public SellSystem()
    {
        _sellDate=LocalDate.now();
    }
    @Override
    public void addSellItem(Object item, int itemQuantity, Double itemPrice) {
        _itemsSell.add(new ItemsSell(item,itemQuantity,itemPrice));
    }

    @Override
    public List<ItemsSell> getItemsSell() {
       return this._itemsSell;
    }

    @Override
    public LocalDate getSellDate() {
        return this._sellDate;
    }

    @Override
    public Double getTotalSell() {      
       
       return _itemsSell.stream()
               .map((item) -> 
                       item.getItemPrice()*item.getItemQuantity())
               .reduce((sum,x)->sum+x).get();
    }
    
}
