package ru.nsu.g.akononov.stackMachine;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    private ByteArrayOutputStream output = new ByteArrayOutputStream();

    void setInput(String s) {
        ByteArrayInputStream in = new ByteArrayInputStream(s.getBytes());
        System.setIn(in);
    }

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(output));

    }

    @Test
    void test1() {
        setInput("# 5 5 3 + print\n");
        Main.main(new String[0]);

        assertEquals("", output.toString());
    }

    @Test
    @DisplayName("Add 1")
    void test2() {
        setInput("5 5 + print\n");
        Main.main(new String[0]);

        assertEquals("10\n", output.toString());
    }

    @Test
    @DisplayName("Add 2")
    void test3() {
        setInput("5 -2 + print\n");
        Main.main(new String[0]);

        assertEquals("3\n", output.toString());
    }

    @Test
    @DisplayName("Sub")
    void test4() {
        setInput("3 10 - print\n");
        Main.main(new String[0]);

        assertEquals("-7\n", output.toString());
    }

    @Test
    @DisplayName("Mult")
    void test5() {
        setInput("7 3 * print\n");
        Main.main(new String[0]);

        assertEquals("21\n", output.toString());
    }

    @Test
    @DisplayName("Div 1")
    void test6() {
        setInput("3 10 / print\n");
        Main.main(new String[0]);

        assertEquals("0\n", output.toString());
    }

    @Test
    @DisplayName("Div 2")
    void test7() {
        setInput("10 3 / print\n");
        Main.main(new String[0]);

        assertEquals("3\n", output.toString());
    }

    @Test
    @DisplayName("Div 2")
    void test8() {
        setInput("10 0 / print\n");
        Main.main(new String[0]);

        assertEquals("# Cannot divide by zero\n" +
                "10\n", output.toString());
    }

    @Test
    @DisplayName("Sqrt")
    void test9() {
        setInput("10 sqrt print\n");
        Main.main(new String[0]);

        assertEquals("3\n", output.toString());
    }

    @Test
    @DisplayName("Define 1")
    void test10() {
        setInput("define func 1 + ; 5 func print\n");
        Main.main(new String[0]);

        assertEquals("6\n", output.toString());
    }

    @Test
    @DisplayName("Define 2")
    void test23() {
        setInput("define\n");
        Main.main(new String[0]);

        assertEquals("# Expected 'define func_name'\n", output.toString());
    }

    @Test
    @DisplayName("Dup")
    void test11() {
        setInput("-12 dup show\n");
        Main.main(new String[0]);

        assertEquals("# -12 -12 \n", output.toString());
    }

    @Test
    @DisplayName("Swap")
    void test12() {
        setInput("1 2 swap show\n");
        Main.main(new String[0]);

        assertEquals("# 2 1 \n", output.toString());
    }

    @Test
    @DisplayName("Rot")
    void test13() {
        setInput("1 2 3 4 5 rot show\n");
        Main.main(new String[0]);

        assertEquals("# 2 3 4 5 1 \n", output.toString());
    }

    @Test
    @DisplayName("Drop")
    void test14() {
        setInput("1 2 3 drop show\n");
        Main.main(new String[0]);

        assertEquals("# 1 2 \n", output.toString());
    }

    @Test
    void test15() {
        setInput("1 2 < print\n");
        Main.main(new String[0]);

        assertEquals("1\n", output.toString());
    }

    @Test
    void test16() {
        setInput("1 2 > print\n");
        Main.main(new String[0]);

        assertEquals("0\n", output.toString());
    }

    @Test
    void test18() {
        setInput("5 dup [ print 1 - dup ]\n");
        Main.main(new String[0]);

        assertEquals("5\n" + "4\n" + "3\n" + "2\n" + "1\n", output.toString());
    }

    @Test
    void test19() {
        setInput("define factorial 1 swap dup [ dup rot * swap 1 - dup ] drop ;\n" +
                "5 factorial print\n");
        Main.main(new String[0]);

        assertEquals("120\n", output.toString());
    }

    @Test
    void test21() {
        setInput("0 1 < [ 1 print 0 ]\n");
        Main.main(new String[0]);

        assertEquals("1\n", output.toString());
    }

    @Test
    void test22() {
        setInput("Unk\n");
        Main.main(new String[0]);

        assertEquals("# Command 'Unk' not found\n", output.toString());
    }

    @Test
    void test24() {
        setInput("define min\n" +
                "  dup rot dup rot 1 rot rot  <\n" +
                "  [ drop swap drop 0 0 ] \n" +
                "  [ drop 0 ] ;\n" +
                "\n" +
                "5 7 min print\n");
        Main.main(new String[0]);

        assertEquals("5\n", output.toString());
    }

    @Test
    void test25() {
        setInput("5\n" + "dup [ dup dup [ print 1 - dup ] drop 1 - dup ]");
        Main.main(new String[0]);

        assertEquals("5\n" + "4\n" + "3\n" + "2\n" + "1\n" + "4\n" + "3\n" + "2\n" +
                "1\n" + "3\n" + "2\n" + "1\n" + "2\n" + "1\n" + "1\n", output.toString());
    }

    @Test
    void test28() {
        setInput("5\n" + "swap");
        Main.main(new String[0]);

        assertEquals("# Not enough elements in stack to command\n", output.toString());
    }

    @Test
    void test27() {
        setInput("1 1 < print\n");
        Main.main(new String[0]);

        assertEquals("0\n", output.toString());
    }

    @AfterEach
    void tearDown() {
        System.setOut(null);
        System.setIn(null);
    }
}