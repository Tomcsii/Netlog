import java.io.*;

class SearchInput2 { // Prepare keyboard to receive data

   /**
    * initialize a new keyInput method
    * 
    * @param fileName string filname
    * @param data[][] used to store two dimentional records
    * @param item     index item that is searched for
    */

   void keyInput(String fileName, String data[][], int item, String val) throws IOException {
      // DataInput d = new DataInputStream(System.in);
      String input = val;
      Search2 s = new Search2();
      if (input != null) {
         // System.out.println("Searching... \n");
         s.searching(fileName, data, item, input);
      }
   } // end keyinput
} // end Searchinput
