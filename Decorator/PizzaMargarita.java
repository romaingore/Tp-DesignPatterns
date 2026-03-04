public class PizzaMargarita implements Pizza {

    @Override
    public String getDescription() {
        return "Pizza Margarita (tomate, mozzarella)";
    }

    @Override
    public double getPrix() {
        return 8.50;
    }
}
