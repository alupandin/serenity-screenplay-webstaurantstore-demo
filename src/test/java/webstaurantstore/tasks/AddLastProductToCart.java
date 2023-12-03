package webstaurantstore.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
/**
 * Tasks methods to add product to cart either directly from results table or after clicking on a product and viewing its details
 */
public class AddLastProductToCart {
        public static Performable addToCartFromResultsTable(String searchTerm) {
        return Task.where("{0} adds '" + searchTerm + "' to cart",
                Click.on("//div[@id='ProductBoxContainer'][last()]//select[@title='Type']")
                .then(Click.on("//div[@id='ProductBoxContainer'][last()]//select[@title='Type']//option[contains(text(),'Sink on Left')]"))
                .then(Click.on("//div[@id='ProductBoxContainer'][last()]//input[@value='Add to Cart']"))
        );
    }

        public static Performable addToCartFromProductDetails(String searchTerm) {
        return Task.where("{0} adds '" + searchTerm + "' to cart",
                Click.on("#Type")
                .then(Click.on("//option[contains(text(), 'Sink on Left')]"))
                .then(Click.on("//div[@id='addToCartContainer']//input[@id='buyButton']"))
        );
    }
}
