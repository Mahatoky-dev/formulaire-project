package controleur;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import dao.FileObjectWriter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FormServlet extends HttpServlet {

    private FileObjectWriter fow = new FileObjectWriter("listeObject");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // recuperer la liste des donnes recu
        HashMap<String, String[]> dataGet = new HashMap<>(request.getParameterMap());

        // initialisation du fichier si necessaire
        if (!fow.fileExiste()) {
            this.initObjectInFile(request);
        }
        
        // ecriture le donnes recu dans le fichier
        writetRowOfRequest(request);

        // redirecition vers la page home
        RequestDispatcher rd = request.getRequestDispatcher("jsp/home.jsp");
        rd.forward(request, response);
    }

    private void initObjectInFile(HttpServletRequest request) {
        try {
            fow.initObjectInFile(Class.forName(request.getParameter("class")));
            request.setAttribute("class", Class.forName(request.getParameter("class")));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void writetRowOfRequest(HttpServletRequest request) {
        String row = "";
        HashMap<String, String[]> dataRequest = new HashMap<>(request.getParameterMap());
        for(Map.Entry<String,String[]> data : dataRequest.entrySet()) {
            row +=  data.getKey();
            row += "->";
            row += data.getValue()[0];
            row += ";;";
        }
        fow.writetRow(row);
    }
}
