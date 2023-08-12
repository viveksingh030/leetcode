package rejex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IpAddressValidation {
    private final String ipv4Regex = "^((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)$";

    private final String ipv6Regex = "^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$";


    public String validIPAddress(String queryIP) {
        return queryIP.matches(ipv4Regex)?"IPv4":(queryIP.matches(ipv6Regex)?"IPv6":"Neither");
    }
}
