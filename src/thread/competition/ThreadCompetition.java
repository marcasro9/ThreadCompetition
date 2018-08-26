/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread.competition;

import GUI.Home;
import domain.CheckLaneThread;
import domain.Lane;
import domain.MoveVehicleThread;
import domain.Vehicle;

/**
 *
 * @author marca
 */
public class ThreadCompetition {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Home home = new Home();
        //home.setVisible(true);
        
        Vehicle v = new Vehicle(3,4,7);
        v.setSpeed(10);
        MoveVehicleThread mv = new MoveVehicleThread(v,"test",true);
        new Thread(mv).start();
        
        Vehicle vh = new Vehicle(3,4,7);
        vh.setSpeed(2);
        MoveVehicleThread mvh = new MoveVehicleThread(vh,"test",true);
        new Thread(mvh).start();
        
        Lane l = new Lane(3);
        l.addVehicle(v);
        l.addVehicle(vh);
        l.setDirection(true);
        CheckLaneThread chkl = new CheckLaneThread(l,"lane test",true);
        new Thread(chkl).start();
        
    }
}
