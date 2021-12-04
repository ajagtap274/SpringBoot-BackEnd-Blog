package com.example.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class imageHelper {

	public final String UPLOAD_DIR="D:\\blog\\src\\assets\\images";
	
	public boolean uploadFile(MultipartFile multifile)
	{
		boolean b=false;
		try {
			InputStream is= multifile.getInputStream();
			byte data[]=new byte[is.available()];
			is.read(data);
			FileOutputStream fos=new FileOutputStream(UPLOAD_DIR+File.separator+multifile.getOriginalFilename());
			fos.write(data);
			fos.flush();
			fos.close();
			b=true;
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		return b;
	}
	
}
