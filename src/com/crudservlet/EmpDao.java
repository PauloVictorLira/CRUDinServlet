// PAULO VICTOR LIRA SILVA 	3003906

package com.crudservlet;

import java.util.*;  
import java.sql.*;  
  
public class EmpDao {  
  
    public static Connection getConnection(){  
        
    Connection con=null;  
    try{  
        Class.forName("com.mysql.cj.jdbc.Driver");  
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useTimezone=true&serverTimezone=America/Sao_Paulo","root","root");  
    }catch(Exception e){System.out.println(e);}  
    return con;  
}  
    public static int save(Emp e){  
        int status=0;  
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into produtos(nome,unidadeCompra,descricao,qtdPrevistoMes,precoMaxComprado) values (?,?,?,?,?)");  
            ps.setString(1,e.getNome());  
            ps.setInt(2,e.getUnidadeCompra());  
            ps.setString(3,e.getDescricao());  
            ps.setDouble(4,e.getQtdPrevistoMes());
            ps.setDouble(5,e.getPrecoMaxComprado());
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int update(Emp e){  
        int status=0;  
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update produtos set nome=?,unidadeCompra=?,descricao=?,qtdPrevistoMes=?,precoMaxComprado=? where id=?");  
            ps.setString(1,e.getNome());  
            ps.setInt(2,e.getUnidadeCompra());  
            ps.setString(3,e.getDescricao());  
            ps.setDouble(4,e.getQtdPrevistoMes());
            ps.setDouble(5,e.getPrecoMaxComprado());  
            ps.setInt(6,e.getId());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from produtos where id=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    public static Emp getEmployeeById(int id){  
        Emp e=new Emp();  
          
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from produtos where id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getInt(1));  
                e.setNome(rs.getString(2));  
                e.setUnidadeCompra(rs.getInt(3)); 
                e.setDescricao(rs.getString(4));  
                e.setQtdPrevistoMes(rs.getDouble(5));
                e.setPrecoMaxComprado(rs.getDouble(6));   
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
    public static List<Emp> getAllEmployees(){  
        List<Emp> list=new ArrayList<Emp>();  
          
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from produtos");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Emp e=new Emp();  
                e.setId(rs.getInt(1));  
                e.setNome(rs.getString(2));  
                e.setUnidadeCompra(rs.getInt(3)); 
                e.setDescricao(rs.getString(4));  
                e.setQtdPrevistoMes(rs.getDouble(5));
                e.setPrecoMaxComprado(rs.getDouble(6)); 
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
}  
