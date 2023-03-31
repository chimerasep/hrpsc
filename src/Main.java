import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Main {
    public static Company company;

    public static void main(String[] args)  {
        company = new Company();
        String inputPath = args[0];
        readInput(inputPath);
    }

    public static void readInput(String inputPath) {
        /* TODO: Take input path and read file, instantiate staff member objects. While you are
            instantiating objects such as Employee etc., each one should be added to the company
            by using its addStaffMember method. */
                try (BufferedReader br = new BufferedReader(new FileReader(inputPath))) {
                    String line;
                    br.readLine();
                    while (((line = br.readLine()) != null)) {
                        String[] fields = line.split("\t");
                        String type = fields[0];
                        String name = fields[1];
                        String address = fields[2];
                        String phone = fields[3];
                        String socSecNumber = fields[4];
                        String payRate = fields[5];

                        StaffMember sm =null ;
                        if (type.equals("Standard")) {
                            sm = new Employee(name, address, phone, socSecNumber, Double.parseDouble(payRate));
                        } else if (type.equals("Manager")) {
                            sm = new Manager(name, address, phone, socSecNumber, Double.parseDouble(payRate));
                        } else if (type.equals("Volunteer")) {
                            sm = new Volunteer(name, address, phone);
                        } else if (type.equals("Hourly")) {
                            sm = new HourlyWorker(name, address, phone, socSecNumber, Double.parseDouble(payRate));
                        }
                        company.addStaffMember(sm);
                    }
                } catch (IOException | InvalidCommandException e) {
                    throw new RuntimeException(e);
                }
    }
}


