/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author dasanchez13
 */
public class Simulation {
    private ArrayList<Lane> highway;
    private Random random;
    private int vehiclesGenerated;
    private ArrayList<MoveVehicleThread> v_Threads;
    private ArrayList<CheckLaneThread> l_Threads;
    
    Simulation(){
        this.highway = new ArrayList<>();
        this.v_Threads = new ArrayList<>();
        this.l_Threads = new ArrayList<>();
        random = new Random();
        vehiclesGenerated = 0;
    }
    
    //this function inserts a vehicle in the lane with the less quantity of vehicles
    public void insertVh_LessCharged(Vehicle v){
        ArrayList<Integer> vehiclesByLane = new ArrayList<>();
        for(int i = 0; i < highway.size(); i++){
            vehiclesByLane.add(highway.get(i).getVehicles().size());
        }
        
        int minIndex = vehiclesByLane.indexOf(Collections.min(vehiclesByLane));
        this.vehiclesGenerated += 1;
        v.setId(this.vehiclesGenerated);
        String threadName = "Vehicle Thread number "+ Integer.toString(vehiclesGenerated);
        MoveVehicleThread mvt = new MoveVehicleThread(v,threadName,true);
        this.v_Threads.add(mvt);
        highway.get(minIndex).addVehicle(v,mvt);
    }
    
    public void insertVh_RandomLane(int speed, int howMany){
        int i = 0;
        while(i < howMany){
            int selectedLane = this.random.nextInt(11);
            this.vehiclesGenerated += 1;
            Lane temp = this.highway.get(selectedLane);
            Vehicle v = new Vehicle();
            v.setSpeed(speed);
            v.setY(10);
            v.setDirection(true);
            v.setId(this.vehiclesGenerated);
            String threadName = "Vehicle Thread number "+ Integer.toString(this.vehiclesGenerated);
            MoveVehicleThread mvt = new MoveVehicleThread(v, threadName, true);
            this.v_Threads.add(mvt);
            temp.addVehicle(v,mvt);
        }
    }
    
    public void revert(){
        for(int i = 0; i < this.highway.size(); i++){
            this.highway.get(i).revert();
        }
    }
}
