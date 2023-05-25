/*
TV+remote by Aaliyah Creech, October 9, 2022
*/
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Television tv = new Television();
        Remote r = new Remote();

        System.out.println("Welcome to the TV Party!");

        while(true) {
            r = Remote.connectToTv(tv);
            r.printOptions();
        }
    }
}
