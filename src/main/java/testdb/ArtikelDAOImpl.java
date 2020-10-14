package testdb;

import java.sql.*;
import java.util.ArrayList;

public class ArtikelDAOImpl implements ArtikelDAO
{
    public ArtikelDAOImpl()
    {

    }

    Connection con;
    public void connectDB()
    {


            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/lager", "root", "");
                //stmt=con.createStatement();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }

    }
    @Override
    public void insert(Artikel a) //Eventuell nummer entfernen weil autoinkrement
    {
        connectDB();
        int nummer = a.getNummer();
        String name = a.getName();

        try
        {
            Statement state = con.createStatement();
            String sql = "insert into artikel"
                    + " (ID, name)"
                    + " values ('"+nummer+"'" +
                      ",'"+name+"')";

            state.executeUpdate(sql);

        }
        catch(Exception e)
        {
            System.out.println(e);

        }
    }

    @Override
    public void update(Artikel a)
    {
        connectDB();
        Statement state = null;
        try
        {
            state = con.createStatement();

            String sql = "update artikel"
                    + " set name = '"+a.getName()+"' "
                    + " where id = '"+a.getNummer()+"' ";

            if(state !=null)
            {
                state.executeUpdate(sql);
            }

        }
        catch(Exception e)
        {
            System.out.println(e);
        }








    }
    @Override
    public void delete(int id)
    {
        connectDB();
        try
        {
            Statement state = con.createStatement();
            String sql = "delete from artikel where ID = '"+id+"' ";
            state.executeUpdate(sql);

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    @Override
    public ArrayList<Artikel> getAll()
    {

        ArrayList<Artikel> artikel = new ArrayList();
        connectDB();
        try
        {
            Statement state = con.createStatement();
            ResultSet rs= state.executeQuery("select * from artikel");

            while(rs.next())
            {

                Artikel artikel1 = new Artikel(rs.getInt(1),rs.getString(2));
                artikel.add(artikel1);
            }
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return artikel;
    }

    @Override
    public Artikel getByID(int id)
    {
        connectDB();
        try
        {
            Statement state = con.createStatement();
            ResultSet rs= state.executeQuery("select * from artikel");

            while(rs.next())
            {

                Artikel artikel = new Artikel(rs.getInt(1),rs.getString(2));
                if(artikel.getNummer() == id)
                {
                    return artikel;
                }
            }
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return null;
    }
}
