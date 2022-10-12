import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class Main {
    public static void main(String[] args) {
        worker("summer draw sun apple corner autumn winter vim doctor ab ac sum x");
    }

    public static void worker(String sentence){


        Map<Character,List<String>> words =
                Stream.of(sentence.split(" "))
                .collect(groupingBy(s->s.charAt(0)));

        List<String>  notUsed = words.values().stream().filter(strings -> strings.toArray().length < 2)
                .map(strings -> strings.get(0))
                .collect(Collectors.toList());

        words = words.entrySet().stream().filter(x -> x.getValue().toArray().length>=2)
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey,
                x -> x.getValue().stream()
                .sorted((t, y)-> y.length() - t.length() !=0? y.length() - t.length(): t.compareTo(y) )
                .collect(Collectors.toList()), (x, y) -> x, LinkedHashMap::new));

        System.out.println(words + "\n" + notUsed);


    }


}