package org.pruark.leutelling.dialogue;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

import java.util.ArrayList;
import java.util.List;

public class DialogueScreen extends Screen {
    private final List<DialogueNode> nodes;
    private int currentNodeIdx = 0;
    private final List<Button> optionButtons = new ArrayList<>();

    public DialogueScreen(List<DialogueNode> nodes) {
        super(Component.literal("Диалог"));
        this.nodes = nodes;
    }

    @Override
    protected void init() {
        super.init();
        showCurrentNode();
    }

    private void showCurrentNode() {
        this.clearWidgets();
        optionButtons.clear();
        DialogueNode node = nodes.get(currentNodeIdx);

        int textY = this.height / 3;
        int optionY = textY + 40;
        int buttonHeight = 24;

        // Текст диалога
        this.addRenderableWidget(new Button(this.width / 2 - 100, textY, 200, 20, Component.literal(node.text), btn -> {})).active = false;

        // Кнопки опций
        for (int i = 0; i < node.options.size(); i++) {
            DialogueOption opt = node.options.get(i);
            Button btn = Button.builder(Component.literal(opt.text), b -> {
                if (opt.nextNode == -1) {
                    Minecraft.getInstance().setScreen(null); // Закрыть экран
                } else {
                    this.currentNodeIdx = opt.nextNode;
                    showCurrentNode();
                }
            }).bounds(this.width / 2 - 60, optionY + i * (buttonHeight + 4), 120, buttonHeight).build();
            this.addRenderableWidget(btn);
            optionButtons.add(btn);
        }
    }

    @Override
    public boolean shouldCloseOnEsc() {
        return true;
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
    }
}