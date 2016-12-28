//Copyright: TeamKrishna (www.teamkrishna.in)
//Author: Kaushik Mazumdar(literaldumb@gmail.com)

package org.godotengine.godot;

//imports
import android.app.Activity;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class GodotFileWriter extends Godot.SingletonBase {

	Activity m_pActivity;
	File file;
	FileOutputStream outputStream;
	FileInputStream inputStream;

    	static public Godot.SingletonBase initialize(Activity p_activity) {
        	return new GodotFileWriter(p_activity);
    	}

    	public GodotFileWriter(Activity p_activity) {
		m_pActivity = p_activity;

        	//register class name and functions to bind
        	registerClass("GodotFileWriter", new String[]{"publish","initFile","fetchContent"});
    	}

	public void initFile(String fileName)
	{
		try{
			
			File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
			path.mkdirs();
			String dirPath = path.getAbsolutePath() ;
			dirPath += "/MyAppData" ;
			//Log.i("Godot",dirPath);
			File tmp = new File(dirPath);
			tmp.mkdirs();
			file = new File(tmp,fileName);
			outputStream = new FileOutputStream(file);
		}catch(IOException e) {
			e.printStackTrace();
		}	
	}

	public void publish(String content)
	{
		try {
			outputStream.write(content.getBytes());
			outputStream.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public String fetchContent()
	{
		String content="";
		try {
			inputStream = new FileInputStream(file);
			int fileLength = (int)file.length();
			byte[] buffer = new byte[fileLength];
			inputStream.read(buffer,0,fileLength);
			inputStream.close();

			content = new String(buffer);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return content ;
	}
}
