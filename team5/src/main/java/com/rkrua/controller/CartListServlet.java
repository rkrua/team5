package com.rkrua.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rkrua.dao.CartDao;
import com.rkrua.dto.CartVo;
import com.rkrua.dto.MemberVo;


@WebServlet("/cartList.do")
public class CartListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession(); 
		MemberVo mVo = (MemberVo)session.getAttribute("loginUser");
		
		String userid = request.getParameter("userid");
		
		CartDao cDao = CartDao.getInstance();		
	
		List<CartVo> cartList = cDao.selectAllCart(userid);
//		System.out.println(cartList.size());
		request.setAttribute("CartList", cartList);
		int total = cDao.totalPrice(userid);		// 총 금액
		int change = cDao.resultPrice(mVo.getPoint(), total);		// 거스름돈
		System.out.println(mVo.getPoint());
		System.out.println(change);
		
		request.setAttribute("change", change);
		request.setAttribute("total", total);
//		System.out.println(cartList); 
		
		
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("product/Cart.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
