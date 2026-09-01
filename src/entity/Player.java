package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp,KeyHandler keyH){
        this.keyH = keyH;
        this.gp = gp;

        setDefaultValues();
    }

    void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 5;
    }

    public void getPlayerImage(){
        try {
            down[0] = ImageIO.read(getClass().getResourceAsStream("/player/walk_down_1"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void update(){

        if(keyH.upPressed){
            y-=speed;
        } else if (keyH.downPressed) {
            y+=speed;
        } else if (keyH.leftPressed) {
            x -= speed;
        } else if (keyH.rightPressed) {
            x+=speed;
        }
    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.white);

        g2.fillRect(x,y,gp.tileSize,gp.tileSize);
    }
}
