package fr.xebia.katas.gildedrose;

import static org.fest.assertions.Assertions.*;

import org.fest.assertions.Assertions;
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
    Assertions.assertThat(inn.items.get(0).getQuality()).isEqualTo(19);
  }

  @Test
  public void brie_increases_quality_with_time() throws Exception {
    Inn inn = new Inn();
    inn.updateQuality();
    Assertions.assertThat(inn.items.get(1).getQuality()).isEqualTo(1);
  }

  @Test
  public void backstage_quality_increases() throws Exception {
    Inn inn = new Inn();
    Item backstage = inn.items.get(4);

    inn.updateQuality();
    assertThat(backstage.getQuality()).isEqualTo(21);

    inn.updateQuality();
    assertThat(backstage.getQuality()).isEqualTo(22);

    inn.updateQuality();
    inn.updateQuality();
    inn.updateQuality();
    inn.updateQuality();
    inn.updateQuality();
    inn.updateQuality();
    inn.updateQuality();
    inn.updateQuality();
    assertThat(backstage.getQuality()).isEqualTo(35);
  }

  @Test
  public void sulfura_quality_is_the_same() throws Exception {
    Inn inn = new Inn();
    inn.updateQuality();
    Assertions.assertThat(inn.items.get(3).getQuality()).isEqualTo(80);
    inn.updateQuality();
    Assertions.assertThat(inn.items.get(3).getQuality()).isEqualTo(80);
  }

  @Test
  public void sulfura_sell_in_is_the_same() throws Exception {
    Inn inn = new Inn();
    inn.updateQuality();
    Assertions.assertThat(inn.items.get(3).getSellIn()).isEqualTo(0);
  }

  @Test
  public void conjured_quality_degrades_twice_as_fast() throws Exception {
    Inn inn = new Inn();
    inn.updateQuality();
    Assertions.assertThat(inn.items.get(5).getQuality()).isEqualTo(4);
  }

}
