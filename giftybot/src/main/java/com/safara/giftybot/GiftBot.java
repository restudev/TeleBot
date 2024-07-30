/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.safara.giftybot;

/**
 *
 * @author safara
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class GiftBot extends TelegramLongPollingBot {

    private String currentGender;
    private String currentAgeGroup;

    private static final String BOT_TOKEN = "7227762546:AAEe1-iLMu5n5YFfGXtlbDMtfU8ILvfSPLI";
    private static final String BOT_USERNAME = "giftyrestu_bot";

    private static final String DB_URL = "jdbc:mysql://localhost:3306/db_giftbot";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();
            Long chatId = message.getChatId();
            String sChatId = Long.toString(chatId);
            String text = message.getText();
            String username = message.getFrom().getUserName();

            LocalDate currentDate = LocalDate.now();

            saveUserData(sChatId, username); // Pass username here
            saveMessageToDatabase(sChatId, username, text, currentDate);

            if (text.equals("/register")) {
                handleRegistration(chatId, username, currentDate); // Pass username here
            } else {
                boolean isRegistered = isUserRegistered(sChatId);
                if (isRegistered) {
                    handleCommands(chatId, text, currentDate);
                } else {
                    String response = "Please register first using the /register command.";
                    sendResponse(chatId, response);
                }
            }
        } else if (update.hasCallbackQuery()) {
            handleCallbackQuery(update);
        }
    }

    @Override
    public String getBotUsername() {
        return BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    private boolean isUserRegistered(String chatId) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            String sql = "SELECT * FROM member WHERE chat_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, chatId);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void saveMessageToDatabase(String chatId, String username, String text, LocalDate currentDate) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            String sql = "INSERT INTO pesan (chat_id, username, pesan, date) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, chatId);
            statement.setString(2, username);
            statement.setString(3, text);
            statement.setString(4, String.valueOf(currentDate));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void saveUserData(String chatId, String username) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            String checkUserExistsSql = "SELECT * FROM user WHERE chat_id = ?";
            PreparedStatement checkUserExistsStatement = connection.prepareStatement(checkUserExistsSql);
            checkUserExistsStatement.setString(1, chatId);
            ResultSet resultSet = checkUserExistsStatement.executeQuery();

            if (!resultSet.next()) {
                String sql = "INSERT INTO user (chat_id, username) VALUES (?, ?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, chatId);
                statement.setString(2, username);
                statement.executeUpdate();
            } else {
                String updateSql = "UPDATE user SET username = ? WHERE chat_id = ?";
                PreparedStatement updateStatement = connection.prepareStatement(updateSql);
                updateStatement.setString(1, username);
                updateStatement.setString(2, chatId);
                updateStatement.executeUpdate();
            }

            resultSet.close();
            checkUserExistsStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void saveMemberData(String chatId, String username) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            String sql = "INSERT INTO member (chat_id, username) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, chatId);
            statement.setString(2, username);

            String checkUserExistsSql = "SELECT * FROM member WHERE chat_id = ?";
            PreparedStatement checkUserExistsStatement = connection.prepareStatement(checkUserExistsSql);
            checkUserExistsStatement.setString(1, chatId);
            ResultSet resultSet = checkUserExistsStatement.executeQuery();

            if (!resultSet.next()) {
                statement.executeUpdate();
            }

            resultSet.close();
            checkUserExistsStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void sendResponse(Long chatId, String response) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(response);

        try {
            execute(message);
            LocalDate currentDate = LocalDate.now();
            saveMessageToDatabase("1234567", BOT_USERNAME, response, currentDate);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void handleRegistration(Long chatId, String username, LocalDate currentDate) {
        String sChatId = String.valueOf(chatId);
        if (isUserRegistered(sChatId)) {
            String response = "You are already registered! 😊\n\nPlease choose one of the commands below:\n /gift - Get a gift suggestion\n /help - Display help and list of commands";
            sendResponse(chatId, response);
        } else {
            saveMemberData(String.valueOf(chatId), username);
            String response = "Thank you for registering! 🤗\n\nPlease choose one of the commands below:\n /gift - Get a gift suggestion\n /help - Display help and list of commands";
            sendResponse(chatId, response);
        }
    }

    private void handleCommands(Long chatId, String text, LocalDate currentDate) {
        switch (text) {
            case "/run":
                String welcomeMessage = "Welcome to GiftBot 🎁\n\nPlease choose one of the commands below:\n /gift - Get a gift suggestion\n /help - Display help and list of commands";
                sendResponse(chatId, welcomeMessage);
                break;
            case "/gift":
                sendGenderSelection(chatId);
                break;
            case "/help":
                String helpResponse = "Here are some available commands:\n\n/register - Register to the bot for full access\n/gift - Get a gift suggestion";
                sendResponse(chatId, helpResponse);
                break;
            default:
                String keywordResponse = getResponseForKeyword(currentGender, currentAgeGroup, text);
                sendResponse(chatId, keywordResponse);
                break;
        }
    }

    private String getResponseForKeyword(String gender, String ageGroup, String keyword) {
        String response = "Keyword not found!";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            String sql = "SELECT product_name, description, link, message FROM keywords WHERE gender = ? AND age_group = ? AND keyword = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, gender);
            statement.setString(2, ageGroup);
            statement.setString(3, keyword);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String productName = resultSet.getString("product_name");
                String description = resultSet.getString("description");
                String link = resultSet.getString("link");
                String message = resultSet.getString("message");

                response = "🎁 Product: " + productName + "\n"
                        + "📝 Description: " + description + "\n"
                        + "🔗 Purchase it here: " + link;
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            response = "An error occurred while retrieving data from the database.";
        }

        return response;
    }

//    private void handleCallbackQuery(Update update) {
//        String callbackData = update.getCallbackQuery().getData();
//        Long chatId = update.getCallbackQuery().getMessage().getChatId();
//
//        if (callbackData.startsWith("gender_")) {
//            currentGender = callbackData.substring("gender_".length());
//            saveUserChoice(chatId.toString(), currentGender, null); // Save gender choice
//            sendAgeSelection(chatId, currentGender);
//        } else if (callbackData.startsWith("age_")) {
//            String[] parts = callbackData.split("_");
//            currentAgeGroup = parts[1] + "_" + parts[2];
//            currentGender = parts[3];
//
//            saveUserChoice(chatId.toString(), currentGender, currentAgeGroup); // Save age group choice
//
//            String response = "You selected:\nGender: " + currentGender + "\nAge Group: " + currentAgeGroup + "\n\nNow please enter a keyword to get a gift suggestion:";
//            sendResponse(chatId, response);
//        }
//    }
    private void handleCallbackQuery(Update update) {
        String callbackData = update.getCallbackQuery().getData();
        Long chatId = update.getCallbackQuery().getMessage().getChatId();

        if (callbackData.startsWith("gender_")) {
            currentGender = callbackData.substring("gender_".length());
            saveUserChoice(chatId.toString(), currentGender, null); // Save gender choice without age_group for now
            sendAgeSelection(chatId, currentGender);
        } else if (callbackData.startsWith("age_")) {
            String[] parts = callbackData.split("_");
            currentAgeGroup = parts[1] + "_" + parts[2];
            currentGender = parts[3];

            // Ensure currentAgeGroup is not null if possible
            if (currentAgeGroup == null || currentAgeGroup.isEmpty()) {
                // Handle the case where age_group is not provided
                currentAgeGroup = "default_value"; // Set default value or handle accordingly
            }

            saveUserChoice(chatId.toString(), currentGender, currentAgeGroup); // Save age group choice

            String response = "You selected:\nGender: " + currentGender + "\nAge Group: " + currentAgeGroup + "\n\nPlease choose a keyword from the list below:";
            sendResponse(chatId, response);

            // Fetch and display available keywords
            displayAvailableKeywords(chatId, currentGender, currentAgeGroup);
        }
    }

    private void displayAvailableKeywords(Long chatId, String gender, String ageGroup) {
        StringBuilder keywordsMessage = new StringBuilder();

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            String sql = "SELECT keyword FROM keywords WHERE gender = ? AND age_group = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, gender);
            statement.setString(2, ageGroup);
            ResultSet resultSet = statement.executeQuery();

            List<String> uniqueKeywords = new ArrayList<>();
            while (resultSet.next()) {
                String keyword = resultSet.getString("keyword");
                if (!uniqueKeywords.contains(keyword)) {
                    uniqueKeywords.add(keyword);
                    keywordsMessage.append("- ").append(keyword).append("\n");
                }
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            keywordsMessage = new StringBuilder("An error occurred while retrieving keywords from the database.");
        }

        // Hanya kirim pesan jika ada kata kunci yang ditemukan
        if (keywordsMessage.length() > 0) {
            sendResponse(chatId, "Available keywords for your selection:\n" + keywordsMessage.toString());
        }
    }

//    private void displayAvailableKeywords(Long chatId, String gender, String ageGroup) {
//        String keywordsMessage = "Available keywords for your selection:\n";
//        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
//            String sql = "SELECT keyword FROM keywords WHERE gender = ? AND age_group = ?";
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setString(1, gender);
//            statement.setString(2, ageGroup);
//            ResultSet resultSet = statement.executeQuery();
//
//            InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
//            List<List<InlineKeyboardButton>> rows = new ArrayList<>();
//
//            while (resultSet.next()) {
//                String keyword = resultSet.getString("keyword");
//                InlineKeyboardButton keywordButton = new InlineKeyboardButton();
//                keywordButton.setText(keyword);
//                keywordButton.setCallbackData("keyword_" + keyword);
//                List<InlineKeyboardButton> row = new ArrayList<>();
//                row.add(keywordButton);
//                rows.add(row);
//            }
//
//            markup.setKeyboard(rows);
//            SendMessage message = new SendMessage();
//            message.setChatId(chatId);
//            message.setText(keywordsMessage);
//            message.setReplyMarkup(markup);
//
//            execute(message);
//
//            resultSet.close();
//            statement.close();
//        } catch (SQLException | TelegramApiException e) {
//            e.printStackTrace();
//            sendResponse(chatId, "An error occurred while retrieving keywords.");
//        }
//    }
//    private void displayAvailableKeywords(Long chatId, String gender, String ageGroup) {
//        String keywordsMessage = "Available keywords for your selection:\n";
//        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
//            String sql = "SELECT keyword FROM keywords WHERE gender = ? AND age_group = ?";
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setString(1, gender);
//            statement.setString(2, ageGroup);
//            ResultSet resultSet = statement.executeQuery();
//
//            while (resultSet.next()) {
//                keywordsMessage += "- " + resultSet.getString("keyword") + "\n";
//            }
//
//            resultSet.close();
//            statement.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            keywordsMessage = "An error occurred while retrieving keywords from the database.";
//        }
//
//        sendResponse(chatId, keywordsMessage);
//    }
    private void sendGenderSelection(Long chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Please select your gender:");

        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rows = new ArrayList<>();

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton maleButton = new InlineKeyboardButton();
        maleButton.setText("Male");
        maleButton.setCallbackData("gender_male");
        row1.add(maleButton);

        InlineKeyboardButton femaleButton = new InlineKeyboardButton();
        femaleButton.setText("Female");
        femaleButton.setCallbackData("gender_female");
        row1.add(femaleButton);

        rows.add(row1);
        markup.setKeyboard(rows);
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void sendAgeSelection(Long chatId, String gender) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Please select your age group:");

        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rows = new ArrayList<>();

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton ageGroup1 = new InlineKeyboardButton();
        ageGroup1.setText("16-25");
        ageGroup1.setCallbackData("age_16_25_" + gender);
        row1.add(ageGroup1);

        InlineKeyboardButton ageGroup2 = new InlineKeyboardButton();
        ageGroup2.setText("26-35");
        ageGroup2.setCallbackData("age_26_35_" + gender);
        row1.add(ageGroup2);

        List<InlineKeyboardButton> row2 = new ArrayList<>();
        InlineKeyboardButton ageGroup3 = new InlineKeyboardButton();
        ageGroup3.setText("36-45");
        ageGroup3.setCallbackData("age_36_45_" + gender);
        row2.add(ageGroup3);

        InlineKeyboardButton ageGroup4 = new InlineKeyboardButton();
        ageGroup4.setText("46+");
        ageGroup4.setCallbackData("age_46_plus_" + gender);
        row2.add(ageGroup4);

        rows.add(row1);
        rows.add(row2);
        markup.setKeyboard(rows);
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void saveUserChoice(String chatId, String gender, String ageGroup) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            String sql = "INSERT INTO user_choice (chat_id, gender, age_group) VALUES (?, ?, ?) "
                    + "ON DUPLICATE KEY UPDATE gender=?, age_group=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, chatId);
            statement.setString(2, gender);
            statement.setString(3, ageGroup);
            statement.setString(4, gender);
            statement.setString(5, ageGroup);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void sendBroadcastTo(String username, String broadcast) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            String sql = "SELECT chat_id FROM member WHERE username=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String sChatId = resultSet.getString("chat_id");
                long chatId = Long.parseLong(sChatId);
                sendResponse(chatId, broadcast);
            }

            LocalDate currentDate = LocalDate.now();

            saveMessageToDatabase("1234567", BOT_USERNAME, broadcast, currentDate);

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void sendBroadcastAll(String broadcast) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            String sql = "SELECT chat_id FROM member";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String sChatId = resultSet.getString("chat_id");
                long chatId = Long.parseLong(sChatId);
                sendResponse(chatId, broadcast);
            }

            LocalDate currentDate = LocalDate.now();

            saveMessageToDatabase("1234567", BOT_USERNAME, broadcast, currentDate);

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
