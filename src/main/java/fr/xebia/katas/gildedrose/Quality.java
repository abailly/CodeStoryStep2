/*
 * Copyright 2012 PolySpot, S.A.S. All Rights Reserved.
 * This software is the proprietary information of PolySpot, S.A.S. Use is subject to license terms.
 */
package fr.xebia.katas.gildedrose;

public class Quality {

  private int accruedTime;

  public Item endOfDay(Item dexterityVest) {
    accruedTime++;
    return new Item(dexterityVest.getName(), dexterityVest.getSellIn(),
      dexterityVest.getSellIn() > accruedTime ? dexterityVest.getQuality() - 1 : dexterityVest.getQuality() - 2);
  }

  public void timeTravelBy(int offsetInDays) {
    this.accruedTime = offsetInDays;
  }

}
