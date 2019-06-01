package my.regApp.main;

import my.regApp.services.Menu;


public class RegAppMain {
    public static void main(String[] args){
        for(;;) {
            Menu menu = new Menu();
            menu.firstWindow();
            if (menu.getAction() == 1) {
                menu.logIn();
            } else if (menu.getAction() == 2) {
                menu.register();
            } else {
                System.out.println("Only 1 or 2, try again\n");
            }
        }
    }
}
