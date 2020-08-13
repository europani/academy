package board;

public class BoardDto {
	private int num;		// 글번호
	private String name;
	private String subject;
	private String content;
	private int pos;		// 답글 순서(부모글로부터 순차부여)
	private int depth;		// 답글 레벨 (답글의 답글과 관련)
	private int ref;		// 답글의 부모글번호
	private String regdate;
	private String pass;
	private String ip;
	private int count;
	private String filename;
	private int filesize;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getPos() {
		return pos;
	}
	public void setPos(int pos) {
		this.pos = pos;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public int getFilesize() {
		return filesize;
	}
	public void setFilesize(int filesize) {
		this.filesize = filesize;
	}
	@Override
	public String toString() {
		return "boardDTO [num=" + num + ", name=" + name + ", subject=" + subject + ", content=" + content + ", pos="
				+ pos + ", depth=" + depth + ", ref=" + ref + ", regdate=" + regdate + ", pass=" + pass + ", ip=" + ip
				+ ", count=" + count + ", filename=" + filename + ", filesize=" + filesize + "]";
	}
	
}
