package com.laytonsmith.core.compiler;

import com.laytonsmith.core.constructs.Token;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 *
 */
public class TokenStream extends ArrayList<Token> {
    FileOptions fileOptions;

    TokenStream(List<Token> list, FileOptions options) {
        super(list);
        this.fileOptions = options;
    }

    TokenStream(List<Token> list, String fileOptions) {
        super(list);
        this.fileOptions = parseFileOptions(fileOptions);
    }

    public FileOptions getFileOptions() {
        return fileOptions;
    }

    private static FileOptions parseFileOptions(String options) {
        //Only ; needs escaping. Everything else is just trimmed, and added to the map.
        Map<String, String> map = new HashMap<String, String>();
        boolean inKey = true;
        StringBuilder buffer = new StringBuilder();
        String keyName = "";
        for (int i = 0; i < options.length(); i++) {
            Character c = options.charAt(i);
            Character c2 = null;
            if (i < options.length() - 1) {
                c2 = options.charAt(i + 1);
            }
            if (inKey) {
                if (c == ':') {
                    keyName = buffer.toString();
                    buffer = new StringBuilder();
                    inKey = false;
                } else if (c == ';') {
                    //Self closed
                    map.put(buffer.toString().trim().toLowerCase(), "true");
                    buffer = new StringBuilder();
                    keyName = "";
                    //We don't reset the inKey parameter
                } else {
                    buffer.append(c);
                }
            } else {
                if (c == '\\' && c2 == ';') {
                    buffer.append(';');
                    i++;
                } else if (c == ';') {
                    //We're done
                    inKey = true;
                    map.put(keyName.trim().toLowerCase(), buffer.toString());
                    buffer = new StringBuilder();
                } else {
                    buffer.append(c);
                }
            }
        }
        if (buffer.length() > 0) {
            if (!inKey) {
                map.put(keyName.trim().toLowerCase(), buffer.toString());
            } else {
                if (!buffer.toString().trim().isEmpty()) {
                    map.put(buffer.toString().trim().toLowerCase(), "true");
                }
            }
        }
        FileOptions fo = new FileOptions(map);
        return fo;
    }

}
