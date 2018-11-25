/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Milica
 */
public class KomunikacijaSaServerom {
    private static KomunikacijaSaServerom instanca;
    Socket soket;

    private KomunikacijaSaServerom() {
        try {
            soket = new Socket("localhost", 9000);
        } catch (IOException ex) {
            Logger.getLogger(KomunikacijaSaServerom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static KomunikacijaSaServerom getInstanca() {
        if(instanca == null)
            instanca = new KomunikacijaSaServerom();
        return instanca;
    }
    
    public void posaljiZahtev(KlijentskiZahtev kz){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(soket.getOutputStream());
            oos.writeObject(kz);
        } catch (IOException ex) {
            Logger.getLogger(KomunikacijaSaServerom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ServerskiOdgovor primiOdgovor(){
        ServerskiOdgovor so = new ServerskiOdgovor();
        
        try {
            ObjectInputStream ois = new ObjectInputStream(soket.getInputStream());
            so = (ServerskiOdgovor) ois.readObject();
        } catch (Exception ex) {
            Logger.getLogger(KomunikacijaSaServerom.class.getName()).log(Level.SEVERE, null, ex);
        }
        return so;
    }
    
}
