import java.util.*;

public class Company {
    /** This is a mapping which maps the names of teams with the team objects. */
    HashMap<String, Team> teamsMap;

    /** This is a mapping which maps the names of staff members with the staff member objects. */
    HashMap<String, StaffMember> staffMemberMap;

    public Company() {
        staffMemberMap = new HashMap<>();
        teamsMap = new HashMap<>();
    }

    public TreeSet<HourlyWorker> getTopWorkedHourlyWorkers(int count) throws InvalidCommandException {
        if (count < 1 || count > staffMemberMap.size()) {
            throw new InvalidCommandException("Invalid count (" + count + ") argument passed to getTopWorkedHourlyWorkers.");
        }

        TreeSet<HourlyWorker> topWorkedHourlyWorkers = new TreeSet<>((o1, o2) -> o2.getHoursWorked() - o1.getHoursWorked());

        for (StaffMember staffMember : staffMemberMap.values()) {
            if (staffMember instanceof HourlyWorker) {
                topWorkedHourlyWorkers.add((HourlyWorker) staffMember);
                if (topWorkedHourlyWorkers.size() > count) {
                    topWorkedHourlyWorkers.pollLast();
                }
            }
        }

        return topWorkedHourlyWorkers;


    }
    public TreeMap<Employee, Double> getTopPaidEmployees(int count) throws InvalidCommandException {
        if (count < 1 || count > staffMemberMap.size()) {
            throw new InvalidCommandException("Invalid count (" + count + ") argument passed to getTopPaidEmployees.");
        }
        TreeMap<Employee, Double> topPaidEmployees = new TreeMap<>((e1, e2) -> Double.compare(e2.calculatePayment(), e1.calculatePayment()));
        for (StaffMember sm : staffMemberMap.values()) {
            if (sm instanceof Employee) {
                Employee e = (Employee) sm;
                topPaidEmployees.put(e, e.calculatePayment());
                if (topPaidEmployees.size() > count) {
                    topPaidEmployees.pollLastEntry();
                }
            }
        }
        return topPaidEmployees;
    }

    public void addStaffMember(StaffMember member) throws InvalidCommandException {

        String name = member.getName();
        if (!staffMemberMap.containsKey(name)) {
            staffMemberMap.put(name, member);
            System.out.println("Staff member " + name + " added to company.");
        } else {
            throw new InvalidCommandException("Staff member " + name + " already exists in company.");
        }
    }


    public void removeStaffMember(String name) throws InvalidCommandException {
        if (staffMemberMap.containsKey(name)) {
            staffMemberMap.remove(name);
            System.out.println("Staff member " + name + " removed from company.");
        } else {
            throw new InvalidCommandException("Staff member " + name + " does not exist in company.");
        }

    }

    public void addNewTeam(String teamName, String managerName, HashSet<String> teamMemberNames) throws InvalidCommandException {
        if (!staffMemberMap.containsKey(managerName) || !(staffMemberMap.get(managerName) instanceof Manager)) {
            throw new InvalidCommandException("There is no manager with name " + managerName + ".");}
        Employee manager = (Employee) staffMemberMap.get(managerName);

        TreeSet<Employee> teamMembers = new TreeSet<>(Comparator.comparing(StaffMember::getName));
        if (!staffMemberMap.containsKey(managerName)) {
            throw new InvalidCommandException("There is no manager with name " + managerName + ".");
        }
        for (String name : teamMemberNames) {
            if (!staffMemberMap.containsKey(name)) {
                throw new InvalidCommandException("There is no employee with name " + name + ".");
            }
            StaffMember sm = staffMemberMap.get(name);
            if (sm instanceof Employee) {
                Employee e = (Employee) sm;
                teamMembers.add(e);
            } else {
                throw new InvalidCommandException("There is no employee with name " + name + ".");
            }
        }

        Team team = new Team(teamMembers, manager, teamName);
        teamsMap.put(teamName, team);
        System.out.println("Team with name " + teamName + " added.");
    }
    public Team getTeamByName(String teamName) throws InvalidCommandException {
        if (teamsMap.containsKey(teamName)) {
            return teamsMap.get(teamName);
        } else {
            throw new InvalidCommandException("Team with name " + teamName + " not found.");
        }
    }

    public void printStaffMembers() {
        TreeSet<StaffMember> sortedStaffMembers = new TreeSet<>(Comparator.comparing(StaffMember::getName));

        sortedStaffMembers.addAll(staffMemberMap.values());

        for (StaffMember sm : sortedStaffMembers) {
            String className = sm.getClass().getSimpleName();
            System.out.println(sm.getName() + " => " + className);
        }
    }

    public HashMap<String, Team> getTeamsMap() {
        return teamsMap;
    }

    public HashMap<String, StaffMember> getStaffMemberMap() {
        return staffMemberMap;
    }
}