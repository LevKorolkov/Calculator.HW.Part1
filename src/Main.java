public class Main {
    public static void main(String[] args) {
        Calculator calc = Calculator.instance.get();

        int a = calc.plus.apply(4, 2);
        int b = calc.minus.apply(2, 2);
        int c = calc.divide.apply(a, b);
        int d = calc.abs.apply(c);

        calc.println.accept(d);

    }
}