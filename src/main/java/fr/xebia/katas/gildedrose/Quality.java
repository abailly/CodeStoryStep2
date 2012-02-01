/*
 * Copyright 2012 PolySpot, S.A.S. All Rights Reserved.
 * This software is the proprietary information of PolySpot, S.A.S. Use is subject to license terms.
 */
package fr.xebia.katas.gildedrose;

public class Quality {

  private int accruedTime = 0;

  interface Rule {
    Item apply(Item item);

    boolean canApply(Quality quality, Item item);
  }

  private final Rule standardDegradation = new Rule() {

    @Override
    public Item apply(Item item) {
      return new Item(item.getName(), item.getSellIn(), item.getQuality() - 1);
    }

    @Override
    public boolean canApply(Quality quality, Item item) {
      return true;
    }

  };

  private final Rule doubleDegradation = new Rule() {

    @Override
    public Item apply(Item item) {
      return new Item(item.getName(), item.getSellIn(), item.getQuality() - 2);
    }

    @Override
    public boolean canApply(Quality quality, Item item) {
      return quality.accruedTime >= item.getSellIn();
    }

  };

  public Item endOfDay(Item item) {
    accruedTime++;
    if (doubleDegradation.canApply(this, item)) {
      return doubleDegradation.apply(item);
    } else {
      return standardDegradation.apply(item);
    }
  }

  public void timeTravelBy(int offsetInDays) {
    this.accruedTime += offsetInDays;
  }

}
