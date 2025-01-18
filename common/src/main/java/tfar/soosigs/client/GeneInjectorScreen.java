package tfar.soosigs.client;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import tfar.soosigs.Soosigs;
import tfar.soosigs.menu.GeneInjectorMenu;

public class GeneInjectorScreen extends AbstractContainerScreen<GeneInjectorMenu> {
    public GeneInjectorScreen(GeneInjectorMenu $$0, Inventory $$1, Component $$2) {
        super($$0, $$1, $$2);
    }

    private static final ResourceLocation CONTAINER_LOCATION = Soosigs.id("textures/gui/gene_injector.png");

    @Override
    public void render(GuiGraphics $$0, int $$1, int $$2, float $$3) {
        this.renderBackground($$0);
        super.render($$0, $$1, $$2, $$3);
        this.renderTooltip($$0, $$1, $$2);
    }

    @Override
    protected void init() {
        super.init();
        addRenderableWidget(Button.builder(Component.empty(),button -> sendButtonToServer(0))
                .bounds(leftPos + 130,topPos+50,10,10).build());
    }

    private void sendButtonToServer(int action) {
        this.minecraft.gameMode.handleInventoryButtonClick(this.menu.containerId, action);
    }


    @Override
    protected void renderBg(GuiGraphics $$0, float $$1, int $$2, int $$3) {
        int $$4 = (this.width - this.imageWidth) / 2;
        int $$5 = (this.height - this.imageHeight) / 2;
        $$0.blit(CONTAINER_LOCATION, $$4, $$5, 0, 0, this.imageWidth, this.imageHeight);
    }
}
