//4.5-2. forward
package examples;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/next")
public class NextServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public NextServlet() {
    super();
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head><title>form</title></head>");
    out.println("<body>");

    int dice = (Integer)request.getAttribute("dice"); // getAttribute() 써서 꺼내면 Object로 반환 -> Integer로 형변환하기
    out.println("dice : " + dice);
    for(int i = 0; i < dice; i++) {
      out.print("<br>hello");
    }
    out.println("</body>");
    out.println("</html>");
  }

}
