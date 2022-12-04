package lt.techin.numbers;

import lt.itakademija.exam.Exercises;
import lt.itakademija.exam.IntegerGenerator;
import lt.itakademija.exam.NumberFilter;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MyExercises implements Exercises {

    @Override
    public Integer findSmallest(List<Integer> list) {
        int minNumber = list.stream().min(Comparator.comparing(Integer::valueOf)).get();
        return minNumber;
    }

    @Override
    public Integer findLargest(List<Integer> list) {
        int maxNumber = list.stream().max(Comparator.comparing(Integer::valueOf)).get();
        return maxNumber;
    }

    @Override
    public boolean isEqual(Object lhs, Object rhs) {
        return lhs.equals(rhs);
    }

    @Override
    public boolean isSameObject(Object lhs, Object rhs) {
        return (lhs == rhs);
    }

    @Override
    public List<Integer> consume(Iterator<Integer> iterator) {
        List<Integer> integers = new ArrayList<>();
        for (Iterator<Integer> iter = iterator; iter.hasNext();) {
            integers.add(iter.next());
        }
        return integers;
       }

    @Override
    public int computeSumOfNumbers(int number) {
        int sum = 0;
        for (int i = 0; i <= number; i++) {
            sum+= i;
        }
        return sum;
    }

    @Override
    public int computeSumOfNumbers(int number, NumberFilter numberFilter) {
        int sum = 0;
        for (int i = 1; i <= number; i++) {
            if(numberFilter.accept(i)){
                sum += i;
            }
        } return sum;
    }

    @Override
    public List<Integer> computeNumbersUpTo(int number) {
        List<Integer> numbers = new ArrayList<>();
       return IntStream.range(1, number).boxed().collect(Collectors.toList());
    }

    @Override
    public Map<Integer, Integer> countOccurrences(List<Integer> list) {
        Map<Integer, Integer> hashmap = new HashMap<>();

        for(int i =0; i < list.size(); i++) {
            if(hashmap.containsKey(list.get(i))) {
                int occurance = hashmap.get(list.get(i));
                occurance++;
                hashmap.put(list.get(i), occurance);
            } else {
                hashmap.put(list.get(i), 1);
            }
        }
        return hashmap;
    }

    @Override
    public IntegerGenerator createIntegerGenerator(int from, int to) {
        return new MyIntegerGenerator(from, to);
        }

    @Override
    public IntegerGenerator createFilteredIntegerGenerator(IntegerGenerator generator, NumberFilter filter) {
        return new MyIntegerGenerator(generator, filter);
    }
}
