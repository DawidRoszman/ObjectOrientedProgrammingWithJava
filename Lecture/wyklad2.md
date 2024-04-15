
    Pakiety
    - wildcards
    - naming conflicts
    - creating packages
    - compiling and running code
    - running programs

```java
import java.util.Random; // importuje pojedyncza klase random
// import java.util.*; // importuje wszystko z pakietu util

public class ImportExample {
    public static void main(String[] args){
        Random r = new Random();
        System.out.println(r.nextInt(10));
    }
}
```

packetA{
    A
    packetB{
        B
        packetC{
            C
        }
    }
}


```java
import packetA.packetB.packetC.*; // import wszystkiego z pakietu C
import packetA.packetB.*; // import wszystkiego TYLKO z pakietu B (nie z C)
import packetA.* // import wszystkiego TYLKO z pakietu A (nie C ani B)
```


java.lang - automatycznie importowany pakiet w każdym programie Java

# Tworzenie pakietu i importowanie klas do innego pakietu

plik ClassA.java
```java
package packageA;

public class ClassA{
}
```

plik ClassB.java
```java
package packageB;

import packageA.ClassA;

public class ClassB {
    public static void main(String[] args){
        ClassA a;
        System.out.println("Got in");
    }
}
```
pic - kolejność w pliku (package, import, class)
class jest wymagane w każdym pliku .java, reszta jest opcjonalna

```java
package structure;
import java.util.*;
public class Cat {
    double weight; //jeżeli nie ma słowa oznaczającego poziom dostępu do zmiennej - domyślnie package private
    double height;
    public double getWeight() {
        return weight;
    }
}
```
zmienne, konstruktory, metody - kolejność w klasie

tylko jedna klasa w pliku może być klasą publiczną

    podstawowe typy danych:
    - boolean
    - byte      8-bit integral value    123
    - short     16-bit integral value   123
    - int       32-bit integral value   123
    - long      64-bit integral value   123L
    - float     32-bit integral value   123.123
    - double    64-bit integral value   123.123
    - char      16-bit integral value   'a'

domyślny typ to int

zmienne przecinkowe domyślnie to double

```java
java.util.Date today;
String greeting;
```

# powołanie obiektu
```java
today = new java.util.Date();
greeting = new String("How are you?");
```

# referencja obiektu
obiekt może być dostępna tylko przy użyciu referencji do miejsca w pamięci
today - referencja do obiektu klasy A Date
greeting - referencja do obiektu klasy A String



zmiennej referencyjnej można przypisać wartość null

# Konwencja nazewnictwa !!!
    - CamelCase - dla nazw klas
    - lowerCamelCase - dla nazw zmiennych, metod, pakietów
    - snake_case z dużymi literami - dla stałych (static final) i wartości enum (Color.RED)


# słowa zarezerwowane
    - this - odwoływanie do obiektu obecnej klasy
    - super - odwoływanie się do obiektu klasy nadrzędnej
    - switch - #TODO poczytać
    - instanceof - czy coś w zmiennej jest obiektem określonej klasy
    - abstract - klasy lub metody abstrakcyjne
    - interface - do grupowania klas 
    - implements - w klasach do zaimplementowania interface
    - extends - oznacza ze klasa odzicza inną


```java
public class Phone{
    private String number;

    public Phone(String number){ //konstruktor ponieważ nazwa taka sama jak klasa i nie ma typu jaki zwraca (nawet void)
        this.number = number;
    }
}
```

# zmienne instancji i zmienne klasy są domyślnie inicjowane
    - boolean - false
    - byte, short, int, long - 0 (w odpowiedniej długości dla zmiennej)
    - float, double - 0.0 (w odpowiedniej długości dla zmiennej)
    - char - '\u0000' (NUL)
    - pozostałe - null

zmienne są dostępne w zakresie klamerek


```java
public class Mouse {
    static int maxLength = 5; // zmienna klasy
    private int length; // zmienna instancji
    public void grow(int inches){ // zmienna dostępna jako parametr w grow
        if (length < maxLength){
            int newSize = length + inches; // zmienna dostępna metodzie grow
            length = newSize;
        }
    } 
}
```

garbage collector

```
1: public class Scope {
2:  public static void main(String[] args) {
3:      String one, two;
4:      one = new String("a"); 
5:      two = new String("b");
6:      one = two; // one wskazuje w pamięci na wartość "b", na "a" nie wskazuje nic, więc jest zauważony przez (eligible for) garbage collector
7:      String three = one; // 3 zmienne wskzują na "b" (one, two, three)
8:      one = null; // 2 zmienne wskazują na "b" (two, three)
9: } }
```

