package aula7.e2;

import java.nio.*;

public class BitmapInfoHeader
{
	private static final int size = 40; 	// the size of this header (40 bytes)
	private int width; 						// the bitmap width in pixels
	private int height; 					// the bitmap height in pixels
	private static final short planes = 1; 	// the number of color planes being used. Must be set to 1 
	private short bitCount;  				// the number of bits per pixel (color depth) - 1, 4, 8, 16, 24, 32 
	private int compression; 				// the compression method being used
	private int sizeImage; 	   				// the image size. This is the size of the raw bitmap data 
	private int xPelsPerMeter; 				// the horizontal resolution of the image (pixel per meter) 
	private int yPelsPerMeter; 				// the vertical resolution of the image (pixel per meter)
	private int clrUsed; 					// the number of colors in the color palette,
	private int clrImportant; 				// the number of important colors used,
	
	public BitmapInfoHeader(int width, int height, short bitCount,int compression, int sizeImage, 
			int xPelsPerMeter, int yPelsPerMeter, int clrUsed, int clrImportant)
	{
		this.width = width;
		this.height = height;
		this.bitCount = bitCount;
		this.compression = compression;
		this.sizeImage = sizeImage;
		this.xPelsPerMeter = xPelsPerMeter;
		this.yPelsPerMeter = yPelsPerMeter;
		this.clrUsed = clrUsed;
		this.clrImportant = clrImportant;
	}
	
	public BitmapInfoHeader(byte[] array)
	{
		ByteBuffer wrapper = ByteBuffer.wrap(array);
		
		if(wrapper.getInt(0) != size)
			throw new IllegalArgumentException("Error! Invalid size!" + wrapper.getInt(0));
		
		if(wrapper.getShort(12)!=planes)
			throw new IllegalArgumentException("Error! Invalid planes!");
	
		this.width = wrapper.getInt(4);
		this.height = wrapper.getInt(8);
		this.bitCount = wrapper.getShort(14);
		this.compression = wrapper.getInt(16);
		this.sizeImage = wrapper.getInt(20);
		this.xPelsPerMeter = wrapper.getInt(24);
		this.yPelsPerMeter = wrapper.getInt(28);
		this.clrUsed = wrapper.getInt(32);
		this.clrImportant =wrapper.getInt(36);
	}
	
	public byte[] getInfoHeader(){
		ByteBuffer wrapper = ByteBuffer.allocate(40);
		wrapper.putInt(size);
		wrapper.putInt(width);
		wrapper.putInt(height);
		wrapper.putShort(planes);
		wrapper.putShort(bitCount);
		wrapper.putInt(compression);
		wrapper.putInt(sizeImage);
		wrapper.putInt(xPelsPerMeter);
		wrapper.putInt(yPelsPerMeter);
		wrapper.putInt(clrUsed);
		wrapper.putInt(clrImportant);
		return wrapper.array();
	}
	
	public byte[] getInfoHeaderReversed()
	{
		ByteBuffer wrapper = ByteBuffer.allocate(40);
		wrapper.putInt(Integer.reverseBytes(size));
		wrapper.putInt(Integer.reverseBytes(width));
		wrapper.putInt(Integer.reverseBytes(height));
		wrapper.putShort(Short.reverseBytes(planes));
		wrapper.putShort(Short.reverseBytes(bitCount));
		wrapper.putInt(Integer.reverseBytes(compression));
		wrapper.putInt(Integer.reverseBytes(sizeImage));
		wrapper.putInt(Integer.reverseBytes(xPelsPerMeter));
		wrapper.putInt(Integer.reverseBytes(yPelsPerMeter));
		wrapper.putInt(Integer.reverseBytes(clrUsed));
		wrapper.putInt(Integer.reverseBytes(clrImportant));
		return wrapper.array();
	}
	
	public int getCompression()
	{
		return compression;
	}
	
	public int getSizeRawImage()
	{
		return sizeImage;
	}
	
	public void setSizeRawImage(int sizeImage)
	{
		this.sizeImage = sizeImage;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public void setWidth(int width)
	{
		this.width = width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public void setHeight(int height)
	{
		this.height = height;
	}
}
