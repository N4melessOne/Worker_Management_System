package Classes;

public class Enterprise {
    private int enterpriseId;
    private String enterpriseName;
    private double sumRevenue;
    private double sumCost;

    public void setProfit(double profit) {
        double tempCost = this.getSumCost();
        double tempRevenue = this.getSumRevenue();
        return (tempRevenue - tempCost);
    }

    private double profit;

    public int getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(int enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }


    public void setSumRevenue(double sumRevenue) {
        this.sumRevenue = sumRevenue;
    }
    public double getSumRevenue() {
        return sumRevenue;
    }

    public double getSumCost() {
        return sumCost;
    }

    public void setSumCost(double sumCost) {
        this.sumCost = sumCost;
    }

    public double getProfit() {
        return profit;
    }




}
