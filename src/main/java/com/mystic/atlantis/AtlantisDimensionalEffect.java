package com.mystic.atlantis;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Axis;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;

import javax.annotation.Nullable;

public class AtlantisDimensionalEffect extends DimensionSpecialEffects {
    public static AtlantisDimensionalEffect INSTANCE = new AtlantisDimensionalEffect();
    private static final ResourceLocation SUN_TEXTURES = ResourceLocation.fromNamespaceAndPath("atlantis", "textures/environment/sun.png");
    private static final ResourceLocation MOON_PHASES_TEXTURES = ResourceLocation.fromNamespaceAndPath("atlantis", "textures/environment/moon_phases.png");

    @Nullable
    private VertexBuffer starBuffer;

    private AtlantisDimensionalEffect() {
        super(255.0F, true, DimensionSpecialEffects.SkyType.NORMAL, false, false);
    }

    @Override
    public boolean renderSky(@NotNull ClientLevel world, int ticks, float tickDelta, Matrix4f matrixStack, @NotNull Camera camera, @NotNull Matrix4f projectionMatrix, boolean isFoggy, @NotNull Runnable setupFog) {
        RenderSystem.disableDepthTest();
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.depthMask(false);
        PoseStack poseStack = new PoseStack();
        drawSun(tickDelta, poseStack, world);
        drawMoonPhases(tickDelta, poseStack, world);
        createStars();
        RenderSystem.depthMask(true);
        RenderSystem.disableBlend();
        RenderSystem.enableDepthTest();
        return true;
    }

    private void createStars() {
        if (this.starBuffer != null) {
            this.starBuffer.close();
        }

        this.starBuffer = new VertexBuffer(VertexBuffer.Usage.STATIC);
        this.starBuffer.bind();
        this.starBuffer.upload(this.drawStars(Tesselator.getInstance()));
        VertexBuffer.unbind();
    }

    private MeshData drawStars(Tesselator p_350542_) {
        RandomSource randomsource = RandomSource.create(10842L);
        int i = 1500;
        float f = 100.0F;
        BufferBuilder bufferbuilder = p_350542_.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION);

        for (int j = 0; j < 1500; j++) {
            float f1 = randomsource.nextFloat() * 2.0F - 1.0F;
            float f2 = randomsource.nextFloat() * 2.0F - 1.0F;
            float f3 = randomsource.nextFloat() * 2.0F - 1.0F;
            float f4 = 0.15F + randomsource.nextFloat() * 0.1F;
            float f5 = Mth.lengthSquared(f1, f2, f3);
            if (!(f5 <= 0.010000001F) && !(f5 >= 1.0F)) {
                Vector3f vector3f = new Vector3f(f1, f2, f3).normalize(100.0F);
                float f6 = (float)(randomsource.nextDouble() * (float) Math.PI * 2.0);
                Quaternionf quaternionf = new Quaternionf().rotateTo(new Vector3f(0.0F, 0.0F, -1.0F), vector3f).rotateZ(f6);
                bufferbuilder.addVertex(vector3f.add(new Vector3f(f4, -f4, 0.0F).rotate(quaternionf)));
                bufferbuilder.addVertex(vector3f.add(new Vector3f(f4, f4, 0.0F).rotate(quaternionf)));
                bufferbuilder.addVertex(vector3f.add(new Vector3f(-f4, f4, 0.0F).rotate(quaternionf)));
                bufferbuilder.addVertex(vector3f.add(new Vector3f(-f4, -f4, 0.0F).rotate(quaternionf)));
            }
        }

        return bufferbuilder.buildOrThrow();
    }

    public void drawSun(float partialTicks, PoseStack matrix, ClientLevel world){
        Tesselator tessellator = Tesselator.getInstance();

        BufferBuilder bufferbuilder = tessellator.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);

        float size = 30.0F;
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderTexture(0, SUN_TEXTURES);
        matrix.mulPose(Axis.YP.rotationDegrees(-90.0F));
        matrix.mulPose(Axis.XP.rotationDegrees(world.getTimeOfDay(partialTicks) * 360));
        Matrix4f matrix4f = matrix.last().pose();
        bufferbuilder.addVertex(matrix4f, (-size), 100.0F, (-size)).setUv(0.0F, 0.0F);
        bufferbuilder.addVertex(matrix4f, size, 100.0F, (-size)).setUv(1.0F, 0.0F);
        bufferbuilder.addVertex(matrix4f, size, 100.0F, size).setUv(1.0F, 1.F);
        bufferbuilder.addVertex(matrix4f, (-size), 100.0F, size).setUv(0.0F, 1.0F);
    }

    public void drawMoonPhases(float partialTicks, PoseStack matrix, ClientLevel world){
        Tesselator tessellator = Tesselator.getInstance();

        float size = 30.0F;
        VertexFormat.Mode drawMode = VertexFormat.Mode.QUADS;
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderTexture(0, MOON_PHASES_TEXTURES);
        matrix.mulPose(Axis.XP.rotationDegrees((world.getTimeOfDay(partialTicks) * 360) * 0.0015F));
        int k1 = world.getMoonPhase();
        int i2 = k1 % 4;
        int k2 = k1 / 4 % 2;
        float f22 = (float)(i2 + 0) / 4.0F;
        float f23 = (float)(k2 + 0) / 2.0F;
        float f24 = (float)(i2 + 1) / 4.0F;
        float f14 = (float)(k2 + 1) / 2.0F;
        Matrix4f matrix4f = matrix.last().pose();
        BufferBuilder bufferbuilder = tessellator.begin(drawMode, DefaultVertexFormat.POSITION_TEX);
        bufferbuilder.addVertex(matrix4f, (-size), -100.0F, size).setUv(f24, f14);
        bufferbuilder.addVertex(matrix4f, size, -100.0F, size).setUv(f22, f14);
        bufferbuilder.addVertex(matrix4f, size, -100.0F, (-size)).setUv(f22, f23);
        bufferbuilder.addVertex(matrix4f, (-size), -100.0F, (-size)).setUv(f24, f23);
    }

    @Override
    public float getCloudHeight() {
        return 450.0f;
    }

    @Override
    public @NotNull Vec3 getBrightnessDependentFogColor(Vec3 p_108908_, float p_108909_) {
        return p_108908_.multiply(p_108909_ * 0.94F + 0.06F, p_108909_ * 0.94F + 0.06F, p_108909_ * 0.91F + 0.09F);
    }

    @Override
    public boolean isFoggyAt(int p_108905_, int p_108906_) {
        return false;
    }
}
