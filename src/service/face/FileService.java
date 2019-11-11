package service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.UploadFile;

public interface FileService {

	/**
	 * 파일 업로드 처리 (Commons-Fileupload 라이브러리 활용)
	 * 
	 * @param req  - 요청정보객체
	 * @param resp - 응답정보객체
	 */

	public void fileupload(HttpServletRequest req, HttpServletResponse resp);

	public List<UploadFile> list();

	/**
	 * 요청객체로부터 요청파라미터 fileno를 얻는다
	 * 
	 * @param req - 요청정보 객체
	 * @return UploadFile - 전달파라미터 fileno를 저장한 DTO
	 */

	public UploadFile getFileno(HttpServletRequest req);

	/**
	 * fileno를 이용해 파일의 정보를 조회한다
	 * 
	 * @param downFile - fileno를 가지고 있는 DTO, 해당 파일의 정보를 저장
	 */

	public void getFile(UploadFile downFile);

	/**
	 * 요청정보 객체로부터 fileno 파라미터를 얻는다 fileno를 이용해 DB에서 UploadFile 정보를 얻어 반환한다
	 * 
	 * @param req - 요청정보객체(fileno를 가짐)
	 * @return UploadFile - fileno에 해당하는 파일의 정보
	 */
	public UploadFile getFile(HttpServletRequest req);

}
