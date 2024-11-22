package main;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class PropertyRegistry {
    private Map<String, Property> propertyMap;

    public PropertyRegistry() {
        propertyMap = new HashMap<>(); 
    }

    public void addProperty(int munNo, int lotNo, int secNo, double area, String ownerName) {
        Property property = new Property(munNo, lotNo, secNo, area, ownerName);
        String id = munNo + "-" + lotNo + "/" + secNo;
        propertyMap.put(id, property);
    }

    public void removeProperty(String id) {
        propertyMap.remove(id);
    }

    public int getPropertyAmount() {
        return propertyMap.size();
    }
    
    public Property getProperty(String id) {
        return propertyMap.get(id);
    }

    public double getAreaMean() {
        double areaMean = propertyMap.values().stream()
                                    .mapToDouble(Property::getArea)
                                    .sum() / propertyMap.size();
        return areaMean;
    }

    public List<Property> getPropertyByLotNo(int lotNo) {
        List<Property> matchingLotNo = propertyMap.values().stream()
                                                .filter(property -> property.getLotNo() == lotNo)
                                                .collect(Collectors.toList());

        return matchingLotNo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        propertyMap.values().stream()
                            .map(Property::toString)
                            .forEach(sb::append);
        return sb.toString();
    }
}
