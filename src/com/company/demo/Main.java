package com.company.demo;

import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Core core = new Core();
        boolean flag = true;

        Directory currentDirectory = core.createDirectory("zoho");
        String currentPath =currentDirectory.getName()+"/";
        Scanner scanner = new Scanner(System.in);

        while(flag)
        {
            String dirNames[] = currentPath.split("/");

            if(dirNames[dirNames.length-1].equals(currentDirectory.getName()))
            {
                System.out.println("$"+currentPath);
            }
            else {
                currentPath = currentPath+currentDirectory.getName()+"/";
                System.out.println("$"+currentPath);
            }


            String spaceSeperated[] = scanner.nextLine().split(" ");

            if(spaceSeperated[0].equals("add"))
            {
                if(spaceSeperated[1].equals("file"))
                {
                   if (!spaceSeperated[2].isEmpty())
                   {
                        File newFile = core.createFile(spaceSeperated[2]);
                        core.addFile(currentDirectory,newFile);
                   }
                }
                else if(spaceSeperated[1].equals("dir"))
                {
                    if (!spaceSeperated[2].isEmpty())
                    {
                        Directory newDirectory = core.createDirectory(spaceSeperated[2]);
                        core.addDirectory(currentDirectory,newDirectory);
                    }
                }
                else {
                    System.out.println("Please enter command dir|file");
                }
            }
            else if(spaceSeperated[0].equals("list"))
            {
                if(spaceSeperated[1].equals("dir"))
                {
                    core.listDirectories(currentDirectory);
                }
                else if(spaceSeperated[1].equals("file"))
                {
                    core.listFiles(currentDirectory);
                }
                else if(spaceSeperated[1].equals("all"))
                {
                    core.listAllDetails(currentDirectory);
                }
                else {
                    System.out.println("Please enter command dir|file|all");
                }

            }
            else if(spaceSeperated[0].equals("forcelist"))
            {
                if(spaceSeperated[1].equals("dir"))
                {
                    core.listAllDirectories(currentDirectory);
                }
                else if(spaceSeperated[1].equals("file"))
                {
                    core.listAllFiles(currentDirectory);
                }
                else if(spaceSeperated[1].equals("all"))
                {
                    core.listAllDirectories(currentDirectory);
                    core.listAllFiles(currentDirectory);
                }
                else {
                    System.out.println("Please enter command dir|file|all");
                }

            }
            else if(spaceSeperated[0].equals("cd"))
            {
                    if(!spaceSeperated[1].isEmpty())
                    {
                        String p[] = spaceSeperated[1].split("/");
                        for (int i = 0; i < p.length; i++) {
                            Directory traverseDirectory =  core.traverseDirectory(currentDirectory,p[i]);
                            if(!Objects.isNull(traverseDirectory)){
                                currentDirectory = traverseDirectory;
                            }else {
                                System.out.println("No such directory exists or hidden");
                            }
                        }
                    }
                    else
                    {
                        System.out.println("Please enter dir name");
                    }
            }
            else if(spaceSeperated[0].equals("rm"))
            {
                if(spaceSeperated[1].equals("file"))
                {
                    if(!spaceSeperated[2].isEmpty())
                    {
                        core.removeFile(currentDirectory, spaceSeperated[2]);
                    }
                    else {
                        System.out.println("Please enter file name");
                    }
                }
                else if(spaceSeperated[1].equals("dir"))
                {
                    if(!spaceSeperated[2].isEmpty())
                    {
                        core.removeDirectory(currentDirectory, spaceSeperated[2]);
                    }
                    else {
                        System.out.println("Please enter dir name");
                    }
                }
            }

            else if(spaceSeperated[0].equals("read"))
            {
                if(!spaceSeperated[1].isEmpty())
                {
                    File f = currentDirectory.getFiles().get(spaceSeperated[1]);
                    if(!Objects.isNull(f))
                    {
                        core.readFile(f);
                    }
                    else
                    {
                        System.out.println("No such file exists");
                    }

                }
            }
            else if(spaceSeperated[0].equals("write"))
            {
                if(!spaceSeperated[1].isEmpty())
                {
                    File f = currentDirectory.getFiles().get(spaceSeperated[1]);

                    if(!Objects.isNull(f))
                    {
                        if (!spaceSeperated[2].isEmpty())
                        {
                            core.writeFile(f,spaceSeperated[2]);
                        }
                    }
                    else
                    {
                        System.out.println("No such file exists");
                    }

                }
            }
            else if(spaceSeperated[0].equals("hide"))
            {
                if(spaceSeperated[1].equals("file"))
                {
                    if(!spaceSeperated[2].isEmpty())
                    {
                        core.setFileHidden(currentDirectory,spaceSeperated[2]);
                    }
                }
                else if(spaceSeperated[1].equals("dir"))
                {
                    if(!spaceSeperated[2].isEmpty())
                    {
                        core.setDirHidden(currentDirectory,spaceSeperated[2]);
                    }
                }

            }

            else if(spaceSeperated[0].equals("unhide"))
            {
                if(spaceSeperated[1].equals("file"))
                {
                    if(!spaceSeperated[2].isEmpty())
                    {
                        core.unHideFile(currentDirectory,spaceSeperated[2]);
                    }
                }
                else if(spaceSeperated[1].equals("dir"))
                {
                    if(!spaceSeperated[2].isEmpty())
                    {
                        core.unHideDir(currentDirectory,spaceSeperated[2]);
                    }
                }

            }

            else if(spaceSeperated[0].equals("chmod"))
            {
                if(spaceSeperated[1].equals("file"))
                {
                    if(!spaceSeperated[2].isEmpty())
                    {
                        String fileName = spaceSeperated[2];
                        if(!spaceSeperated[3].isEmpty())
                        {
                            String p = spaceSeperated[3];
                            if(!spaceSeperated[4].isEmpty())
                            {
                                String s = spaceSeperated[4];
                                if(s.equals("true"))
                                {
                                    core.setPermissionFile(currentDirectory,fileName,p,true);
                                }
                                else if(s.equals("false"))
                                {
                                    core.setPermissionFile(currentDirectory,fileName,p,false);
                                }
                            }
                        }
                    }
                }
                else if(spaceSeperated[1].equals("dir"))
                {
                    if(!spaceSeperated[2].isEmpty())
                    {
                        String dirName = spaceSeperated[2];
                        if(!spaceSeperated[3].isEmpty())
                        {
                            String p = spaceSeperated[3];
                            if(!spaceSeperated[4].isEmpty())
                            {
                                String s = spaceSeperated[4];
                                if(s.equals("true"))
                                {
                                    core.setPermissionFile(currentDirectory,dirName,p,true);
                                }
                                else if(s.equals("false"))
                                {
                                    core.setPermissionFile(currentDirectory,dirName,p,false);
                                }
                            }
                        }
                    }
                }

            }

            else if(spaceSeperated[0].equals("exit"))
            {
                flag = false;
            }

            else {
                System.out.println("Please enter valid command");
            }

        }
    }
}
