package org.example;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;


public class MainTest {

    @Test
    public void testMarkers() {
        String input = "90\n85\n75\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Scanner scanner = new Scanner(System.in);
        int total = Main.Marks(3, scanner);

        assertEquals(250, total); // Expected total sum for the provided marks
    }

    @Test
    public void testGrade() {
        char gradeA = Main.Grade(85.0);
        char gradeB = Main.Grade(75.0);
        char gradeC = Main.Grade(65.0);
        char gradeD = Main.Grade(55.0);
        char gradeE = Main.Grade(45.0);
        char gradeF = Main.Grade(35.0);

        assertEquals('A', gradeA);
        assertEquals('B', gradeB);
        assertEquals('C', gradeC);
        assertEquals('D', gradeD);
        assertEquals('E', gradeE);
        assertEquals('F', gradeF);
    }
}
