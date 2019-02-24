package com.abdullah;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {

  /**
   * Bu uygulama dizini parametre olarak alir. java -jar target/log-1.0-SNAPSHOT.jar
   * com.abdullah.App dizinin_path
   */
  public static void main(String args[]) {

    ///Users/byil/Downloads/root
    String rootPath = args[0];

    //dizinleri listelicem
    //her bir dizin icin dosyalari okuyup icindeki kelimeleri bulacam (dizini icindeki .log uzantili dosyalari okuyup top 3 kelimeyi bulsa)
    //her bir gun icin top 3 kelimeyi bulacam sonra dosyaya yazdiracaz.

    List<String> directories = list(rootPath);
    String directory = "/Users/byil/Downloads/root/2018-01-04";
    List<String> words = readAllWords(directory);

    try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(
        "C:\\Users\\wind_\\IdeaProjects\\log\\src\\main\\java\\com\\abdullah\\data.log")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(
            "C:\\Users\\wind_\\IdeaProjects\\log\\src\\main\\java\\com\\abdullah\\dataLogRecords.log"))) {

      while (scanner.hasNextLine()) {

        String logRecords = scanner.nextLine();
        String[] logArray = logRecords.split(" ");

        int count;

        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for (String word : logArray) {
          if (map.containsKey(word)) {
            count = map.get(word);
            map.put(word, count + 1);
          } else {
            map.put(word, 1);
          }
        }

//                for (Map.Entry<String, Integer> entry : map.entrySet()) {
//                    System.out.println(entry.getKey() + " : " + entry.getValue());
//                }

        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(
            map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
          public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            return (o1.getValue()).compareTo(o2.getValue());
          }
        });

        Map<String, Integer> map1 = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list) {
          map1.put(entry.getKey(), entry.getValue());
        }
//
//                for (Map.Entry<String, Integer> entry : map.entrySet()) {
//                    String key = entry.getKey();
//                    int value = entry.getValue();
//                    System.out.println(key + " : " + value);

//
//                for (Map.Entry<String, Integer> entry : list
//                     ) {
//                    System.out.println(entry);
//                }

//                bufferedWriter.write(String.valueOf(map1.values()));

//                System.out.println(list.size());

        for (int i = list.size() - 3; i < list.size(); i++) {

          bufferedWriter.write(String.valueOf(list.get(i)) + " ");


        }

        System.out.println("====================");
        System.out.println(list.get(list.size() - 3));
        System.out.println(list.get(list.size() - 2));
        System.out.println(list.get(list.size() - 1));

//

//                for (int i = map1.size()-3; i < map1.size() ; i++) {
//                   System.out.print(map1.get(i)+",");
//
//
//                }
//
//                }

//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

      }
    } catch (FileNotFoundException e1) {
      e1.printStackTrace();
    } catch (IOException e1) {
      e1.printStackTrace();
    }
  }

  /**
   * @param directory Dosyanin pathi
   * @return
   */
  public static List<String> readAllWords(String directory) {
    List<String> words = new ArrayList<>();
    Path path = Paths.get(directory);
    try {
      List<String> lines = Files.readAllLines(path);
      for (String line : lines) {
        String[] wordArray = line.split("\\s+");//regular expression bak
        for (int i = 0; i < wordArray.length; i++) {
          String clean = wordArray[i]
              .toLowerCase()
              .replace(".", "")
              .replace(",", "")
              .replace("?", "");
          words.add(clean);
        }
      }
      return words;
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  public static List<String> list(String rootPath) {
    List<String> files = new ArrayList<>();

    try {
      DirectoryStream<Path> paths = Files.newDirectoryStream(Paths.get(rootPath));
      paths.forEach(directory -> {
        String dizin = directory.toString();
        if (!dizin.contains(".DS_Store")) {
          files.add(dizin);
        }
      });
      return files;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return files;
  }
}
