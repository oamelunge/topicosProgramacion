/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sellSubSystem;

import sellSubSystem.ItemsSell;
import sellSubSystem.ISell;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author WINDOWS 7
 */
public class SellDataBase implements ISell{

    @Override
    public void addSellItem(Object item, int itemQuantity, Double itemPrice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ItemsSell> getItemsSell() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LocalDate getSellDate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Double getTotalSell() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
