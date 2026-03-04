public abstract class DecoratorIngredient implements Pizza {

    protected Pizza pizza;

    public DecoratorIngredient(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }

    @Override
    public double getPrix() {
        return pizza.getPrix();
    }
}
