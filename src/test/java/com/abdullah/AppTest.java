package com.abdullah;

import static org.junit.Assert.assertTrue;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

  /**
   * Rigorous Test :-)
   */
  @Test
  public void shouldAnswerWithTrue() {
    assertTrue(true);
  }

  @Test
  public void name() {
    App app = new App();
    List<String> list = app.list("/Users/byil/Downloads/root");
    Assert.assertFalse(list.isEmpty());

  }

  @Test
  public void dosyaOkuma() {
    App app = new App();
    List<String> words = app.readAllWords("/Users/byil/Downloads/root/2018-01-12/data5.log");
    Assert.assertFalse(words.isEmpty());
  }
}

