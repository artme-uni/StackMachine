package ru.nsu.g.akononov.stackMachine.cmds;

import ru.nsu.g.akononov.stackMachine.Cmd;

public class Drop extends Cmd {

    @Override
    public void execution() {
        if (stack.isEmpty()) {
            System.out.println("# Not enough elements in stack to command 'drop'");
            return;
        }

        stack.pop();
    }
}