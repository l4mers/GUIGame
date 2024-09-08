package items;

import main.GamePanel;

public class Arrow extends Item{

    public Arrow(GamePanel gamePanel) {
        super(gamePanel);
        setDefaultValues();
        setIcon();
    }
    private void setDefaultValues(){
        name = "Arrow";
        attackValue = 1;
        stackAble = true;
        toolTip = "ATTRIBUTE VALUES\nAttack +" + attackValue;

        attackAreaX = 25;
        attackAreaY = 25;

        //type
        type = projectile;
        projectileType = arrow;
        useFrequency = 35;
    }
    private void setIcon(){
        icon = super.setUp("/items/arrow_west", gamePanel.tileSize, gamePanel.tileSize);
    }

}
