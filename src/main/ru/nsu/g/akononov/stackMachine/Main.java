package ru.nsu.g.akononov.stackMachine;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try(Scanner s = new Scanner(System.in))
        {
            while (s.hasNextLine()) {
                Cmd.line.addAll(Arrays.asList(s.nextLine().split(" ")));
                Cmd.run();
            }

            Cmd.stack.clear();
        }
    }
}
