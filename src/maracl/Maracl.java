package maracl;

import java.io.File;
import java.io.FileWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
 
public class Maracl {

	public static void main(String[] args) throws SQLException, ClassNotFoundException, Exception {
		            
             
                String db_server = args[0];
                String db_name = null;
                String db_user = null ;
                String db_password = null;
                String sqlin = null;
                String xmlout = "1";
                String path2go = null;
                
                if (null != db_server) 
                        switch (db_server) {
            //Interactive mode
            case "-i":{
                    ASCII(db_server).forEach(System.out::println);
                    
                    Scanner scanner = new Scanner(System.in);
                    System.out.print(" Server address [localhost]: ");
                    db_server = scanner.nextLine();
                    if (db_server.matches("\\d+")) {
                        db_server = "localhost";
                                        }
                    System.out.print(" DB name: ");
                    db_name = scanner.next();
                    System.out.print(" DB User: ");
                    db_user = scanner.next();
                    System.out.print(" Password: ");
                    db_password = scanner.next();
                    System.out.print(" Input SQL: ");
                    sqlin = new Scanner (new File(scanner.next())).useDelimiter("\\A").next();
                    System.out.print(" Output XML: ");
                    xmlout =  scanner.next();
                    path2go = "i";
                    break;
                }
            //Export PM_LOOKUP_DEFINTION
            case "-ld":{
                    ASCII(db_server).forEach(System.out::println);

                    Scanner scanner = new Scanner(System.in);
                    System.out.print(" Server address [localhost]: ");
                    db_server = scanner.nextLine();
                    if (db_server.matches("\\d+")) {
                        db_server = "localhost";
                                       }
                    System.out.print(" DB name: ");
                    db_name = scanner.next();
                    System.out.print(" DB User: ");
                    db_user = scanner.next();
                    System.out.print(" Password: ");
                    db_password = scanner.next();
                    sqlin = new Scanner (new File("sql/PM.LOOKUPNAME.sql")).useDelimiter("\\A").next();
                    xmlout =  "output/PM.LOOKUPNAME.xml";
                    path2go = "i";
                        break;
                }
            //Export PM_LOOKUP_VALUE
            case "-lv":{
                    ASCII(db_server).forEach(System.out::println);

                    Scanner scanner = new Scanner(System.in);
                    System.out.print(" Server address [localhost]: ");
                    db_server = scanner.nextLine();
                    if (db_server.matches("\\d+")) {
                        db_server = "localhost";
                                       }
                    System.out.print(" DB name: ");
                    db_name = scanner.next();
                    System.out.print(" DB User: ");
                    db_user = scanner.next();
                    System.out.print(" Password: ");
                    db_password = scanner.next();
                    sqlin = new Scanner (new File("sql/PM.LOOKUPVALUE.sql")).useDelimiter("\\A").next();
                    xmlout =  "output/PM.LOOKUPVALUE.xml";
                    path2go = "i";
                        break;
                }
            //Export PM_MARKET_INDEX
            case "-mi":{
                    ASCII(db_server).forEach(System.out::println);

                    Scanner scanner = new Scanner(System.in);
                    System.out.print(" Server address [localhost]: ");
                    db_server = scanner.nextLine();
                    if (db_server.matches("\\d+")) {
                        db_server = "localhost";
                                       }
                    System.out.print(" DB name: ");
                    db_name = scanner.next();
                    System.out.print(" DB User: ");
                    db_user = scanner.next();
                    System.out.print(" Password: ");
                    db_password = scanner.next();
                    sqlin = new Scanner (new File("sql/PM.MKTINDEX.sql")).useDelimiter("\\A").next();
                    xmlout =  "output/PM.MKTINDEX.xml";
                    path2go = "i";
                        break;
                }
            //Export PM_PRICE_ITEM
            case "-pi":{
                    ASCII(db_server).forEach(System.out::println);

                    Scanner scanner = new Scanner(System.in);
                    System.out.print(" Server address [localhost]: ");
                    db_server = scanner.nextLine();
                    if (db_server.matches("\\d+")) {
                        db_server = "localhost";
                                       }
                    System.out.print(" DB name: ");
                    db_name = scanner.next();
                    System.out.print(" DB User: ");
                    db_user = scanner.next();
                    System.out.print(" Password: ");
                    db_password = scanner.next();
                    sqlin = new Scanner (new File("sql/PM.PRICEITEMDATA.sql")).useDelimiter("\\A").next();
                    xmlout =  "output/PM.PRICEITEMDATA.xml";
                    path2go = "i";
                        break;
                }         
            //Export PM_PRICE_RECORD
            case "-pr":{
                    ASCII(db_server).forEach(System.out::println);

                    Scanner scanner = new Scanner(System.in);
                    System.out.print(" Server address [localhost]: ");
                    db_server = scanner.nextLine();
                    if (db_server.matches("\\d+")) {
                        db_server = "localhost";
                                       }
                    System.out.print(" DB name: ");
                    db_name = scanner.next();
                    System.out.print(" DB User: ");
                    db_user = scanner.next();
                    System.out.print(" Password: ");
                    db_password = scanner.next();
                    sqlin = new Scanner (new File("sql/PM.SAPCONDTBLDATA.sql")).useDelimiter("\\A").next();
                    xmlout =  "output/PM.SAPCONDTBLDATA.xml";
                    path2go = "i";
                        break;
                }    
            //Export PM_UNIT_OF_MEASURE
            case "-uom":{
                    ASCII(db_server).forEach(System.out::println);

                    Scanner scanner = new Scanner(System.in);
                    System.out.print(" Server address [localhost]: ");
                    db_server = scanner.nextLine();
                    if (db_server.matches("\\d+")) {
                        db_server = "localhost";
                                       }
                    System.out.print(" DB name: ");
                    db_name = scanner.next();
                    System.out.print(" DB User: ");
                    db_user = scanner.next();
                    System.out.print(" Password: ");
                    db_password = scanner.next();
                    sqlin = new Scanner (new File("sql/PM.SAPUOM.sql")).useDelimiter("\\A").next();
                    xmlout =  "output/PM.SAPUOM.xml";
                    path2go = "i";
                        break;
                }               
            //Export SY_ROLE_PRIVILEGE
            case "-sy3":{
                    ASCII(db_server).forEach(System.out::println);

                    Scanner scanner = new Scanner(System.in);
                    System.out.print(" Server address [localhost]: ");
                    db_server = scanner.nextLine();
                    if (db_server.matches("\\d+")) {
                        db_server = "localhost";
                                       }
                    System.out.print(" DB name: ");
                    db_name = scanner.next();
                    System.out.print(" DB User: ");
                    db_user = scanner.next();
                    System.out.print(" Password: ");
                    db_password = scanner.next();
                    sqlin = new Scanner (new File("sql/SY.ROLEPRIVILEGE.sql")).useDelimiter("\\A").next();
                    xmlout =  "output/3.SY.ROLEPRIVILEGE.xml";
                    path2go = "i";
                        break;
                }     
            //Export SY_ROLES
            case "-sy2":{
                    ASCII(db_server).forEach(System.out::println);

                    Scanner scanner = new Scanner(System.in);
                    System.out.print(" Server address [localhost]: ");
                    db_server = scanner.nextLine();
                    if (db_server.matches("\\d+")) {
                        db_server = "localhost";
                                       }
                    System.out.print(" DB name: ");
                    db_name = scanner.next();
                    System.out.print(" DB User: ");
                    db_user = scanner.next();
                    System.out.print(" Password: ");
                    db_password = scanner.next();
                    sqlin = new Scanner (new File("sql/SY.ROLES.sql")).useDelimiter("\\A").next();
                    xmlout =  "output/2.SY.ROLES.xml";
                    path2go = "i";
                        break;
                }               
            //Export SY_USER_ACCOUNT (USER_INFO)
            case "-sy1":{
                    ASCII(db_server).forEach(System.out::println);

                    Scanner scanner = new Scanner(System.in);
                    System.out.print(" Server address [localhost]: ");
                    db_server = scanner.nextLine();
                    if (db_server.matches("\\d+")) {
                        db_server = "localhost";
                                       }
                    System.out.print(" DB name: ");
                    db_name = scanner.next();
                    System.out.print(" DB User: ");
                    db_user = scanner.next();
                    System.out.print(" Password: ");
                    db_password = scanner.next();
                    sqlin = new Scanner (new File("sql/SY.USERACCOUNT.sql")).useDelimiter("\\A").next();
                    xmlout =  "output/1.SY.USERACCOUNT.xml";
                    path2go = "i";
                        break;
                }             
            //Export SY_USER_ROLE
            case "-sy4":{
                    ASCII(db_server).forEach(System.out::println);

                    Scanner scanner = new Scanner(System.in);
                    System.out.print(" Server address [localhost]: ");
                    db_server = scanner.nextLine();
                    if (db_server.matches("\\d+")) {
                        db_server = "localhost";
                                       }
                    System.out.print(" DB name: ");
                    db_name = scanner.next();
                    System.out.print(" DB User: ");
                    db_user = scanner.next();
                    System.out.print(" Password: ");
                    db_password = scanner.next();
                    sqlin = new Scanner (new File("sql/SY.USERROLE.sql")).useDelimiter("\\A").next();
                    xmlout =  "output/4.SY.USERACCOUNT.xml";
                    path2go = "i";
                        break;
                }              
            //Export SY_WORKTEAMS
            case "-sy5":{
                    ASCII(db_server).forEach(System.out::println);

                    Scanner scanner = new Scanner(System.in);
                    System.out.print(" Server address [localhost]: ");
                    db_server = scanner.nextLine();
                    if (db_server.matches("\\d+")) {
                        db_server = "localhost";
                                       }
                    System.out.print(" DB name: ");
                    db_name = scanner.next();
                    System.out.print(" DB User: ");
                    db_user = scanner.next();
                    System.out.print(" Password: ");
                    db_password = scanner.next();
                    sqlin = new Scanner (new File("sql/SY.WORKTEAM.sql")).useDelimiter("\\A").next();
                    xmlout =  "output/5.SY.WORKTEAM.xml";
                    path2go = "i";
                        break;
                }              
            //Export SY_USER_WORKTEAMS
            case "-sy6":{
                    ASCII(db_server).forEach(System.out::println);

                    Scanner scanner = new Scanner(System.in);
                    System.out.print(" Server address [localhost]: ");
                    db_server = scanner.nextLine();
                    if (db_server.matches("\\d+")) {
                        db_server = "localhost";
                                       }
                    System.out.print(" DB name: ");
                    db_name = scanner.next();
                    System.out.print(" DB User: ");
                    db_user = scanner.next();
                    System.out.print(" Password: ");
                    db_password = scanner.next();
                    sqlin = new Scanner (new File("sql/SY.USERWORKTEAM.sql")).useDelimiter("\\A").next();
                    xmlout =  "output/6.SY.USERWORKTEAM.xml";
                    path2go = "i";
                        break;
                }     
            //Export SY_SCRIPTS
            case "-sc":{
                    ASCII(db_server).forEach(System.out::println);

                    Scanner scanner = new Scanner(System.in);
                    System.out.print(" Server address [localhost]: ");
                    db_server = scanner.nextLine();
                    if (db_server.matches("\\d+")) {
                        db_server = "localhost";
                                       }
                    System.out.print(" DB name: ");
                    db_name = scanner.next();
                    System.out.print(" DB User: ");
                    db_user = scanner.next();
                    System.out.print(" Password: ");
                    db_password = scanner.next();
                    sqlin = new Scanner (new File("sql/SY.SCRIPTDATA.sql")).useDelimiter("\\A").next();
                    xmlout =  "output/SY.SCRIPTDATA.xml";
                    path2go = "i";
                        break;
                }              
            default:
                    db_name = args[1];
                    db_user = args[2];
                    db_password = args[3];
                    sqlin = new Scanner (new File(args[4])).useDelimiter("\\A").next();
                    xmlout = args[5];
                    path2go = "c";
                    break;
        }
 
                
                
                //DATABASE CONNECTION
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
		Connection conn = DriverManager.getConnection("jdbc:sqlserver://" + db_server + ";user="+ db_user + ";password="+ db_password + ";database=" + db_name);
		Statement sta = conn.createStatement();
                
		ResultSet rs = sta.executeQuery(sqlin);
      
                String result = new String();
		
                    while (rs.next()){
                                           
                          result = result.concat(rs.getString(1));
                                                                        
                          }
                    
                //XML GENERATION    
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setValidating(false);
		DocumentBuilder db = dbf.newDocumentBuilder();	
                InputSource is = new InputSource();
                is.setCharacterStream(new StringReader(result));
                           
                Document doc = db.parse(is);
                            
                Transformer tf = TransformerFactory.newInstance().newTransformer();
		
                tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		tf.setOutputProperty(OutputKeys.INDENT, "yes");
                tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
		Writer out = new StringWriter();
                               
		tf.transform(new DOMSource(doc), new StreamResult(out));
                
                xmlout = xmlout.replaceAll(".xml","").replaceAll(".sql", "");
                        
                String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
                
                 try (FileWriter fw = new FileWriter(xmlout + "." + timeStamp + ".xml")) {
                fw.write(out.toString());
                fw.close();
                        
                    if ("i".equals(path2go))
                    {    
                        System.out.println("");
                        System.out.println("Mara finished creating " + xmlout + "." + timeStamp + ".xml");
                    }
           
               }

        }
        
    
        private static ArrayList<String> ASCII(String input) {
        
        ArrayList<String> ascii;
        ascii = new ArrayList<>();
        
        String message = "Export of ";
        
         if (  !"-".startsWith(input)) 
            {
                if (null != input) switch (input) {
                case "-ld":
                    message = message.concat("PM_LOOKUP_DEFINTION");
                    break;
                case "-i":
                    message = message.concat("user defined tables");
                    break;
                case "-lv":
                    message = message.concat("PM_LOOKUP_VALUE");
                    break;
                case "-mi":
                    message = message.concat("PM_MARKET_INDEX");
                    break; 
                case "-pi":
                    message = message.concat("PM_PRICE_ITEM");
                    break;  
                case "-pr":
                    message = message.concat("PM_CONDITION_DATA");
                    break;  
                case "-uom":
                    message = message.concat("PM_UNIT_OF_MEASURE");
                    break;  
                case "-sy1":
                    message = message.concat("SY_USER_ACCOUNT");
                    break;                      
                case "-sy2":
                    message = message.concat("SY_ROLES");
                    break;                      
                case "-sy3":
                    message = message.concat("SY_ROLE_PRIVILEGE");
                    break;                      
                case "-sy4":
                    message = message.concat("SY_USER_ROLES");
                    break;                      
                case "-sy5":
                    message = message.concat("SY_WORKTEAMS");
                    break;                      
                case "-sy6":
                    message = message.concat("SY_USER_WORKTEAM");
                    break; 
                case "-sc":
                    message = message.concat("SY_SCRIPTS");
                    break;                      
                default:
                    break;
            }
                                   

          String line1 =  ("*____________________________________________________________________________________________________________________________________________*");
          String line2 = ("*  ##     ##    ###    ########     ###       #### ##    ## ######## ######## ########     ###     ######  ######## #### ##     ## ########  *");
          String line3 = ("*  ###   ###   ## ##   ##     ##   ## ##       ##  ###   ##    ##    ##       ##     ##   ## ##   ##    ##    ##     ##  ##     ## ##        *");
          String line4 = ("*  #### ####  ##   ##  ##     ##  ##   ##      ##  ####  ##    ##    ##       ##     ##  ##   ##  ##          ##     ##  ##     ## ##        *");
          String line5 = ("*  ## ### ## ##     ## ########  ##     ##     ##  ## ## ##    ##    ######   ########  ##     ## ##          ##     ##  ##     ## ######    *");
          String line6 = ("*  ##     ## ######### ##   ##   #########     ##  ##  ####    ##    ##       ##   ##   ######### ##          ##     ##   ##   ##  ##        *");
          String line7 = ("*  ##     ## ##     ## ##    ##  ##     ##     ##  ##   ###    ##    ##       ##    ##  ##     ## ##    ##    ##     ##    ## ##   ##        *");
          String line8 = ("*  ##     ## ##     ## ##     ## ##     ##    #### ##    ##    ##    ######## ##     ## ##     ##  ######     ##    ####    ###    ########  *");
          String line9 = ("*_____________________________________________________THE GREAT MIGRATION____________________________________________________________________*");
          String line10 = "";
          String line11 = (message);
          String line12 = "";
          String line13 = ("*____________________________________________________________________________________________________________________________________________*");
          String line14 = "";
  
          ascii.add(line1);
          ascii.add(line2);
          ascii.add(line3);
          ascii.add(line4);
          ascii.add(line5);
          ascii.add(line6);
          ascii.add(line7);
          ascii.add(line8);
          ascii.add(line9);
          ascii.add(line10);
          ascii.add(line11);
          ascii.add(line12);
          ascii.add(line13);
          ascii.add(line14);
            } 
            
            return ascii;
    }
        
        
}