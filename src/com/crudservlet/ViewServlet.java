// PAULO VICTOR LIRA SILVA 	3003906

package com.crudservlet;

import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/ViewServlet")  
public class ViewServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<a href='index.html'>Add Novo Produto</a>");  
        out.println("<h1>Lista de Produtos</h1>");  
          
        List<Emp> list=EmpDao.getAllEmployees();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Id</th><th>Nome</th><th>Un. de Compra</th><th>Descri��o</th><th>Qtd Previsto/ M�s</th><th>Pre�o M�x. Comprado</th><th>Edit</th><th>Delete</th></tr>");  
        for(Emp e:list){  
         out.print("<tr><td>"+e.getId()+"</td><td>"+e.getNome()+"</td><td>"+e.getUnidadeCompra()+"</td><td>"+e.getDescricao()+"</td><td>"+e.getQtdPrevistoMes()+"</td><td>"+e.getPrecoMaxComprado()+"</td><td><a href='EditServlet?id="+e.getId()+"'>edit</a></td><td><a href='DeleteServlet?id="+e.getId()+"'>delete</a></td></tr>");  
        }  
        out.print("</table><a href=\"creditos.html\">Creditos</a>");  
        out.print("<header><style>td {text-align: center}</style><header>");
        out.close();  
    }  
}  