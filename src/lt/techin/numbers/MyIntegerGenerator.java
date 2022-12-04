package lt.techin.numbers;

import lt.itakademija.exam.IntegerGenerator;
import lt.itakademija.exam.NumberFilter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyIntegerGenerator implements IntegerGenerator {

    private int iterator = 0;
    private List<Integer> numbers = new ArrayList<>();

    public MyIntegerGenerator(int from, int to) {
        for (int i = from; i <= to; i++) {
            numbers.add(i);
        }
    }

    public MyIntegerGenerator(IntegerGenerator generator, NumberFilter filter) {
        while (true) {
            try {
                int integer = generator.getNext();
                if (filter.accept(integer)) {
                    numbers.add(integer);
                }
            } catch (Exception e) {
                break;
            }
        }
    }

    @Override
    public Integer getNext() {
        if (iterator >= numbers.size()) {
            return null;
        }
        return numbers.get(iterator++);
    }
}
