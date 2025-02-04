package chatapp.controlleur;

import chatapp.model.command;
import chatapp.model.ChatCommand;
import chatapp.view.ChatView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class ChatControlleur {
    private ChatView view;
    private Stack<command> commands = new Stack<>();
    private Stack<command> refaireCommands = new Stack<>();

    public ChatControlleur(ChatView view) {
        this.view = view;

        // Ajouter les écouteurs aux éléments de la vue
        view.addEnvoyerListener(new EnvoyerListener());
        view.addAnnulerListener(new AnnulerListener());
        view.addRefaireListener(new RefaireListener());
    }

    class EnvoyerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String texte = view.getTextFieldContent();
            ChatCommand command = new ChatCommand(texte, view);
            commands.push(command);
            command.ecrire();
            view.clearTextField();
            view.setAnnulerEnabled(true);
        }
    }

    class AnnulerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!commands.isEmpty()) {
                command command = commands.pop();
                command.annuler();
                refaireCommands.push(command);
                view.setAnnulerEnabled(!commands.isEmpty());
                view.setRefaireEnabled(true);
            }
        }
    }

    class RefaireListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!refaireCommands.isEmpty()) {
                command command = refaireCommands.pop();
                command.refaire();
                commands.push(command);
                view.setRefaireEnabled(!refaireCommands.isEmpty());
                view.setAnnulerEnabled(true);
            }
        }
    }
}
