/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serversiDeo;

import domen.Oprema;
import domen.Rentiranje;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import konstante.Operacije;
import logika.Kontroler;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Milica
 */
public class ObradaKlijentskiZahteva extends Thread{
    Socket soket;
    boolean kraj = false;

    public ObradaKlijentskiZahteva(Socket soket) {
        this.soket = soket;
    }

    @Override
    public void run() {
        while (!kraj) {            
            KlijentskiZahtev kz = primiZahtev();
            ServerskiOdgovor so = new ServerskiOdgovor();
            switch(kz.getOperacija()){
                case Operacije.POPUNI_OPREMU:
                    ArrayList<Oprema> lista = Kontroler.getInstanca().dajMiOpremu();
                    so.setOdgovor(lista);
                    break;
                case Operacije.SACUVAJ:
                    Rentiranje r = (Rentiranje) kz.getParametar();
                    so = Kontroler.getInstanca().sacuvajRentiranje(r);
                    break;
            }
            
            posaljiOdgovorKlijentu(so);
        }
    }

    private KlijentskiZahtev primiZahtev() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        
        try {
            ObjectInputStream ois = new ObjectInputStream(soket.getInputStream());
            kz = (KlijentskiZahtev) ois.readObject();
        } catch (Exception ex) {
            Logger.getLogger(ObradaKlijentskiZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return kz;
    }

    private void posaljiOdgovorKlijentu(ServerskiOdgovor so) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(soket.getOutputStream());
            oos.writeObject(so);
        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskiZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
