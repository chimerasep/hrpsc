public class HourlyWorker extends Employee
{
    public int getHoursWorked() {
        return totalHoursWorked;
    }

    public void setHoursWorked(int totalHoursWorked) {
        this.totalHoursWorked = totalHoursWorked;
    }

    public int totalHoursWorked;


    public HourlyWorker(String name, String address, String phone, String socSecNumber, double payRate) {
        super(name, address, phone, socSecNumber, payRate);
    }

    public void addHours(int hours) {
        this.totalHoursWorked=hours;
    }

    @Override
    public double calculatePayment() {
        return payRate*totalHoursWorked;
    }
}
