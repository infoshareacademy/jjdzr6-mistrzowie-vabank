package com.infoshareacademy;

import com.infoshareacademy.menu.collaborative.Menu;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {
        Menu menu = new Menu();
        menu.showMenu();


        /**Json Generators
        *OrderJson orderJson = new OrderJson();
        *orderJson.WritingOrderToJson();

        *UserJson userJson = new UserJson();
        *userJson.WritingUserToJson();

        *VineJson vineJson = new VineJson();
        *vineJson.WritingVineToJson();

         */
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
