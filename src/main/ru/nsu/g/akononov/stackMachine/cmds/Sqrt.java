package ru.nsu.g.akononov.stackMachine.cmds;

import ru.nsu.g.akononov.stackMachine.Cmd;

public class Sqrt extends Cmd {

    @Override
    public void execution() {
        if (stack.size() == 0) {
            System.out.println("# Not enough elements in stack to command 'sqrt'");
            return;
        }

        stack.push((int) Math.sqrt(stack.pop()));
    }
}