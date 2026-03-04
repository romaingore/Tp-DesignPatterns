public interface Diffuseur {
    void subscribe(Souscripteur s);
    void unsubscribe(Souscripteur s);
    void notifier();
}
