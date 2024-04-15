
12 kwietnia test

12 pytań
0-1 punkt
albo pojedynczego wyboru albo wielokrotnego
6 pkt - 3
8 pkt - 3.5
9 pkt - 4
10 pkt - 4.5
11 pkt - 5

36 minut

zakres do tego wykładu
test po angielsku


## Operatory
 - jeden dwa albo trzy argumenty
 - kolejność wykonywania operatorów

```java
int y = 4;
double x = 3 + 2 * --y; //9 od prawej do lewej w tym przypadku 

int y = 4;
double x = 3 + 2 * y--; //11 sprawdzić wyniki
```

zmienną węższego typu można przypisać do zmiennej węższego typu
jak w drugą stronę trzeba jawnie określić zmienną

## Promocja typów
 - węższy typ zostanie zamieniony na szerszy, wykona operacje i zwróci wynik w szerszym typie
 - zmienno przecinkowe są zmieniane na większy zakres
 - mniejsze typy danych są najpierw zamieniane na int

## Ternary operator
 - booleanExpression ? trueExpression : falseExpression

```java
int y = 10;
int x = (y > 5) ? (2 * y) : (3 * y);
```

for (initialization; booleanExpression; updateStatement){
    // Body
}

for (datatype instance : collection) {
    // Body
}

```java
int[][] myComplexArray = {{5,2,1,3},{3,9,8,9},{5,7,12,7}};
for(int[] mySimpleArray : myComplexArray){
    for (int i : mySimpleArray){
        System.out.print(i + "\t");
    }
    System.out.println();
}
```

tworząc obiekt pisząc znaki, java mając taki sam obiekt w puli przypisze do niego referencje
uzywając new String java tworzy zawsze nowy obiekt

"+" dla stringów oznacza konkatenacje stringów

System.out.println(1+2+"3"); // "33"

## Stringi są immutable
 - przy konkatenacji stringów java przechowuje kazdy nowy string
 - s.concat()

## Zestaw metod String
 - length()
 - charAt(int index)
 - indexOf(char outChar)
 - substring()
 - toLowerCase()
 - toUpperCase()
 - equals(String str)
 - equalsIgnoreCase(String str)
 - startsWith()
 - endsWith()
 - replace(char oldChar, char newChar)
 - contains()
 - trim()
 - strip()
 - stripLeading()
 - stripTrailing()
 - intern()

## StringBuilder
 - mutwoalność i łańcuchowanie
 - tworzenie StringBuilder
 - metody StringBuilder

```java
String x = new String("Hello World");
String z = "Hello World";
System.out.println(x.equals(z)); // true
```

## Przesłanianie metod
 - tworzenie metody toString dla obiektów

## Deklaracja tablicy
 - int[] numbers = new int[3];

```java
int[][] differentSize = {{1,6},{3,5,9,8},{2,4,7}};
```

|     | 0 | 1 | 2 |
|-----|---|---|---|
| 0   | 1 | 3 | 2 |
| 1   | 6 | 5 | 4 |
| 2   |   | 9 | 7 |
| 3   |   | 8 |   |


## ArrayList
 - import java.util.ArrayList;

```java
ArrayList<String> list4 = new ArrayList<String>(); // można przechowywać obiekty klasy String
ArrayList<String> list5 = new ArrayList<>();
```

w kolekcji ArrayList przchowujemy tylko obiekty klasy
 - add()
 - remove()
 - set()
 - isEmpty()
 - size()
 - clear()
 - contains()

## Autoboxing
 - int -> Integer
 - double -> Double
 - char -> Character
 - boolean -> Boolean

```java
Integer intWrapped = 1;
int i = intWrapped;
```

Integer intWrapped = Integer.valueOf(1);
int i = intWrapped.intValue();

Double doubleWrapped = Double.valueOf(1.0);
double d = doubleWrapped.doubleValue();