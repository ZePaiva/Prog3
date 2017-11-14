package aula9.e1;

import java.io.*;
import java.util.*;

public class ScannerAbeirense
implements Iterator<String>, Closeable
{

	private static Scanner lel;
	
	public ScannerAbeirense(InputStream arg) {
		lel = new Scanner(arg);
	}
	
	@Override
	public void close() 
	throws IOException
	{
		lel.close();
		
	}

	@Override
	public boolean hasNext()
	{
		lel.hasNext();
		return false;
	}

	@Override
	public String next()
	{
		String next = lel.next();
		next = next.replace('v', 'b');
		next = next.replace('V', 'B');
		return next;
	}

	public String nextLine()
	{
		String nextLine = lel.nextLine();
		nextLine = nextLine.replace('v', 'b');
		nextLine = nextLine.replace('V', 'B');
		return nextLine;
	}
}
