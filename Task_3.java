import java.util.HashMap;
import java.util.Scanner;

/**
 * Написать метод, который переведет число из римского формата записи в
 * арабский.
 * Например, MMXXII = 2022
 */

public class Task_3 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        while (!iScanner.hasNext()) {
            System.out.println("Invalid input. Please enter an integer.");
            iScanner.next();
        }
        String userNum = iScanner.next();

        HashMap<String, Integer> userData = new HashMap<>();
        userData.put("I", 1);
        userData.put("V", 5);
        userData.put("X", 10);
        userData.put("L", 50);
        userData.put("C", 100);
        userData.put("D", 500);
        userData.put("M", 1000);

        System.out.println(converter(userData, userNum));

    }

    static Integer converter(HashMap<String, Integer> map, String userNum) {
        int acc = 0;
        String[] userNumArr = userNum.split("");
        for (int i = 0; i < userNumArr.length - 1; i++) {
            if (map.get(userNumArr[i]) < map.get(userNumArr[i + 1])) {
                acc -= map.get(userNumArr[i]);
            } else {
                acc += map.get(userNumArr[i]);
            }

        }
        acc += map.get(userNumArr[userNumArr.length - 1]);
        return acc;

    }
}