import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import p1.*;


public class AddFlight extends HttpServlet
{
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
        PrintWriter pw=res.getWriter();
        res.setContentType("text/html");
        try
        {
        String source=req.getParameter("txtsource").trim();
        String destination=req.getParameter("txtdestination").trim();
        String flightno=req.getParameter("txtflightno").trim();
        String d_time=req.getParameter("txtdeparturetime").trim();
        String a_time=req.getParameter("txtarrivaltime").trim();
        String days[]=req.getParameterValues("days[]");
        String days1="";
        for(int i=0;i<days.length;i++)
        {
            days1=days1+days[i]+" ";
        }
        int cost_economy=Integer.parseInt(req.getParameter("txtcost_economy").trim());
        int cost_business=Integer.parseInt(req.getParameter("txtcost_business").trim());
        int seats_economy=Integer.parseInt(req.getParameter("txtseats_economy").trim());
        int seats_business=Integer.parseInt(req.getParameter("txtseats_business").trim());
       
        
           
        Connection con=DB_Connection.get_DBConnection();
        PreparedStatement pst1=con.prepareStatement("insert into flights values(?,?,?,?,?,?,?,?,?,?)");
        pst1.setString(1, flightno);
        pst1.setString(2,source);
        pst1.setString(3,destination);
        pst1.setInt(4,cost_economy);
        pst1.setInt(5,cost_business);
        pst1.setInt(6,seats_economy);
        pst1.setInt(7,seats_business);
        pst1.setString(8,d_time);
        pst1.setString(9,a_time);
        pst1.setString(10,days1);
        pst1.executeUpdate();
        
                 req.setAttribute("msg", "$('#modal-msg').modal('show');");
            RequestDispatcher rd=req.getRequestDispatcher("addflight.jsp");
            rd.forward(req, res);
                      
        
       
        }
        catch(Exception e)
        {
            pw.println(e);
        }

              
        
    }
}