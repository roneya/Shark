package com.shark.test.Utility;

import java.util.Base64;
import java.util.concurrent.ThreadLocalRandom;

public class SupplyDetailUtility {

    public static String uuidGenerator() {
        String random = String.valueOf(ThreadLocalRandom.current().nextInt(10000, 100000))
                + String.valueOf(System.currentTimeMillis());
        return Base64.getEncoder().encodeToString(random.getBytes());
    }
}
