public class Main {
    public static void main(String[] args) {

        // Pizza de base sans ingredient supplementaire
        Pizza pizza1 = new PizzaMargarita();
        afficher(pizza1);

        System.out.println();

        // Ajout d'ingredients un par un (empilage des decorateurs)
        Pizza pizza2 = new PizzaMargarita();
        pizza2 = new AvecJambon(pizza2);
        afficher(pizza2);

        pizza2 = new AvecChampignons(pizza2);
        afficher(pizza2);

        pizza2 = new AvecFromage(pizza2);
        afficher(pizza2);

        System.out.println();

        // Composition directe en une seule ligne
        Pizza pizza3 = new AvecOlives(new AvecJambon(new AvecChampignons(new PizzaMargarita())));
        afficher(pizza3);

        System.out.println();

        // Meme ingredient ajoute deux fois (double fromage)
        Pizza pizza4 = new AvecFromage(new AvecFromage(new PizzaMargarita()));
        afficher(pizza4);
    }

    private static void afficher(Pizza pizza) {
        System.out.printf("%-60s %.2f€%n", pizza.getDescription(), pizza.getPrix());
    }
}
