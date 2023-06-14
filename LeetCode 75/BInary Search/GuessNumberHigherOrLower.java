public class GuessNumberHigherOrLower {

    public static int guess(int n) {
        return 0;
    }

    public static int guessNumber(int n) {
        // Does Binary search until we get the guessed number, pretty self-explanatory tbh
        int left = 1, right = n, mid;

        while (left <= right) {
            mid = left + (right - left) / 2;

            if (guess(mid) == 0) return mid; // We found our guess
            else if (guess(mid) == 1) left = mid + 1; // The guess was higher, so we up our lower bound
            else right = mid - 1; // The guess was lower, so we down the upper bound
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("I don't know how to implement the API");
    }
}
