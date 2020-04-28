package ru.nsu.g.akononov.stackMachine.cmds;

import ru.nsu.g.akononov.stackMachine.Cmd;

public class Print extends Cmd {

    @Override
    public void execution() {
        System.out.println(stack.peek());
    }
}
