import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.Random;

public class MenuReg {
        private List<Menu> menuList;
        private Random random = new Random();

        public MenuReg() {
            menuList = new ArrayList<>();
        }

        public void addMenu(Menu menu) {
            menuList.add(menu);
        }

        public Dish registerDish(String name, String courseType, double price, String recipe) {
            
            return new Dish(name, courseType, price, recipe);
        }

        public List<Dish> getDish(String name) {
            return menuList.stream()
                            .flatMap(menu -> menu.getDishes().stream())
                            .filter(dish -> dish.getName().equals(name))
                            .collect(Collectors.toList());
        }

        public List<Dish> dishByType(String courseType) {
            return menuList.stream()   
                            .flatMap(menu -> menu.getDishes().stream())
                            .filter(dish -> dish.getCourseType().equals(courseType))
                            .collect(Collectors.toList());
        }

        private Optional<Dish> getRandomDish(String courseType) {
            List<Dish> dishes = menuList.stream()  
                                        .flatMap(menu -> menu.getDishes().stream())
                                        .filter(dish -> dish.getCourseType().equals(courseType))
                                        .collect(Collectors.toList());
            return Optional.of(dishes.get(random.nextInt(dishes.size())));
        }

        public List<Dish> registerMenu() {
            List<String> courseTypes = List.of("appetizer","main","dessert");

            return courseTypes.stream()
                        .map(courseType -> getRandomDish(courseType))
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .collect(Collectors.toList());
        }

        public List<Menu> getMenusByPrice(double totalPrice) {
            return menuList.stream().filter(menu -> menu.getTotalPrice() > totalPrice)
                            .collect(Collectors.toList());
        }

        public void init() {

            Menu menu1 = new Menu();
            Menu menu2 = new Menu();
            Menu menu3 = new Menu();
        
            menu1.addDish(new Dish("Pancakes", "dessert", 5.99, "Fluffy pancakes with syrup"));
            menu1.addDish(new Dish("Omelette", "appetizer", 6.99, "Eggs with veggies and cheese"));
            menu1.addDish(new Dish("Burger", "main", 9.99, "Classic beef burger with fries"));
            menu1.addDish(new Dish("Caesar Salad", "appetizer", 7.99, "Crispy lettuce with Caesar dressing"));
            menu1.addDish(new Dish("Steak", "main", 19.99, "Grilled steak with garlic butter"));
        
            menu2.addDish(new Dish("French Toast", "dessert", 6.49, "Toasted bread with cinnamon"));
            menu2.addDish(new Dish("Pizza", "main", 8.99, "Cheese pizza with tomato sauce"));
            menu2.addDish(new Dish("Chicken Alfredo", "main", 14.99, "Pasta with creamy Alfredo sauce"));
            menu2.addDish(new Dish("Soup", "appetizer", 5.99, "Hot tomato soup with croutons"));
        
            menu3.addDish(new Dish("Bagel", "appetizer", 3.99, "Bagel with cream cheese"));
            menu3.addDish(new Dish("Sushi", "dinner", 12.99, "Assorted sushi platter"));
            menu3.addDish(new Dish("Cake", "dessert", 4.99, "cake"));
        
            menuList.add(menu1);
            menuList.add(menu2);
            menuList.add(menu3);
        }
        

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            menuList.forEach(menu -> sb.append(menu).append("\n"));
            return sb.toString();
        }
}
