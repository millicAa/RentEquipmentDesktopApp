/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.StavkaRentiranja;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Milica
 */
public class ModelTabele extends AbstractTableModel{

    ArrayList<StavkaRentiranja> lista;

    public ModelTabele() {
        lista = new ArrayList<>();
    }
    
    
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaRentiranja sr = lista.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return sr.getRb();
            case 1: return sr.getOprema();
            case 2: return sr.getOprema().getCenaPoDanu();
            case 3: return sr.getIznos();
            
            default: return "Sta god";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:
                return "RB";
            case 1: return "Oprema";
            case 2: return "Cena po danu";
            case 3: return "Iznos";
            
            default: return "Sta god";
        }
    }

    public void ubaciStavku(StavkaRentiranja sr) {
        lista.add(sr);
        fireTableDataChanged();
    }

    public void srediStavke(Date datumOd, Date datumDo) {
        long diff = datumDo.getTime() - datumOd.getTime();
        long dani = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
            
        int brojac = 0;
        for (StavkaRentiranja stavkaRentiranja : lista) {
              brojac++;
              double iznos = dani * stavkaRentiranja.getOprema().getCenaPoDanu(); 
              stavkaRentiranja.setIznos(iznos);
              stavkaRentiranja.setRb(brojac);
        }
        
        fireTableDataChanged();  //kljucno!!!!
    }

    public void obrisiStavku(int red) {
        lista.remove(red);
    }

    public ArrayList<StavkaRentiranja> getLista() {
        return lista;
    }
    
    
    
}
