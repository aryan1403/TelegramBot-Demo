package com.example;

import com.example.configurations.cfg;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class bot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        if(update.getMessage().getText().equals(cfg.handler+"id")) {
            SendMessage message = new SendMessage(update.getMessage().getChatId().toString(),
            "id : "+update.getMessage().getChatId().toString());

            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    
        // msg = /start
        if (update.getMessage().getText().equals(cfg.handler + "start")) {
            SendPhoto photo = new SendPhoto(chatId(update), new InputFile("https://www.internetandtechnologylaw.com/files/2019/06/iStock-872962368-chat-bots.jpg"));
            photo.setCaption("Hi "+update.getMessage().getFrom().getFirstName());

            
            SendDocument document = new SendDocument(chatId(update) , new InputFile("https://www.internetandtechnologylaw.com/files/2019/06/iStock-872962368-chat-bots.jpg"));
            SendMessage message = new SendMessage(update.getMessage().getChatId().toString(),"Hello");

            try { 
                execute(message);
                execute(photo);
                execute(document);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

        }
    }

    public String chatId(Update update) {
        return update.getMessage().getChatId().toString();
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