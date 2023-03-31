public class Employee extends StaffMember {
    String socSecNumber;
    double payRate;
    public Employee(String name, String address, String phone, String socSecNumber, double payRate) {
        this.name = name;
        this.phone = phone;
        this.socSecNumber =socSecNumber;
        this.payRate = payRate;
        this.address = address;
    }

    public String getSocSecNumber() {
        return socSecNumber;
    }

    public void setSocSecNumber(String socSecNumber) {
        this.socSecNumber = socSecNumber;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }


    @Override
    public double calculatePayment() {
        return payRate;
    }
}
