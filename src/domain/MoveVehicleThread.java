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
public class MoveVehicleThread implements Runnable{
    private boolean running;
    private boolean stopped;
    private Vehicle myObject;
    private int sleepTime;
    private String name;
    
    public MoveVehicleThread(Vehicle obj, String name, boolean running){
        this.myObject = obj;
        this.running = running;
        this.name = name;
        this.sleepTime = 10;
        this.stopped = false;
    }

    @Override
    public void run() {
        while(running && !stopped){
            try {
                myObject.move();
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