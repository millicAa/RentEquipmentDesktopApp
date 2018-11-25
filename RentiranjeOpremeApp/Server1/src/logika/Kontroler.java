/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import db.DBBroker;
import domen.Oprema;
import domen.Proizvodjac;
import domen.Rentiranje;
import domen.StavkaRentiranja;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pomoc.PomocnaKlasaTabela;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Milica
 */
public class Kontroler {
    private static Kontroler instanca;
    DBBroker db;

    private Kontroler() {
        db = new DBBroker();
    }

    public static Kontroler getInstanca() {
        if(instanca == null)
            instanca = new Kontroler();
        return instanca;
    }

    public ArrayList<Oprema> dajMiOpremu() {
        db.ucitajDrajver();
        db.otvoriKonekciju();
        ArrayList<Oprema> lista = db.vratiOpremu();
        db.zatvoriKonekciju();
        
        return lista;
    }

    public ServerskiOdgovor sacuvajRentiranje(Rentiranje r) {
        ServerskiOdgovor so = new ServerskiOdgovor();
        db.ucitajDrajver();
        db.otvoriKonekciju();
        try {
            int rentiranjeID = db.vratiID();
            r.setRentiranjeID(rentiranjeID);
            db.sacuvajRentiranje(r);
            for (StavkaRentiranja s : r.getLista()) {
                db.sacuvajStavku(s,r.getRentiranjeID());
            }
            db.commit();
            so.setPoruka("Uspesno sacuvano sve");
        } catch (SQLException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
            db.rollback();
            so.setPoruka("Nije uspesno sacuvano "+ex.getMessage());
        }
        
        db.zatvoriKonekciju();
        
        return so;
    }

    public ArrayList<Proizvodjac> dajProizvodjace() {
        db.ucitajDrajver();
        db.otvoriKonekciju();
        ArrayList<Proizvodjac> lista = db.vratiProizvodjace();
        db.zatvoriKonekciju();
        
        return lista;
    }

    public ArrayList<PomocnaKlasaTabela> vratiListuZaServer(Proizvodjac p) {
        db.ucitajDrajver();
        db.otvoriKonekciju();
        ArrayList<PomocnaKlasaTabela> lista = db.vratiPodatkeServer(p);
        db.zatvoriKonekciju();
        
        return lista;
    }
   
}
