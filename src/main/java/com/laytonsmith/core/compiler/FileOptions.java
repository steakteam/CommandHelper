package com.laytonsmith.core.compiler;

import com.laytonsmith.PureUtilities.ClassLoading.ClassDiscovery;
import com.laytonsmith.PureUtilities.Version;
import com.laytonsmith.core.MSVersion;
import com.laytonsmith.core.Documentation;
import com.laytonsmith.core.Prefs;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 *
 */
public class FileOptions {

	/*
	 * These value names are used in the syntax highlighter, and should remain the name they are in code.
	 */
	private final Boolean strict;
	private final Set<SuppressWarnings> suppressWarnings;
	private final String name;
	private final String author;
	private final String created;
	private final String description;
	private final Set<String> requiredExtensions;
	//TODO: Make this non-public once this is all finished.

	public FileOptions(Map<String, String> parsedOptions) {
		strict = parseBoolean(getDefault(parsedOptions, "strict", null));
		suppressWarnings = parseEnumSet(getDefault(parsedOptions, "suppresswarnings", ""), SuppressWarnings.class);
		name = getDefault(parsedOptions, "name", "").trim();
		author = getDefault(parsedOptions, "author", "").trim();
		created = getDefault(parsedOptions, "created", "").trim();
		description = getDefault(parsedOptions, "description", "").trim();
		requiredExtensions = Collections.unmodifiableSet(parseSet(getDefault(parsedOptions, "requiredextensions", "")));
	}

	private String getDefault(Map<String, String> map, String key, String defaultIfNone) {
		if(map.containsKey(key)) {
			return map.get(key);
		} else {
			return defaultIfNone;
		}
	}

	private Boolean parseBoolean(String bool) {
		if(bool == null) {
			return null;
		}
		return !(bool.equalsIgnoreCase("false") || bool.equalsIgnoreCase("off"));
	}

	private List<String> parseList(String list) {
		List<String> l = new ArrayList<>();
		for(String part : list.split(",")) {
			if(!part.trim().isEmpty()) {
				l.add(part.trim().toLowerCase());
			}
		}
		return l;
	}

	private Set<String> parseSet(String list) {
		return new HashSet<>(parseList(list));
	}

	private <T extends Enum<T>> Set<T> parseEnumSet(String list, Class<T> type) {
		EnumSet<T> set = EnumSet.noneOf(type);
		List<String> sList = parseList(list);
		for(String s : sList) {
			for(T e : type.getEnumConstants()) {
				if(e.name().equals(s)) {
					set.add(e);
					break;
				}
			}
		}
		return set;
	}

	/**
	 * Returns whether or not this file is in strict mode. Unlike most options, this one depends on both the file
	 * options and the config value. In the config, if strict mode is turned on or off, this value only serves as the
	 * default. File options will override the global setting.
	 *
	 * @return
	 */
	public boolean isStrict() {
		if(strict != null) {
			return strict;
		} else {
			return Prefs.StrictMode();
		}
	}

	/**
	 * Returns true if the specified warning has been suppressed.
	 * @param warning
	 * @return
	 */
	public boolean isWarningSuppressed(SuppressWarnings warning) {
		return suppressWarnings.contains(warning);
	}

	/**
	 * Gets the file name. If the actual file name and this value do not match, this is a compiler warning. The default
	 * is an empty string, which should suppress the warning.
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the file author(s). This is not used programmatically, and is only for reference.
	 * @return
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Gets the file creation date. This is not used programmatically, and is only for reference.
	 * @return
	 */
	public String getCreated() {
		return created;
	}

	/**
	 * Gets the file description. This is not used programmatically, and is only for reference.
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Returns whether or not this file has required extensions.
	 * @return
	 */
	public boolean requiresExtensions() {
		return !requiredExtensions.isEmpty();
	}

	/**
	 * Returns the list of required extensions for this file. It should be a compile error if the file requires an
	 * extension, but the extension is not present.
	 * @return
	 */
	public Set<String> getRequiredExtensions() {
		return requiredExtensions;
	}

	@Override
	public String toString() {
		return (strict ? "Strict Mode on" : "") + "\n"
				+ (suppressWarnings.isEmpty() ? "" : "Suppressed Warnings: " + suppressWarnings.toString() + "\n")
				+ (name.isEmpty() ? "" : "File name: " + name + "\n")
				+ (author.isEmpty() ? "" : "Author: " + author + "\n")
				+ (created.isEmpty() ? "" : "Creation Date: " + created + "\n")
				+ (description == null ? "" : "File description: " + description + "\n");

	}

	public static enum SuppressWarnings implements Documentation {
		// In the future, when some are added, this can be removed, and the rest of the system will work
		// quite nicely. Perhaps a good first candidate would be to allow string "false" coerced to boolean warning
		// to be suppressed on a per file basis?
		Note("There are currently no warning suppressions defined, but some will be added in the future",
			MSVersion.V0_0_0);

		private SuppressWarnings(String docs, Version version) {
			this.docs = docs;
			this.version = version;
		}

		private final String docs;
		private final Version version;
		@Override
		public URL getSourceJar() {
			return ClassDiscovery.GetClassContainer(this.getClass());
		}

		@Override
		public Class<? extends Documentation>[] seeAlso() {
			return new Class[]{};
		}

		@Override
		public String getName() {
			return this.name();
		}

		@Override
		public String docs() {
			return docs;
		}

		@Override
		public Version since() {
			return version;
		}
	}

}
