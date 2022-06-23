package com.infoshareacademy;

import com.infoshareacademy.domain.Wine;
import com.infoshareacademy.menu.Menu;
import com.infoshareacademy.service.WineService;
import com.infoshareacademy.writers.WineJson;

import java.io.IOException;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {
        Menu menu = new Menu();
        menu.menu();
       // WineJson.ReadingWineToJson();
     /*   WineService wineService = new WineService();
        wineService.ReadingWineToJson();
        Wine wine = wineService.getWineById(3);
        System.out.println(wine.getWineName());
        Wine wine2 = wineService.getWineById(3);
        System.out.println(wine2);*/

        //UserJson.WritingUserToJson();
        //OrderJson.WritingOrderToJson();


        //System.out.println("Podaj Wina: Id, Nazwę, Smak, Typ, Rocznik, Pochodzenie, Cenę");

        //System.out.println(v1);
    }
}

// Sortowanie i filtrowanie tabel
//https://edu.pjwstk.edu.pl/wyklady/poj/scb/TabSort/TabSort.html
// panel klienta: #4 "Wyszukaj wino", (rozdzielamy) #1 po id #2 po smaku
//koszyk zostawiamy
// magazynier: podpięcie listy win (jak uzytkownik), lista zamówien: na sztywno, produkty na wyczerpaniu: sztywno + ew. warunki ilosciowe
// Daniel: # wyszukaj wino;
// Krysia: dokonczenie, skaner, wyjatek,
// Dominik: podpiecie listy win dla magazyniera;
// Mikolaj: code review :)
// wspolne code review
