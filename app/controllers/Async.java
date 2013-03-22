package controllers;

import play.Logger;
import play.libs.Akka;
import play.libs.F;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.concurrent.Callable;

/**
 * Playground (no pun intended for Async actions
 *
 * @author npeeters
 */
public class Async extends Controller {

    public static Result index() {

        F.Promise<Integer> promiseOfInt = Akka.future(
                new Callable<Integer>() {
                    public Integer call() {
                        return intensiveComputation();
                    }
                }
        );
        return async(
                promiseOfInt.map(
                        new F.Function<Integer, Result>() {
                            public Result apply(Integer i) {
                                return ok("Got result: " + i);
                            }
                        }
                )
        );
    }

    private static Integer intensiveComputation() {
        try {
            return fibonacci(64);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }

    public static Integer fibonacci(int n) throws InterruptedException {
        Logger.info("Starting fibo. Will wait for 3 secs");
//        Thread.sleep(1000);
        Logger.info("Done calculating fibo");

        return 1;
    }

}
