import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShoppingCartTest {
    @Test
    public void calculatePrice() {
        assertEquals(10.0, ShoppingCart.calculatePrice(5.0, 2), 0.01);
    }

    @Test
    public void getLanguageBundle() {
        assertEquals("en", ShoppingCart.getLanguageBundle(1).getLocale().getLanguage());
        assertEquals("sv", ShoppingCart.getLanguageBundle(2).getLocale().getLanguage());
        assertEquals("fi", ShoppingCart.getLanguageBundle(3).getLocale().getLanguage());
        assertEquals("ja", ShoppingCart.getLanguageBundle(4).getLocale().getLanguage());
        assertEquals("en", ShoppingCart.getLanguageBundle(5).getLocale().getLanguage());
    }
}
