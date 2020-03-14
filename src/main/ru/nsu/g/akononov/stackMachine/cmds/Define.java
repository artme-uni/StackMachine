package ru.nsu.g.akononov.stackMachine.cmds;

import ru.nsu.g.akononov.stackMachine.Cmd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Define extends Cmd {

    public static String name;
    public static ArrayList<String> defined_str;

    @Override
    public void execution() {

        if (!defining_process && line.isEmpty()) {
            System.out.println("# Expected 'define func_name'");
            return;
        }

        if(!defining_process) {
            name = line.get(0);
            line.remove(0);
            defined_str = new ArrayList<>();
        }

        if(line.isEmpty()) {
            defining_process = true;
            return;
        }

        while (!line.get(0).equals(";"))
        {
            defined_str.add(line.get(0));
            line.remove(0);

            if(line.isEmpty())
            {
                defining_process = true;
                return;
            }
        }

        defining_process = false;
        line.remove(0);
        defined.putIfAbsent(name, defined_str);
    }
}
