package webstaurantstore.store_ui;

import net.serenitybdd.screenplay.targets.Target;
/**
 * Collection of web elements related to cart details view page
 */
public class CartDetailsView {
    public static Target EMPTY_CART_BUTTON = Target.the("empty cart button").locatedBy("//button[@type='button' and text()='Empty Cart']");
    public static Target DELETE_CART_ITEM_BUTTON = Target.the("delete cart item button").locatedBy("//button[contains(@class,'deleteCartItemButton')]");
    public static Target EMPTY_CART_CONFIRM_BUTTON = Target.the("empty cart confirmation button").locatedBy("//div[contains(@class,'ReactModal')]//button[text()='Empty']");
    public static Target EMPTY_CART_MESSAGE = Target.the("empty cart message").locatedBy("//div[contains(@class,'empty-cart')]/p[contains(text(),'Your cart is empty')]");
}
