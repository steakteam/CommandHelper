package com.laytonsmith.abstraction;

import com.laytonsmith.abstraction.enums.MCInventoryType;
import com.laytonsmith.abstraction.enums.MCVersion;
import com.laytonsmith.abstraction.pluginmessages.MCMessenger;

import java.util.Collection;
import java.util.List;
import java.util.Set;


/**
 *
 *
 */
public interface MCServer extends AbstractionObject {
    public String getName();

    public Collection<MCPlayer> getOnlinePlayers();

    public boolean dispatchCommand(MCCommandSender cs, String string) throws MCCommandException;

    public MCPluginManager getPluginManager();

    public MCPlayer getPlayer(String name);

    public MCWorld getWorld(String name);

    public List<MCWorld> getWorlds();

    public void broadcastMessage(String message);

    public void broadcastMessage(String message, String permission);

    public MCConsoleCommandSender getConsole();

    public MCItemFactory getItemFactory();

    public MCCommandMap getCommandMap();

    public MCInventory createInventory(MCInventoryHolder owner, MCInventoryType type);

    public MCInventory createInventory(MCInventoryHolder owner, int size, String title);

    public MCInventory createInventory(MCInventoryHolder owner, int size);

    /**
     * Provides access to local user data associated with a name.
     * Depending on the implementation, a web lookup with the official API may or may not be performed.
     *
     * @param player The name to lookup
     * @return An object containing any info that can be accessed regardless of a connected player.
     */
    public MCOfflinePlayer getOfflinePlayer(String player);

    public MCOfflinePlayer[] getOfflinePlayers();

    /* Boring information get methods -.- */
    public String getServerName();

    public String getMotd();

    public String getAPIVersion();

    public String getServerVersion();

    public MCVersion getMinecraftVersion();

    public int getPort();

    public String getIp();

    boolean getAllowEnd();

    boolean getAllowFlight();

    boolean getAllowNether();

    boolean getOnlineMode();

    public int getViewDistance();

    public String getWorldContainer();

    public int getMaxPlayers();

    public List<MCOfflinePlayer> getBannedPlayers();

    public List<MCOfflinePlayer> getWhitelistedPlayers();

    public List<MCOfflinePlayer> getOperators();

    public void banName(String name);

    public void unbanName(String name);

    public void banIP(String address);

    public Set<String> getIPBans();

    public void unbanIP(String address);

    public MCScoreboard getMainScoreboard();

    public MCScoreboard getNewScoreboard();

    public void runasConsole(String cmd);

    public MCMessenger getMessenger();

    public boolean unloadWorld(MCWorld world, boolean save);

    public boolean addRecipe(MCRecipe recipe);

    public List<MCRecipe> getRecipesFor(MCItemStack result);

    public List<MCRecipe> allRecipes();

    public void clearRecipes();

    public void resetRecipes();

    public void savePlayers();

    public void shutdown();

    /**
     * Dispatches a command like {@link #dispatchCommand(com.laytonsmith.abstraction.MCCommandSender, java.lang.String) }, but
     * attempts to capture the output of the command, and returns that.
     *
     * @param commandSender The command sender
     * @param cmd           The command
     * @return The command's captured output, if possible, otherwise an empty string, never null.
     */
    public String dispatchAndCaptureCommand(MCCommandSender commandSender, String cmd);
}
