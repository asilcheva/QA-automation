import org.junit.*;


public class CalculatorTest {
    public static final int firstPosNumber = 10;
    public static final int firstSecNumber = 5;
    private Calculator calculator;
    @Before
    public void init(){
        calculator = new Calculator();
        calculator.setFirstNumber(firstPosNumber);
        calculator.setSecondNumber(firstSecNumber);
    }
    @Test
    public void verify1AddOfTwoPositiveNumber()
    {
        int expectedSumma =16;
        int actual = calculator.addNumbers();
        Assert.assertEquals(expectedSumma, actual);
    }
    @Test
    public void verify2DivideOfTwoPositiveNumber()
    {
        int expectedSumma =2;
        int actual = calculator.divideNumbers();
        Assert.assertEquals(expectedSumma, actual);
    }
    @Test
    public void verify3MultiplyOfTwoPositiveNumber()
    {
        int expectedSumma =50;
        int actual = calculator.multiplyNumbers();
        Assert.assertEquals(expectedSumma, actual);
    }
    @After
    public void close()
    {
        calculator = null;
    }
}
