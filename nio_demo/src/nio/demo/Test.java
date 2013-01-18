package nio.demo;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ByteBuffer buffer = ByteBuffer.allocate(32);
		CharBuffer charBuffer = buffer.asCharBuffer();
		String content = charBuffer.put("Hello ").put("World").flip().toString();
		
		ByteBuffer buffer1 = ByteBuffer.allocate(32);
		CharBuffer charBuffer1 = buffer1.asCharBuffer();
		charBuffer1.put("Hello"); 
		charBuffer1.put("World");
		System.out.println(content); 
		System.out.println(charBuffer1.flip().toString());
	}

}
