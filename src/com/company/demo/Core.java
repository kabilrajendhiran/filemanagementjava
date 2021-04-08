package com.company.demo;

import java.util.HashMap;
import java.util.Objects;

public class Core {

    public Directory createDirectory(String name)
    {
        return new Directory(name);
    }

    public void addDirectory(Directory currentDirectory , Directory newDirectory)
    {
        newDirectory.getPermissions().put("read", true);
        newDirectory.getPermissions().put("write", true);
        currentDirectory.getDirectories().put(newDirectory.getName(), newDirectory);
    }

    public Directory traverseDirectory(Directory currentDirectory ,String name)
    {
            HashMap<String,Directory> directories = currentDirectory.getDirectories();
            if (directories.containsKey(name))
            {
                if(!directories.get(name).isHidden())
                {
                    return directories.get(name);
                }
            }
            return null;
    }

    public void listDirectories(Directory currentDirectory)
    {
        HashMap<String, Directory> directoryHashMap = currentDirectory.getDirectories();

        for (String key: directoryHashMap.keySet() ) {
            Directory directory = directoryHashMap.get(key);
            if(!directory.isHidden())
            {
                System.out.println(directory.getName());
            }
        }

    }

    public void listAllDirectories(Directory currentDirectory)
    {
        HashMap<String, Directory> directoryHashMap = currentDirectory.getDirectories();

        for (String key: directoryHashMap.keySet() ) {
            Directory directory = directoryHashMap.get(key);
            System.out.println(directory.getName());
        }

    }

    public File createFile(String name)
    {
        return new File(name);
    }

    public void addFile(Directory directory,File file)
    {
        file.getFilePermissions().put("read", true);
        file.getFilePermissions().put("write", true);
        directory.getFiles().put(file.getName(),file);
    }

    public void listFiles(Directory currentDirectory)
    {
        HashMap<String, File> fileHashMap = currentDirectory.getFiles();
        for (String key : fileHashMap.keySet())
        {
            File file = fileHashMap.get(key);
            if(!file.isHidden())
            {
                System.out.println("File name : "+file.getName());
            }
        }
    }

    public void listAllDetails(Directory currentDirectory)
    {
        String name = currentDirectory.getName();
        System.out.println("Current Directory : " +name);
        listDirectories(currentDirectory);
        listFiles(currentDirectory);

        HashMap<String,Boolean> permissions = currentDirectory.getPermissions();

        for (String key: permissions.keySet())
        {
            System.out.println(key+" : "+permissions.get(key));
        }

    }

    public void listAllFiles(Directory currentDirectory)
    {
        HashMap<String, File> fileHashMap = currentDirectory.getFiles();
        for (String key : fileHashMap.keySet())
        {
            File file = fileHashMap.get(key);
            System.out.println("File name : "+file.getName());
        }
    }


    public void readFile(File file)
    {
        System.out.println("File Content");
        if(file.getFilePermissions().get("read"))
        {
            System.out.println(file.getFileContent());
        } else {
            System.out.println("No Permission to read this file");
        }
    }

    public void writeFile(File file, String content)
    {
        if (file.getFilePermissions().get("write"))
        {
            file.setFileContent(file.getFileContent() +" "+ content);
        } else {
            System.out.println("No Permission to write this file");
        }
    }

    public void removeDirectory(Directory currentDirectory, String name)
    {
        Directory d = currentDirectory.getDirectories().remove(name);
        if(!Objects.nonNull(d))
        {
            System.out.println(d.getName()+" is removed");
        }
        else {
            System.out.println("No such directory exists");
        }

    }

    public void removeFile(Directory currentDirectory, String name)
    {
       File f = currentDirectory.getFiles().remove(name);

        if(!Objects.nonNull(f))
        {
            System.out.println(f.getName()+" is removed");
        }
        else {
            System.out.println("No such file exists");
        }
    }

    public void setFileHidden(Directory currentDirectory, String name)
    {
        File f = currentDirectory.getFiles().get(name);
        if(!Objects.isNull(f))
        {
            f.setHidden(true);
        }
        else
        {
            System.out.println("No such file exists");
        }
    }

    public void unHideFile(Directory currentDirectory, String name)
    {
        File f = currentDirectory.getFiles().get(name);
        if(!Objects.isNull(f))
        {
            f.setHidden(false);
        }
        else
        {
            System.out.println("No such file exists");
        }
    }

    public void setDirHidden(Directory currentDirectory, String name)
    {
        Directory d = currentDirectory.getDirectories().get(name);
        if(!Objects.isNull(d))
        {
            d.setHidden(true);
        }
        else
        {
            System.out.println("No such dir exists");
        }
    }

    public void unHideDir(Directory currentDirectory, String name)
    {
        Directory d = currentDirectory.getDirectories().get(name);
        if(!Objects.isNull(d))
        {
            d.setHidden(false);
        }
        else
        {
            System.out.println("No such dir exists");
        }
    }

    public void setPermissionDir(Directory currentdirectory,String filename, String permission, boolean status)
    {
        currentdirectory.getDirectories().get(filename).getPermissions().put(permission,status);
    }

    public void setPermissionFile(Directory currentdirectory,String filename, String permission, boolean status)
    {
        currentdirectory.getFiles().get(filename).getFilePermissions().put(permission,status);
    }


}
