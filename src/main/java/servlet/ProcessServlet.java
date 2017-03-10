package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datahandler.JspMessagePreparator;

@WebServlet("/process")
public class ProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProcessServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("submit") != null) {
			process(request, response);
		}
	}

	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		String className = request.getParameter("className");

		List<String> result = JspMessagePreparator.getMessage(className);

		HttpSession session = request.getSession();

		session.setAttribute("mainMessage", result.get(0));

		if (result.size() > 1) {
			session.setAttribute("resultList", result.subList(1, result.size() - 1));
		} else {
		    session.removeAttribute("resultList");
        }
		session.setAttribute("sessionID", session.getId());

		RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/methods.jsp");
		reqDispatcher.forward(request, response);
	}
}