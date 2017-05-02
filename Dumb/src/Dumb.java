import java.util.Scanner;

/**
 * Created by Laptop on 2017-01-10.
 */
public class Dumb {
    public static void main(String args){
        Scanner sc = new Scanner(System.in);

        boolean run = true;
        while(run) {
            String st = sc.nextLine().toLowerCase();
            if (st.equals("q")) {
                run = false;
            }
        }
    }
}
