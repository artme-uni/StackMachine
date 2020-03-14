package ru.nsu.g.akononov.stackMachine.cmds;

import ru.nsu.g.akononov.stackMachine.Cmd;

import java.util.Stack;

public class Rot extends Cmd {

    @Override
    public void execution() {
        if (stack.isEmpty()) {
            System.out.println("# Not enough elements in stack to command 'rot'");
            return;
        }

        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty())
            temp.push(stack.pop());

        Integer cur = temp.pop();

        while (!temp.isEmpty())
            stack.push(temp.pop());

        stack.push(cur);

    }
}
