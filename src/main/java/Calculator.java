public class Calculator {
    private int firstNumber;
    private int secondNumber;

    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public int addNumbers() {
        int summa = firstNumber + secondNumber;
        return summa;
    }

    public int multiplyNumbers() {
        int multiplication = firstNumber * secondNumber;
        return multiplication;
    }

    public int divideNumbers() {
        try {
            int division = firstNumber / secondNumber;
            return division;
        } catch (ArithmeticException e) {
            throw  new ArithmeticException();
        }
    }
}
