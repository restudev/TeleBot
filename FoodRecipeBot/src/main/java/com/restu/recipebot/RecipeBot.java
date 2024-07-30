package com.restu.recipebot;

import com.fasterxml.jackson.databind.JsonNode;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.apache.http.client.fluent.Request;
import org.json.JSONArray;
import org.json.JSONObject;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class RecipeBot extends TelegramLongPollingBot {

    private static final String BOT_TOKEN = "6706755092:AAF1VXF8UK2w6sLHltoileND6JfZAoDHob4";
    private static final String BOT_USERNAME = "frecipe_bot";

    private static final String API_ID = "e262db7b";
    private static final String API_KEY = "8c2a440413843397d0dc0d833e973e92";

    // Database Credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/db_foodrecipe";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            handleIncomingMessage(update.getMessage());
        } else if (update.hasCallbackQuery()) {
            handleCallbackQuery(update.getCallbackQuery());
        }
    }

    private void handleIncomingMessage(Message message) {
        String messageText = message.getText();
        long chatId = message.getChatId();
        String sChatId = Long.toString(chatId);
        String username = message.getFrom().getUserName();

        LocalDate currentDate = LocalDate.now();
        saveMessageToDatabase(sChatId, username, messageText, currentDate);
        saveUserData(sChatId, username);

        if (messageText.startsWith("/")) {
            // Handle commands
            if (!isUserRegistered(chatId)) {
                // User is not registered
                if (messageText.equals("/run")) {
                    sendResponse(chatId, "Please register first using the /register command.");
                    saveMessageToDatabase("2631836", BOT_USERNAME, "User tried to use /run without registration", currentDate);
                } else if (messageText.equals("/register")) {
                    saveMemberData(sChatId, username);
                    String response = "Thank you for registering 🤗\n\nPlease use the commands below:\n"
                            + "--------------------------------------------------------------------\n"
                            + "/recipe <query> - Search for a recipe\n"
                            + "/recommend - Get recommended recipes\n"
                            + "/help - Display help and commands\n"
                            + "==================================\n"
                            + "Your chat will be visible in our database\n\nBy Restu Lestari";
                    sendResponse(chatId, response);
                    saveMessageToDatabase("2631836", BOT_USERNAME, response, currentDate);
                } else if (messageText.equals("/help")) {
                    sendResponse(chatId, "Here are some of the available commands:\n\n/register - Register with the bot to get full access");
                    saveMessageToDatabase("2631836", BOT_USERNAME, "User requested help without registration", currentDate);
                } else {
                    sendResponse(chatId, "Command not recognized. Please use /help to see available commands.");
                    saveMessageToDatabase("2631836", BOT_USERNAME, "Unrecognized command from unregistered user", currentDate);
                }
            } else {
                // User is registered, handle registered user commands
                handleRegisteredUserCommands(chatId, messageText);
            }
        } else {
            // Check if messageText matches any keyword in the database
            String keywordResponse = fetchKeywordResponse(messageText);
            if (keywordResponse != null) {
                sendResponse(chatId, keywordResponse);
                saveMessageToDatabase("2631836", BOT_USERNAME, keywordResponse, currentDate);
            } else {
                sendResponse(chatId, "Keyword not found.");
                saveMessageToDatabase("2631836", BOT_USERNAME, "Keyword not found: " + messageText, currentDate);
            }
        }
    }

    private void handleRegisteredUserCommands(long chatId, String text) {
        if (text.equals("/run")) {
            sendWelcomeMessage(chatId);
        } else if (text.equals("/register")) {
            sendResponse(chatId, "You are already registered!\n\nUse the following commands:\n"
                    + "--------------------------------------------------------------------\n"
                    + "/recipe <query> - To search for recipes\n"
                    + "/recommend - To get recipe recommendations\n"
                    + "/help - To display help and commands\n"
                    + "==================================");
            saveMessageToDatabase("2631836", BOT_USERNAME, "User requested /register again", LocalDate.now());
        } else if (text.startsWith("/recipe")) {
            String query = text.substring(7).trim();
            sendRecipe(chatId, query);
        } else if (text.equals("/recommend")) {
            sendRandomRecipeOptions(chatId);
        } else if (text.equals("/help")) {
            sendHelpMessage(chatId);
        } else {
            sendDefaultMessage(chatId);
        }
    }

    private String fetchKeywordResponse(String keyword) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            String sql = "SELECT pesan FROM kunci WHERE kata = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, keyword);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("pesan");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Return null if no matching keyword is found
    }

    private void sendDefaultMessage(long chatId) {
        String defaultMessage = "Command not recognized. Please use /help to see available commands.";
        sendResponse(chatId, defaultMessage);
        saveMessageToDatabase("2631836", BOT_USERNAME, defaultMessage, LocalDate.now());
    }

    private String fetchCommandResponse(String command) {
        switch (command) {
            case "/register":
                return "You are already registered!";
            case "/help":
                return "Here are some of the available commands:\n\n/register - Register with the bot to get full access";
            // Add other commands as needed
            default:
                return null;
        }
    }

