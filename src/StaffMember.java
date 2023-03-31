abstract public class StaffMember
{
    String name, address, phone;
    public StaffMember(String name, String address, String phone) {
        this.name = name;
        this.address= address;
        this.phone = phone;
    }
    public StaffMember() {}
    public abstract double calculatePayment();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



}
