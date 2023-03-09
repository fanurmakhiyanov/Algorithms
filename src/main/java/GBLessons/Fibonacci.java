package GBLessons;

import java.util.concurrent.atomic.AtomicInteger;

/* Числа Фиббоначи
 *  Индексы     0   1   2   3   4   5   6   7   8   9   10  ...
 *  Значения    0   1   1   2   3   5   8   13  21  34  55  ...
 */
public class Fibonacci {
    public static void main(String[] args) {

        AtomicInteger counter = new AtomicInteger();

        counter.set(0);
        long startTime = System.currentTimeMillis();
        System.out.printf("(1) Число Фибоначчи для значения %d равно %d; Кол-во итераций %d (РЕКУРСИЯ)\n",
                10, fb1(10, counter), counter.get());
        long endTime = System.currentTimeMillis();
        long processingTime = endTime - startTime;
        System.out.printf("(1) Операция выполнена за %d мс.\n", processingTime);

        counter.set(0);
        startTime = System.currentTimeMillis();
        System.out.printf("(2) Число Фибоначчи для значения %d равно %d; Кол-во итераций %d (РЕКУРСИЯ)\n",
                30, fb1(30, counter), counter.get());
        endTime = System.currentTimeMillis();
        processingTime = endTime - startTime;
        System.out.printf("(2) Операция выполнена за %d мс.\n", processingTime);

        counter.set(0);
        startTime = System.currentTimeMillis();
        System.out.printf("(3) Число Фибоначчи для значения %d равно %d; Кол-во итераций %d (РЕКУРСИЯ)\n",
                43, fb1(43, counter), counter.get());
        endTime = System.currentTimeMillis();
        processingTime = endTime - startTime;
        System.out.printf("(3) Операция выполнена за %d мс.\n", processingTime);

        counter.set(0);
        startTime = System.currentTimeMillis();
        System.out.printf("(1) Число Фибоначчи для значения %d равно %d; Кол-во итераций %d\n",
                10, fb2(10, counter), counter.get());
        endTime = System.currentTimeMillis();
        processingTime = endTime - startTime;
        System.out.printf("(1) Операция выполнена за %d мс.\n", processingTime);

        counter.set(0);
        startTime = System.currentTimeMillis();
        System.out.printf("(2) Число Фибоначчи для значения %d равно %d; Кол-во итераций %d\n",
                30, fb2(30, counter), counter.get());
        endTime = System.currentTimeMillis();
        processingTime = endTime - startTime;
        System.out.printf("(2) Операция выполнена за %d мс.\n", processingTime);

        counter.set(0);
        startTime = System.currentTimeMillis();
        System.out.printf("(3) Число Фибоначчи для значения %d равно %d; Кол-во итераций %d\n",
                43, fb2(43, counter), counter.get());
        endTime = System.currentTimeMillis();
        processingTime = endTime - startTime;
        System.out.printf("(3) Операция выполнена за %d мс.\n", processingTime);


    }

    static long fb1(int num, AtomicInteger counter) {
        counter.getAndIncrement(); // +1
        if (num == 0 || num == 1) return num;
        return fb1(num - 1, counter) + fb1(num - 2, counter);
    }

    static long fb2(int num, AtomicInteger counter) {
        if (num == 0 || num == 1) return num;
        long[] numbers = new long[num + 1];
        numbers[0] = 0;
        numbers[1] = 1;
        for (int i = 2; i <= num; i++) {
            numbers[i] = numbers[i - 1] + numbers[i - 2];
            counter.getAndIncrement();
        }
        return numbers[num];
    }

}