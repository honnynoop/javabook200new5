package kr.co.infopub.chapter.s150.swing;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

//use for application not for applet
public class ImageUtiil {
	
	public static final int WIDTH=71;
	public static final int HIGHT=96;
	public static final String imgUrl="kr/co/infopub/chapter/s150/images/";
	public static final String ext=".gif";
	
	public  static  JLabel getImgJLabel(String url){
		ClassLoader cldr = ImageUtiil.class.getClassLoader();
	    java.net.URL imageURL   = cldr.getResource(url);
	    ImageIcon image = new ImageIcon(imageURL);
		JLabel jLabel =new JLabel(image);
		return jLabel;
	}
	public static  Image getImage(String url){
		ClassLoader cldr = ImageUtiil.class.getClassLoader();
	    java.net.URL imageURL   = cldr.getResource(url);
	    Image image = new ImageIcon(imageURL).getImage();
		return image;
	}
	public static  ImageIcon getIcon(String url){
		ClassLoader cldr = ImageUtiil.class.getClassLoader();
	    java.net.URL imageURL   = cldr.getResource(url);
	    ImageIcon image = new ImageIcon(imageURL);
		return image;
	}
	public static Image fromImgBuffer(BufferedImage bufImg){
		return Toolkit.getDefaultToolkit()
		              .createImage(bufImg.getSource());
	}
	public static BufferedImage fromImage(
			Image img,int x0, int y0, int width, int height){
		BufferedImage copy=new BufferedImage(
				width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d=copy.createGraphics();
		g2d.drawImage(img,x0,y0,null);
		g2d.dispose();
		return copy;
	}
	public static BufferedImage fromImage(
			Image img, int width, int height){
		return fromImage(img,0,0,width,height);
	}//
	public static BufferedImage getSubBufferedImage(
		BufferedImage bufimg,int x0, int y0, int width, int height){
		BufferedImage subimage=
			             bufimg.getSubimage(x0, y0, width, height);
		return subimage;
	}//
	public static Image getSubImage(
		BufferedImage bufimg,int x0, int y0, int width, int height){
		BufferedImage subimage=bufimg.getSubimage(x0, y0, width, height);
		return fromImgBuffer(subimage);
	}//
	public static BufferedImage loadImage(String url) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(url));
		}
		catch (IOException e) {
			System.err.println(e);
		}
		return img;
	}

	public static Image getPhotoImage(String url,int x, int y, int moveX, int moveY){//0~3 0~3
		Image img=ImageUtiil.getImage(url);
		BufferedImage bufimg=ImageUtiil.fromImage(img, 0,0,400+moveX,400+moveY );
		BufferedImage subimg=ImageUtiil.getSubBufferedImage(bufimg, moveX+100*x,moveY+100*y, 100, 100);
		Image madeImg=ImageUtiil.fromImgBuffer(subimg);
		return madeImg;
	}

}
