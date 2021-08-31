package com.example;

import com.example.configurations.cfg;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class bot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        // msg = /start
        if(update.getMessage().getText().equals(cfg.handler+"start")) {
            SendMessage message = new SendMessage(update.getMessage().getChatId().toString(), 
                "Hello "+update.getMessage().getFrom().getFirstName());
            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
        
    }

    @Override
    public String getBotUsername() {
        return cfg.botUsername;
    }

    @Override
    public String getBotToken() {
        return cfg.botToken;
    }

}