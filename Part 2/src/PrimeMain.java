package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PrimeChecker;


@WebServlet("/PrimeMain")
public class PrimeMain extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public PrimeMain() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		long startTime = System.currentTimeMillis();
		PrintWriter out=response.getWriter();

		//Fetching values from user
		String first=request.getParameter("First").trim();
		String Second=request.getParameter("Second").trim();
		int Method=Integer.parseInt(request.getParameter("Method"));

		int FirstI=0,SecondI=0;
		try {
			FirstI=Integer.parseInt(first);
			SecondI=Integer.parseInt(Second);
		}catch(NumberFormatException e)
		{
			Method=3;
		}

		if(SecondI<=FirstI)
		{
			Method=3;
		}

		//List to store no of prime return
		ArrayList<Integer> arr=new ArrayList<>();

		switch(Method)
		{

		case 1:
			arr=PrimeChecker.methodA(FirstI,SecondI);                    //Aggregation
			print(arr,request,response);
			save(request,response,startTime,FirstI,SecondI,arr.size(),Method);   
			break;

		case 2:
			arr=PrimeChecker.methodB(FirstI,SecondI);
			print(arr,request,response);
			save(request,response,startTime,FirstI,SecondI,arr.size(),Method);
			break;
		case 3:
			request.getRequestDispatcher("Check.jsp").include(request, response);;
			out.print("please enter valid input");
			break;
		}



	}
	public void print(ArrayList<Integer> arr,HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
	{
		Iterator<Integer> itr=arr.iterator();
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("Check.jsp").include(request, response);;

		while(itr.hasNext())
		{
			out.print(itr.next()+" ");
		}
		out.close();
	}

	public void save(HttpServletRequest request,HttpServletResponse response,long startTime,int First,int Second,int size,int Method)
	{

		Connection con=null;
		try{

			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/helper?verifyServerCertificate=false&useSSL=true","root","1709");

			long endTime   = System.currentTimeMillis();
			double totalTime = endTime - startTime;

			PreparedStatement ps = con.prepareStatement("insert into finder(first_no,second_no,time_elapsed,method_chosen,quantity) values(?,?,?,?,?)");
			ps.setInt(1,First);
			ps.setInt(2,Second);
			ps.setDouble(3,totalTime/1000);
			ps.setInt(4,Method);
			ps.setInt(5,size);

			int status=ps.executeUpdate();

			if(status >0)
			{
				request.getRequestDispatcher("Check.jsp").include(request, response);;
				
			}else {
				request.getRequestDispatcher("Check.jsp").include(request, response);;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
