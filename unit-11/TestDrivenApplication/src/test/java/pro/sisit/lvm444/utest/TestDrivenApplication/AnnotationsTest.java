package pro.sisit.lvm444.utest.TestDrivenApplication;

import org.junit.*;

public class AnnotationsTest {

    @BeforeClass
    public static void beforeClass()
    {
        System.out.println("BEFORE CLASS");
    }

    @Before
    public void before()
    {
        System.out.println("BEFORE");
    }

    @Test
    public void test1()
    {
        System.out.println("TEST 1");
    }

    @Test
    public void test2()
    {
        System.out.println("TEST 2");
    }

    @After
    public void after()
    {
        System.out.println("AFTER");
    }

    @AfterClass
    public static void afterClass()
    {
        System.out.println("AFTER CLASS");
    }
}
