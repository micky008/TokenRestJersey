package com.msc.rest.tokenrestjersey;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A lancer dans le Main.
 *
 * @author Micky
 */
public class TokenGarbage implements Runnable {

    private boolean go = true;

    @Override
    public void run() {
        Object o = new Object();

        while (go) {
            synchronized (o) {
                try {
                    o.wait(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(TokenGarbage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            TokenService.removeOldToken();
        }
    }

    public void setContinue(boolean go) {
        this.go = go;
    }

}
