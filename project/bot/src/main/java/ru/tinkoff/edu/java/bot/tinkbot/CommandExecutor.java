package ru.tinkoff.edu.java.bot.tinkbot;

public interface CommandExecutor {
    void start(int userId);
    void help(int userId);
    void track(int userId, String link);
    void untrack(int userId, String link);
    void list(int userId);
}