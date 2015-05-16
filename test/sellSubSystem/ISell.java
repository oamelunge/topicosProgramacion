/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sellSubSystem;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author WINDOWS 7
 */
public interface ISell {

    void addSellItem(Object item, int itemQuantity, Double itemPrice);

    List<ItemsSell> getItemsSell();

    LocalDate getSellDate();

    Double getTotalSell();
    //hola comentario
}
