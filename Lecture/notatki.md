Dr inż. Tomasz Górski

tomasz.gorski@ug.edu.pl

3 testy 

OCP: Oracle Certified Professional Java SE 11 Programmer

inteliJ

## Pojęcia obiektowości
w obiektach używać tylko własności tych klas
zmienne w metodach
context innych klas
przypisywanie obiektow do roznych klas

klasa jest to szablon, według którego tworzone są obiekty
klasa jest to pojęcie opisujące obiekty o zbliżonych właściwościach

Unified Modeling Language
diagram klasy (class diagram) <---- nauczyć sie tego (narzędzie visual paradime)



Podstawowe zasady obiektowości
- Abstrakcja
    - zapisywanie nezbędnych, istotnych, niepotrzebynych atrybutów
- Hermetyzacja
    - ochrona kodu i danych przed zewnętrzną integracją i niewłaściwym użyciem
- Modułowość
- Dziedziczenie
    - proces dzięki któremu klasa/obiekt nabywa właściwości innej klasy/obiektu (zmienne atrybuty relacje są dziedziczone)
- Polimorfizm
    - zmienne typu podstawowego przechowują wartość
    - zmienne typu referencyjnego przechowują adres w pamięci
        - w zmiennej referencyjnej można przechowywać obiekty różnych klas
        - ten sam obiekt może być dostępny ze zmiennych referencyjnych różnego typu

zmienne na poziomie klasy i zmienne na poziomie obiektu


            człowiek (nadtyp)
                ^
                |
                |
              lekarz (podtyp)
             /\    /\
            /        \
           /          \
        urolog       pediatra


jdk
oracle open JDK


kompilator: javac (.java -----> .class)
launcher: java


```java
public class Animal {
    private String name; // Zmienna instancji

    public Animal(String name){ // konstruktor klasy animal
        this.name=name;
    }
    public void setName(String newName){
        name = newName;
    }
    public String getName(){
        return name;
    }
}
// bez konstruktora java doda konstruktor bezparametrowy
// jeśli jest dodany konstruktor to java go już nie doda
```


```java
public class Zoo{
    public static void main(String[] args){ // static -- oznacza ze jest to metoda klasy Zoo.main

    }
}
```

reguły obiektowości
spojrzeć na typy podstawowe i typy referencyjne
dla typow podstawowych sa typy referencyjne