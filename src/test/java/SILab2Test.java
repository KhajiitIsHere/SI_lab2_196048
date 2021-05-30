import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class SILab2Test {

    SILab2 def;
    List<Time> timeList;

    public SILab2Test() {
        def = new SILab2();
        timeList = new ArrayList<>();
    }

    @Test
    public void test1() {
        timeList.add(new Time(-2,1, 1));
        RuntimeException exp = assertThrows(RuntimeException.class, () -> def.function(timeList));
        assertEquals(exp.getMessage(), "The hours are smaller than the minimum");
    }

    @Test
    public void test2() {
        timeList.add(new Time(26,1,1));
        RuntimeException exp = assertThrows(RuntimeException.class, () -> def.function(timeList));
        System.out.println(exp.getMessage());
        assertEquals(exp.getMessage(), "The hours are grater than the maximum");
    }

    @Test
    public void test3() {
        timeList.add(new Time(10,70,10));
        RuntimeException exp = assertThrows(RuntimeException.class, () -> def.function(timeList));
        assertEquals(exp.getMessage(), "The minutes are not valid!");
    }

    @Test
    public void test4() {
        timeList.add(new Time(10,40,40));
        Integer rez = def.function(timeList).get(0);
        assertEquals(rez, 10 * 3600 + 40 * 60 + 40);
    }

    @Test
    public void test5() {
        timeList.add(new Time(10,40,69));
        RuntimeException exp = assertThrows(RuntimeException.class, () -> def.function(timeList));
        assertEquals(exp.getMessage(), "The seconds are not valid");
    }

    @Test
    public void test6() {
        timeList.add(new Time(24,0,0));
        Integer rez = def.function(timeList).get(0);
        assertEquals(rez, 24 * 3600);
    }

    @Test
    public void test7() {
        timeList.add(new Time(24,100,100));
        RuntimeException exp = assertThrows(RuntimeException.class, () -> def.function(timeList));
        assertEquals(exp.getMessage(), "The time is greater than the maximum");
    }
}
