import java.util.TreeSet;
public class Team {
    private TreeSet<Employee> members;
    private Employee manager;
    private String teamName;

    public Team(TreeSet<Employee> members, Employee manager, String teamName) {
        this.members = members;
        this.manager = manager;
        this.teamName = teamName;
    }

    public TreeSet<Employee> getMembers() {
        return members;
    }

    public Employee getManager() {
        return manager;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setMembers(TreeSet<Employee> members) {
        this.members = members;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Team: " + teamName + " - ");
        sb.append("Manager: " + manager.getName() + " - ");
        sb.append("Members: ");
        for (Employee employee : members) {
            if (employee == (members.last() )) {
                sb.append(employee.getName());
            } else {
                sb.append(employee.getName() + ", ");
            }
        }
        return sb.toString();
    }
}