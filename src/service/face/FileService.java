package service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.UploadFile;

public interface FileService {
	
	/**
	 * 파일 업로드 처리
	 * (Commons-Fileupload 라이브러리 활용)
	 * 
	 * @param req - 요청정보객체
	 * @param resp - 응답정보객체
	 */
	
	public void fileupload(HttpServletRequest req, HttpServletResponse resp);

	public List<UploadFile> list();
		
}
