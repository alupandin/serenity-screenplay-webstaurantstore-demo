package webstaurantstore.store_ui;

import net.serenitybdd.screenplay.targets.Target;
/**
 * Collection of web elements related to search results table as they are displayed on storefront page
 */
public class SearchResultTable {
    public static Target RESULT_PRODUCTS_ROW = Target.the("results table").locatedBy("//span[@data-testid='itemDescription']");
    public static Target NEXT_BUTTON = Target.the("next arrow button").locatedBy("//li[contains(@class, 'rounded-r-md')]/a[contains(@aria-label, 'go to page')]");
    public static Target LAST_PAGE_BUTTON = Target.the("last page button").locatedBy("//a[contains(@aria-label, 'last page')]");
}
