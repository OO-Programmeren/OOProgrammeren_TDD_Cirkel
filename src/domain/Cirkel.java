package domain;

import java.awt.geom.Point2D;

public class Cirkel {
    private Point2D.Double middelpunt;
    private double straal;


    public Cirkel(Point2D.Double middelpunt, double straal) {
        if (middelpunt == null) throw new IllegalArgumentException();
        if (straal < 0) throw new IllegalArgumentException();
        if (straal > middelpunt.getX()) throw new IllegalArgumentException();
        if (straal > middelpunt.getY()) throw new IllegalArgumentException();
        this.middelpunt = middelpunt;
        this.straal = straal;
    }

    public Point2D.Double getMiddelpunt() {
        return this.middelpunt;
    }

    public double getStraal() {
        return this.straal;
    }

    public double oppervlakteCirkel(){
        return (this.straal * this.straal) * Math.PI;
    }

    public boolean ligtBinnenCirkel(Point2D.Double randomPunt){
        return ((randomPunt.getX() - this.middelpunt.getX())*(randomPunt.getX() - this.middelpunt.getX()) +
                (randomPunt.getY() - this.middelpunt.getY())*(randomPunt.getY() - this.middelpunt.getY())) < (this.straal*this.straal);
    }

    public void vergrootStraal(double factor){
        double nieuweStraal = straal * factor;
        if (factor < 0) throw new IllegalArgumentException();
        if (nieuweStraal < 0) throw new IllegalArgumentException();
        if (nieuweStraal > middelpunt.getX()) throw new IllegalArgumentException();
        if (nieuweStraal > middelpunt.getY()) throw new IllegalArgumentException();
        this.straal = nieuweStraal;
    }
}