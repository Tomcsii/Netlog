import java.io.*;

class NewRecord {

   public void addRecord(String fileName, String newRec) {
      String txt[] = new String[50];
      int count = 0;
      try {
         DataInput f1 = new DataInputStream(new FileInputStream(fileName));
         txt[count] = f1.readLine();
         while (txt[count] != null) { // Read all records from file
            ++count;
            txt[count] = f1.readLine();
         }
         DataOutput f2 = new DataOutputStream(new FileOutputStream(fileName));
         for (int i = 0; i < count; i++)
            f2.writeBytes(txt[i] + "\r\n");// Write to file
         f2.writeBytes(newRec); // Insert new record
      } catch (Exception e) {
      }
   } // end addRecord
} // end Newrecord
