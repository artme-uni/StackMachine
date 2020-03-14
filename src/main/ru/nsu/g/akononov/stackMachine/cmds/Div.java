package ru.nsu.g.akononov.stackMachine.cmds;

import ru.nsu.g.akononov.stackMachine.Cmd;

public class Div extends Cmd {

    @Override
    public void execution() {
        if (stack.size() < 2) {
            System.out.println("# Not enough elements in stack to command /");
            return;
        }
        Integer temp = stack.pop();
        if(temp.equals(0))
        {
            System.out.println("# Cannot divide by zero");
            return;
        }
            stack.push(stack.pop() / temp);

    }
}
