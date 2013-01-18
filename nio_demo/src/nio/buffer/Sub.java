package nio.buffer;

import java.util.Date;

public class Sub extends Super {
private final Date date;

Sub(){
	date = new Date();
}

public void overrideMe(){
	System.out.println(date);
}

public static void main(String[] args) {
	Super s = new Sub();
	s.overrideMe();
}
}
