public class Dish {
    String name;
    String courseType;
    double price;
    String recipe;

    public Dish(String name, String courseType, double price, String recipe) {
        this.name = name;
        this.courseType = courseType;
        this.price = price;
        this.recipe = recipe;
    }

    public String getCourseType() {
        return courseType;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public String getRecipe() {
        return recipe;
    }
   
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Dish: ").append(name).append("\nType: ")
        .append(courseType).append("\nPrice: ")
        .append(price).append("\nRecipe: ")
        .append(recipe);
        return sb.toString();
    }


}
