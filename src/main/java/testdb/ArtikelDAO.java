package testdb;

import java.util.ArrayList;

public interface ArtikelDAO
{

    public void insert(Artikel a); //
    public void update (Artikel a);
    public void delete(int id); //
    ArrayList<Artikel> getAll(); //
    Artikel getByID(int id);
}
