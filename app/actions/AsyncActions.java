package actions;

import play.libs.Akka;
import play.libs.F.Promise;

import java.util.concurrent.Callable;

/**
 * Playground (no pun intended for Async actions
 *
 * @author npeeters
 */
public class AsyncActions {

//    Promise<Double> promiseOfPIValue = computePIAsynchronously();

//    Promise<Result> promiseOfResult = promiseOfPIValue.map(
//            new F.Function<Double,Result>() {
//                public Result apply(Double pi) {
//                    return ok("PI value computed: " + pi);
//                }
//            }
//    );
//
//
//    private Promise<Double> computePIAsynchronously() {
//        Future<Double> doubleFuture = new Future<Double>();
//        return new Promise<Double>(doubleFuture);
//    }

    private static Double intensiveComputation() {
        return Math.PI;
    }


    /**
     * Play 2.0 asynchronous API methods give you a Promise.
     * This is the case when you are calling an external web service using the play.libs.WS API,
     * or if you are using Akka to schedule asynchronous tasks or to communicate with Actors using play.libs.Akka.
     * A simple way to execute a block of code asynchronously and to get a Promise is to use the play.libs.Akka helpers:
     */

    public Promise<Double> promiseOfInt = Akka.future(
            new Callable<Double>() {
                public Double call() {
                    return intensiveComputation();
                }
            }
    );
}
