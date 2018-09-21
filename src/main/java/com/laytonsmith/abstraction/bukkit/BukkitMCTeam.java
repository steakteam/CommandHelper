package com.laytonsmith.abstraction.bukkit;

import com.github.teamsteak.commandhelper.MockOfflinePlayer;
import com.laytonsmith.PureUtilities.Common.ReflectionUtils;
import com.laytonsmith.abstraction.MCScoreboard;
import com.laytonsmith.abstraction.MCTeam;
import net.minecraft.server.v1_5_R3.ScoreboardTeam;
import org.bukkit.scoreboard.Team;

import java.util.HashSet;
import java.util.Set;

public class BukkitMCTeam implements MCTeam {

    private final Team t;
    private final ScoreboardTeam nmsTeam;

    public BukkitMCTeam(Team team) {
        t = team;
        nmsTeam = (ScoreboardTeam) ReflectionUtils.get(t.getClass(), t, "team");
    }

    @Override
    public void addEntry(String entry) {
        t.addPlayer(new MockOfflinePlayer(entry));
    }

    @Override
    public boolean allowFriendlyFire() {
        return t.allowFriendlyFire();
    }

    @Override
    public boolean canSeeFriendlyInvisibles() {
        return t.canSeeFriendlyInvisibles();
    }

    @Override
    public String getDisplayName() {
        return t.getDisplayName();
    }

    @Override
    public String getName() {
        return t.getName();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Set<String> getEntries() {
        return new HashSet<String>(nmsTeam.getPlayerNameSet());
    }

    @Override
    public String getPrefix() {
        return t.getPrefix();
    }

    @Override
    public MCScoreboard getScoreboard() {
        return new BukkitMCScoreboard(t.getScoreboard());
    }

    @Override
    public int getSize() {
        return t.getSize();
    }

    @Override
    public String getSuffix() {
        return t.getSuffix();
    }

    @Override
    public boolean hasEntry(String entry) {
        return t.hasPlayer(new MockOfflinePlayer(entry));
    }

    @Override
    public boolean removeEntry(String entry) {
        return t.removePlayer(new MockOfflinePlayer(entry));
    }

    @Override
    public void setAllowFriendlyFire(boolean enabled) {
        t.setAllowFriendlyFire(enabled);
    }

    @Override
    public void setCanSeeFriendlyInvisibles(boolean enabled) {
        t.setCanSeeFriendlyInvisibles(enabled);
    }

    @Override
    public void setDisplayName(String displayName) {
        t.setDisplayName(displayName);
    }

    @Override
    public void setPrefix(String prefix) {
        t.setPrefix(prefix);
    }

    @Override
    public void setSuffix(String suffix) {
        t.setSuffix(suffix);
    }

    @Override
    public void unregister() {
        t.unregister();
    }
}
