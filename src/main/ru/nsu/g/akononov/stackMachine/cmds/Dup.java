package ru.nsu.g.akononov.stackMachine.cmds;

import ru.nsu.g.akononov.stackMachine.Cmd;

public class Dup extends Cmd {

    @Override
    public void execution() {
        stack.push(stack.peek());
    }
}
