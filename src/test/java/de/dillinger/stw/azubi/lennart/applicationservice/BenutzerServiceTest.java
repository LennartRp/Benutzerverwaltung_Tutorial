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
    void testLegeBenutzerAn() throws IOException
    {
        //Arrange
        BenutzerService benutzerService = new BenutzerService();
        Benutzer benutzer = new Benutzer("Max", "Mustermann", "Emailadresse");
        Benutzer gelesenerBenutzer = null;
        Gson gson = new GsonBuilder().create();

        //Act
        benutzerService.legeBenutzerAn(benutzer);
       //Assert
        BufferedReader meinReader = null;
        File speichernBenutzer = new File("C:\\Users\\di39258\\speichernBenutzer.txt");
        FileReader fileReader = null;

        fileReader = new FileReader(speichernBenutzer);
        meinReader = new BufferedReader(fileReader);

            String line = meinReader.readLine();
            while (line!=null)
            {
               gelesenerBenutzer = gson.fromJson(line, Benutzer.class);
            }

        assertEquals(benutzer,gelesenerBenutzer);


    }
}