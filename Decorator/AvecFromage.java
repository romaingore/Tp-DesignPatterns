public class AvecFromage extends DecoratorIngredient {

    public AvecFromage(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", fromage supplementaire";
    }

    @Override
    public double getPrix() {
        return pizza.getPrix() + 1.20;
    }
}
