package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.UploadFile;
import service.face.FileService;
import service.impl.FileServiceImpl;


@WebServlet("/commons/fileupload/list")
public class CommonsFileUploadListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private FileService fileService = new FileServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<UploadFile> uploadfile = fileService.list();
		
		req.setAttribute("list", uploadfile);
		
		System.out.println(uploadfile);
		
//		req.getRequestDispatcher("/WEB-INF/views/commons/filelist.jsp").forward(req, resp);
		req.getRequestDispatcher("/WEB-INF/views/file/list.jsp").forward(req, resp);
		
	} 
}
