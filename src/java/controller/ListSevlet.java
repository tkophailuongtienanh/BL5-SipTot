/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.CategoryDAO;
import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Categories;
import model.Color;
import model.Mat;
import model.ProductDisplay;
import model.Size;
import model.SubCategories;

/**
 *
 * @author Admin
 */
public class ListSevlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListSevlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListSevlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        ProductDAO dao = new ProductDAO();
        CategoryDAO cdb = new CategoryDAO();
        
        String name = request.getParameter("name");
        String catid = request.getParameter("cid");
        String subcatid = request.getParameter("scid");
        String colorid = request.getParameter("color");
        String mat = request.getParameter("mat");
        String sizeid = request.getParameter("size");
        String oderby = request.getParameter("odb");
        if(catid == null){
            catid = "";
        }
        if(subcatid == null){
            subcatid = "";
        }
        if(colorid == null){
            colorid = "";
        }
        if(mat == null){
            mat = "";
        }
        if(sizeid == null){
            sizeid = "";
        }
        if(oderby == null){
            oderby = "";
        }
        if(name == null){
            name = "";
        }
        List<ProductDisplay> data = dao.getProduct(name, catid, subcatid, colorid, sizeid, mat, oderby);
        
        int page, numberPerPage = 12;
        int size = data.size();
        int num = (size%12==0?(size/12):((size/12)+1));
        String xpage=request.getParameter("page");
        if(xpage==null){
            page=1;
        }else{
            page=Integer.parseInt(xpage);
        }
        int start, end;
        start=(page-1)*numberPerPage;
        end=Math.min(page*numberPerPage, size);
        
        List<ProductDisplay> list = dao.getListByPage(data, start, end);
        List<Categories> clist = cdb.getAll();
        List<SubCategories> sclist = cdb.getAllSub(catid);
        List<Mat> mlist = dao.getAllMat();
        List<Color> cllist = dao.getAllColor();
        List<Size> slist = dao.getAllSize();
        
        request.setAttribute("curcid", catid);
        request.setAttribute("curscid", subcatid);
        request.setAttribute("curclid", colorid);
        request.setAttribute("cursid", sizeid);
        request.setAttribute("curmat", mat);
        request.setAttribute("curodb", oderby);
        request.setAttribute("clist", clist);
        request.setAttribute("sclist", sclist);
        request.setAttribute("mlist", mlist);
        request.setAttribute("cllist", cllist);
        request.setAttribute("slist", slist);
        
        request.setAttribute("data", list);
        request.setAttribute("page", page);
        request.setAttribute("num", num);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
