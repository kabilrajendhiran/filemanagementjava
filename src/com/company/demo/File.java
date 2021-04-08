package com.company.demo;

import java.util.HashMap;

public class File {
    private String name;
    private String fileContent;
    private HashMap<String, Boolean> filePermissions;
    private boolean hidden;


    public File(String name) {
        this.name = name;
        hidden = false;
        fileContent="";
        this.filePermissions = new HashMap<>();
        this.filePermissions.put("read", true);
        this.filePermissions.put("write", true);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFileContent() {
        return fileContent;
    }

    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }

    public HashMap<String, Boolean> getFilePermissions() {
        return filePermissions;
    }

    public void setFilePermissions(HashMap<String, Boolean> filePermissions) {
        this.filePermissions = filePermissions;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
}
