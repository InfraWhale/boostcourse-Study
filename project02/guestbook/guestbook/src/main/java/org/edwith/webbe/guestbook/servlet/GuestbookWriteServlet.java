package org.edwith.webbe.guestbook.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.edwith.webbe.guestbook.dao.GuestbookDao;
import org.edwith.webbe.guestbook.dto.Guestbook;

@WebServlet("/guestbooks/write")
public class GuestbookWriteServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {

    GuestbookDao guestbookDao = new GuestbookDao();

    request.setCharacterEncoding("UTF-8");
    String name = request.getParameter("name");
    String content = request.getParameter("content");

    Guestbook guestbook = new Guestbook(name, content);
    guestbookDao.addGuestbook(guestbook);

    response.sendRedirect("/guestbooks");
  }
}
