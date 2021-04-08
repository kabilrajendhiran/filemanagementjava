package com.company.demo;

import java.util.ArrayList;
import java.util.HashMap;

public class Directory {
    private String name;
    private HashMap<String, Boolean> permissions;
    private HashMap<String,File> files;
    private HashMap<String,Directory> directories;
    private boolean hidden;

    public Directory(String name) {
        this.name = name;
        this.files = new HashMap<>();
        this.directories = new HashMap<>();
        this.permissions =  new HashMap<>();
        this.hidden = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, Boolean> getPermissions() {
        return permissions;
    }

    public void setPermissions(HashMap<String, Boolean> permissions) {
        this.permissions = permissions;
    }

    public HashMap<String, File> getFiles() {
        return files;
    }

    public void setFiles(HashMap<String, File> files) {
        this.files = files;
    }

    public HashMap<String, Directory> getDirectories() {
        return directories;
    }

    public void setDirectories(HashMap<String, Directory> directories) {
        this.directories = directories;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
}
