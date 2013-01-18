package nio.buffer;

import java.nio.Buffer;
import java.nio.CharBuffer;

public class BufferCompact {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CharBuffer buf = CharBuffer.allocate(20);
		buf.put("hello world");
		buf.flip();
		System.out.println(buf.position()+", "+buf.limit()+", "+buf.capacity()+", "+buf.toString());
	
		buf.clear();
		buf.put("jump in");
	   	buf.put("to rain");
		Buffer b = buf.mark();
		//buf.flip();
		
		
		System.out.println(buf.position()+", "+buf.limit()+", "+buf.capacity()+", "+buf.toString());
		
		buf.position(5);
		CharBuffer newCharBuf = buf.compact();
		//buf.flip();
		System.out.println(buf.position()+", "+buf.limit()+", "+buf.capacity()+", "+buf.toString());
	}

}
