import javafx.scene.media.SubtitleTrack;

import java.net.SocketTimeoutException;
import java.util.Scanner;

/**
 * Created by ME on 2017-01-09.
 */
public class FirstTest {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Hell! ...oh Mr Belsebub.");
        boolean lock = true;
        String input = "oh";

        System.out.println("Play?  Y/N");
        input = (String) sc.nextLine().toUpperCase();
        if(input.equals("Y")){
            while (lock) {
                lock = !isTrue();
            }
        }else {
            System.out.print("Ass!");
        }

    }

    private static boolean isTrue(){
        Scanner sc = new Scanner(System.in);
        String input = "input";
        String inputTwo = "input";
        while (!inputTwo.equals("Y")){
            System.out.println("5 + 5 is?");
            input = (String) sc.nextLine();
            input = input.toLowerCase();
            System.out.println("Shure?  Y/N");
            inputTwo = (String) sc.nextLine().toUpperCase();
        }
        inputTwo = "Hell";

        if(input.equals("10") || input.equals("tio") || input.equals("ten")){
            System.out.println("Good!");
            return true;
        } else {
            System.out.println("Idioto!!!\n");
            return false;
        }
    }
}
