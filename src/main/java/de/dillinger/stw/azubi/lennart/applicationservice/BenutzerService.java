package de.dillinger.stw.azubi.lennart.applicationservice;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import de.dillinger.stw.azubi.lennart.domain.valueobject.Benutzer;

public class BenutzerService
{

    public static final String DATEI = "target/benutzerVerwaltung.txt";

    private File benutzerVerwaltung;
    private final Gson gson;

    public BenutzerService()
    {
        final GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();
        benutzerVerwaltung = erzeugeDatei();
    }

    private File erzeugeDatei()
    {
        File file = new File(DATEI);

        if(!file.exists())
        {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Die Datei konnte nicht erzeugt werden");

                throw new IllegalStateException(e);
            }
        }

        return file;
    }

    public void legeBenutzerAn(Benutzer benutzer)
    {
       String gsonString = gson.toJson(benutzer);
       PrintWriter meinWriter = null;

        try
        {
            meinWriter = new PrintWriter(new BufferedWriter(new FileWriter(benutzerVerwaltung)));
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

    public Benutzer sucheBenutzer(String vorname, String nachname)
    {
        try
        {
            BufferedReader bReader =  new BufferedReader(new FileReader(benutzerVerwaltung));
            String line = bReader.readLine();
            while (line!=null)
            {
               Benutzer gelesenerBenutzer = gson.fromJson(line, Benutzer.class);
               if(gelesenerBenutzer.getVorName().equals(vorname) && gelesenerBenutzer.getName().equals(nachname))
               {
                   return gelesenerBenutzer;
               }
                line = bReader.readLine();
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    public void loescheBenutzer(String vorname, String nachname, String email)
    {
        try
        {
            BufferedReader bReader =  new BufferedReader(new FileReader(benutzerVerwaltung));
            String line = bReader.readLine();
            while (line!=null)
            {
                Benutzer gelesenerBenutzer = gson.fromJson(line, Benutzer.class);
                if(gelesenerBenutzer.getVorName().equals(vorname) && gelesenerBenutzer.getName().equals(nachname))
                {
                    StringBuffer geleseneLine = new StringBuffer(line);

                    geleseneLine.delete(0, line.length()-1);
                }
                line = bReader.readLine();
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void benutzerAendern(String vorname, String nachname, String email)
    {
        try
        {
            BufferedReader bReader =  new BufferedReader(new FileReader(benutzerVerwaltung));
            String line = bReader.readLine();
            while (line!=null)
            {
                Benutzer gelesenerBenutzer = gson.fromJson(line, Benutzer.class);
                if(gelesenerBenutzer.getVorName().equals(vorname) && gelesenerBenutzer.getName().equals(nachname))
                {
                    gelesenerBenutzer.setName(nachname);
                    gelesenerBenutzer.setVorName(vorname);
                    gelesenerBenutzer.setEmail(email);
                }
                line = bReader.readLine();
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
