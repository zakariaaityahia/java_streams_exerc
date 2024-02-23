import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainApp_tp1 {
    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("zakaria");
        names.add("ahmed");
        names.add("medo");
        names.add("adil");
        names.add("achraf");
        names.add("bic");

        System.out.println("________________q1________________");

        // display the names contains letter "a"
        names.stream()
                .filter(name -> name.contains("a"))
                .forEach(System.out::println);

        System.out.println("________________q2________________");
        //Filterer les mots qui ont une longueur superior à 3 et transformer chaque mot en son
        //inverse.

        names.stream()
                .filter(name_1 -> name_1.length() > 3)
                .map(name_1 -> new StringBuilder(name_1).reverse().toString())
                .forEach(System.out::println);

        System.out.println("________________q3________________");
        //Filtrer les chaînes qui contiennent la lettre "e" et aplatir chaque chaîne en une liste de
        //ses caractères.

        List<Character> res = names.stream()
                .filter(name_2 -> name_2.contains("e"))
                .flatMap(name_2-> name_2.chars().mapToObj(c -> (char) c))
                .collect(Collectors.toList());

        System.out.println(res);

        System.out.println("________________q4________________");
        //Transformer chaque chaîne en sa version en majuscules.
        names.stream()
                .map(name_3 -> name_3.toUpperCase(Locale.ROOT))
                .forEach(System.out::println);

        System.out.println("________________q5________________");

        List<Integer> length = names.stream()
                .map(String::length)
                .collect(Collectors.toList());

        System.out.println(length);


        System.out.println("________________q6________________");
        List<Character> res_1 = names.stream()
                .map(name_4-> name_4.chars().mapToObj(b -> (char) b).collect(Collectors.toList()))
                .flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println(res_1);


        System.out.println("________________q7________________");

        List<String> res_3 = IntStream.range(0, names.size())
                .mapToObj(i -> names.get(i) + " : " + i)
                .collect(Collectors.toList());

        System.out.println(res_3);

    }
}