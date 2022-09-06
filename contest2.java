import java.io.File;
import java.io.*;
import java.util.*;
import java.io.FileNotFoundException;

public class Contest2 {

  public static void removeSpam(String folder) {

    // Your logic goes here
    String spamwords[] = {
      "Wrong",
      "Worry"
    };
    File Folder = new File(folder);
    File[] listOfFiles = Folder.listFiles();
    for (File file: listOfFiles) {
      try {
        String fileNameWithoutExtension = file.getName().substring(0, file.getName().lastIndexOf('.'));
        File newfile = new File(Folder, fileNameWithoutExtension + "_processed" + ".txt");
        BufferedWriter write1 = new BufferedWriter(new FileWriter(newfile));

        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()) {
          String data = scan.nextLine();
          String[] line = data.split(" ");
          for (String word: line) {

            try {
              if (Arrays.asList(spamwords).contains(word)) {
                String str = "****";

                write1.write(str);

              } else {
                write1.write(word);

              }

            } catch (IOException e) {
              System.out.println(e);

            }

            write1.write(" ");
          }
          write1.write("\n");
        }
        scan.close();
        write1.close();
      } catch (FileNotFoundException e) {
        System.out.println(e);
        e.printStackTrace();
      } catch (IOException e) {
        System.out.println(e);

      }

    }
  }

  public static void main(String[] args) throws Exception {
    String folder = "C:/textfiles";
    removeSpam(folder);
  }

}
