public class AvecChampignons extends DecoratorIngredient {

    public AvecChampignons(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", champignons";
    }

    @Override
    public double getPrix() {
        return pizza.getPrix() + 1.00;
    }
}
