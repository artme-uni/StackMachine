package ru.nsu.g.akononov.stackMachine.cmds;

import ru.nsu.g.akononov.stackMachine.Cmd;

public class Less extends Cmd {

    @Override
    public void execution() {
        if (stack.size() < 2) {
            System.out.println("# Not enough elements in stack to command '<'");
            return;
        }
        stack.push((stack.pop() < stack.pop()) ? 0 : 1);

    }
}
