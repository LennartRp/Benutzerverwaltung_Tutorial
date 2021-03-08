package de.dillinger.stw.azubi.lennart.applicationservice;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.BeforeEach;

import de.dillinger.stw.azubi.lennart.domain.valueobject.Benutzer;

class BenutzerServiceTest
{

    @org.junit.jupiter.api.Test
    void testLegeBenutzerAn()
    {
        //Arrange
        BenutzerService benutzerService = new BenutzerService();
        Benutzer benutzer = new Benutzer("Max", "Mustermann", "Emailadresse");
        Benutzer gelesenerBenutzer = null;
        Gson gson = new GsonBuilder().create();

        //Act
        benutzerService.legeBenutzerAn(benutzer);
       //Assert

        //gelesenerBenutzer = benutzerService.sucheBenutzer(benutzer.getVorName(), benutzer.getName());

        try
        {
            File file = new File(BenutzerService.DATEI);
            BufferedReader bReader =  new BufferedReader(new FileReader(file));
            String line = bReader.readLine();
            while (line!=null)
            {
                Benutzer benutzer1 = gson.fromJson(line, Benutzer.class);
                if(benutzer1.getVorName().equals(benutzer.getVorName()) && benutzer1.getName().equals(benutzer.getName()))
                {
                    gelesenerBenutzer = benutzer1;
                }
                line = bReader.readLine();
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals(benutzer,gelesenerBenutzer);

    }
}