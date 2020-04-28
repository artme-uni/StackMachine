package ru.nsu.g.akononov.stackMachine.cmds;

import ru.nsu.g.akononov.stackMachine.Cmd;

public class Div extends Cmd {

    @Override
    public void execution() {
        Integer temp = stack.pop();
        if(temp.equals(0))
        {
            System.out.println("# Cannot divide by zero");
            return;
        }
            stack.push(stack.pop() / temp);

    }
}
