package com.infoshareacademy;

import com.infoshareacademy.menu.collaborative.Menu;

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

