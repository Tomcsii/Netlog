import java.io.*;

class UpdateRecords {

   /**
    * initialize a new updateFile method
    * 
    * @param fileName string filname
    * @param data[][] used to store two dimentional records
    */

   public static void updateFile(String fileName, String data[][]) { // records.txt
      try {
         File in = new File(fileName);
         FileOutputStream myout = new FileOutputStream(in);
         DataOutputStream myData = new DataOutputStream(myout);
         for (int i = 0; i < data.length; i++) {// update records
            String txt = "";
            if (data[i][0].equals(""))
               continue; // Omit the record
            for (int j = 0; j < 6; j++)
               txt += data[i][j] + "#";
            myData.writeBytes(txt + "\r");
         }
         myout.close();

      } catch (Exception e) {
      }
   }
}
