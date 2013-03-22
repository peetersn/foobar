package controllers;

import actions.VerboseAction;
import models.Bar;
import play.data.Form;
import play.db.ebean.Model;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.With;
import views.html.index;

import java.util.List;

import static play.libs.Json.toJson;

public class Application extends Controller {
  
    public static Result index() {
        return ok(index.render("Changed.. . Your new application is ready."));
    }

    public static Result addBar() {
        Bar bar = Form.form(Bar.class).bindFromRequest().get();
        System.out.println( "Saving bar '" +bar.name+"'");
        bar.save();
        System.out.println( "Bar saved");
        return redirect(routes.Application.index()); //reverse routing
    }

    public static Result getBars() {
        List<Bar> bars = new Model.Finder(String.class, Bar.class).all();
        return ok(toJson(bars));
    }

    public static Result findById(String id) {
        Bar bar = Bar.find.byId(id);
        return ok(bar.name +" ("+bar.id+")");
    }

    /**
     * This is an example of composition with actions.
     * @return
     */
    @With(VerboseAction.class)
    public static Result compose() {
        return ok("It works! This is a composed action");
    }

}
