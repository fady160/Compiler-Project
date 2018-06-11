
package compile.code;
import java.io.*;
import java.io.IOException;
import java.util.regex.*;



public class CompileCode {

     public static String dat2,lin,tit,ven,com,nocom,deta;
    
    public static void readLines(File f) throws  IOException
    {
        try (FileReader fReader = new FileReader(f)) {
            BufferedReader reader = new BufferedReader(fReader);
            String line=null;
            while((line=reader.readLine())!=null){
                
                
                
                Pattern date = Pattern.compile("(<div class=\"item-post\" >)+(\\d+ \\w+ \\d+)+(<\\/div>)");
                 Matcher d= date.matcher(line);
                 if(d.find())
                 {
                    dat2=d.group(2);
                 }
                
                 Pattern link = Pattern.compile("(<a href=\\D{1})\\/(\\S+)(\\\")+(\\s*>)+(\\D+)+(<\\/a>)");
                 Matcher l= link.matcher(line);
                 if(l.find())
                 {
                  lin=l.group(2);
                  tit=l.group(5);
                 }
                 
                 Pattern venue = Pattern.compile("(<span style=\"color:)+(\\S+;)(\\W\\S+\">)(\\w*\\s\\S*\\s[A-Za-z0-9,\\s]*\\-\\s[A-Za-z0-9,\\s+,\\:\\-]*)+(<\\/span><br \\/>)");
                 Matcher v= venue.matcher(line);
                 if(v.find())
                 {
                  ven=v.group(4);
                  
                 }
                 
                 
                 Pattern comment = Pattern.compile("(<a class=\\\"item-comments\\\" href=\\\")([A-Za-z,\\/,\\-]*\\#+\\w*)(\\\">)");
                 Matcher c= comment.matcher(line);
                 if(c.find())
                 {
                  com=c.group(2);
                 
                 }
                  Pattern e = Pattern.compile("\\s+(\\d+\\s(comment))\\s+\\<\\/a>");
                 Matcher ce= e.matcher(line);
                 if(ce.find())
                 {
                      nocom=ce.group(1);       
                 }
                         
                //cannot find a way to get the pattern to read the next line !!         
                 Pattern detail = Pattern.compile("\\s*(<p style=\"font-size: 16px;\">)^(\\s*[A-Za-z\\s\\.]*)$",Pattern.CASE_INSENSITIVE|Pattern.MULTILINE);
                 Matcher de= detail.matcher(line);
                 if(de.find())
                 {
                  deta=de.group();
                 
                 }
                 
    
        }
   }      
    }
    
    public static void main(String[] args) {
          File f = new File("File.txt");
        
        try{
            readLines(f);
            
        }
        catch (IOException e){
            e.printStackTrace();
        }
        
        System.out.format("Date:'%s'\n", dat2);
        System.out.format("Comments Link:'%s'\n", com);
       System.out.format("Number of Comments:'%s'\n", nocom);
        System.out.format("Link:'%s'\n", lin);
        System.out.format("Title:'%s'\n", tit);
        System.out.format("Venue:'%s'\n", ven);
        System.out.format("Detail:'%s'\n", deta);
        
    
    }
}





    