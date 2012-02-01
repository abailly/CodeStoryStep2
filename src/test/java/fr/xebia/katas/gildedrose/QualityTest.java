/*
 * Copyright 2012 PolySpot, S.A.S. All Rights Reserved.
 * This software is the proprietary information of PolySpot, S.A.S. Use is subject to license terms.
 */
package fr.xebia.katas.gildedrose;

import static fr.xebia.katas.gildedrose.Inn.*;
import static org.fest.assertions.Assertions.*;

import org.junit.Test;

public class QualityTest {

  @Test
  public void lower_quality_by_1_at_end_of_day() throws Exception {
    Quality quality = new Quality();
    Item degradedVest = quality.endOfDay(DEXTERITY_VEST);

    assertThat(degradedVest.getQuality()).isEqualTo(19);
  }

  @Test
  public void once_the_sell_by_date_has_passed_quality_degrades_twice_as_fast() throws Exception {
    Quality quality = new Quality();
    quality.timeTravelBy(10);
    Item degradedVest = quality.endOfDay(DEXTERITY_VEST);

    assertThat(degradedVest.getQuality()).isEqualTo(18);
  }

}
