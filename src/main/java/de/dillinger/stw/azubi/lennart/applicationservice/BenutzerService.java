package de.dillinger.stw.azubi.lennart.applicationservice;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import de.dillinger.stw.azubi.lennart.domain.valueobject.Benutzer;

public class BenutzerService
{
    File speichernBenutzer = new File("C:\\Users\\di39258\\speichernBenutzer.txt");
    private final Gson gson;

    public BenutzerService()
    {
        final GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();
    }

    public void legeBenutzerAn(Benutzer benutzer)
    {
       String gsonString = gson.toJson(benutzer);
        PrintWriter meinWriter = null;

        try
        {
            meinWriter = new PrintWriter(new BufferedWriter(new FileWriter(speichernBenutzer)));
            meinWriter.println(gsonString);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            meinWriter.close(); 
            
        }


    }

    public void loescheBenutzer()
    {

    }

    public void benutzerAendern()
    {

    }

    public void sucheBenutzer()
    {

    }

}
