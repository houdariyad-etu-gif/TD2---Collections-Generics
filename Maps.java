import java.util.HashMap;

public class Maps {

    public static void main(String[] args) {

        // I. Collections & Streams
        // 2- Create HashMap
        HashMap<String, Double> grades = new HashMap<>();

        //1- Insert student grades
        grades.put("Imane", 14.5);
        grades.put("Salma", 17.0);
        grades.put("Houda", 12.0);
        grades.put("Wijdane", 19.0);

        System.out.println("After insertion:");
        display(grades);

        //2-Increase a student's grade
        grades.put("Salma", grades.get("Salma") + 1);
        System.out.println("\nAfter increasing Salma's grade:");
        display(grades);

        //3- Increase another student's grade
        grades.put("Imane", grades.get("Imane") + 2);
        System.out.println("\nAfter increasing Imane's grade:");
        display(grades);

        //4- Delete a student's grade
        grades.remove("Houda");
        System.out.println("\nAfter deleting Houda:");
        display(grades);

        // 5- Display size of map
        System.out.println("\nMap size: " + grades.size());

        // 6- Average, max, min
        double sum = 0;
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;

        for (double g : grades.values()) {
            sum += g;
            if (g > max) max = g;
            if (g < min) min = g;
        }

        double average = sum / grades.size();
        System.out.println("Average: " + average);
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);

        // 7- Check if a grade = 20
        boolean has20 = grades.containsValue(20.0);
        System.out.println("Is there a grade = 20? " + has20);

        // 8- Display using forEach + lambda
        System.out.println("\nFinal list:");
        grades.forEach((name, grade) ->
                System.out.println(name + " -> " + grade)
        );
    }

    // Display method
    public static void display(HashMap<String, Double> map) {
        map.forEach((name, grade) ->
                System.out.println(name + " -> " + grade)
        );
    }
}
