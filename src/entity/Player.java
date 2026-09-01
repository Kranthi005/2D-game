package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp,KeyHandler keyH){
        this.keyH = keyH;
        this.gp = gp;

        setDefaultValues();
        getPlayerImage();
    }

    void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 5;
        direction = "down";
    }

    public void getPlayerImage() {
        try {
            for (int i = 0; i < 8; i++) {
                down[i] = ImageIO.read(
                        getClass().getResourceAsStream("/Player/WalkDown/walk_down_" + (i + 1) + ".png"));
                up[i] = ImageIO.read(
                        getClass().getResourceAsStream("/Player/WalkDown/walk_down_" + (i + 1) + ".png"));

                left[i] = ImageIO.read(
                        getClass().getResourceAsStream("/Player/WalkDown/walk_down_" + (i + 1) + ".png"));

                right[i] = ImageIO.read(
                        getClass().getResourceAsStream("/Player/WalkDown/walk_down_" + (i + 1) + ".png"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void update(){

        if(keyH.upPressed){
            direction = "up";
            y-=speed;
        } else if (keyH.downPressed) {
            direction = "down";
            y+=speed;
        } else if (keyH.leftPressed) {
            direction = "left";
            x -= speed;
        } else if (keyH.rightPressed) {
            direction = "right";
            x+=speed;
        }

        spriteCounter++;

        if (spriteCounter > 10) {
            spriteNum++;

            if (spriteNum >= 8) {
                spriteNum = 0;
            }

            spriteCounter = 0;
        }
    }

    public void draw(Graphics2D g2){
            BufferedImage image = null;

            switch (direction) {
                case "up":
                    image = up[spriteNum];
                    break;

                case "down":
                    image = down[spriteNum];
                    break;

                case "left":
                    image = left[spriteNum];
                    break;

                case "right":
                    image = right[spriteNum];
                    break;
            }

            g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
        }
}
