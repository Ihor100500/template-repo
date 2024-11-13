package edu.ui.template.tests;

import edu.ui.template.base.BaseTest;
import edu.ui.template.utils.MobileElementActions;
import org.junit.jupiter.api.Test;

public class MobileTest extends BaseTest {

  @Test
  public void hybridModeTest() {
    MobileElementActions actions = new MobileElementActions(androidDriver);
  }
}
