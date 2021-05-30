package com.jarcopy.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Utility to copy files generated by build in libs to jboss server.
 * @author Vineesh.Chauhan
 *
 */
public class JarCopy {

	public static void main(String[] args) throws IOException {

		// Constants
		String buildPathWTK = "C:/dev/source/wtk/build/components/wtk_core/libs";
		String buildPathWFP = "C:/dev/source/wfp/build/components/wfp_core/libs";
		String [] sourcePath = {buildPathWTK,buildPathWFP};
		String tempPath = "C:/temp/Input";
		String tempBackUpPath = "C:/temp/BackUp";
		String [] bckPaths = {tempPath,tempBackUpPath};
		
		String serverPath = "C:/Kronos/jboss/wfc/deployments/wfc.ear/wfc.war/WEB-INF/lib";
		//Create Temp Folders
		for(String path : bckPaths){
			createTempDirectories(path);
		}
		// Clean up temp
		for(String path : bckPaths){
			File src = new File(path);
			for (File file : src.listFiles()) {
				file.delete();
			}
		}
		// Copy from WTK/WFP libs to C:/temp/BackUp
		for(String str : sourcePath)
			copyFiles(str,tempPath);
		//create jboss files backup at C:/temp/BackUp
		createBackUp(serverPath, tempBackUpPath);
		//copy from C:/temp/BackUp to C:/Kronos/jboss/wfc/deployments/wfc.ear/wfc.war/WEB-INF/lib
		copyToServer(tempPath,serverPath);
		System.out.println("Done");
	}

	private static void createTempDirectories(String path) throws IOException {
		File tempPathFile = new File(path);
		if(!tempPathFile.exists()){
			tempPathFile.mkdirs();
		}
	}

	private static void createBackUp(String serverPath, String tempBackUpPath) throws IOException {
		File sourceFile = new File(serverPath);
		for(String sourceFileName : sourceFile.list()){
			Path source = Paths.get(serverPath + "/" + sourceFileName);
			File desc = new File(tempBackUpPath + "/" + source.getFileName());
			if (!desc.exists()) {
				desc.createNewFile();
			}
			Files.copy(source, desc.toPath(), StandardCopyOption.REPLACE_EXISTING);
		}
	}

	private static void copyToServer(String tempPath, String serverPath) throws IOException {
		File sourceFile = new File(tempPath);
		for(String sourceFileName : sourceFile.list()){
			Path source = Paths.get(tempPath + "/" + sourceFileName);
			File desc = new File(serverPath + "/" + source.getFileName());
			Files.copy(source, desc.toPath(), StandardCopyOption.REPLACE_EXISTING);
		}
	}

	private static void copyFiles(String buildPathWTK, String tempPath) throws IOException {
		File buildPathSre = new File(buildPathWTK);
		for (String fileName : buildPathSre.list()) {
			if(fileName.startsWith("wtk-core") || fileName.startsWith("wfp-core")){
				continue;
			}
			// Source Path
			Path source = Paths.get(buildPathWTK + "/" + fileName);
			// Destination Path
			File desc = new File(tempPath + "/" + source.getFileName());
			if (!desc.exists()) {
				desc.createNewFile();
			}
			//Copy files
			Files.copy(source, desc.toPath(), StandardCopyOption.REPLACE_EXISTING);
			//Find first number 
			String[] s = fileName.split("\\d+");
			String fName = s[0];
			String f1Name = fName.substring(0, fName.length()-1).replace('-','_');
			desc.renameTo(new File(tempPath + "/" + f1Name+".jar"));
		}
		
	}

}