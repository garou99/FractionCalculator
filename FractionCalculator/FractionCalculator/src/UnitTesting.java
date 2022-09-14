import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UnitTesting {

    @Test
    public void test1(){
        Main main=new Main();
        assertEquals("1/2x2/3 returns 1/2x2/3=2/6",main.multiplyFractions("1/2x2/3"));
    }

    @Test
    public void test2(){
        Main main=new Main();
        assertEquals("6/10x4/10 returns 3/5x2/5=6/25",main.multiplyFractions("6/10x4/10"));
    }

    @Test
    public void test3(){
        Main main=new Main();
        assertEquals("6/5x4/10 returns 6/5x2/5=12/25",main.multiplyFractions("6/5x4/10"));
    }

    @Test
    public void test4(){
        Main main=new Main();
        assertEquals("60/50x4/10 returns 6/5x2/5=12/25",main.multiplyFractions("60/50x4/10"));
    }

    @Test
    public void test5(){
        Main main=new Main();
        assertEquals("123/3x5/10 returns 41/1x1/2=41/2",main.multiplyFractions("123/3x5/10"));
    }

    @Test
    public void test6(){
        Main main=new Main();
        assertEquals("6134/504x56/10 returns 3067/252x28/5=85876/1260",main.multiplyFractions("6134/504x56/10"));
    }

    @Test
    public void test7(){
        Main main=new Main();
        assertEquals("785/1x4/10 returns 785/1x2/5=1570/5",main.multiplyFractions("785/1x4/10"));
    }

    @Test
    public void test8(){
        Main main=new Main();
        assertEquals("989/505x47/10 returns 989/505x47/10=46483/5050",main.multiplyFractions("989/505x47/10"));
    }

    @Test
    public void test9(){
        Main main=new Main();
        assertEquals("656/553x486/782 returns 656/553x243/391=159408/216223",main.multiplyFractions("656/553x486/782"));
    }

    @Test
    public void test10(){
        Main main=new Main();
        assertEquals("0/1x0/2 returns 0/1x0/2=0/2",main.multiplyFractions("0/1x0/2"));
    }

    @Test
    public void test11(){
        Main main=new Main();
        assertEquals("0/5x5/25 returns 0/5x1/5=0/25",main.multiplyFractions("0/5x5/25"));
    }

    @Test
    public void test12(){
        Main main=new Main();
        assertEquals("0/5x2/400 returns 0/5x1/200=0/1000",main.multiplyFractions("0/5x2/400"));
    }

    @Test
    public void negativeTest1(){
        Main main=new Main();
        assertThrows(ZeroDenominatorException.class,()->main.multiplyFractions("89/0x90/10"));
    }

    @Test
    public void negativeTest2(){
        Main main=new Main();
        assertThrows(IllegalArgumentException.class,()->main.multiplyFractions("Multiply"));
    }

    @Test
    public void negativeTest4(){
        Main main=new Main();
        assertThrows(IllegalArgumentException.class,()->main.multiplyFractions("1/10+2/10"));
    }

    @Test
    public void negativeTest5(){
        Main main=new Main();
        assertThrows(IllegalArgumentException.class,()->main.multiplyFractions("1/10-2/10"));
    }

    @Test
    public void negativeTest6(){
        Main main=new Main();
        assertThrows(IllegalArgumentException.class,()->main.multiplyFractions("1/10/10/10F"));
    }
}
