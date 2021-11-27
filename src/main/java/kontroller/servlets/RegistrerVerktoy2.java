package kontroller.servlets;

import modell.Connector;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import java.io.IOException;

import java.io.InputStream;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Logger;


@WebServlet("/RegistrerVerktoy2")
//konfigurert max fil størrelse
@MultipartConfig(maxFileSize = 1024 * 1024 * 2)
public class RegistrerVerktoy2 extends HttpServlet {

//forward til registrerVerktoy3 ligger neste registrerVerktoy3 servlet, på samme vis som denne.
//doGet for å navigere oss til registrerVerktoy2.jsp. doGet fordi vi ønsker å hente noe, og ikke lage noe.
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("registrerVerktoy2.jsp").forward(request, response);
    }

    //doPost, fordi vi ønsker å gi applikasjonen (her databasen) noe informasjon.
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        //setContentType forteller hva HTML applikasjonen innholder og skal tolke
        PrintWriter out = response.getWriter();
        //returnerer et PrintWriter object som kan sende text til klienten
        InputStream image = null;
        //inputStream er en klasse som snakker med applikasjonen, inputStream for å laste ned/inn i applikasjonen
        //outputStram for å laste opp

        PreparedStatement ps;
        Connection con;
        Part filePart = request.getPart("image");

        if (filePart != null) {
            image = filePart.getInputStream();
        }

        try{
            String VerktoyNavn = request.getParameter("VerktoyTypeNavn");
            con = Connector.getINSTANCE().getConnection(out);
            String query = "INSERT INTO amv.VerktoyType (VerktoyTypeNavn, VerktoyBilde) values (?,?)";

            ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, VerktoyNavn);
            if (image != null) {
                ps.setBlob(2, image);
            }
            ps.execute();
            int VtID = 0;
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()){
                    VtID = (int) rs.getLong(1);

            }

               request.setAttribute("VtID", VtID);
               request.getRequestDispatcher("registrerVerktoy3.jsp").forward(request, response);
               //bruker forward og getRequestDispatcher til å gå videre til en ny ressurs
                //html, java servlet eller jsp fil



           // request.getRequestDispatcher("/RegistrerVerktoy3").forward(request, response);*/



        }
        catch(Exception ex)
        {
            ex.printStackTrace();

        }

    }


}