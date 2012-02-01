package fr.xebia.katas.gildedrose;

import java.util.ArrayList;
import java.util.List;

public class Inn {

  public static final Item DEXTERITY_VEST = new Item("+5 Dexterity Vest", 10, 20);

  public List<Item> items;

  Item OMG = new Item("Aged Brie", 2, 0);

  public Inn() {
    items = new ArrayList<Item>();
    items.add(DEXTERITY_VEST);
    items.add(OMG);
    items.add(new Item("Elixir of the Mongoose", 5, 7));
    items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
    items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
    items.add(new Item("Conjured Mana Cake", 3, 6));
  }

  public void updateQuality() {

    for (int i = 0; i < items.size(); i++) {
      Item item = items.get(i);
      if (item.getQuality() < 50) {

        if (!isBrie(item) && !isBackstage(item) && item.getQuality() > 0 && notSulfuras(item)) {
          item.setQuality(item.getQuality() - 1);
        }

        if (isConjured(item)) {
          item.setQuality(item.getQuality() - 1);
        }

        if (isBrie(item)) {
          item.setQuality(item.getQuality() + 1);
        }

        if (isBackstage(item)) {
          item.setQuality(item.getQuality() + 1);

          if (item.getSellIn() < 11) {
            item.setQuality(item.getQuality() + 1);
          }

          if (item.getSellIn() < 6) {
            item.setQuality(item.getQuality() + 1);
          }
        }
      }

      if (sellIn0(item)) {
        item.setQuality(item.getQuality() - 1);
      }

      if (isBackstageAndSellIn0(item)) {
        item.setQuality(0);
      }

      if (brieSellIn0(item)) {
        item.setQuality(item.getQuality() + 1);
      }

      if (notSulfuras(item)) {
        item.setSellIn(item.getSellIn() - 1);
      }

    }

  }

  /**
   * @param item
   * @return
   */
  private boolean isConjured(Item item) {
    return item.getName().startsWith("Conjured");
  }

  boolean isBrie(Item item) {
    return item.getName().equals("Aged Brie");
  }

  boolean isBackstage(Item item) {
    return item.getName().equals("Backstage passes to a TAFKAL80ETC concert");
  }

  boolean notSulfuras(Item item) {
    return !item.getName().equals("Sulfuras, Hand of Ragnaros");
  }

  boolean brieSellIn0(Item item) {
    return item.getSellIn() < 0 && isBrie(item) && item.getQuality() < 50;
  }

  boolean isBackstageAndSellIn0(Item item) {
    return item.getSellIn() < 0 && !isBrie(item) && isBackstage(item);
  }

  boolean sellIn0(Item item) {
    return item.getSellIn() < 0 && !isBrie(item) && !isBackstage(item) && item.getQuality() > 0 && notSulfuras(item);
  }

  public static void main(String[] args) {
    System.out.println("OMGHAI!");
    new Inn().updateQuality();
  }

}
