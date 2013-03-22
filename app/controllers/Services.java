package controllers;

import play.libs.F;
import play.libs.WS;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * This is a controller to experiment with the Webservices and the Promise APIs.
 *
 * @author npeeters
 */
public class Services extends Controller {

    public static Result getHomePage() {
        F.Promise<WS.Response> homePage = WS.url("http://www.infohubble.com").get();
        String body = homePage.get().getBody();
        return ok(body); //this dump the whole HTML to the body.
    }

    public static void postHomepage() {
        F.Promise<WS.Response> result = WS.url("http://localhost:9001").post("content");
    }
}
