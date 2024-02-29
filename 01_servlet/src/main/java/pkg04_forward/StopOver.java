package pkg04_forward;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class StopOver extends HttpServlet {
	
  private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	 /*
	  * forward (서버 내부에서 이동할 때, crud 중 select 했을 때 사용) - 프론트에선 데이터가 어디로 어떻게 이동했는 지 모름
	  * 
	  * 1. 이동할 때 요청과 응답 모두 전달된다.
	  * 2. 이동 경로를 작성할 때 contextPath는 제외하고 작성해야 한다. (URLMapping만 작성해야 한다.)
	  * 3. 클라이언트는 forward 경로를 확인할 수 없다.
	  * 4. forward 하는 경우
	  *   1) 단순 이동
	  *   2) 쿼리 select
	  */
	 
	  // 응답
	  request.getRequestDispatcher("/destination").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
