/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serversiDeo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Milica
 */
public class PokreniServerNit extends Thread{

    @Override
    public void run() {
        try {
            ServerSocket ss = new ServerSocket(9000);
            System.out.println("Server se pokrenuo");
            while (true) {                
                Socket klijent = ss.accept();
                System.out.println("Klijent se povezao");
                ObradaKlijentskiZahteva okz = new ObradaKlijentskiZahteva(klijent);
                okz.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(PokreniServerNit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
