package fr.xebia.katas.gildedrose;

import static org.fest.assertions.Assertions.*;

import org.junit.Test;

public class InnTest {

  @Test
  public void should_test_the_truth() throws Exception {
    assertThat(true).isTrue();
  }

  @Test
  public void update_lowers_value_of_all_items() throws Exception {
    Inn inn = new Inn();
    inn.updateQuality();
  }
}
