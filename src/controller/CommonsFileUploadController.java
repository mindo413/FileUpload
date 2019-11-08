package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.face.FileService;
import service.impl.FileServiceImpl;

@WebServlet("/commons/fileupload")
public class CommonsFileUploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private FileService fileService = new FileServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/commons/fileupload.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// application/x-www-form-urlencoded 인코딩 방식으로 전달된
		// 요청파라미터는 getParameter() 메소드를 통해서 얻을 수 있지만
		
		// multipart/form-data 인코딩 방식으로 전달된
		// 요청파라미터는 getParameter() 메소드에 null만 반환한다
		
		// 파일 업로드 라이브러리를 활용해서 전달 받을 수 있다
		// <input type="text" /> 로 전송한 파라미터도 마찬가지!
		
//		System.out.println("title : " + req.getParameter("title"));
//		System.out.println("upfile : " + req.getParameter("upfile"));
		
		// 서비스를 이용한 파일 업로드 처리
		fileService.fileupload(req,resp);
		req.getRequestDispatcher("/WEB-INF/views/commons/fileupload.jsp").forward(req, resp);
	}
}
