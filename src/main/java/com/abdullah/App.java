package com.abdullah;

import java.io.*;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {


        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("C:\\Users\\wind_\\IdeaProjects\\log\\src\\main\\java\\com\\abdullah\\data.log")));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\wind_\\IdeaProjects\\log\\src\\main\\java\\com\\abdullah\\dataLogRecords.log"))) {


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

                List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());

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


                for (int i = list.size()-3; i <list.size() ; i++) {


                    bufferedWriter.write(String.valueOf(list.get(i))+" ");
    

                }

                System.out.println("====================");
                System.out.println(  list.get(list.size()-3));
                System.out.println(  list.get(list.size()-2));
                System.out.println(list.get(list.size()-1));


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
    }
