package calc;

public class Price {


    public static double priceGuest(int guests, String desert) {
        double pricePerGuest = guests * 22.9;
        if (desert.equals("s")) {
            double priceDesert = pricePerGuest * 0.1;
            pricePerGuest = pricePerGuest + priceDesert;
            return pricePerGuest;
        } else {
            return pricePerGuest;
        }
    }

    public static double priceGuests (int guests, double pricePerGuest) {
        return pricePerGuest * guests;
    }

    public static int countWaiter(int guests) {
        return guests / 15;
    }

    public static double priceWaiter(int countWaiter) {
        double priceWaiter = countWaiter * 250;
        return priceWaiter;
    }

    public static double priceTotal(int guests, double pricePerGuest, double priceWaiter) {
            return (pricePerGuest * guests) + priceWaiter;
    }
}


