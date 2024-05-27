import java.util.ArrayList;
import java.util.function.Predicate;

public class Offers {
    private ArrayList<Building> offers;

    public Offers() {
        offers = new ArrayList<>();
    }

    public Offers(ArrayList<Building> offers) {
        this.offers = offers;
    }

    public ArrayList<Building> getOffers() {
        return offers;
    }

    public void setOffers(ArrayList<Building> offers) {
        this.offers = offers;
    }

    public void add(Building building) {
        offers.add(building);
    }

    public ArrayList<Building> filter(Predicate<Building> checker) {
        ArrayList<Building> matchingOffers = new ArrayList<>();
        for (Building offer : offers) {
            if (checker.test(offer)) {
                matchingOffers.add(offer);
            }
        }
        return matchingOffers;
    }

}
