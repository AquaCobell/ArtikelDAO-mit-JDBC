package testdb;

public class Artikel
{
    int nummer;
    String name;
    Artikel(int nummer, String name)
    {

        this.nummer = nummer;
        this.name = name;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Artikel{" +
                "nummer=" + nummer +
                ", name='" + name + '\'' +
                '}';
    }
}
