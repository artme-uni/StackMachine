package ru.nsu.g.akononov.stackMachine.cmds;

import ru.nsu.g.akononov.stackMachine.Cmd;

public class Sub extends Cmd {

    @Override
    public void execution() {
        Integer temp = stack.pop();
        stack.push(stack.pop() - temp);

    }
}