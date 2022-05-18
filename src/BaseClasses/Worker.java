package BaseClasses;

import java.util.Date;

public class Worker {
    private int workerId;
    private int salary;
    private int workerAddress;
    private int departmentId;
    private boolean isLeader;
    private Date birthDate;
    private String workerName;
    private String mobile;
    private String email;

    public Worker(int workerId, int salary, int workerAddress, int departmentId, boolean isLeader,
                  Date birthDate, String workerName, String mobile, String email) {
        this.workerId = workerId;
        this.salary = salary;
        this.workerAddress = workerAddress;
        this.departmentId = departmentId;
        this.isLeader = isLeader;
        this.birthDate = birthDate;
        this.workerName = workerName;
        this.mobile = mobile;
        this.email = email;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getWorkerAddress() {
        return workerAddress;
    }

    public void setWorkerAddress(int workerAddress) {
        this.workerAddress = workerAddress;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public boolean getLeader() {
        return isLeader;
    }

    public void setLeader(boolean leader) {
        this.isLeader = leader;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public int getWorkerId() {
        return workerId;
    }
}
