package com.all.guava;

import com.google.common.util.concurrent.RateLimiter;
import org.junit.Test;

/**
 * @author: ps
 * @since: 2019/4/3  1:06 PM
 * @version: 1.0.0
 */
public class RateLimiterTest {

    @Test
    public void smoothBurstyTest() {
        RateLimiter limiter = RateLimiter.create(5);

        while (true) {
            System.out.println("get 1 tokens: " + limiter.acquire() + "s");
        }
    }

    @Test
    public void testSmoothBursty3() {

        RateLimiter r = RateLimiter.create(5);

        while (true) {

            System.out.println("get 5 tokens: " + r.acquire(5) + "s");

            System.out.println("get 1 tokens: " + r.acquire(1) + "s");

            System.out.println("get 1 tokens: " + r.acquire(1) + "s");

            System.out.println("get 1 tokens: " + r.acquire(1) + "s");

            System.out.println("end");
        }
    }
}
