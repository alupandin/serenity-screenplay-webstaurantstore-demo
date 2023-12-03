package webstaurantstore.tasks;


import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import webstaurantstore.store_ui.CartDetailsView;

public class EmptyCart {
        public static Performable withEmptyCartButton() {
        return Task.where("{0} empties cart using 'Empty Cart Button'",
                Click.on(CartDetailsView.EMPTY_CART_BUTTON)
                .then(WaitUntil.the(CartDetailsView.EMPTY_CART_CONFIRM_BUTTON, WebElementStateMatchers.isVisible()))
                .then(Click.on(CartDetailsView.EMPTY_CART_CONFIRM_BUTTON))
                .then(WaitUntil.the(CartDetailsView.EMPTY_CART_MESSAGE, WebElementStateMatchers.isVisible()))
        );
        }

        public static Performable withDeleteCartItemButton(){
        return Task.where("{0} empties cart using delete cart item 'X' button",
                Click.on(CartDetailsView.DELETE_CART_ITEM_BUTTON)
                .then(WaitUntil.the(CartDetailsView.EMPTY_CART_MESSAGE, WebElementStateMatchers.isVisible()))
        );
    }
}
