package pkg06_upload;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Collection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
                 maxFileSize = 1024 * 1024 * 5,
                 maxRequestSize = 1024 * 1024 * 50) // 파일 첨부를 가지고 있을 때 작성해야함


public class Upload extends HttpServlet {

  private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    // 업로드 경로 (톰캣 내부 경로)
	  String uploadPath = request.getServletContext().getRealPath("upload");
	  File uploadDir = new File(uploadPath);
	  if(!uploadDir.exists()) {
	    uploadDir.mkdir();
	  }
	  
	  String originalFilename = null;
	  String filesystemName = null;
	  
	  // 첨부된 파일 정보
	  Collection<Part> parts = request.getParts();
	  for(Part part : parts) {
//	    System.out.println(part.getName());             // name 속성 조회
//	    System.out.println(part.getContentType());      // 파일 유형
//	    System.out.println(part.getSize());             // 파일 크기
//	    System.out.println(part.getSubmittedFileName());// 파일 이름
//	    System.out.println(part.getHeader("Content-Disposition")); // 첨부파일 확인
	    if(part.getHeader("Content-Disposition").contains("filename")) {
	      if(part.getSize() > 0) {
	        originalFilename = part.getSubmittedFileName();
        	        
	      }
	    }
	    if(originalFilename != null) {
	      int point = originalFilename.lastIndexOf(".");
	      String extName = originalFilename.substring(point);     //.jpg
	      String fileName = originalFilename.substring(0, point); //animal1 
	      filesystemName = fileName + "_" + System.currentTimeMillis() +  extName ;
	      
	    }
	    // realPath에 첨부파일 저장하기
	    if(filesystemName != null) {
	      part.write(uploadPath + File.separator + filesystemName);
	    }
	  }
	  // 응답
	  response.setContentType("text/html; charset=utf-8");
	  PrintWriter out = response.getWriter();
	  out.println("<div><a href=\"/servlet/pkg06_upload/NewFile.html\">입력폼으로 돌아가기</a></div>");
	  out.println("<div>첨부파일명 : " + originalFilename + "</div>");
	  out.println("<div>저장파일명 : " + filesystemName + "</div>");
	  out.println("<div>저장경로 : " + uploadPath + "</div>");
	  out.println("<hr>");
	  
	  // 업로드한 파일 다운로드 링크 만들기
	  File[] files = uploadDir.listFiles();
	  for(File file : files) {
	   String fileName1 = file.getName(); // 파일명_1234567890.jpg
	   String ext = fileName1.substring(fileName1.lastIndexOf("."));
	   String fileName2 = fileName1.substring(0, fileName1.lastIndexOf("_"));
	   out.println("<div><a href=\"/servlet/download?filename=" + URLEncoder.encode(fileName1, "utf-8") + "\">" + fileName2 + ext + "</a></div>");
	  
	  }
	 
	  out.flush();
	  out.close();
	}
	
	 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	  doGet(request, response);
	}

}
