package webstaurantstore.nav;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavToPage {
    public static Performable theSearchLandingPage() {
        return Task.where("{0} opens the DuckDuckGo home page",
                Open.browserOn().the(Webstaurantstorepage.class));
    }
}
