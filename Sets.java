import java.util.HashSet;

public class Sets {

    public static void main(String[] args) {
        //I. Collections & Streams
        //3- sets
        HashSet<String> groupA = new HashSet<>();
        HashSet<String> groupB = new HashSet<>();

        // 1- Add students
        groupA.add("Ahmed");
        groupA.add("salma");
        groupA.add("Imane");

        groupB.add("Ahmed");
        groupB.add("Yazid");
        groupB.add("Badr");

        System.out.println("Group A: " + groupA);
        System.out.println("Group B: " + groupB);

        // 2- Intersection
        HashSet<String> intersection = new HashSet<>(groupA);
        intersection.retainAll(groupB);
        System.out.println("Intersection: " + intersection);

        // 3- Union
        HashSet<String> union = new HashSet<>(groupA);
        union.addAll(groupB);
        System.out.println("Union: " + union);
    }
}
