package de.dillinger.stw.azubi.lennart.domain.valueobject;

public class Benutzer
{
    private final String name;
    private final String vorName;
    private final String email;

    public Benutzer(String name, String vorName, String email)
    {
        this.name = name;
        this.vorName = vorName;
        this.email = email;
    }

    public String getName()
    {
        return name;
    }

    public String getVorName()
    {
        return vorName;
    }

    public String getEmail()
    {
        return email;
    }
}
