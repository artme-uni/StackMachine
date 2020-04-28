package ru.nsu.g.akononov.stackMachine.cmds;

import ru.nsu.g.akononov.stackMachine.Cmd;

public class Sqrt extends Cmd {

    @Override
    public void execution() {
        stack.push((int) Math.sqrt(stack.pop()));
    }
}