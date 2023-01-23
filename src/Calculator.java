import java.util.function.*;

public class Calculator {
    public static Supplier<Calculator> instance = Calculator::new;

    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;

    // Добавлена проверка деления на ноль
    BinaryOperator<Integer> divide = (x, y) -> {
        int result = 0;
        if (y == 0) {
            System.out.println("Dividing by zero");
        } else {
            result = x / y;
        }
        return result;
    };
        
    UnaryOperator<Integer> pow = x -> x * x;

    // Чтобы не загромождать код предлагаю использование библиотеки Math с использованием статического метода abs,
    // в котором верно реализован алгоритм перевода числа в абсолютное значение
    // Причина неработоспособности x -> x > 0 ? x : x * -1 заключается в самом смысле операции: нам необходимо не получить
    // новое число, умножив x на -1, а взять x в абсолют, так как, например, -0 и +0 тоже не равны, что подтверждается
    // результатами деления 1 на -0 и +0 (-infinity и +infinity соответственно).
    UnaryOperator<Integer> abs = Math::abs;
    Predicate<Integer> isPositive = x -> x > 0;
    Consumer<Integer> println = System.out::println;
}
