import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Dish> list;
    private double totalPrice;

    public Menu() {
        list = new ArrayList<>();
        this.totalPrice = 0;
    }
    

    public double getTotalPrice() {
        totalPrice = list.stream()
                    .mapToDouble(Dish::getPrice)
                    .sum();
        return totalPrice;
    }

    public List<Dish> getDishes() {
        return list;
    }

    public void addDish(Dish dish) {
        list.add(dish);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        list.stream().forEach(dish -> sb.append(dish).append("\n"));
        return sb.toString();
    }
}