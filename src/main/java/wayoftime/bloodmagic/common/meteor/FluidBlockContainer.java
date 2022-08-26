package wayoftime.bloodmagic.common.meteor;

import java.util.Random;

import com.google.gson.JsonObject;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import wayoftime.bloodmagic.util.Constants;

public class FluidBlockContainer extends RandomBlockContainer
{
	public final Fluid fluid;

	public FluidBlockContainer(Fluid fluid)
	{
		this.fluid = fluid;
	}

	@Override
	public Block getRandomBlock(Random rand, Level world)
	{
		BlockState state = fluid.defaultFluidState().createLegacyBlock();
		if (state == null)
		{
			return null;
		}

		return state.getBlock();
	}

	@Override
	public String getEntry()
	{
//		 jsonobject.addProperty("tag", this.tag.location().toString());
		ResourceLocation rl = fluid.getRegistryName();
		String entry = ";" + rl.toString();

		return entry;
	}

	@Override
	public JsonObject serialize(int weight)
	{
		JsonObject jsonObj = new JsonObject();
		jsonObj.addProperty(Constants.JSON.FLUID, fluid.getRegistryName().toString());
		jsonObj.addProperty(Constants.JSON.WEIGHT, weight);

		return jsonObj;
	}

	@Override
	public JsonObject serialize()
	{
		JsonObject jsonObj = new JsonObject();
		jsonObj.addProperty(Constants.JSON.FLUID, fluid.getRegistryName().toString());

		return jsonObj;
	}
}
