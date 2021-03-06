package de.dillinger.stw.azubi.lennart.domain.valueobject;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Benutzer benutzer = (Benutzer) o;
        return Objects.equals(name, benutzer.name) && Objects.equals(vorName, benutzer.vorName) && Objects.equals(email, benutzer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, vorName, email);
    }

    @Override
    public String toString() {
        return "Benutzer{" +
                "name='" + name + '\'' +
                ", vorName='" + vorName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
