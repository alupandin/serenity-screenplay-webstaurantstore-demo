package webstaurantstore.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import webstaurantstore.store_ui.SearchResultTable;

import java.util.Collection;
/**
 * A factory class used to provide different questions about the products displayed in results table
 */
public class TheProducts {
    public static Question<Collection<String>> displayed() {
        return Text.ofEach(SearchResultTable.RESULT_PRODUCTS_ROW).describedAs("the products displayed");
    }
}
