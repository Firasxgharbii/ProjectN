package chatapp.model;

import chatapp.view.ChatView;

public class ChatCommand implements command {
    private String texte;
    private ChatView view;

    public ChatCommand(String texte, ChatView view) {
        this.texte = texte;
        this.view = view;
    }

    public void ecrire() {
        view.appendToTextPane(texte);
    }

    @Override
    public void annuler() {
        String content = view.getTextPaneContent();
        if (content.endsWith(texte + "\n")) {
            content = content.substring(0, content.length() - texte.length() - 1); // Supprime le dernier texte ajouté
            view.setTextPaneContent(content);
        }
    }

    @Override
    public void refaire() {
        ecrire();
    }
}
