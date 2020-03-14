package ru.nsu.g.akononov.stackMachine.cmds;

import ru.nsu.g.akononov.stackMachine.Cmd;

public class Sub extends Cmd {

    @Override
    public void execution() {
        if (stack.size() < 2) {
            System.out.println("# Not enough elements in stack to command -");
            return;
        }
        Integer temp = stack.pop();
        stack.push(stack.pop() - temp);

    }
}