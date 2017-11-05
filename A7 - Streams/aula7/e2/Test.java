package aula7.e2;

public class Test
{
	public static void main(String args[])
	{
		Bitmap bmp = new Bitmap("Figura.bmp");
		
		//copy
		bmp.write("Copy.bmp");
		
		//get the raw
		bmp.getBmpRaw("Figura.raw");
		
		//reisize image
		bmp.resize025("Resized.bmp");
		
		//flip vertical 
		bmp.flipVertical("FlipVertical.bmp");
		
		//flip horizontal 
		bmp.flipHorizontal("FliHorizontal.bmp");
	}
}
