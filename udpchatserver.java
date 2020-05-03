import java.io.*; 
import java.net.*; 
 
public class EchoClient 
{ 
public static void main(String args[]) throws Exception 
{ try { int Port; 
BufferedReader Buf =new BufferedReader(new 
InputStreamReader(System.in)); 
System.out.print(" Enter the Port Address : " ); 
Port=Integer.parseInt(Buf.readLine()); Socket sok=new Socket("localhost",Port); 
if(sok.isConnected()==true) 
 System.out.println(" Server Socket is Connected Succecfully. "); 
InputStream in=sok.getInputStream(); 
OutputStream ou=sok.getOutputStream(); 
PrintWriter pr=new PrintWriter(ou); 
BufferedReader buf1=new BufferedReader(new 
InputStreamReader(System.in)); 
BufferedReader buf2=new BufferedReader(new 
InputStreamReader(in)); 
String str1,str2; 
System.out.print(" Enter the Message : "); 
str1=buf1.readLine(); 
pr.println(str1); pr.flush(); 
System.out.println(" Message Send Successfully. "); 
str2=buf2.readLine(); 
System.out.println(" Message From Server : " + str2); 
     } 
  catch(Exception e) 
  { 
   System.out.println(" Error : " + e.getMessage()); 
  } 
} 
} 
  
          udpserver

import java.io.*; import java.net.*; 
class UDPServer 
{ 
public static DatagramSocket serversocket; 
public static DatagramPacket dp; 
public static BufferedReader dis; public static InetAddress ia;
 public static byte buf[] = new byte[1024]; public static int cport = 789,sport=790; 
public static void main(String[] a) throws IOException 
{ 
serversocket = new DatagramSocket(sport); dp = new DatagramPacket(buf,buf.length); dis = new BufferedReader 
(new InputStreamReader(System.in)); ia = InetAddress.getLocalHost(); 
System.out.println("Server is Running..."); while(true) 
{ 
serversocket.receive(dp); 
String str = new String(dp.getData(), 0, dp.getLength()); 
if(str.equals("STOP")) 
{ 
System.out.println("Terminated..."); 
break; 
} 
System.out.println("Client: " + str); 
String str1 = new String(dis.readLine()); buf = str1.getBytes(); serversocket.send(new 
DatagramPacket(buf,str1.length(), ia, cport)); 
} 
} 
} 



