public class AvecOlives extends DecoratorIngredient {

    public AvecOlives(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", olives";
    }

    @Override
    public double getPrix() {
        return pizza.getPrix() + 0.80;
    }
}
