package ru.nsu.g.akononov.stackMachine.cmds;

import ru.nsu.g.akononov.stackMachine.Cmd;

public class ShowAll extends Cmd {

    @Override
    public void execution() {
        System.out.print("# ");
        for(var element : stack) {
            System.out.print(element + " ");
        }
        System.out.println();

    }
}
