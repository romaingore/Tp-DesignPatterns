public class AvecJambon extends DecoratorIngredient {

    public AvecJambon(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", jambon";
    }

    @Override
    public double getPrix() {
        return pizza.getPrix() + 1.50;
    }
}
