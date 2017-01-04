/**
 * 
 */
package com.figo.study.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.figo.study.model.User;
import com.figo.study.service.UserService;

/**
 * Servlet测试demo
 * 
 * @author figo
 *
 */
public class LoginServlet extends HttpServlet {
	UserService userService = new UserService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = new User();
		String userName = req.getParameter("userName");
		String userPwd = req.getParameter("userPwd");
		user.setUserName(userName);
		user.setUserPwd(userPwd);

		if (userService.login(user)) {
			System.out.println("success");
			session.setAttribute("user", user);
			String login_suc = "success.jsp";
			resp.sendRedirect(login_suc);
		} else {
			req.setAttribute("msg", "用户或密码错误！");
			String login_fail = "login.jsp";
			req.getRequestDispatcher("login.jsp").forward(req, resp);// 转发，是同一个请求，转发到的jsp可以得到request里面的属性值
		}
	}

}
