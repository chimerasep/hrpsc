public class Manager extends Employee
{
    public Manager(String name, String address, String phone, String socSecNumber, double payRate) {
        super(name, address, phone, socSecNumber, payRate);
    }
    private double bonus;
    public void awardBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double calculatePayment() {

        return payRate+bonus;
    }
}
