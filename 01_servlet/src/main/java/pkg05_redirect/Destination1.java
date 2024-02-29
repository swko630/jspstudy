package pkg05_redirect;

import java.io.IOException;
import java.net.URLEncoder;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class Destination1 extends HttpServlet {
	
  private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	  /*
	    * redirect (비행기 회항의 느낌, 목적지1 갔다가 회항했다가 목적지2로 가는 것)
	    * 
	    * 1. 이동할 때 요청과 응답 모두 전달되지 않는다.
	    * 2. 이동 경로를 작성할 때 contextPath부터 작성해야 한다. 
	    * 3. 클라이언트는 redirect 경로를 확인할 수 있다.
	    * 4. redirect 하는 경우
	    *   1) 쿼리 insert
	    *   2) 쿼리 update
	    *   3) 쿼리 delete
	    */
	  request.setCharacterEncoding("utf-8");
    String luggage = request.getParameter("luggage");
    response.sendRedirect("/servlet/destination2?luggage=" + URLEncoder.encode(luggage, "utf-8"));
    
	  
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	  doGet(request, response);
	}

}
