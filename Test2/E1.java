import java.util.function.*;

public class E1 {
    int age;

    public static void main(String[] args) {
        E1 p1 = new E1();
        p1.age = 1;
        check(p1, p -> p.age < 5);
    }

    private static void check(E1 panda,
            Predicate<E1> pred) {
        String result = pred.test(panda) ? "match" : "not match";
        System.out.print(result);
    }
}
