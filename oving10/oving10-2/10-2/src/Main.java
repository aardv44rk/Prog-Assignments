import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        MenuReg menuReg = new MenuReg();

        menuReg.init();

        System.out.println("Dishes named 'Burger':");
        menuReg.getDish("Burger").forEach(System.out::println);

        System.out.println("\nAll appetizer dishes:");
        menuReg.dishByType("appetizer").forEach(System.out::println);

        double priceThreshold = 20.0;
        System.out.println("\nMenus with a total price over " + priceThreshold + ":");
        menuReg.getMenusByPrice(priceThreshold).forEach(System.out::println);

        System.out.println("\nThree random dishes of different course types:");
        List<Dish> randomDishes = menuReg.registerMenu();
        randomDishes.forEach(System.out::println);    
    }

}
