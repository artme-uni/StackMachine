package ru.nsu.g.akononov.stackMachine;

import ru.nsu.g.akononov.stackMachine.cmds.Define;

import java.util.*;

public abstract class Cmd {

    public static Stack<Integer> stack = new Stack<>();
    public static Map<String, ArrayList<String>> defined = new HashMap<>();
    public static List<String> line = new ArrayList<>();

    public static boolean defining_process;

    private static Factory factory = Factory.getInstance();

    public static void run()
    {
        if(line.isEmpty())
            return;

        if(!line.get(0).equals("") && line.get(0).charAt(0) == '#')
            line.clear();

        while(!line.isEmpty() && !defining_process)
        {
            String str = line.get(0);
            line.remove(0);

            if(str.equals(" ") || str.equals("\t") || str.equals("") || str.equals("]"))
                continue;

            ArrayList<String> part = defined.get(str);
            if(part != null)
            {
                for (int i = 1; i <= part.size(); i++) {
                    line.add(0, (part.get(part.size() - i)));
                }
                continue;
            }

            try {
                Cmd.stack.push(Integer.valueOf(str));
            } catch (NumberFormatException e) {

                Cmd cur_cmd = factory.getClass(str);

                if (cur_cmd == null) {
                    System.out.println("# Command '" + str + "' not found");
                    continue;
                }

                cur_cmd.execution();
            }
        }

        if(defining_process)
        {
            Define d = new Define();
            d.execution();
        }
    }

    public abstract void execution();
}
