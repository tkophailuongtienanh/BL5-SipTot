/*
 * To change this license header, choose License Headers in Project Properties. 
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.CartDAO;
import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CartDetail;
import model.ProductDisplayInCart;
import model.User;

/**
 *
 * @author Admin
 */
public class AddCartServlet extends HttpServlet {

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
            out.println("<title>Servlet AddCartServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddCartServlet at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("account");
        if (u == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
//            response.sendRedirect("login.jsp");
        } else {
            CartDAO cdb = new CartDAO();
            String pid = request.getParameter("pid");
            String sid = request.getParameter("size");
            String cid = request.getParameter("color");
            String tnum = request.getParameter("quantity");
            int num;
            try {
                num = Integer.parseInt(tnum);
                ProductDAO pdb = new ProductDAO();
                String pdid = pdb.getProductDetailID(cid, sid, pid);

                int unit = pdb.getUnitInStock(pdid);
                if (num > unit) {
                    request.setAttribute("error", "Số lượng sản phẩm chỉ còn " + unit + " sản phẩm");
                    request.getRequestDispatcher("productview?pid=" + pid).forward(request, response);
//                    response.sendRedirect("productview?pid=" + pid);
                }else{
                ProductDisplayInCart pdic = pdb.getProductDisplayInCartByPDID(pdid);
                int price = pdic.getPrice();

                int uid = cdb.getCart(u.getUsername());

                CartDetail cd = new CartDetail(pdic, uid, num * price);

                cdb.addCart(u.getUsername(), cd);

                List<CartDetail> list = cdb.getAll(u.getUsername());
                session.setAttribute("csize", list.size());
                response.sendRedirect("productview?pid=" + pid);}
            } catch (IOException | NumberFormatException e) {

            }
        }
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
