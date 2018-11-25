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
public class Proizvodjac implements Serializable{
    private int proizvodjacID;
    private String naziv;
    private String adresa;

    public Proizvodjac() {
    }

    public Proizvodjac(int proizvodjacID, String naziv, String adresa) {
        this.proizvodjacID = proizvodjacID;
        this.naziv = naziv;
        this.adresa = adresa;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public int getProizvodjacID() {
        return proizvodjacID;
    }

    public void setProizvodjacID(int proizvodjacID) {
        this.proizvodjacID = proizvodjacID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return naziv;
    }
    
    
}
