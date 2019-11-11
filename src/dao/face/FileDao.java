package dao.face;

import java.util.List;

import dto.UploadFile;

public interface FileDao {

	public void insert(UploadFile uploadFile);

	public List<UploadFile> filelist();
	
	/**
	 * fileno를 이용해서 DB정보를 조회하고 저장한다
	 * 
	 * @param downFile - fileno를 가진 DTO, 파일 정보 저장 객체
	 */
	public void selectByFileno(UploadFile downFile);

}
