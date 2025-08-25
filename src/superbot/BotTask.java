package superbot;

public interface BotTask {
    void onStart();
    int onLoop();
    void onExit();
}
