/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pomoc;

import domen.Oprema;

/**
 *
 * @author Milica
 */
public class PomocnaKlasaTabela {
    private Oprema oprema;
    private int brojDana;
    private double prihod;

    public PomocnaKlasaTabela() {
    }

    public PomocnaKlasaTabela(Oprema oprema, int brojDana, double prihod) {
        this.oprema = oprema;
        this.brojDana = brojDana;
        this.prihod = prihod;
    }

    public double getPrihod() {
        return prihod;
    }

    public void setPrihod(double prihod) {
        this.prihod = prihod;
    }

    public Oprema getOprema() {
        return oprema;
    }

    public void setOprema(Oprema oprema) {
        this.oprema = oprema;
    }

    public int getBrojDana() {
        return brojDana;
    }

    public void setBrojDana(int brojDana) {
        this.brojDana = brojDana;
    }
    
    
}
