package com.laytonsmith.abstraction.bukkit.events;

import com.laytonsmith.abstraction.MCCommand;
import com.laytonsmith.abstraction.MCCommandSender;
import com.laytonsmith.abstraction.MCPlayer;
import com.laytonsmith.abstraction.bukkit.BukkitMCCommand;
import com.laytonsmith.abstraction.bukkit.entities.BukkitMCPlayer;
import com.laytonsmith.abstraction.events.MCCommandTabCompleteEvent;
import com.laytonsmith.abstraction.events.MCPluginIncomingMessageEvent;
import com.laytonsmith.abstraction.events.MCServerCommandEvent;
import com.laytonsmith.abstraction.events.MCServerPingEvent;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.event.server.ServerCommandEvent;
import org.bukkit.event.server.ServerListPingEvent;

import java.net.InetAddress;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 *
 *
 */
public class BukkitMiscEvents {
    public static class BukkitMCServerCommandEvent implements MCServerCommandEvent {
        ServerCommandEvent sce;
        MCCommandSender sender;

        public BukkitMCServerCommandEvent(ServerCommandEvent sce, MCCommandSender sender) {
            this.sce = sce;
            this.sender = sender;
        }

        @Override
        public Object _GetObject() {
            return sce;
        }

        @Override
        public String getCommand() {
            return sce.getCommand();
        }

        @Override
        public void setCommand(String command) {
            sce.setCommand(command);
        }

        @Override
        public MCCommandSender getCommandSender() {
            return sender;
        }
    }

    /*
     * Not an actual event, but making it one.
     */
    public static class BukkitMCPluginIncomingMessageEvent implements MCPluginIncomingMessageEvent {

        Player player;
        String channel;
        byte[] bytes;

        public BukkitMCPluginIncomingMessageEvent(Player player, String channel, byte[] bytes) {
            this.player = player;
            this.channel = channel;
            this.bytes = bytes;
        }


        @Override
        public String getChannel() {
            return channel;
        }

        @Override
        public byte[] getBytes() {
            return bytes;
        }

        @Override
        public MCPlayer getPlayer() {
            return new BukkitMCPlayer(player);
        }

        @Override
        public Object _GetObject() {
            return null;
        }
    }

    public static class BukkitMCServerPingEvent implements MCServerPingEvent {

        private final ServerListPingEvent slp;

        public BukkitMCServerPingEvent(ServerListPingEvent event) {
            slp = event;
        }

        @Override
        public Object _GetObject() {
            return slp;
        }

        @Override
        public InetAddress getAddress() {
            return slp.getAddress();
        }

        @Override
        public int getMaxPlayers() {
            return slp.getMaxPlayers();
        }

        @Override
        public String getMOTD() {
            return slp.getMotd();
        }

        @Override
        public int getNumPlayers() {
            return slp.getNumPlayers();
        }

        @Override
        public void setMaxPlayers(int max) {
            slp.setMaxPlayers(max);
        }

        @Override
        public void setMOTD(String motd) {
            slp.setMotd(motd);
        }

        @Override
        public Set<MCPlayer> getPlayers() {
            Set<MCPlayer> players = new HashSet<>();
            try {
                Iterator<Player> iterator = slp.iterator();
                while (iterator.hasNext()) {
                    players.add(new BukkitMCPlayer(iterator.next()));
                }
            } catch (UnsupportedOperationException ex) {
                // not implemented, ignore
            }
            return players;
        }

        @Override
        public void setPlayers(Collection<MCPlayer> players) {
            Set<Player> ps = new HashSet<>();
            for (MCPlayer player : players) {
                ps.add((Player) player.getHandle());
            }
            try {
                Iterator<Player> iterator = slp.iterator();
                while (iterator.hasNext()) {
                    if (!ps.contains(iterator.next())) {
                        iterator.remove();
                    }
                }
            } catch (UnsupportedOperationException ex) {
                // not implemented, ignore
            }
        }
    }

    public static class BukkitMCCommandTabCompleteEvent implements MCCommandTabCompleteEvent {

        List<String> comp;
        MCCommandSender sender;
        Command cmd;
        String alias;
        String[] args;

        public BukkitMCCommandTabCompleteEvent(MCCommandSender sender, Command cmd, String alias, String[] args) {
            this.comp = null;
            this.sender = sender;
            this.cmd = cmd;
            this.alias = alias;
            this.args = args;
        }

        @Override
        public Object _GetObject() {
            return comp;
        }

        @Override
        public MCCommandSender getCommandSender() {
            return sender;
        }

        @Override
        public MCCommand getCommand() {
            return new BukkitMCCommand(cmd);
        }

        @Override
        public String getAlias() {
            return alias;
        }

        @Override
        public String[] getArguments() {
            return args;
        }

        @Override
        public List<String> getCompletions() {
            return comp;
        }

        @Override
        public void setCompletions(List<String> completions) {
            this.comp = completions;
        }
    }
}
