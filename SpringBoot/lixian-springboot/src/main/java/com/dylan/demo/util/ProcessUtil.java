package com.dylan.demo.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcessUtil {

	private Process process;
	private static Runtime runtime = Runtime.getRuntime();

	public String runCmd(String cmd) {
		StringBuffer result = new StringBuffer();
		try {
			process = runtime.exec(cmd);
			InputStream is = process.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			
			String line = "";
			while((line = reader.readLine())!= null){
				result.append(line);
			}
			process.waitFor();
			is.close();
			reader.close();
			process.destroy();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result.toString();
	}
	
}
