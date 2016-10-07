package com.example;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

import javax.imageio.ImageIO;

public class FileReading {
	public static void main(String args[])throws IOException{
	    int width = 963;    //width of the image
	    int height = 640;   //height of the image
	    BufferedImage image = null;
	    File f = null;

	    //read image
	    try{
	    	System.out.println(System.getProperty("user.dir"));
	      f = new File("C:\\Users\\Achyuet\\workspace2\\Image\\src\\main\\java\\com\\example\\Taj.jpg"); //image file path
	      image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	      System.out.println(f.exists());
	      image = ImageIO.read(f);
	      ByteArrayOutputStream baos = new ByteArrayOutputStream();
	      ImageIO.write( image, "jpg", baos );
	      baos.flush();
	      
	      byte[] imageInByte = baos.toByteArray();
	      String encoded = Base64.getEncoder().encodeToString(imageInByte);
	      baos.close();
	      System.out.println("Reading complete."+encoded);
	      byte[] imageOutByte = Base64.getDecoder().decode(encoded);
	      ByteArrayInputStream bais = new ByteArrayInputStream(imageOutByte);
	      image = ImageIO.read(bais);
	      bais.reset();
	      ImageIO.write(image, "jpg",new File("E:\\out.jpg"));

	      
	      
	    }catch(IOException e){
	      System.out.println("Error: "+e);
	    }
	  }
	

}
