package ch12;

public class AnnotationEx1 {

	public static void main(String[] args) {
		@SuppressWarnings("deprecation")
		NewClass nc = new NewClass();
		nc.oldField = 10;
		nc.getOldField();
		
	}

}

class NewClass {
	int newField;
	@Deprecated
	int oldField;
	
	int getNewField() {
		return newField;
	}
	@Deprecated
	int getOldField() {
		return newField;
		
	}
}
