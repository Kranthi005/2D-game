package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH) {

        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {

        x = 100;
        y = 100;

        speed = 5;

        direction = "down";

        spriteNum = 0;
        spriteCounter = 0;
    }

    public void getPlayerImage() {

        try {

            BufferedImage spriteSheet = ImageIO.read(
                    getClass().getResourceAsStream("/Player/PlayerWalk.png")
            );

            int frameWidth = 40;
            int frameHeight = 48;


            for (int i = 0; i < 4; i++) {

                left[i] = spriteSheet.getSubimage(i * frameWidth, 0, frameWidth, frameHeight);

                right[i] = spriteSheet.getSubimage(i * frameWidth, frameHeight, frameWidth, frameHeight);

                up[i] = spriteSheet.getSubimage(i * frameWidth, frameHeight * 2, frameWidth, frameHeight);

                down[i] = spriteSheet.getSubimage(i * frameWidth, frameHeight * 3, frameWidth, frameHeight);
            }

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    public void update() {

        if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {

            if (keyH.upPressed) {
                direction = "up";
                y -= speed;
            }
            else if (keyH.downPressed) {
                direction = "down";
                y += speed;
            }
            else if (keyH.leftPressed) {
                direction = "left";
                x -= speed;
            }
            else {
                direction = "right";
                x += speed;
            }

            spriteCounter++;

            if (spriteCounter > 10) {
                spriteNum++;
                if (spriteNum >= 4) {
                    spriteNum = 0;
                }
                spriteCounter = 0;
            }
        } else {
            spriteNum = 0;
            spriteCounter = 0;
        }
    }

    public void draw(Graphics2D g2) {

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

        if (image != null) {
            g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
        }
    }
}