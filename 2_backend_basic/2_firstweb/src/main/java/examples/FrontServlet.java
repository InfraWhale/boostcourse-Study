//4.5-2. forward
package examples;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/front")
public class FrontServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public FrontServlet() {
    super();
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int diceValue = (int)(Math.random() * 6) + 1 ;
    request.setAttribute("dice", diceValue);

    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/next");
    requestDispatcher.forward(request, response);
  }

}
