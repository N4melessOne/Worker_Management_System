package Classes;

import java.util.Date;

public class Worker {
    private int workerId;
    private int salary;
    private int wrokerAddress;
    private int departmentId;
    private byte leader;
    private Date birthDate;
    private String workerName;
    private String mobile;
    private String email;

    public Worker(int workerId, int salary, int wrokerAddress, int departmentId, byte leader,
                  Date birthDate, String workerName, String mobile, String email) {
        this.workerId = workerId;
        this.salary = salary;
        this.wrokerAddress = wrokerAddress;
        this.departmentId = departmentId;
        this.leader = leader;
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

    public int getWrokerAddress() {
        return wrokerAddress;
    }

    public void setWrokerAddress(int wrokerAddress) {
        this.wrokerAddress = wrokerAddress;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public byte getLeader() {
        return leader;
    }

    public void setLeader(byte leader) {
        this.leader = leader;
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
