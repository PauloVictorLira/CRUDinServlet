// PAULO VICTOR LIRA SILVA 	3003906

package com.crudservlet;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/EditServlet2")  
public class EditServlet2 extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
          throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        String nome=request.getParameter("nome");  
        String sunidadeCompra=request.getParameter("unidadeCompra");  
        int unidadeCompra=Integer.parseInt(sunidadeCompra); 
        String descricao=request.getParameter("descricao");
        String sqtdPrevistoMes = request.getParameter("qtdPrevistoMes");
        double qtdPrevistoMes = Double.parseDouble(sqtdPrevistoMes);        
        String sprecoMaxComprado=request.getParameter("precoMaxComprado");
        double precoMaxComprado = Double.parseDouble(sprecoMaxComprado);        
          
        Emp e=new Emp();
        e.setId(id);
        e.setNome(nome); 
        e.setUnidadeCompra(unidadeCompra);  
        e.setDescricao(descricao);  
        e.setQtdPrevistoMes(qtdPrevistoMes);  
        e.setPrecoMaxComprado(precoMaxComprado);
          
        int status=EmpDao.update(e);  
        if(status>0){  
            response.sendRedirect("ViewServlet");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close();  
    }  
  
}  