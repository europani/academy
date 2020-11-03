package upload;

import org.springframework.web.multipart.MultipartFile;

public class FileCommand {
	private MultipartFile f;
	private String title;
	
	public MultipartFile getF() {
		return f;
	}
	public void setF(MultipartFile f) {
		this.f = f;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
