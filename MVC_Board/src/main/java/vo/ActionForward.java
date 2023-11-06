package vo;

// 포워딩 정보(포워딩 주소와 포워딩 방식)를 관리할 ActionForward 클래스 정의 
public class ActionForward {
	private String path; // 포워딩 주소
	private boolean isRedirect; // 포워딩 방식(true : Redirect, false : Dispatch)
	
	// Getter/Setter 정의
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
}
