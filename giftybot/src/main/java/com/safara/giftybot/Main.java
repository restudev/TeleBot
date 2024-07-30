package com.safara.giftybot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

/**
 *
 * @author safara
 */
public class Main {
    public static void main(String[] args){
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            GiftBot bot = new GiftBot();
            botsApi.registerBot(bot);

            // Setelah registrasi bot selesai, panggil form login
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new FormLogin().setVisible(true); 
                }
            });

        } catch (TelegramApiException e) {
            e.printStackTrace();
        } 
    } 
}