//    private String fetchKeywordResponse(String keyword) {
//        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
//            String sql = "SELECT pesan FROM kunci WHERE kata = ?";
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setString(1, keyword);
//            ResultSet resultSet = statement.executeQuery();
//
//            if (resultSet.next()) {
//                return resultSet.getString("pesan");
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null; // Return null if no matching keyword is found
//    }
    private void handleCallbackQuery(CallbackQuery callbackQuery) {
        String data = callbackQuery.getData();
        long chatId = callbackQuery.getMessage().getChatId();
        String sChatId = Long.toString(chatId);
        String username = callbackQuery.getFrom().getUserName();

        LocalDate currentDate = LocalDate.now();
        saveMessageToDatabase(sChatId, username, data, currentDate);

        // Fetch and send the recipe details based on the selected recipe label
        sendRecipeDetails(chatId, data);
    }

//    private void handleRegisteredUserCommands(long chatId, String text) {
//        if (text.equals("/run")) {
//            if (!isUserRegistered(chatId)) {
//                sendResponse(chatId, "Please register first using the /register command.");
//                saveMessageToDatabase("2631836", BOT_USERNAME, "User tried to use /run without registration", LocalDate.now());
//            } else {
//                sendWelcomeMessage(chatId);
//            }
//        } else if (text.equals("/register")) {
//            String response = "You are already registered!\n\nUse the following commands:\n"
//                    + "--------------------------------------------------------------------\n"
//                    + "/recipe <query> - To search for recipes\n"
//                    + "/recommend - To get recipe recommendations\n"
//                    + "/help - To display help and commands"
//                    + "\n==================================";
//
//            sendResponse(chatId, response);
//            saveMessageToDatabase("2631836", BOT_USERNAME, response, LocalDate.now());
//        } else if (text.startsWith("/recipe")) {
//            String query = text.substring(7).trim();
//            sendRecipe(chatId, query);
//        } else if (text.equals("/recommend")) {
//            sendRandomRecipeOptions(chatId);
//        } else if (text.equals("/help")) {
//            sendHelpMessage(chatId);
//        } else {
//            // Check if messageText matches any keyword in the database
//            String keywordResponse = fetchKeywordResponse(text);
//            if (keywordResponse != null) {
//                sendResponse(chatId, keywordResponse);
//                saveMessageToDatabase("2631836", BOT_USERNAME, keywordResponse, LocalDate.now());
//            } else {
//                sendDefaultMessage(chatId);
//            }
//        }
//    }
//    private void sendDefaultMessage(long chatId) {
//        String defaultMessage = "I did not understand that command. Type /help to see available commands.";
//        sendResponse(chatId, defaultMessage);
//    }
    private void sendWelcomeMessage(long chatId) {
        String welcomeMessage = "Welcome to FoodRecipeBot 🍲\n\n"
                + "Please use the commands below:\n"
                + "--------------------------------------------------------------------\n"
                + "/register - Register to gain full access\n"
                + "/recipe <query> - Search for a recipe\n"
                + "/recommend - Get recommended recipes\n"
                + "/help - Display help and commands"
                + "\n=================================="
                + "\n Your chat will be visible in our database";

        sendResponse(chatId, welcomeMessage);
    }

    private boolean isUserRegistered(long chatId) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            String sql = "SELECT * FROM member WHERE chat_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, String.valueOf(chatId)); // Convert chatId to String
            ResultSet resultSet = statement.executeQuery();

            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void sendRandomRecipeOptions(long chatId) {
        try {
            String url = "https://api.edamam.com/search?q=indonesian&app_id=" + API_ID + "&app_key=" + API_KEY + "&from=0&to=10";
            String responseBody = Request.Get(url).execute().returnContent().asString();
            JSONObject jsonObject = new JSONObject(responseBody);
            JSONArray hits = jsonObject.getJSONArray("hits");
            List<JSONObject> randomRecipes = getRandomRecipes(hits, 3); // Get 3 unique random recipes

            SendMessage message = new SendMessage();
            message.setChatId(chatId);
            message.setText("Here are some Indonesian recipe recommendations for you:");

            InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
            List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

            for (JSONObject hit : randomRecipes) {
                JSONObject recipe = hit.getJSONObject("recipe");
                String recipeLabel = recipe.getString("label");

                InlineKeyboardButton button = new InlineKeyboardButton();
                button.setText(recipeLabel);
                button.setCallbackData(recipeLabel); // Ensure callback data is set correctly

                List<InlineKeyboardButton> row = new ArrayList<>();
                row.add(button);
                keyboard.add(row);
            }

            markup.setKeyboard(keyboard);
            message.setReplyMarkup(markup);
            execute(message);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<JSONObject> getRandomRecipes(JSONArray hits, int count) {
        List<JSONObject> randomRecipes = new ArrayList<>();
        Random random = new Random();
        Set<String> usedLabels = new HashSet<>();

        while (randomRecipes.size() < count && randomRecipes.size() < hits.length()) {
            int randomIndex = random.nextInt(hits.length());
            JSONObject hit = hits.getJSONObject(randomIndex);
            JSONObject recipe = hit.getJSONObject("recipe");
            String label = recipe.getString("label");

            if (!usedLabels.contains(label)) {
                randomRecipes.add(hit);
                usedLabels.add(label);
            }
        }

        return randomRecipes;
    }

    private void sendRecipe(long chatId, String query) {
        try {
            String encodedQuery = URLEncoder.encode(query, StandardCharsets.UTF_8.toString());
            String url = "https://api.edamam.com/search?q=" + encodedQuery + "&app_id=" + API_ID + "&app_key=" + API_KEY;
            String responseBody = Request.Get(url).execute().returnContent().asString();
            JSONObject jsonObject = new JSONObject(responseBody);
            JSONArray hits = jsonObject.getJSONArray("hits");

            if (hits.length() > 0) {
                JSONObject recipe = hits.getJSONObject(0).getJSONObject("recipe");
                String recipeLabel = recipe.getString("label");

                SendMessage message = new SendMessage();
                message.setChatId(chatId);
                message.setText("Fetching details for " + recipeLabel + "...");
                execute(message);

                sendRecipeDetails(chatId, recipeLabel);
                saveMessageToDatabase("2631836", BOT_USERNAME, "Fetching recipe: " + recipeLabel, LocalDate.now());

            } else {
                sendResponse(chatId, "Sorry, I couldn't find any recipe for \"" + query + "\". \nPlease use /recipe <query> format to search for recipes.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            sendResponse(chatId, "Oops! Something went wrong while fetching the recipe.");
        }
    }

    private void sendRecipeDetails(long chatId, String recipeLabel) {
        try {
            String encodedRecipeLabel = URLEncoder.encode(recipeLabel, StandardCharsets.UTF_8.toString());
            String url = "https://api.edamam.com/search?q=" + encodedRecipeLabel + "&app_id=" + API_ID + "&app_key=" + API_KEY;
            String responseBody = Request.Get(url).execute().returnContent().asString();
            JSONObject jsonObject = new JSONObject(responseBody);
            JSONArray hits = jsonObject.getJSONArray("hits");

            if (hits.length() > 0) {
                JSONObject recipe = hits.getJSONObject(0).getJSONObject("recipe");
                String label = recipe.getString("label");
                String imageUrl = recipe.getString("image");
                JSONArray ingredientsArray = recipe.getJSONArray("ingredientLines");

                StringBuilder ingredients = new StringBuilder();
                for (int i = 0; i < ingredientsArray.length(); i++) {
                    ingredients.append("- ").append(ingredientsArray.getString(i)).append("\n");
                }

                String instructions = "🔗 Please visit the link for detailed instructions: " + recipe.getString("url");

                SendPhoto sendPhotoRequest = new SendPhoto();
                sendPhotoRequest.setChatId(chatId);
                sendPhotoRequest.setPhoto(new InputFile(imageUrl));
                sendPhotoRequest.setCaption("Recipe: " + label + "\n\nIngredients:\n" + ingredients.toString() + "\n\nInstructions: \n" + instructions);
                execute(sendPhotoRequest);
                saveMessageToDatabase("2631836", BOT_USERNAME, "Sent recipe details for: " + recipeLabel, LocalDate.now());

            } else {
                sendResponse(chatId, "Sorry, I couldn't find the details for " + recipeLabel);
            }
        } catch (Exception e) {
            e.printStackTrace();
            sendResponse(chatId, "Oops! Something went wrong while fetching the recipe details.");
        }
    }

    private void sendHelpMessage(long chatId) {
        String helpMessage = "Here are some of the available commands:\n\n"
                + "--------------------------------------------------------------------\n"
                + "/register - Register with the bot to get full access\n"
                + "/recipe <query> - To search for recipes\n"
                + "/recommend - To get recipe recommendations\n"
                + "\n==================================";

        sendResponse(chatId, helpMessage);
    }

//    private void sendDefaultMessage(long chatId) {
//        String defaultMessage = "I did not understand that command. Type /help to see available commands.";
//        sendResponse(chatId, defaultMessage);
//    }
    private void sendResponse(long chatId, String response) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(response);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void saveMessageToDatabase(String chatId, String username, String message, LocalDate date) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            String sql = "INSERT INTO pesan (chat_id, username, pesan, date) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, chatId);
            statement.setString(2, username);
            statement.setString(3, message);
            statement.setDate(4, Date.valueOf(date));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void saveUserData(String chatId, String username) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            String sql = "INSERT INTO user (chat_id, username) VALUES (?, ?) ON DUPLICATE KEY UPDATE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, chatId);
            statement.setString(2, username);
            statement.setString(3, username);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void saveMemberData(String chatId, String username) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            String sql = "INSERT INTO member (chat_id, username) VALUES (?, ?) ON DUPLICATE KEY UPDATE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, chatId);
            statement.setString(2, username);
            statement.setString(3, username);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void sendMsg(long chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(text);

        try {
            execute(message);
        } catch (TelegramApiException e) {
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

            saveMessageToDatabase("2631836", BOT_USERNAME, broadcast, currentDate);

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

            saveMessageToDatabase("2631836", BOT_USERNAME, broadcast, currentDate);

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public String getBotUsername() {
        return BOT_USERNAME;
    }
}
