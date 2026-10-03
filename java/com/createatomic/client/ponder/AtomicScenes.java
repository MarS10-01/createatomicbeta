package com.createatomic.client.ponder;

import com.createatomic.registry.ModItems;
import com.simibubi.create.AllItems;

import net.createmod.catnip.math.Pointing;
import net.createmod.ponder.api.PonderPalette;
import net.createmod.ponder.api.scene.SceneBuilder;
import net.createmod.ponder.api.scene.SceneBuildingUtil;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

/** Clear, compact Create Ponder scenes for the reactor. */
public class AtomicScenes {

    public static void structure(SceneBuilder scene, SceneBuildingUtil util) {
        scene.title("reactor_structure", "Building the Compact Reactor");
        scene.scaleSceneView(0.68f);
        scene.showBasePlate();
        scene.idle(8);

        // 1. Base and walls: show the real compact 9x9x9 footprint first.
        scene.world().showSection(util.select().fromTo(1, 1, 1, 9, 1, 9), Direction.DOWN);
        scene.idle(12);
        scene.overlay().showText(85).text("createatomic.ponder.reactor_structure.text_1")
                .attachKeyFrame().placeNearTarget().pointAt(util.vector().topOf(5, 1, 5));
        scene.idle(95);

        scene.world().showSection(util.select().fromTo(1, 2, 1, 1, 8, 9), Direction.EAST);
        scene.world().showSection(util.select().fromTo(9, 2, 1, 9, 8, 9), Direction.WEST);
        scene.world().showSection(util.select().fromTo(2, 2, 1, 8, 8, 1), Direction.SOUTH);
        scene.world().showSection(util.select().fromTo(2, 2, 9, 8, 8, 9), Direction.NORTH);
        scene.idle(18);

        // 2. Show the compact active zone without any water blocks.
        scene.world().showSection(util.select().fromTo(2, 2, 2, 8, 4, 8), Direction.DOWN);
        scene.idle(12);
        scene.overlay().showText(95).text("createatomic.ponder.reactor_structure.text_2")
                .attachKeyFrame().placeNearTarget().pointAt(util.vector().centerOf(5, 3, 5));
        scene.idle(105);

        scene.world().showSection(util.select().fromTo(2, 5, 2, 8, 8, 8), Direction.DOWN);
        scene.idle(15);
        scene.overlay().showText(95).text("createatomic.ponder.reactor_structure.text_3")
                .colored(PonderPalette.BLUE).placeNearTarget().pointAt(util.vector().centerOf(5, 6, 5));
        scene.idle(105);

        // 3. Roof and service hatch.
        scene.world().showSection(util.select().fromTo(1, 9, 1, 9, 9, 9), Direction.DOWN);
        scene.idle(15);
        scene.overlay().showText(95).text("createatomic.ponder.reactor_structure.text_4")
                .attachKeyFrame().placeNearTarget().pointAt(util.vector().topOf(5, 9, 5));
        scene.idle(100);

        scene.world().hideSection(util.select().position(5, 9, 5), Direction.UP);
        scene.idle(8);
        scene.overlay().showText(80).text("createatomic.ponder.reactor_structure.text_5")
                .placeNearTarget().pointAt(util.vector().topOf(5, 9, 5));
        scene.idle(90);

        // 4. Cutaway: only the two front service panels are hidden, never the whole machine.
        scene.world().hideSection(util.select().fromTo(1, 2, 1, 1, 8, 9), Direction.WEST);
        scene.world().hideSection(util.select().fromTo(2, 2, 1, 8, 8, 1), Direction.NORTH);
        scene.world().showSection(util.select().position(1, 5, 5), Direction.WEST);
        scene.world().showSection(util.select().position(0, 5, 5), Direction.WEST);
        scene.idle(12);
        scene.overlay().showText(100).text("createatomic.ponder.reactor_structure.text_6")
                .colored(PonderPalette.BLUE).placeNearTarget().pointAt(util.vector().centerOf(5, 5, 5));
        scene.idle(110);

        scene.world().showSection(util.select().position(5, 9, 5), Direction.DOWN);
        scene.idle(8);
        scene.overlay().showText(100).text("createatomic.ponder.reactor_structure.text_7")
                .attachKeyFrame().placeNearTarget().pointAt(util.vector().topOf(5, 9, 5));
        scene.idle(105);
        scene.markAsFinished();
    }

