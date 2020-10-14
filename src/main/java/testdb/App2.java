package testdb;

import java.util.ArrayList;

public class App2
{




    public static void main(String[] args)
    {

       ArtikelDAOImpl test2 = new ArtikelDAOImpl();
       Artikel test = new Artikel(1,"test");
       test2.insert(test);

       Artikel hallo = new Artikel(1,"hallo");
       test2.update(hallo);

       //test2.delete(1);

       ArrayList<Artikel> testo = test2.getAll();
       System.out.println("");







    }
}
