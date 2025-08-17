package com.thecsdev.examplemod.fabric;

import com.thecsdev.examplemod.fabric.client.ExampleModFabricClient;
import com.thecsdev.examplemod.fabric.server.ExampleModFabricServer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.api.ModInitializer;

public final class ExampleModFabric implements ModInitializer, ClientModInitializer, DedicatedServerModInitializer
{
	// ==================================================
	public final @Override void onInitializeClient() { new ExampleModFabricClient(); }
	public final @Override void onInitializeServer() { new ExampleModFabricServer(); }
	// --------------------------------------------------
	public final @Override void onInitialize()
	{
		//TODO - Place Fabric-only common initialization code here
	}
	// ==================================================
}
