package game2014.as1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Dictionary extends GamePlay{

    Map<String, String> dictionary = new HashMap<>();

    Dictionary() throws IOException {

        String delimiter = ":";

        try(Stream<String> lines = Files.lines(Paths.get("Dictionary.txt"))){
            lines.filter(line -> line.contains(delimiter)).forEach(
                    line -> dictionary.putIfAbsent(line.split(delimiter)[0], line.split(delimiter)[1])
            );
        }

//        for (String key : dictionary.keySet())
//        {
//            System.out.println(key + ":" + dictionary.get(key));
//        }
    }

    //    Dictionary()  throws IOException {
//
//        String filePath = "Dictionary.txt";
//        HashMap<String, String> dictionary = new HashMap<String, String>();
//
//        String line;
//        BufferedReader reader = new BufferedReader(new FileReader(filePath));
//        while ((line = reader.readLine()) != null)
//        {
//            String[] parts = line.split(":", 2);
//            if (parts.length >= 2)
//            {
//                String word = parts[0];
//                String definition = parts[1];
//                dictionary.put(word, definition);
//            } else {
//                System.out.println("ignoring line: " + line);
//            }
//        }
//
////        for (String key : dictionary.keySet())
////        {
////            System.out.println(key + ":" + dictionary.get(key));
////        }
//        reader.close();
//    }

}
