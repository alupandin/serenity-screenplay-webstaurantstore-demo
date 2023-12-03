package webstaurantstore.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import webstaurantstore.store_ui.SearchButton;
import webstaurantstore.store_ui.SearchField;
import webstaurantstore.store_ui.SearchResultTable;

import org.openqa.selenium.Keys;
/**
 * Collection of tasks related to searching for the product, using ENTER key, using search magnifying glass button and navigating to next page of search results
 */
public class LookForProduct {
    public static Performable withEnterKey(String searchTerm) {
        return Task.where("{0} searches for '" + searchTerm + "' using enter key",
                Enter.theValue(searchTerm)
                        .into(SearchField.SEARCH_FIELD)
                        .thenHit(Keys.ENTER)
                        .then(WaitUntil.the(SearchResultTable.RESULT_PRODUCTS_ROW, WebElementStateMatchers.isVisible()))
        );
    }

    public static Performable wihtSearchBtn(String searchTerm) {
        return Task.where("{0} searches for '" + searchTerm + "' using search button",
                Enter.theValue(searchTerm)
                        .into(SearchField.SEARCH_FIELD),
                Click.on(SearchButton.SEARCH_BUTTON),
                WaitUntil.the(SearchResultTable.RESULT_PRODUCTS_ROW, WebElementStateMatchers.isVisible())
        );
    }

    //
    public static Performable nextProductPage(){
        return Task.where("{0} navigates to next page of results",
                Click.on(SearchResultTable.NEXT_BUTTON),
                WaitUntil.the(SearchResultTable.RESULT_PRODUCTS_ROW, WebElementStateMatchers.isVisible())
        );
    }
}
