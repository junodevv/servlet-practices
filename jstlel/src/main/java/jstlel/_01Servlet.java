package jstlel;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class _01Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 값
		int iVal = 10;
		long lVal = 10;
		float fVal = 3.14f;
		boolean bVal = true;
		String sVal = "가나다라마바사";
		
		request.setAttribute("ival", iVal);
		request.setAttribute("lval", lVal);
		request.setAttribute("fval", fVal);
		request.setAttribute("bval", bVal);
		request.setAttribute("sval", sVal);
		
		// 객체
		Object object = null;
		UserVo userVo = new UserVo();
		userVo.setNo(10L);
		userVo.setName("이준오");
		
		request.setAttribute("object", object);
		request.setAttribute("vo", userVo);
		
		// MAP
		Map<String, Object> map = new HashMap<>();
		map.put("ival", iVal);
		map.put("sval", sVal);
		map.put("fval", fVal);
		request.setAttribute("m", map);
		
		
		request.getRequestDispatcher("/WEB-INF/views/01.jsp")
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
