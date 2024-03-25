class Calculations {
    static long calculateSum(long start, long end) {
        long sum = 0;
        for (long i = start; i <= end; i++) {
            sum += i;
        }
        return sum;
    }

    static long calculatePower(long number) {
        long power = 1;
        for (long i = 0; i < number; i++) {
            power *= 2;
        }
        return power;
    }
}
