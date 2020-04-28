package ru.nsu.g.akononov.stackMachine.cmds;

import ru.nsu.g.akononov.stackMachine.Cmd;

public class Mult extends Cmd {

    @Override
    public void execution() {
        stack.push(stack.pop() * stack.pop());

    }
}