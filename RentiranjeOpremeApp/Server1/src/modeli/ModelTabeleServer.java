/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import pomoc.PomocnaKlasaTabela;

/**
 *
 * @author Milica
 */
public class ModelTabeleServer extends AbstractTableModel{
    ArrayList<PomocnaKlasaTabela> lista;

    public ModelTabeleServer() {
        lista = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PomocnaKlasaTabela p = lista.get(rowIndex);
        
        switch(columnIndex){
            case 0: return p.getOprema();
            case 1: return p.getOprema().getProizvodjac();
            case 2: return p.getOprema().getCenaPoDanu();
            case 3: return p.getBrojDana();
            case 4: return p.getPrihod();
            
            default: return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Oprema";
            case 1: return "Proizvodjac";
            case 2: return "Cena po danu";
            case 3: return "Broj dana";
            case 4: return "Prihod";
            
            default: return "";
        }
    }

    public ArrayList<PomocnaKlasaTabela> getLista() {
        return lista;
    }

    public void setLista(ArrayList<PomocnaKlasaTabela> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }
    
    
}
