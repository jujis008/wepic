package com.wetuo.wepic.publish.actions ;
 
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Hibernate;

public class Image extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        this.doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            FileInputStream in = ImageUtil.getByteImage("D:\\me.jpg");
            Blob blob = Hibernate.createBlob(in);
            InputStream inputStream = blob.getBinaryStream();// IO��
            int length = (int) blob.length();
            byte[] b = new byte[length];
            inputStream.read(b, 0, length);
            PrintWriter out = resp.getWriter();
            InputStream is = new ByteArrayInputStream(b);
            int a = is.read();
            while (a != -1) {
                out.print((char) a);
                a = is.read();
            }
            out.flush();
            out.close();
            /*OutputStream outputStream = resp.getOutputStream();// ��response�л�ȡgetOutputStream
            outputStream.write(b);// д
            inputStream.close();
            outputStream.close();*/
        } catch (Exception e) {
            System.out.println("error");
        }
    }
}
