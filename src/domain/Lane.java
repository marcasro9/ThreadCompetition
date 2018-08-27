/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
    private Queue<Vehicle> queueVehicles;
    private Queue<MoveVehicleThread> queueMoveVehiclesThreads;

    public Lane(int x) {
        this.x = x;
        this.initial_Y = 10;
        this.final_Y = 600;
        this.vehicles = new ArrayList<>();
        this.queueVehicles = new LinkedList<>();
        this.queueMoveVehiclesThreads = new LinkedList<>();
        this.wall = false;
    }
    
    public void addVehicle(Vehicle v, MoveVehicleThread mvt){
        v.setX(this.x);
        if(!this.vehicles.isEmpty()){
            int posY_LastVehicle = getPosY_LastVehicle();
            if(posY_LastVehicle < 35){//I suppose this is the min posY of a vehicle
                v.setCanMove(false);
                this.queueVehicles.add(v);
                mvt.setRunning(false);
                this.queueMoveVehiclesThreads.add(mvt);
            }else{
                v.setCanMove(true);
                v.setDirection(direction);
                this.vehicles.add(v);
                new Thread(mvt).start();
            }
        }else{
            v.setCanMove(true);
            v.setDirection(direction);
            this.vehicles.add(v);
            new Thread(mvt).start();
        }
    }
    
    public void checkQueue(){
        if(!this.queueVehicles.isEmpty()){
            int posY_LastVehicle = getPosY_LastVehicle();
            if(posY_LastVehicle > 35){
                Vehicle v = this.queueVehicles.poll();
                MoveVehicleThread mvt = this.queueMoveVehiclesThreads.poll();
                v.setCanMove(true);
                v.setDirection(direction);
                mvt.setRunning(true);
                new Thread(mvt).start();
            }
        }
    }
    
    public void deleteFirstVehicle(){
        if(!this.vehicles.isEmpty()){
            Vehicle temp = this.vehicles.get(0);
            int posY_FirstVehicle = (int)temp.getY() - 25;
            if(posY_FirstVehicle > 600){
                temp.setCanMove(false);
                this.vehicles.remove(0);
            }
        }
    }
    
    public int getPosY_LastVehicle(){
        int last_Vehicle = this.vehicles.size() - 1;
        Vehicle temp = this.vehicles.get(last_Vehicle);
        int posY_LastVehicle = (int)temp.getY() - 25;
        return posY_LastVehicle;
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
                System.out.println(temp.isCanMove());
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
                if(spaceUsedByNext-mySpace < 0 && !youShallNotPass(mySpace)){
                    temp.setCanMove(false);
                }
            }
        }
    }
    
    public boolean youShallNotPass(int posY_Vehicle){
        if(this.wall){
           //the vehicle is far of the wall
            if(300 - posY_Vehicle <= 0){
                return false;
            }else{
                return true;
            }
        }else{
            return false;
        }
    }
    
    public void revert(){
        this.direction = !this.direction;
        for(int i = 0; i < this.vehicles.size(); i++){
            this.vehicles.get(i).setDirection(this.direction);
        }
    }
}
