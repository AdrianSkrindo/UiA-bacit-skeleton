package kontroller.servlets;

import modell.loggInn.BrukerDB;
import modell.loggInn.DBUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@WebServlet("/RegistrerVerktoy3")
public class RegistrerVerktoy3 extends HttpServlet {


    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.sendRedirect("registrerVerktoy3.jsp");
    }


    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        //setContentType forteller hva HTML applikasjonen innholder og skal tolke
        PrintWriter out = res.getWriter();
        //returnerer et PrintWriter object som kan sende text til klienten
        PreparedStatement ps;
        Connection con;

        //H
        String Gratis = (req.getParameter("Gratis")).toLowerCase();
        System.out.println(Gratis);
        String Kostnad = req.getParameter("Kostnad");
        System.out.println(Kostnad);
        String VerktoyID = req.getParameter("VtID");
        System.out.println(VerktoyID);

        //string her må matche setString under.

        int Maksdager = 4;


        try {

            //.getConnection, for database connection
            con = DBUtils.getINSTANCE().getConnection(out);
            //"?" for placeholder, forvi vi ønsker å sette inn en verdi (parameter) isteden for å
            //harkode selve insert into, åpner opp for mulighet til å sette forksjellige ting inn i databasen
            String query = "INSERT INTO Verktoy (VerktoyTypeID, Tilgjenglighet, Maksdager, Gratis, Kostnad) values (?,?,?,?,?)";
            //
            ps = con.prepareStatement(query);

            ps.setString(1, VerktoyID);
            ps.setBoolean(2, true);
            ps.setInt(3, Maksdager);
            ps.setBoolean(4, Boolean.parseBoolean(Gratis));
            ps.setString(5, Kostnad);

            ps.execute();
            res.sendRedirect("hjem.jsp");

// STACKTRACE, skriver ut feilmelding ved error
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
