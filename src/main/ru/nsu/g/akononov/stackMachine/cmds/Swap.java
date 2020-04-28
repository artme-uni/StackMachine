package ru.nsu.g.akononov.stackMachine.cmds;

import ru.nsu.g.akononov.stackMachine.Cmd;

public class Swap extends Cmd {

    @Override
    public void execution() {
        Integer temp1 = stack.pop();
        Integer temp2 = stack.pop();

        stack.push(temp1);
        stack.push(temp2);
    }
}