    public static void operation(SceneBuilder scene, SceneBuildingUtil util) {
        scene.title("reactor_operation", "Loading and Operating the Reactor");
        scene.scaleSceneView(0.72f);
        scene.showBasePlate();
        scene.idle(8);

        // Operation now has its own matching NBT, so W on the fuel rod never opens an empty scene.
        scene.world().showSection(util.select().fromTo(1, 1, 1, 9, 9, 9), Direction.DOWN);
        scene.world().showSection(util.select().position(1, 5, 5), Direction.WEST);
        scene.world().showSection(util.select().position(0, 5, 5), Direction.WEST);
        scene.idle(15);

        // Maintenance cutaway: remove front/side panels and roof, then expose the real 7x7x7 contents.
        scene.world().hideSection(util.select().fromTo(1, 2, 1, 1, 8, 9), Direction.WEST);
        scene.world().hideSection(util.select().fromTo(2, 2, 1, 8, 8, 1), Direction.NORTH);
        scene.world().showSection(util.select().position(1, 5, 5), Direction.WEST);
        scene.world().showSection(util.select().position(0, 5, 5), Direction.WEST);
        scene.world().hideSection(util.select().fromTo(1, 9, 1, 9, 9, 9), Direction.UP);
        scene.world().showSection(util.select().fromTo(2, 2, 2, 8, 8, 8), Direction.DOWN);
        scene.idle(15);

        scene.overlay().showText(90).text("createatomic.ponder.reactor_operation.text_1")
                .attachKeyFrame().placeNearTarget().pointAt(util.vector().topOf(5, 8, 5));
        scene.idle(25);
        scene.overlay().showControls(util.vector().centerOf(5, 4, 5), Pointing.DOWN, 70)
                .rightClick().withItem(new ItemStack(ModItems.FUEL_ROD.get()));
        scene.idle(85);

        scene.overlay().showText(95).text("createatomic.ponder.reactor_operation.text_2")
                .colored(PonderPalette.GREEN).placeNearTarget().pointAt(util.vector().centerOf(5, 4, 5));
        scene.idle(105);

        scene.overlay().showText(95).text("createatomic.ponder.reactor_operation.text_3")
                .placeNearTarget().pointAt(util.vector().topOf(3, 9, 1));
        scene.idle(100);

        scene.overlay().showText(95).text("createatomic.ponder.reactor_operation.text_4")
                .placeNearTarget().pointAt(util.vector().centerOf(5, 6, 5));
        scene.idle(100);

        // Restore roof to explain normal closed operation and external coolant connection.
        scene.world().showSection(util.select().fromTo(1, 9, 1, 9, 9, 9), Direction.DOWN);
        scene.idle(12);
        scene.overlay().showText(95).text("createatomic.ponder.reactor_operation.text_5")
                .colored(PonderPalette.BLUE).placeNearTarget().pointAt(util.vector().topOf(3, 9, 1));
        scene.idle(100);

        scene.overlay().showControls(util.vector().topOf(5, 9, 5), Pointing.DOWN, 60)
                .withItem(AllItems.GOGGLES.asStack());
        scene.overlay().showText(95).text("createatomic.ponder.reactor_operation.text_6")
                .placeNearTarget().pointAt(util.vector().topOf(5, 9, 5));
        scene.idle(105);

        scene.overlay().showText(95).text("createatomic.ponder.reactor_operation.text_7")
                .attachKeyFrame().colored(PonderPalette.RED).placeNearTarget()
                .pointAt(util.vector().centerOf(5, 4, 5));
        scene.idle(105);
        scene.markAsFinished();
    }

