import java.util.ArrayList;
import java.util.function.Predicate;

public class Calendar {
    public static final int CALENDAR_LENGTH = 7;
    private ArrayList<ArrayList<Element>> elements;

    public Calendar() {
        elements = new ArrayList<>();

        for (int i = 0; i < CALENDAR_LENGTH; i++) {
            elements.add(new ArrayList<>());
        }
    }

    public void addElement(int dayNumber, Meeting meeting) {
        elements.get(dayNumber).add(meeting);
    }
    public void addElement(int dayNumber, Task task) {
        elements.get(dayNumber).add(task);
    }

    public void removeElement(int dayNumber, Element element) {
        elements.get(dayNumber).remove(element);
    }
    public ArrayList<Element> getElementsFromDay(int dayNumber, Predicate<Element> checker) {
        ArrayList<Element> matchingElements = new ArrayList<>();
        for (Element element : elements.get(dayNumber)) {
            if (checker.test(element)) {
                matchingElements.add(element);
            }
        }
        return matchingElements;
    }
}
