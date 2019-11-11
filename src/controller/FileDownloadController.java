package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import dto.UploadFile;
import service.face.FileService;
import service.impl.FileServiceImpl;

@WebServlet("/file/download")
public class FileDownloadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private FileService fileService = new FileServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		// 전달파라미터 받기
//		UploadFile downFile = fileService.getFileno(req);
//		System.out.println(downFile);
//		
//		// 다운로드 대상 파일 정보 조회하기
//		fileService.getFile(downFile);
//		System.out.println(downFile);

		// 다운로드 대상 파일 정보 조회하기
		UploadFile downFile = fileService.getFile(req);
		System.out.println(downFile);

		// 다운로드용 File 객체 만들기
		String path = getServletContext().getRealPath("upload"); // 경로
		String filename = downFile.getStoredname(); // 파일 이름

		File file = new File(path, filename);
		System.out.println("FILE : " + file);
		System.out.println("FILE exists() : " + file.exists());

		// - - - 파일 다운로드 시키기 - - -
		// 응답 정보 객체를 설정한다
		// Reponse Message의 Header를 수정한다

		// 응답 body의 길이 설정
		resp.setHeader("Content-Length", String.valueOf(file.length()));

		// 응답 데이터의 형식(MIME - Type)
		resp.setContentType("application/octet-stream"); // 이진 파일의 형태

		// 응답 파일의 저장위치 지정하기
		// (이름도 변경할 수 있다)
		resp.setHeader("Content-Dispposition",
				"attachment;fileName=" + new String(downFile.getOriginname().getBytes("utf-8"), "8859_1") + ";");

		// - - - - - - - - - - - - - - - -
		
		//  - - - 응답 메세지의 응답 Body(본문) 작성 - - -
		// 파일의 내용을 응답으로 출력
		
		// 파일 입력 스트림 (서버의 로컬 저장소 파일)
		InputStream is = new FileInputStream(file);
		
		// 파일 출력 스트림 (브라우저)
		OutputStream os = resp.getOutputStream();
		
		// 파일 입력 -> 브라우저 출력
		IOUtils.copy(is, os);
		
		os.flush();
		
		is.close();
		os.close();
		
		// - - - - - - - - - - - - - - - - - - - -
	}
}
