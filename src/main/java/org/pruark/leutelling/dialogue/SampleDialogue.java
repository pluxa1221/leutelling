package org.pruark.leutelling.dialogue;

import java.util.Arrays;
import java.util.List;

public class SampleDialogue {
    public static List<DialogueNode> getDialogue() {
        return Arrays.asList(
            new DialogueNode("Привет! Чем могу помочь?", Arrays.asList(
                new DialogueOption("Кто ты?", 1),
                new DialogueOption("Пока!", -1)
            )),
            new DialogueNode("Я страж этого мира.", Arrays.asList(
                new DialogueOption("Расскажи о себе.", 2),
                new DialogueOption("Пока!", -1)
            )),
            new DialogueNode("Я охраняю этот лес с древних времён.", Arrays.asList(
                new DialogueOption("Понятно, спасибо.", -1)
            ))
        );
    }
}