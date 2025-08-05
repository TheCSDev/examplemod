package com.thecsdev.examplemod;

import com.thecsdev.examplemod.client.ExampleModClient;
import com.thecsdev.examplemod.server.ExampleModServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.Properties;

/**
 * The main {@link Class} representing this mod.
 * This is the main "common" entry-point executed by all sides
 * (client/server) and all loaders (fabric/neoforge).
 */
public class ExampleMod
{
	// ==================================================
	/**
	 * The value of this variable MUST accurately reflect the same
	 * value as 'mod.id' from 'gradle.properties'.
	 *
	 * FIXME - You MUST fill this value in!
	 */
	public static final String MOD_ID = "examplemod";
	// ==================================================
	/**
	 * The primary {@link Logger} instance used by this mod.
	 * Intended for this mod's internal/personal use only.
	 */
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	/**
	 * Holds the properties of this mod, inherited from 'gradle.properties'.
	 * Automatically loaded during the initialization phase.
	 */
	private static final Properties PROPERTIES = new Properties();
	// --------------------------------------------------
	/**
	 * THE ONE and ONLY instance of this object representing this mod.
	 * Automatically assigned post-initialization.
	 */
	private static ExampleMod INSTANCE;
	// --------------------------------------------------
	private final String modName;
	private final String modVersion;
	// ==================================================
	protected ExampleMod()
	{
		//since sealed classes and modules are incompatible with Minecraft modding
		//environments, we use runtime instanceof checks instead
		if(!(this instanceof  ExampleModClient) && !(this instanceof  ExampleModServer))
			throw new IllegalStateException("Unexpected subclass " + getClass());

		//there can only ever be ONE instance of this object
		else if(INSTANCE != null)
			throw new IllegalStateException("Mod already initialized - " + MOD_ID);
		INSTANCE = this; //keep track of the instance

		//log instance initialization
		LOGGER.info("Initializing '" + MOD_ID + "' as '" + getClass().getSimpleName() + "'.");

		//load the mod properties
		try {
			PROPERTIES.load(ExampleMod.class.getResourceAsStream("/" + MOD_ID + ".properties"));
		} catch(Exception e) {
			throw new RuntimeException("Failed to load '" + MOD_ID + ".properties'", e);
		}
		this.modName    = Objects.requireNonNull(PROPERTIES.getProperty("mod.name"));
		this.modVersion = Objects.requireNonNull(PROPERTIES.getProperty("mod.version"));

		//TODO - Place your mod's "common" initialization code below;
		//...
	}
	// ==================================================
	/**
	 * Returns the instance of this {@link ExampleMod}.
	 */
	public static final ExampleMod getInstance() { return INSTANCE; }
	// --------------------------------------------------
	/**
	 * Returns the name of this mod.
	 */
	public final String getModName() { return this.modName; }

	/**
	 * Returns the version of this mod, in {@link String} form.
	 */
	public final String getModVersion() { return this.modVersion; }
	// ==================================================
}
