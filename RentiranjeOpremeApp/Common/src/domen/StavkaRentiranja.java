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
public class StavkaRentiranja implements Serializable{
    private int rb;
    private Oprema oprema;
    private double iznos;

    public StavkaRentiranja() {
    }

    public StavkaRentiranja(int rb, Oprema oprema, double iznos) {
        this.rb = rb;
        this.oprema = oprema;
        this.iznos = iznos;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public Oprema getOprema() {
        return oprema;
    }

    public void setOprema(Oprema oprema) {
        this.oprema = oprema;
    }
    
    
    
}
