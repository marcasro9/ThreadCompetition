/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;

/**
 *
 * @author marca
 */
public class MoveObject  extends Vehicle{
    
    public MoveObject(int x, int y, int imgNum) throws FileNotFoundException {
        super(x,y,imgNum);
        setSprite();
    }

    public MoveObject() {
    }

    
    //Change
    public void setSprite() throws FileNotFoundException{
        ArrayList<Image> sprite = super.getSprite();
        //for(int i = 0; i < 8; i++){
            sprite.add(new Image(new FileInputStream("src/Assets/Coche"+2+".png")));
            
        //}
        super.setSprite(sprite);
    }
    
    //Change
    public void run() {
        ArrayList<Image> sprite = super.getSprite();
        super.setImage(sprite.get(0));
        while (true) {
            try {
                super.setX(100);
                Thread.sleep(100);
                super.setImage(sprite.get(1));
                
                super.setX(130);
                Thread.sleep(100);
                super.setImage(sprite.get(2));
                
                super.setX(160);
                Thread.sleep(100);
                super.setImage(sprite.get(3));
                
                super.setX(190);
                Thread.sleep(100);
                super.setImage(sprite.get(4));
                
                super.setX(220);
                Thread.sleep(100);
                super.setImage(sprite.get(5));
                
                super.setX(250);
                Thread.sleep(100);
                super.setImage(sprite.get(6));
                
                super.setX(280);
                Thread.sleep(100);
                super.setImage(sprite.get(7));
                
                super.setX(310);
                Thread.sleep(100);
                super.setImage(sprite.get(1));
                
                super.setX(340);
                Thread.sleep(100);
                super.setImage(sprite.get(2));
                
                super.setX(370);
                Thread.sleep(100);
                super.setImage(sprite.get(3));
                
                super.setX(400);
                Thread.sleep(100);
                super.setImage(sprite.get(4));
                
                super.setX(430);
                Thread.sleep(100);
                super.setImage(sprite.get(5));
                
                
            } 
            catch (InterruptedException ex) {}
        }
    }

}
