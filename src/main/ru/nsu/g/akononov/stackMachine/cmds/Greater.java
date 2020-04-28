package ru.nsu.g.akononov.stackMachine.cmds;

import ru.nsu.g.akononov.stackMachine.Cmd;

public class Greater extends Cmd {

    @Override
    public void execution() {
        stack.push((stack.pop() > stack.pop()) ? 0 : 1);

    }
}
