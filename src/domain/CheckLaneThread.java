/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dasanchez13
 */
public class CheckLaneThread implements Runnable{
    
    private boolean running;
    private Lane myObject;
    private int sleepTime;
    private String name;
    
    public CheckLaneThread(Lane obj, String name, boolean running){
        this.myObject = obj;
        this.running = running;
        this.name = name;
        this.sleepTime = 50;
    }

    @Override
    public void run() {
        while(running){
            try {
                myObject.verifyMovement();
                Thread.sleep(this.sleepTime);
            } catch (InterruptedException ex) {
                Logger.getLogger(MoveVehicleThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    public synchronized void setRunning(boolean running) {
        this.running = running;
    }
}
