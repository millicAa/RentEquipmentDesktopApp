/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Milica
 */
public class Rentiranje implements Serializable{
    private int rentiranjeID;
    private String klijent;
    private Date datumOd;
    private Date datumDo;
    private double ukupanIznos;
    private ArrayList<StavkaRentiranja> lista;

    public Rentiranje() {
        lista = new ArrayList<>();
    }

    public Rentiranje(int rentiranjeID, String klijent, Date datumOd, Date datumDo, double ukupanIznos, ArrayList<StavkaRentiranja> lista) {
        this.rentiranjeID = rentiranjeID;
        this.klijent = klijent;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
        this.ukupanIznos = ukupanIznos;
        this.lista = lista;
    }

    public ArrayList<StavkaRentiranja> getLista() {
        return lista;
    }

    public void setLista(ArrayList<StavkaRentiranja> lista) {
        this.lista = lista;
    }

    public int getRentiranjeID() {
        return rentiranjeID;
    }

    public void setRentiranjeID(int rentiranjeID) {
        this.rentiranjeID = rentiranjeID;
    }

    public String getKlijent() {
        return klijent;
    }

    public void setKlijent(String klijent) {
        this.klijent = klijent;
    }

    public Date getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }

    public Date getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(Date datumDo) {
        this.datumDo = datumDo;
    }

    public double getUkupanIznos() {
        return ukupanIznos;
    }

    public void setUkupanIznos(double ukupanIznos) {
        this.ukupanIznos = ukupanIznos;
    }
    
    
}
