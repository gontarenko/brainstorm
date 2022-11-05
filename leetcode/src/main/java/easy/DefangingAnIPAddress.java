package easy;

import static org.junit.Assert.assertEquals;

/**
 * 1108. Defanging an IP Address
 */
public class DefangingAnIPAddress {
    public static void main(String[] args) {
        var solution = new DefangingAnIPAddress();
        var input = "1.1.1.1";
        var expected = "1[.]1[.]1[.]1";
        assertEquals(expected, solution.defangIPaddr(input));
    }

    public String defangIPaddr(String address) {
        return address.replaceAll("[.]", "[.]");
    }
}
