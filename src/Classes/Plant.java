package Classes;

public class Plant {
    private int plantId;
    private String plantName;
    private String plantAddress;
    private double revenue;
    private double cost;

    public Plant(int plantId, String plantName, String plantAddress, double revenue, double cost) {
        this.plantId = plantId;
        this.plantName = plantName;
        this.plantAddress = plantAddress;
        this.revenue = revenue;
        this.cost = cost;
    }

    public int getPlantId() {
        return plantId;
    }

    public void setPlantId(int plantId) {
        this.plantId = plantId;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public String getPlantAddress() {
        return plantAddress;
    }

    public void setPlantAddress(String plantAddress) {
        this.plantAddress = plantAddress;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }


}
