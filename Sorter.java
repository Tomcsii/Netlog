class Sorter {

   public static String[][] sort(String list[][], int item) { // Input records; item=name etc
      String temp;
      int len = list.length - 1;
      for (int i = len; i > 1; i--)
         for (int j = 0; j < i; j++)
            if (list[j][item].compareTo(list[j + 1][item]) > 0) {
               for (int k = 0; k < 6; k++)
                  swap(list, j, k);// swapping all 6 items
            } // end it
      return list; // return sorted list
   } // end sort

   static void swap(String list[][], int index, int item) {
      String temp;
      temp = list[index][item];
      list[index][item] = list[index + 1][item];
      list[index + 1][item] = temp;
   } // end swap
} // end Sorter
