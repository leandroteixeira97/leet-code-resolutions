public class BinarySearch {
    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println(doSearch(array, 2));
        System.out.println(doSearch(array, 20));
        System.out.println(doSearch(array, 10));
    }

    private static int doSearch(int[] list, int item) {
        int min = 0;
        int max = list.length - 1;

        while (min <= max) {
            int position = (min + max) / 2;

            int guess = list[position];

            if (guess == item) {
                return position;
            } else if (guess > item) {
                max = guess - 1;
            } else {
                min = guess + 1;
            }
        }

        return -1;
    }
}
