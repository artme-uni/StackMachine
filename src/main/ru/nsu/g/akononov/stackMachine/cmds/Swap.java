package ru.nsu.g.akononov.stackMachine.cmds;

import ru.nsu.g.akononov.stackMachine.Cmd;

public class Swap extends Cmd {

    @Override
    public void execution() {
        if (stack.size() < 2) {
            System.out.println("# Not enough elements in stack to command 'swap'");
            return;
        }

        Integer temp1 = stack.pop();
        Integer temp2 = stack.pop();

        stack.push(temp1);
        stack.push(temp2);
    }
}
