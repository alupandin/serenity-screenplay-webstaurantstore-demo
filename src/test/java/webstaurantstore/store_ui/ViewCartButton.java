package webstaurantstore.store_ui;

import net.serenitybdd.screenplay.targets.Target;
/**
 * Collection of web elements related to cart as they are displayed on storefront page
 */
public class ViewCartButton {
    public static Target VIEW_CART_BUTTON = Target.the("view cart button").locatedBy("//a[@data-testid='cart-button']");
}
