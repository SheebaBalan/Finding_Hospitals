package resources;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class TakeScreenshot {
	
public static void takeScreenshot(String fileName) throws Exception {
		
		//Robot class to take screenshot
		Robot robot=new Robot();
		//Get the screen size
		Dimension size=Toolkit.getDefaultToolkit().getScreenSize();
		//Defining the shape of the screen
		Rectangle screenSize=new Rectangle(size);
		//Take the screenshot
		BufferedImage source=robot.createScreenCapture(screenSize);
		//Create a new file
		File file=new File(fileName);
		//Get the location of the file
		String name=file.getAbsolutePath();
		//Create the destination file to copy the captured screenshot
		File destination=new File(name);
		//Copy the captured screenshot to the destination file
		ImageIO.write(source, "png", destination);
	}

}
