package main;

import java.util.Map;

public class Property {
    private int munNo;
    private String munName;
    private int lotNo;
    private int secNo;
    private String name;
    private double area;
    private String ownerName;

    private MunicipalityLoader loader = new MunicipalityLoader();
    
    // henter ut det offisielle registeret av kommuner i Norge
    Map<Integer, String> municipalities = loader.loadMunicipalities();

    public Property(int munNo, int lotNo, int secNo, double area, String ownerName) {
        this.munNo = munNo;
        this.munName = municipalities.get(munNo);
        this.lotNo = lotNo;
        this.secNo = secNo;
        this.name = "";
        this.area = area;
        this.ownerName = ownerName;
    }

    

    // getters
    public int getMunNo() {
        return munNo;
    }

    public String getMunName() {
        return munName;
    }

    public int getLotNo() {
        return lotNo;
    }

    public int getSecNo() {
        return secNo;
    }

    public String getName() {
        return name;
    }

    public double getArea() {
        return area;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
                    sb.append(ownerName).append("'s property: \n")
                    .append(name)
                    .append("\n Municipality name and property code: \n")
                    .append(munName).append("\n")
                    .append(munNo).append("-")
                    .append(lotNo).append("/")
                    .append(secNo).append("\n")
                    .append("Area: ").append(area)
                    .append("\n---------\n");
        return sb.toString();
    }
}
