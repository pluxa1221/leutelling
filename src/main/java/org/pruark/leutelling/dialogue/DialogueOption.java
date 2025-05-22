package org.pruark.leutelling.dialogue;

public class DialogueOption {
    public final String text;
    public final int nextNode; // -1 если конец

    public DialogueOption(String text, int nextNode) {
        this.text = text;
        this.nextNode = nextNode;
    }
}