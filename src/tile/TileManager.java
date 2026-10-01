package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;

public class TileManager {
    GamePanel gp;
    Tile[] tile;

    public TileManager(GamePanel gp){
        this.gp = gp;
        tile = new Tile[10];
        getTileImage();
    }

    public void getTileImage(){
        try{
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream(""));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void draw(Graphics2D g2){
        g2.drawImage(tile[0].image,0,0,gp.tileSize,gp.tileSize,null);
    }
}
