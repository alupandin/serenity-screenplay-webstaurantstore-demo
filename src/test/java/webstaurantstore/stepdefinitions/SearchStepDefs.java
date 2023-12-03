package webstaurantstore.stepdefinitions;

import webstaurantstore.nav.NavToPage;
import webstaurantstore.store_ui.SearchResultTable;
import webstaurantstore.tasks.AddLastProductToCart;
import webstaurantstore.tasks.EmptyCart;
import webstaurantstore.tasks.LookForProduct;
import webstaurantstore.tasks.ViewProductsInCart;

import java.util.List;


import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import net.serenitybdd.screenplay.targets.Target;

public class SearchStepDefs {

    @Given("{actor} is looking for new product to buy")
    public void visitStorePage(Actor actor) {
        actor.wasAbleTo(
                NavToPage.theSearchLandingPage());
    }

    @When("{actor} looks up {string}")
    public void searchesForProduct(Actor actor, String product) {
        //Search for product using enter key
        actor.attemptsTo(
                LookForProduct.withEnterKey(product)
        );

        //Alternatively, search for product using search button
        // actor.attemptsTo(
        //         LookForProduct.wihtSearchBtn(product)
        // );
    }

    private boolean nextButtonVisible(Actor actor){
        return SearchResultTable.NEXT_BUTTON.isVisibleFor(actor);

    }

    private void validateSearchResults(Actor actor, String product){
        List<WebElementFacade> allRows = Target.the("all rows of table").locatedBy("//span[@data-testid='itemDescription']").resolveAllFor(actor);
        for (WebElementFacade row : allRows) {
            actor.attemptsTo(
                Ensure.that(row.getText()).containsIgnoringCase(product));
        }
    }

    @Then("{actor} should see a list of products containing {string}")
    public void should_see_list_of_products(Actor actor, String product){
        //Depening on the size of result table, it could be spread out between multiple pages:
        //Find out if there's a paging element with @id=paging, store it in a list of elements
        //If the list size is 0, means we have products only on 1 page, then validate that one single page
        //Otherwise, find out how many pages total we have, but finding element with "last page" and parseInt to get the int number out of its text
        //For loop to validate results on a page, click the "next page" button, if it exists, and validate results on new page, etc... .
        List<WebElementFacade> pagingElem = Target.the("paging element").locatedBy("#paging").resolveAllFor(actor);
        if(pagingElem.size()!=0){
            WebElementFacade lastPageElem = Target.the("last page of results").locatedBy("//a[contains(@aria-label, 'last page')]").resolveFor(actor);
            int pageCnt = Integer.parseInt(lastPageElem.getText());
            if(lastPageElem.isPresent()){
                for(int i=0; i < pageCnt; i++){
                    validateSearchResults(actor, product);
                    if(nextButtonVisible(actor)){
                        actor.attemptsTo(
                            LookForProduct.nextProductPage());
                        }
                    }
                }
        }
        else{
            validateSearchResults(actor, product);
        }
    }

    @Then("{actor} should add last search result for {string} to cart")
    public void should_add_product_to_cart(Actor actor, String product){
        //Grabbing the last container item from the collection of elements and clicking on it to go into the details
        //where we then add the product to cart
        actor.attemptsTo(Click.on(SearchResultTable.LAST_PAGE_BUTTON));
        List<WebElementFacade> allRows = Target.the("all rows of table").locatedBy("//span[@data-testid='itemDescription']").resolveAllFor(actor);
        actor.attemptsTo(
                Click.on(allRows.get(allRows.size() - 1))
                        .then(AddLastProductToCart.addToCartFromProductDetails(product))
                        .then(ViewProductsInCart.goToCart(product)));

        //Alternatively, add last product to cart straight from the results page.
        // actor.attemptsTo(AddLastProductToCart.addToCartFromResultsTable(product)
        // .then(ViewProductsInCart.goToCart(product)));
    }

    @Then("{actor} should empty the cart")
    public void should_empty_the_cart(Actor actor){
        //Empty cart using the 'Empty Cart' button
        actor.attemptsTo(
            EmptyCart.withEmptyCartButton()
        );

        //Alternatively, can use the 'delete cart item button'
        //actor.attemptsTo(
        //    EmptyCart.withDeleteCartItemButton()
        //);
    }

    @Then("{actor} should see a list of products containing {string} adding the last product to cart")
    public void verify_products_and_add_last_product_to_cart(Actor actor, String product){
        //Depening on the size of result table, it could be spread out between multiple pages:
        //Find out if there's a paging element with @id=paging, store it in a list of elements
        //If the list size is 0, means we have products only on 1 page, then validate that one single page
        //Otherwise, find out how many pages total we have, but finding element with "last page" and parseInt to get the int number out of its text
        //For loop to validate results on a page, click the "next page" button, if it exists, and validate results on new page, etc... .

        //TODO: we are currently failing on the last (9th) page, because there's a product that doesn't contain "Table" in the name
        //Product named "Metro CR2430DSS Drive-Thru Order Prep Station with Stainless Steel Shelving".
        //Suggest use soft asserts, if we would like to have this in a single test and passing. But in my opinion this should be a hard fail.
        List<WebElementFacade> pagingElem = Target.the("paging element").locatedBy("#paging").resolveAllFor(actor);
        if(pagingElem.size()!=0){
            WebElementFacade lastPageElem = Target.the("last page of results").locatedBy("//a[contains(@aria-label, 'last page')]").resolveFor(actor);
            int pageCnt = Integer.parseInt(lastPageElem.getText());
            if(lastPageElem.isPresent()){
                for(int i=0; i < pageCnt; i++){
                    validateSearchResults(actor, product);
                    if(nextButtonVisible(actor)){
                        actor.attemptsTo(
                            LookForProduct.nextProductPage());
                        }
                    }
                }
        }
        else{
            validateSearchResults(actor, product);
        }
        actor.attemptsTo(AddLastProductToCart.addToCartFromResultsTable(product)
                        .then(ViewProductsInCart.goToCart(product)));
    }

}