    /** Focused lesson attached directly to the fresh fuel rod item. */
    public static void fuelRod(SceneBuilder scene, SceneBuildingUtil util) {
        scene.title("fuel_rod", "Loading a Fresh Fuel Rod");
        scene.scaleSceneView(0.76f);
        scene.showBasePlate();
        scene.idle(8);

        scene.world().showSection(util.select().fromTo(1, 1, 1, 9, 9, 9), Direction.DOWN);
        scene.world().hideSection(util.select().fromTo(1, 2, 1, 1, 8, 9), Direction.WEST);
        scene.world().hideSection(util.select().fromTo(2, 2, 1, 8, 8, 1), Direction.NORTH);
        scene.world().hideSection(util.select().fromTo(1, 9, 1, 9, 9, 9), Direction.UP);
        scene.world().showSection(util.select().fromTo(2, 2, 2, 8, 8, 8), Direction.DOWN);
        scene.world().showSection(util.select().position(1, 5, 5), Direction.WEST);
        scene.world().showSection(util.select().position(0, 5, 5), Direction.WEST);
        scene.idle(18);

        scene.overlay().showText(90).text("createatomic.ponder.reactor_operation.text_1")
                .attachKeyFrame().placeNearTarget().pointAt(util.vector().centerOf(5, 4, 5));
        scene.idle(30);
        scene.overlay().showControls(util.vector().centerOf(5, 4, 5), Pointing.DOWN, 75)
                .rightClick().withItem(new ItemStack(ModItems.FUEL_ROD.get()));
        scene.idle(85);

        scene.overlay().showText(100).text("createatomic.ponder.reactor_operation.text_2")
                .colored(PonderPalette.GREEN).placeNearTarget().pointAt(util.vector().centerOf(5, 4, 5));
        scene.idle(110);

        scene.world().showSection(util.select().fromTo(1, 9, 1, 9, 9, 9), Direction.DOWN);
        scene.idle(10);
        scene.overlay().showText(95).text("createatomic.ponder.reactor_operation.text_3")
                .placeNearTarget().pointAt(util.vector().topOf(3, 9, 1));
        scene.idle(100);
        scene.overlay().showText(95).text("createatomic.ponder.reactor_operation.text_6")
                .placeNearTarget().pointAt(util.vector().topOf(5, 9, 5));
        scene.idle(105);
        scene.markAsFinished();
    }

    public static void shielding(SceneBuilder scene, SceneBuildingUtil util) {
        scene.title("radiation_shielding", "Radiation and Shielding");
        scene.scaleSceneView(0.8f);
        scene.showBasePlate();
        scene.idle(10);

        scene.world().showSection(util.select().position(1, 1, 2), Direction.DOWN);
        scene.idle(10);
        scene.overlay().showText(90).text("createatomic.ponder.radiation_shielding.text_1");
        scene.idle(100);

        scene.world().showSection(util.select().fromTo(4, 1, 0, 4, 3, 4), Direction.DOWN);
        scene.idle(10);
        scene.overlay().showText(80).text("createatomic.ponder.radiation_shielding.text_2");
        scene.idle(90);

        scene.world().showSection(util.select().fromTo(5, 1, 0, 5, 3, 4), Direction.DOWN);
        scene.idle(10);
        scene.overlay().showText(80).text("createatomic.ponder.radiation_shielding.text_3");
        scene.idle(90);

        scene.overlay().showControls(util.vector().topOf(7, 0, 2), Pointing.DOWN, 70)
                .withItem(new ItemStack(ModItems.GEIGER_COUNTER.get()));
        scene.overlay().showText(90).text("createatomic.ponder.radiation_shielding.text_4");
        scene.idle(95);

        scene.overlay().showText(95).text("createatomic.ponder.radiation_shielding.text_5");
        scene.idle(105);
        scene.markAsFinished();
    }

    private AtomicScenes() {}
}
