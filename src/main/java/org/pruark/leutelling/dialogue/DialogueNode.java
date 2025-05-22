package org.pruark.leutelling.dialogue;

import java.util.List;

public class DialogueNode {
    public final String text;
    public final List<DialogueOption> options;

    public DialogueNode(String text, List<DialogueOption> options) {
        this.text = text;
        this.options = options;
    }
}