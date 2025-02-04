package chatapp;

import chatapp.view.ChatView;
import chatapp.controlleur.ChatControlleur;

public class ChatApp {
    public static void main(String[] args) {
        ChatView view = new ChatView();
        new ChatControlleur(view);
        view.setVisible(true);
    }
}
