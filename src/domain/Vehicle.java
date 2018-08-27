/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import javafx.scene.image.Image;

/**
 *
 * @author marca
 */
public class Vehicle {
    
    private static final int size = 50;

    private int id;
    private double x;
    private double y;
    private int imgNum;
    private Image image;
    private ArrayList<Image> sprite;
    private int speed;
    private boolean direction;
    private boolean canMove;

    public Vehicle() {
    }

    public Vehicle(int id, double x, double y, int imgNum, Image image, ArrayList<Image> sprite,
            int speed) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.imgNum = imgNum;
        this.image = image;
        this.sprite = sprite;
        this.speed = speed;
        this.direction = true;
        this.canMove = true;
    }

    public Vehicle(double x, double y, int imgNum) {
        this.x = x;
        this.y = y;
        this.imgNum = imgNum;
        this.canMove = true;
        this.direction = true;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isDirection() {
        return direction;
    }

    public void setDirection(boolean direction) {
        this.direction = direction;
    }

    public boolean isCanMove() {
        return canMove;
    }

    public void setCanMove(boolean canMove) {
        this.canMove = canMove;
    }
    
    public void move(){
        if(canMove){
            if(direction){//if direction is true, the vehicle can move down 
                this.y = this.y + speed;
            }else{
                this.y = this.y - speed;
            }
        }
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getImgNum() {
        return imgNum;
    }

    public void setImgNum(int imgNum) {
        this.imgNum = imgNum;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public ArrayList<Image> getSprite() {
        return sprite;
    }

    public void setSprite(ArrayList<Image> sprite) {
        this.sprite = sprite;
    }
    
    
}
