package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Connector;
import deployment.Deployment;
import model.Item;
import utils.ProcessText;

/**
 * Servlet implementation class MobileController
 */
@WebServlet("/MobileController")
public class MobileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MobileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s= request.getParameter("mobile");
		s=ProcessText.processMobileInput(s);
		System.out.println(s+ProcessText.isMobileValid(s));		
		if (ProcessText.isMobileValid(s)) {			
			List<Item> items=Connector.retriveItemsByPhone(s);
			int itemsSize=items.size();
			System.out.println("item size: "+itemsSize);
			if (itemsSize==0) {
				String path = "/index.jsp";
				request.setAttribute("searchResult", "failed");
				ServletContext servletContext = getServletContext();
		        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
		        requestDispatcher.forward(request, response);
			}				
			else {
				request.setAttribute("searchResult", null);	
				response.setCharacterEncoding("UTF-8");
				PrintWriter out = response.getWriter();
				
				String description=Connector.createDescriptionOfItems(items);				
		        out.println (
		                  "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" +" +
		                      "http://www.w3.org/TR/html4/loose.dtd\">\n" +
		                  "<html> \n" +
		                    "<head> \n" +
		                      "<meta http-equiv=\"content-type\" content=\"text/html; " +
		                        "charset=utf-8\"> \n" +
		                      "<title> Результат поиска </title> \n" +
		                    "</head> \n" +
		                    "<body> <div align='center'> \n" +
		                      "<style= \"font-size=\"12px\" color='black'\"" + "\">" +
		                        "Найдено следующие записи: <br> " +description+
		                        "<a href=\""+Deployment.retriveProjectNameInURI()+"\\index.jsp\">Искать вновь</a>" + 
		                    "</font></body> \n" +
		                  "</html>" 
		                );   
				
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
