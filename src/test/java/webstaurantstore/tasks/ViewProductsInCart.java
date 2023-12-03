package webstaurantstore.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import webstaurantstore.store_ui.ViewCartButton;
/**
 * Tasks relating to viewing product in a cart.
 */
public class ViewProductsInCart {
        public static Performable goToCart(String searchTerm) {
        return Task.where("{0} views added products '" + searchTerm + "' in cart cart",
                Click.on(ViewCartButton.VIEW_CART_BUTTON)
        );
    }
}
