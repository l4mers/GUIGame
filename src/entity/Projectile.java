package entity;

import items.Item;
import main.GamePanel;

public class Projectile extends Entity{

    Entity user;

    public Projectile(Item item) {
        super(item);
        gamePanel = item.gamePanel;

        setUpProjectile();
    }

    private void setUpProjectile() {
        if (itemAsEntity.projectileType == 0){

            name = itemAsEntity.getName();
            speed = 7;
            maxHealth = 60;
            currentHealth = maxHealth;
            alive = false;
            attack = itemAsEntity.attackValue;

            setUpImage("/items/arrow_north", "/items/arrow_north", "/items/arrow_north", "/items/arrow_south", "/items/arrow_south",
                    "/items/arrow_south", "/items/arrow_west", "/items/arrow_west_fall", "/items/arrow_west_stop",
                    "/items/arrow_east", "/items/arrow_east_fall", "/items/arrow_east_stop");
        }
    }

    private void setUpImage(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, String s10, String s11) {
        restNorth = setUp(s, gamePanel.tileSize, gamePanel.tileSize);
        northOne = setUp(s1, gamePanel.tileSize, gamePanel.tileSize);
        northTwo = setUp(s2, gamePanel.tileSize, gamePanel.tileSize);
        restSouth = setUp(s3, gamePanel.tileSize, gamePanel.tileSize);
        southOne = setUp(s4, gamePanel.tileSize, gamePanel.tileSize);
        southTwo = setUp(s5, gamePanel.tileSize, gamePanel.tileSize);
        restWest = setUp(s6, gamePanel.tileSize, gamePanel.tileSize);
        westOne = setUp(s7, gamePanel.tileSize, gamePanel.tileSize);
        westTwo = setUp(s8, gamePanel.tileSize, gamePanel.tileSize);
        restEast = setUp(s9, gamePanel.tileSize, gamePanel.tileSize);
        eastOne = setUp(s10, gamePanel.tileSize, gamePanel.tileSize);
        eastTwo = setUp(s11, gamePanel.tileSize, gamePanel.tileSize);
    }

    public void set(int worldX, int worldY, String direction, boolean alive, Entity user){
        this.worldX = worldX;
        this.worldY = worldY;
        this.direction = direction;
        this.alive = alive;
        this.user = user;
        this.currentHealth = this.maxHealth;
    }

    public void update(){

        if(user.equals(gamePanel.player)){
            int mosterIndex = gamePanel.hitBoxChecker.checkMobile(this, gamePanel.foe);
            if(mosterIndex != 999){
                gamePanel.player.damageFoe(mosterIndex, attack);
                alive = false;
            }
        } else{

        }

        switch(direction){
            case "north" -> worldY -= speed;
            case "south" -> worldY += speed;
            case "west" -> worldX -= speed;
            case "east" -> worldX += speed;
        }

        currentHealth--;
        if(currentHealth < 0){
            alive = false;
        }

        spriteCount++;
        if(spriteCount > 15) {
            spriteSwapAnimation = !spriteSwapAnimation;
            spriteCount = 0;
        }
    }
}
