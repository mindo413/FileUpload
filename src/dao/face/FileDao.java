package dao.face;

import java.util.List;

import dto.UploadFile;

public interface FileDao {

	public void insert(UploadFile uploadFile);

	public List<UploadFile> filelist();

}
