package ru.nsu.g.akononov.stackMachine.cmds;

import ru.nsu.g.akononov.stackMachine.Cmd;

import java.util.ArrayList;

public class Condition extends Cmd {

    @Override
    public void execution() {
        if (line.size() < 2) {
            System.out.println("# Line cannot be empty");
            return;
        }
        if (stack.isEmpty()) {
            System.out.println("# Stack is empty");
            return;
        }

        int cond = stack.pop();
        int end_index = -1;

        int count = 0;
        for (int i = 0; i < line.size(); i++) {
            if (line.get(i).equals("[")) {
                count++;
            }

            if (line.get(i).equals("]") && count == 0) {
                end_index = i;
                break;
            }

            if (line.get(i).equals("]") && count != 0) {
                count--;
            }
        }

        if(end_index == -1)
        {
            System.out.println("Condition have to be closed by ']'");
            line.clear();
            return;
        }

        if (cond <= 0) {
            line.subList(0, end_index + 1).clear();
            return;
        }

        line.add(0, ("["));
        line.addAll(0, line.subList(1, end_index+1));
    }
}
