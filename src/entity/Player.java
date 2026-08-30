package entity;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp,KeyHandler keyH){
        this.keyH = keyH;
        this.gp = gp;
    }

    void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 5;
    }
}
