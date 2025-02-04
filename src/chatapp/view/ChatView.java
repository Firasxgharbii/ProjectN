package chatapp.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ChatView extends JFrame {
    private JTextPane textPane;
    private JTextField textField;
    private JButton button;
    private JMenuItem menuAnnuler;
    private JMenuItem menuRefaire;

    public ChatView() {
        setTitle("Conversation en ligne");
        setLayout(new BorderLayout());

        // Configuration des composants Swing
        textPane = new JTextPane();
        textField = new JTextField();
        button = new JButton("Envoyer");

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Edition");
        menuAnnuler = new JMenuItem("Annuler");
        menuRefaire = new JMenuItem("Refaire");

        menu.add(menuAnnuler);
        menu.add(menuRefaire);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        add(new JScrollPane(textPane), BorderLayout.CENTER);
        add(textField, BorderLayout.SOUTH);
        add(button, BorderLayout.EAST);

        // Désactiver les menus Annuler et Refaire au début
        menuAnnuler.setEnabled(false);
        menuRefaire.setEnabled(false);

        // Paramètres de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
    }

    // Getters pour les composants
    public String getTextFieldContent() {
        return textField.getText();
    }

    public void clearTextField() {
        textField.setText("");
    }

    public void setTextPaneContent(String content) {
        textPane.setText(content);
    }

    public String getTextPaneContent() {
        return textPane.getText();
    }

    public void appendToTextPane(String text) {
        textPane.setText(textPane.getText() + text + "\n");
    }

    public void setAnnulerEnabled(boolean enabled) {
        menuAnnuler.setEnabled(enabled);
    }

    public void setRefaireEnabled(boolean enabled) {
        menuRefaire.setEnabled(enabled);
    }

    // Méthodes pour ajouter les écouteurs
    public void addEnvoyerListener(ActionListener listener) {
        button.addActionListener(listener);
    }

    public void addAnnulerListener(ActionListener listener) {
        menuAnnuler.addActionListener(listener);
    }

    public void addRefaireListener(ActionListener listener) {
        menuRefaire.addActionListener(listener);
    }
}
