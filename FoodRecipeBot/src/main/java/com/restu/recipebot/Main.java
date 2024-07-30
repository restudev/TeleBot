/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restu.recipebot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

/**
 *
 * @author Restu
 */

public class Main {
    public static void main(String[] args){
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            RecipeBot bot = new RecipeBot();
            botsApi.registerBot(bot);

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



