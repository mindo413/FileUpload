package service.impl;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.face.FileDao;
import dao.impl.FileDaoImpl;
import dto.UploadFile;
import service.face.FileService;

public class FileServiceImpl implements FileService {
	
	private FileDao fileDao = new FileDaoImpl();
	
	@Override
	public void fileupload(HttpServletRequest req, HttpServletResponse resp) {

		// 응답객체 Content-Type 설정
		resp.setContentType("text/html; charset=UTF-8");

		// 응답 객체 출력 스트림 얻기
		PrintWriter out = null;
		try {
			out = resp.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 1. 파일업로드 형태의 데이터가 맞는지 확인
		// enctype이 multipart/form-data가 맞는지 확인
		boolean isMultipart = false;
		isMultipart = ServletFileUpload.isMultipartContent(req);

		// 1-1. multipart/form-data 인코딩으로 전송되지 않았을 경우
		if (!isMultipart) {
			out.append("<h1>enctype이 multipart/form-data가 아님</h1>");
			out.append("<a href='/commons/fileupload'>이동</a>");

			return;
		}

		// 1-2. 여기 이후는 multipart/form-data로 요청된 상황임
		// 파일이 전송되었음

		// 2. 업로드된 파일을 처리하는 아이템팩토리 객체 생성

		// ItemFactory : 업로드된 파일을 처리하늘 방식을 정하는 클래스

		// FileItem : 클라이언트로부터 전송된 데이터를 객체화시킨 것

		// DiskFileItemFactory class
		// -> 디스크기반(HDD)의 파일아이템 처리 API
		// -> 업로드된 파일을 디스크에 임시 저장하고 후처리한다
		DiskFileItemFactory factory = null;
		factory = new DiskFileItemFactory();

		// 3. 업로드된 아이템이 용량이 적당히 작으면 메모리에서 처리
		int maxMem = 1 * 1024 * 1024; // 1MB
		factory.setSizeThreshold(maxMem);

		// 4. 용량이 적당히 크면 임시파일을 만들어 처리(디스크)
		ServletContext context = req.getServletContext();
		String path = context.getRealPath("tmp");
		File repository = new File(path);

		// Test
//		System.out.println("repository : " + repository);

		factory.setRepository(repository);

		// 5. 업로드 허용 용량 기준을 넘지 않을 경우에만 업로드 처리
		int maxFile = 10 * 1024 * 1024; // 10MB

		// 파일 업로드 객체 생성
		ServletFileUpload upload = null;
		upload = new ServletFileUpload(factory);

		// 파일 업로드 용량제한 설정 : 10MB
		upload.setFileSizeMax(maxFile);

		// ----- 파일 업로드 준비 -----

		// 6. 업로드된 데이터 추출(파싱)
		// 임시 파일 업로드도 같이 수행함
		List<FileItem> items = null;
		try {
			items = upload.parseRequest(req);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}

		// 7. 파싱된 데이터 처리하기
		// item 리스트에 요청파라미터가 파싱되어있음

		// 요청정보의 형태 3가지
		// 1. 빈파일(용량이 0인 파일)
		// 2. form-data(일반적인 요청파라미터)
		// 3. 파일

		Iterator<FileItem> iter = items.iterator();

		// 모든 요청정보 처리
		while (iter.hasNext()) {
			FileItem item = iter.next();

			// 1) 빈 파일 처리
			if (item.getSize() <= 0)
				continue;

			// 2) 일반적인 요청 데이터 처리
			if (item.isFormField()) {
				// form-data일 경우
				// key:value 쌍으로 전달된 요청 파라미터

				// key - getFieldName()
				// value - getString()

				// 기본 처리 방식
//				out.println("- - - 폼 필드 - - -<br>");
//				out.println("키 : " + item.getFieldName() + "<br>");
//				out.println("값 : " + item.getString() + "<br>");

				// key값에 따라 처리방식 다르게 하기
				String key = item.getFieldName();

				if ("title".equals(key)) {
					out.println("- - - 폼 필드 - - -<br>");
					out.println("키 : " + item.getFieldName() + "<br>");
					try {
						out.println("값 : " + item.getString("utf-8") + "<br>");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}

				} else if ("shylee".equals(key)) {
					out.println("- - - 폼 필드 - - -<br>");
					out.println("키 : " + item.getFieldName() + "<br>");
					try {
						out.println("값 : " + item.getString("utf-8") + "<br>");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				} else if ("chaechae".equals(key)) {
					out.println("- - - 폼 필드 - - -<br>");
					out.println("키 : " + item.getFieldName() + "<br>");
					try {
						out.println("값 : " + item.getString("utf-8") + "<br>");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				} else if ("duck".equals(key)) {
					out.println("- - - 폼 필드 - - -<br>");
					out.println("키 : " + item.getFieldName() + "<br>");
					try {
						out.println("값 : " + item.getString("utf-8") + "<br>");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				} else if ("cheol".equals(key)) {
					out.println("- - - 폼 필드 - - -<br>");
					out.println("키 : " + item.getFieldName() + "<br>");
					try {
						out.println("값 : " + item.getString("utf-8") + "<br>");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}

			} else { // 3) 파일 처리
				// 업로드 파일 처리 방법 2가지
				// 1. 웹 서버의 로컬 디스크에 저장
				// 파일의 정보는 DB에 기록

				// 2. DB의 테이블에 컬럼으로 저장

				// --------------------------

				// 로컬파일로 저장하고 DB에 기록하는 방식으로 진행

				// --- UUID 생성 ---
				UUID uuid = UUID.randomUUID(); // 랜덤 UID 생성

				// 12자리 uid 얻기
				String u = uuid.toString().split("-")[4];

				// -----------------------------------

				// 로컬 파일 저장소에 파일 저장하기

				// 로컬 저장소 파일 객체
				File up = new File(context.getRealPath("upload"), item.getName() + "_" + u);
				// 파일의 경로는 "/upload"
				// 파일의 이름은 "원본명_uid"
//				System.out.println(up); // 저장소 출력

				// - - - DB에 업로드 정보 기록하기 - - -
				// 파일번호 fileno
				// 원본파일명 origin_name
				// 저장파일명 stored_name
				// -------------------------------

				UploadFile uploadFile = new UploadFile();
				uploadFile.setOriginname(item.getName());
				uploadFile.setStoredname(item.getName() + "_" + u);
				
				// DAO를 통해 DB에 INSERT
				fileDao.insert(uploadFile);

				// - - - 처리가 완료된 파일 업로드 하기 - - -
				// 로컬 저장소에 실제 저장
				try {
					item.write(up); // 실제 업로드
					item.delete(); // 임시 파일 삭제
				} catch (Exception e) {
					e.printStackTrace();
				}
				// -----------------------------------

			} // 파일처리 if
		} // 요청파라미터 처리 while

	} // fileupload() 메소드

	@Override
	public List<UploadFile> list() {
		
		return fileDao.filelist();
	}
	
	/**
	 * 요청객체로부터 요청파라미터 fileno를 얻는다
	 * 
	 * @param req - 요청정보 객체
	 * @return UploadFile - 전달파라미터 fileno를 저장한 DTO
	 */
	
	@Override
	public UploadFile getFileno(HttpServletRequest req) {
		
		// 전달 파라미터 받기
		String param = req.getParameter("fileno");
		
		// int형으로 형 변환
		int fileno = 0;
		if(param != null && !"".equals(param)) {
			fileno = Integer.parseInt(param);
		}
		
		// DTO에 저장
		UploadFile uploadFile = new UploadFile();
		uploadFile.setFileno(fileno);
		
		// 반환
		return uploadFile;
	}

	@Override
	public void getFile(UploadFile downFile) {
		fileDao.selectByFileno(downFile);
		
	}

	@Override
	public UploadFile getFile(HttpServletRequest req) {
		// 요청파라미터 fileno 얻기
		UploadFile downFile = getFileno(req);
		
		// 파일정보 얻기
		getFile(downFile);
		
		// 반환
		return downFile;
	}
	
	
	

}
