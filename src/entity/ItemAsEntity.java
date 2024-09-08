package entity;

import items.Item;

public class ItemAsEntity extends Entity{
    public Item item;
    public ItemAsEntity(Item item) {
        super(item.gamePanel);
        this.item = item;
        restSouth = item.icon;
    }
}
