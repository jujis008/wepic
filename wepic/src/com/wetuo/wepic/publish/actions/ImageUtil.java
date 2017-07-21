package com.wetuo.wepic.publish.actions;

import java.io.File;                                                                                           
import java.io.FileInputStream;                                                                                
import java.io.FileNotFoundException;                                                                          
import java.io.FileOutputStream;                                                                               
import java.io.IOException;                                                                                    
 public class ImageUtil {                                                                                      
    private static File file = null;                                                                           
    /**                                                                                                        
     * ��ȡͼ��Ķ�������                                                                                      
     *                                                                                                         
     * @param infile                                                                                           
     * @return                                                                                                 
     */                                                                                                        
    public static FileInputStream getByteImage(String infile) {                                                
        FileInputStream inputImage = null;                                                                     
        file = new File(infile);                                                                               
        try {                                                                                                  
            inputImage = new FileInputStream(file);                                                            
        } catch (FileNotFoundException e) {                                                                    
            e.printStackTrace();                                                                               
        }                                                                                                      
        return inputImage;                                                                                     
    }                                                                                                          
    /**                                                                                                        
     * ���ͼƬ                                                                                                
     * @param inputStream                                                                                      
     * @param path                                                                                             
     */                                                                                                        
    public static void readBlob(FileInputStream inputStream, String path) {                                    
        try {                                                                                                  
            FileOutputStream fileOutputStream = new FileOutputStream(path);                                    
            byte[] buf = new byte[1024];                                                                       
            int len = 0;                                                                                       
            while ((len = inputStream.read(buf)) != -1) {                                                      
                fileOutputStream.write(buf, 0, len);// д                                                      
             }                                                                                                 
            inputStream.close();                                                                               
            fileOutputStream.close();                                                                          
        } catch (FileNotFoundException e) {                                                                    
            e.printStackTrace();                                                                               
        } catch (IOException e) {                                                                              
            e.printStackTrace();                                                                               
        }                                                                                                      
    }                                                                                                          

    /*
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
            outputStream.close();                                                             
        } catch (Exception e) {                                                                    
            System.out.println("error");                                                           
        }                                                                                          
    }                                                                 
    */
    
    
    
 }//end class
 
