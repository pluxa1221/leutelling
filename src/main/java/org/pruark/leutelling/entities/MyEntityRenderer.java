package org.pruark.leutelling.entities;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class MyEntityRenderer extends GeoEntityRenderer<MyEntity> {
    public MyEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new MyEntityModel());
    }
}