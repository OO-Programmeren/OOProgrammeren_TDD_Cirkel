package domain;

import org.junit.Before;
import org.junit.Test;

import java.awt.geom.Point2D;

import static org.junit.Assert.*;

public class CirkelTest {

    private Point2D.Double  geldigMiddelpunt, ongeldigMiddelpunt, randomPunt, randomPuntBuiten ;
    private double geldigeStraal, ongeldigeStraal, negatieveStraal, ongeldigeStraalY;
    private final double delta = 1E-12;
    private Cirkel cirkel;

    @Before
    public void setUp() throws Exception {
        geldigMiddelpunt = new Point2D.Double(12.5, 13.4);
        geldigeStraal = 10.3;

        ongeldigMiddelpunt = new Point2D.Double(7.4, 5.3);
        ongeldigeStraal = 8.4;
        ongeldigeStraalY = 8.4;
        negatieveStraal = -3.2;

        cirkel = new Cirkel(geldigMiddelpunt, geldigeStraal);
        randomPunt = new Point2D.Double(15.5, 13.8);
        randomPuntBuiten = new Point2D.Double(34.4, 40.8);

    }

    @Test(expected = IllegalArgumentException.class)
    public void Cirkel_Met_Negatieve_Middelpunt_Gooit_Exception(){
        new Cirkel(null, geldigeStraal);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Cirkel_Met_Geldig_Middelpunt_Maar_Met_Negatieve_Straal_Gooit_Exception(){
        new Cirkel(geldigMiddelpunt, negatieveStraal);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Cirkel_Met_Geldig_Middelpunt_Maar_Met_Straal_Groter_Dan_X_Van_De_Coordinaten(){
        new Cirkel(ongeldigMiddelpunt, ongeldigeStraal);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Cirkel_Met_Geldig_Middelpunt_Maar_Met_Straal_Groter_Dan_Y_Van_De_Coordinaten(){
        new Cirkel(ongeldigMiddelpunt, ongeldigeStraalY);
    }

    @Test
    public void Cirkel_Met_Geldig_Middelpunt_En_Geldige_Straal(){
        Cirkel cirkel = new Cirkel(geldigMiddelpunt, geldigeStraal);
        assertNotNull(cirkel);
        assertEquals(geldigMiddelpunt, cirkel.getMiddelpunt());
        assertEquals(geldigeStraal, cirkel.getStraal(), delta);
    }

    @Test
    public void Cirkel_Met_Straal_Gelijk_Aan_Exact_Minimum(){
        Cirkel cirkel = new Cirkel(geldigMiddelpunt, 12.5);
        assertNotNull(cirkel);
        assertEquals(geldigMiddelpunt, cirkel.getMiddelpunt());
        assertEquals(12.5, cirkel.getStraal(), delta);
    }

    @Test
    public void Cirkel_Met_Geldige_Straal_En_Met_Geldig_Middelpunt_Geeft_Oppervlakte(){
        assertEquals(333.2915646193412, cirkel.oppervlakteCirkel(), delta);
    }

    @Test
    public void Cirkel_Met_Geldige_Straal_En_Met_Geldig_Middelpunt_Punt_Ligt_Binnen_Cirkel(){
        assertTrue(cirkel.ligtBinnenCirkel(randomPunt));
    }

    @Test
    public void Cirkel_Met_Geldige_Straal_En_Met_Geldig_Middelpunt_Punt_Ligt_Buiten_Cirkel(){
        assertFalse(cirkel.ligtBinnenCirkel(randomPuntBuiten));
    }

    @Test(expected = IllegalArgumentException.class)
    public void Cirkel_Vergroot_Straal_Met_Negatieve_Factor_Gooit_Exception(){
        cirkel.vergrootStraal(-3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Cirkel_Vergroot_Straal_Met_Postieve_Factor_Maar_Straal_Is_Groter_Dan_X_Van_Het_Middelpunt_Gooit_Exception(){
        cirkel.vergrootStraal(3.6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Cirkel_Vergroot_Straal_Met_Postieve_Factor_Maar_Straal_Is_Groter_Dan_Y_Van_Het_Middelpunt_Gooit_Exception(){
        cirkel.vergrootStraal(3.8);
    }

    @Test
    public void Cirkel_Vergroot_Straal_Met_Correcte_Straal(){
        cirkel.vergrootStraal(1.1);
        assertEquals(11.33,cirkel.getStraal(), delta);
    }


}