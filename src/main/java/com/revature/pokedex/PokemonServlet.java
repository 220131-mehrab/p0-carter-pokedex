package com.revature.pokedex;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class PokemonServlet extends HttpServlet
{
    public PokemonServlet(){}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    {
        try
        {
            resp.getWriter().println("<html>" +
                    "                 <head>" +
                    "                     <title>Welcome to the Pok&eacute;mon Search App</title>" +
                    "                     <script>" +
                    "                       function ClickedBox() {" +
                    "                           searchBox = document.getElementById('searchBox');" +
                    "                           searchBox.value = '';" +
                    "                       }" +
                    "                       </script>" +
                    "                 </head>" +
                    "                 <body style='color:#4d4d4d; background-color:#e7e7e7;'>" +
                    "                   <br><br><br><br>" +
                    "                   <center>" +
                    "                   <div style='width:50%; align:center;background-color :#e7e7e7; border-color:#676767; border-width:5px;'>" +
                    "                       <h1><b><u>&nbsp;&nbsp;Welcome to the Pok&eacute;mon Search App&nbsp;&nbsp;</u></b></h1>" +
                    "                       <form name='PokemonForm' action='pokemon' method='get'>" +
                    "                           <input id='searchBox' type=name name='searchName' value='Search Field' onclick='ClickedBox()'>" +
                    "                           <input type=submit value='Search Through Pok&eacute;mon'>" +
                    "                   </form><br><a href='/search' method='get'>See full list of Pok&eacute;mon</e></a><br><br><br>" +
                    "                   </div>" +
                    "                   <br><br><hr width=50%><br><br><br><br><br><br><br>" +
                    "               </center></body></head></html>");
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
