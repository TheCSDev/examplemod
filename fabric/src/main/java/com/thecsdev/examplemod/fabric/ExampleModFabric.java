package com.thecsdev.examplemod.fabric;

import com.thecsdev.examplemod.fabric.client.ExampleModFabricClient;
import com.thecsdev.examplemod.fabric.server.ExampleModFabricServer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.DedicatedServerModInitializer;

public final class ExampleModFabric implements ClientModInitializer, DedicatedServerModInitializer
{
	// ==================================================
	public @Override void onInitializeClient() { new ExampleModFabricClient(); }
	public @Override void onInitializeServer() { new ExampleModFabricServer(); }
	// ==================================================
}
