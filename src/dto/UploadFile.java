package dto;

public class UploadFile {
	private int fileno;
	private String originname;
	private String storedname;

	@Override
	public String toString() {
		return "UploadFile [fileno=" + fileno + ", originname=" + originname + ", storedname=" + storedname + "]";
	}

	public int getFileno() {
		return fileno;
	}

	public void setFileno(int fileno) {
		this.fileno = fileno;
	}

	public String getOriginname() {
		return originname;
	}

	public void setOriginname(String originname) {
		this.originname = originname;
	}

	public String getStoredname() {
		return storedname;
	}

	public void setStoredname(String storedname) {
		this.storedname = storedname;
	}

}
