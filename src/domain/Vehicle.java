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

    public Vehicle() {
    }

    public Vehicle(int id, double x, double y, int imgNum, Image image, ArrayList<Image> sprite) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.imgNum = imgNum;
        this.image = image;
        this.sprite = sprite;
    }

    public Vehicle(double x, double y, int imgNum) {
        this.x = x;
        this.y = y;
        this.imgNum = imgNum;
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
