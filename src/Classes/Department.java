package Classes;

public class Department {
    private int departmentId;
    private String departmentName;
    private int maxWorkers;

    public Department(int departmentId, String departmentName, int maxWorkers) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.maxWorkers = maxWorkers;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getMaxWorkers() {
        return maxWorkers;
    }

    public void setMaxWorkers(int maxWorkers) {
        this.maxWorkers = maxWorkers;
    }

}
