package com.thecsdev.examplemod.neoforge;

import com.thecsdev.examplemod.ExampleMod;
import com.thecsdev.examplemod.neoforge.client.ExampleModNeoClient;
import com.thecsdev.examplemod.neoforge.server.ExampleModNeoServer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;

@Mod(ExampleMod.MOD_ID)
public final class ExampleModNeoForge
{
	// ==================================================
	public ExampleModNeoForge()
	{
		//create an instance of the mod's main class, depending on the dist
		switch(FMLEnvironment.dist)
		{
			case CLIENT           -> new ExampleModNeoClient();
			case DEDICATED_SERVER -> new ExampleModNeoServer();
		}
	}
	// ==================================================
}
