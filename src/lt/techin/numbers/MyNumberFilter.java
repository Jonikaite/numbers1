package lt.techin.numbers;

import lt.itakademija.exam.NumberFilter;

import java.util.ArrayList;
import java.util.List;

public class MyNumberFilter implements NumberFilter {

    private List<Integer> numbers = new ArrayList<>();

    @Override
    public boolean accept(int number) {
        if (numbers.contains(number)) {
            return true;
        }
        return false;
    }
}