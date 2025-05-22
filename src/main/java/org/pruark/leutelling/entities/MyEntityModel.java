package org.pruark.leutelling.entities;

import net.minecraft.resources.ResourceLocation;
import org.pruark.leutelling.Leutelling;
import software.bernie.geckolib.model.GeoModel;

public class MyEntityModel extends GeoModel<MyEntity> {
    private final ResourceLocation model = new ResourceLocation(Leutelling.MODID, "geo/watcher.geo.json");
    private final ResourceLocation texture = new ResourceLocation(Leutelling.MODID, "textures/entity/watcher.png");
    private final ResourceLocation animations = new ResourceLocation(Leutelling.MODID, "animations/watcher.animation.json");

    @Override
    public ResourceLocation getModelResource(MyEntity object) {
        return this.model;
    }

    @Override
    public ResourceLocation getTextureResource(MyEntity object) {
        return this.texture;
    }

    @Override
    public ResourceLocation getAnimationResource(MyEntity object) {
        return this.animations;
    }
}
