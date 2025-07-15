package com.izeye.helloworld;

import java.net.InetAddress;
import java.security.Security;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

/**
 * Tester for {@link InetAddress}.
 *
 * @author Johnny Lim
 */
public class InetAddressTester {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Security.getProperty(\"networkaddress.cache.ttl\"): " + Security.getProperty("networkaddress.cache.ttl"));

        while (true) {
            try {
                // Change entry for "www.izeye.org" in /etc/hosts.
                String hostAddress = InetAddress.getByName("www.izeye.org").getHostAddress();
                System.out.println(Instant.now() + ": " + hostAddress);
            }
            catch (Throwable ex) {
                System.err.println(Instant.now() + ": " + ex.getMessage());
            }
            finally {
                TimeUnit.SECONDS.sleep(1);
            }
        }
    }

}
