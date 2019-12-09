package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import ec.edu.espe.hardware.model.ProductoVO;
import ec.edu.espe.hardware.model.ProductoDAO;
import java.awt.TrayIcon.MessageType;
import java.sql.*;

public final class addproduct_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <h1>Agregar Producto</h1>\n");
      out.write("            <hr>\n");
      out.write("            <form action=\"\" method=\"post\" class=\"form-control\" style=\"width: 500px; height: 400px\">\n");
      out.write("                    \n");
      out.write("                            <label for=\"cedula\">Id:</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" placeholder=\"1\" name=\"cedula\" />\n");
      out.write("                       \n");
      out.write("                            <label for=\"cedula\">Nombre:</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" placeholder=\"Hammer\" name=\"nombre\" />\n");
      out.write("                       \n");
      out.write("                            <label for=\"direccion\">Tipo:</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" placeholder=\"Hardware\" name=\"direccion\" />\n");
      out.write("                       \n");
      out.write("                            <label for=\"cedula\">Cantidad:</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" placeholder=\"1\" name=\"telefono\" />\n");
      out.write("                   \n");
      out.write("                <input type=\"submit\" value=\"Guardar\" />\n");
      out.write("                ");
ProductoDAO dao=new ProductoDAO();
                String id, nom,dir,telf;
                id=request.getParameter("cedula");
                 nom=request.getParameter("nombre");
             dir=request.getParameter("direccion");
                 telf=request.getParameter("telefono");
                 ProductoVO produc=new ProductoVO(1,nom,dir,1);
                 dao.setServices(produc);
                 
      out.write("\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
