package com.example;

import com.example.configurations.cfg;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class bot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        // msg = /start
        if (update.getMessage().getText().equals(cfg.handler + "start")) {
            SendPhoto photo = new SendPhoto(update.getMessage().getChatId().toString(),new InputFile("https://www.internetandtechnologylaw.com/files/2019/06/iStock-872962368-chat-bots.jpg"));
            photo.setCaption("Hi "+update.getMessage().getFrom().getFirstName());
            try {
                execute(photo);
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