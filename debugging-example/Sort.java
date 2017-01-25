public class Sort {

   public static void sort(int[] array) {

     if (array.length <= 1)
       return;

     int[] left  = new int[array.length / 2];
     int[] right = new int[array.length / 2];

     System.arraycopy(array, 0, left, 0, left.length);
     System.arraycopy(array, array.length / 2, right, 0, right.length);

     sort(left);
     sort(right);

     int left_i = 0;
     int right_i = 0;
     int insert_i = 0;
     
     while (left_i < left.length && right_i < right.length) {
       array[insert_i++] =
           (left[left_i] <= right[right_i]) ? left[left_i++] : right[right_i++];
     }
     
     while (left_i < left.length) {
       array[insert_i++] = left[left_i++];
     }
     
     while (right_i < right.length) {
       array[insert_i++] = right[right_i++];
     }

   }

}

