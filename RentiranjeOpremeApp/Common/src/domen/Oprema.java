/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;

/**
 *
 * @author Milica
 */
public class Oprema implements Serializable{
    private int opremaID;
    private String naziv;
    private double cenaPoDanu;
    private Proizvodjac proizvodjac;

    public Oprema() {
    }

    public Oprema(int opremaID, String naziv, double cenaPoDanu, Proizvodjac proizvodjac) {
        this.opremaID = opremaID;
        this.naziv = naziv;
        this.cenaPoDanu = cenaPoDanu;
        this.proizvodjac = proizvodjac;
    }

    public Proizvodjac getProizvodjac() {
        return proizvodjac;
    }

    public void setProizvodjac(Proizvodjac proizvodjac) {
        this.proizvodjac = proizvodjac;
    }

    public int getOpremaID() {
        return opremaID;
    }

    public void setOpremaID(int opremaID) {
        this.opremaID = opremaID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getCenaPoDanu() {
        return cenaPoDanu;
    }

    public void setCenaPoDanu(double cenaPoDanu) {
        this.cenaPoDanu = cenaPoDanu;
    }

    @Override
    public String toString() {
        return naziv;
    }
    
    
}
