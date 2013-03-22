package actions;

import play.Logger;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.Result;

public class VerboseAction extends Action.Simple {

    public Result call(Http.Context ctx) throws Throwable {
        Logger.info("Calling action for " + ctx);
        return delegate.call(ctx);
    }
}


