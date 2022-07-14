import java.util.*;
import java.io.*;

class DecoderChallenge
{
   public static void main(String[] args)
   {
      //For user input/output
      Scanner in = new Scanner (System.in);
      //To store decryption key
      int key;
      //To store the encrypted file
      ArrayList<Character> words = new ArrayList<Character>();
      String line = "";
      String fileName = "";
      
      //Get file from the user
      System.out.println("Please enter the name of the encrypted file: ");
      fileName = in.nextLine();
           
      
      while (!fileName.equalsIgnoreCase("Q"))
      {
         //Get decryption key from the user
         System.out.println("Enter decryption key (1-5): ");
         key = in.nextInt(); 
         //Load user file
         try{
         //Use Scanner and File to open
            File f = new File (fileName);
            Scanner fileIn = new Scanner (f); 
            while (fileIn.hasNext())
               {
                  //Add word by word to array
                  line = fileIn.next();
                  for (int i = 0; i < line.length(); i++)
                  {  
                     words.add(line.charAt(i));
                  }
                  words.add('\n');
               }
               fileIn.close();
            }
         //If error occurs, display the message
         catch (Exception e)
         {
            System.out.println("Error: " + e.getMessage());
         }
         
         //Print to Decrypted.txt
         try
         {
            //Creates a PrintWriter to write to the file
            PrintWriter fileOut = new PrintWriter("Decrypted.txt");
            for (int i = 0; i < words.size(); i++)
            {
               if (words.get(i) != '\n')
               {
               char c = words.get(i);
               c = (char)(c - key);                    
               fileOut.print(c);
               }
               else
               {
                  fileOut.print('\n');
               }
            }        
         
            fileOut.close();
         }
         catch (Exception e)
         {
            System.out.println("Error: " + e.getMessage());
         }
         words.clear();
         System.out.println("File has been decrypted to Decrypted.txt");
         System.out.println("Press Q to quit or any other key to decrypt another file.");
         in.nextLine();
         fileName = in.nextLine();
         if (fileName.equalsIgnoreCase("Q"))
         {
            break;
         }
         else
         {
         System.out.println("Please enter the name of the encrypted file (Q to quit): ");
         fileName = in.nextLine();
         }
         
      }
      
   }// End Main
}// End class