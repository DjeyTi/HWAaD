public class Pyramid {
    private static void heap(int[] array, int heapSize, int rootIndex) {
        int max = rootIndex;
        int left = 2 * rootIndex + 1;
        int right = 2 * rootIndex + 2;

        if (left < heapSize && array[left] > array[max])
            max = left;

        if (right < heapSize && array[right] > array[max])
            max = right;

        if (max != rootIndex) {
            int placeholder = array[rootIndex];
            array[rootIndex] = array[max];
            array[max] = placeholder;
            heap(array, heapSize, max);
        }
    }
    
    public static void sort(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--)
            heap(array, array.length, i);

        for (int i = array.length - 1; i >= 0; i--) {
            int placeholder = array[0];
            array[0] = array[i];
            array[i] = placeholder;
            heap(array, i, 0);
        }
    }

    public static void main(String[] args) {
        int[] array = {10,6,4,8,3,2,9,1,7,5};
        sort(array);
        for (int i = 0; i < array.length; i++)
            System.out.println(array[i]);
    }
}
