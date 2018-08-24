/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author dasanchez13
 */
public class Lane {
    private int x;
    private int initial_Y;
    private int final_Y;
    private ArrayList<Vehicle> vehicles;
    private boolean wall;
    private boolean direction;

    public Lane(int x) {
        this.x = x;
        this.initial_Y = 10;
        this.final_Y = 600;
        this.vehicles = new ArrayList<>();
        wall = false;
    }
    
    public void addVehicle(Vehicle v){
        v.setX(this.x);
        this.vehicles.add(v);
    }
    
    public void deleteVehicle(int i){
        this.vehicles.remove(i);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getInitial_Y() {
        return initial_Y;
    }

    public void setInitial_Y(int initial_Y) {
        this.initial_Y = initial_Y;
    }

    public int getFinal_Y() {
        return final_Y;
    }

    public void setFinal_Y(int final_Y) {
        this.final_Y = final_Y;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public boolean isWall() {
        return wall;
    }

    public void setWall(boolean wall) {
        this.wall = wall;
    }
    
    public void verifyMovement(){
        if(this.direction){
            for(int i = 1; i < this.vehicles.size(); i++){
            //starts with 1 because the first element always is allowed to move
                Vehicle nextVehicle = this.vehicles.get(i-1);
                Vehicle temp = this.vehicles.get(i);
                int spaceUsedByNext = (int)nextVehicle.getY() - 25;
                spaceUsedByNext += nextVehicle.getSpeed();
                int mySpace = (int) temp.getY() + 25;
                mySpace+=temp.getSpeed();
                if(spaceUsedByNext-mySpace < 0){
                    temp.setCanMove(false);
                }
            }
        }else{
            int lastElement = this.vehicles.size()-2;
            //this is the first element if the direction of the vehicles is reverted
            for(int i = lastElement; i > 0; i--){
                Vehicle nextVehicle = this.vehicles.get(i-1);
                Vehicle temp = this.vehicles.get(i);
                int spaceUsedByNext = (int)nextVehicle.getY() - 25;
                spaceUsedByNext += nextVehicle.getSpeed();
                int mySpace = (int) temp.getY() + 25;
                mySpace+=temp.getSpeed();
                if(spaceUsedByNext-mySpace < 0){
                    temp.setCanMove(false);
                }
            }
        }
    }
    
    public void setDirection(boolean direction){
        this.direction = direction;
        for(int i = 0; i < this.vehicles.size(); i++){
            this.vehicles.get(i).setDirection(direction);
        }
        //Collections.reverse(this.vehicles);
    }
}
