package ru.nsu.g.akononov.stackMachine.cmds;

import ru.nsu.g.akononov.stackMachine.Cmd;

public class Drop extends Cmd {

    @Override
    public void execution() {
        stack.pop();
    }
}