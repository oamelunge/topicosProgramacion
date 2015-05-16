/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sellSubSystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;

/**
 *
 * @author WINDOWS 7
 */

public class Sell {
    private List<ItemsSell> _itemsSell = new ArrayList<ItemsSell>();
    private LocalDate _sellDate;
    
    public List<ItemsSell> getItemsSell() {
        return _itemsSell;
    }

    public void setItemsSell(List<ItemsSell> _itemsSell) {
        this._itemsSell = _itemsSell;
    }

    public LocalDate getSellDate() {
        return _sellDate;
    }

    public void setSellDate(LocalDate _sellDate) {
        this._sellDate = _sellDate;
    }
    
}
