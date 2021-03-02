package de.dillinger.stw.azubi.lennart;

import java.util.Scanner;

import de.dillinger.stw.azubi.lennart.applicationservice.BenutzerService;

/**
 * Hello world!
 *
 */
public class BenutzerVerwaltungMain
{

    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        String vorname = sc.next();
        String nachname = sc.next();
        String email = sc.next();
        new BenutzerService();



    }
    
    
}
