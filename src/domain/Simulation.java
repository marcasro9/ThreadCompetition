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
    
    Simulation(){
        highway = new ArrayList<>();
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
        highway.get(minIndex).addVehicle(v);
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
            temp.addVehicle(v);
        }
    }
}
