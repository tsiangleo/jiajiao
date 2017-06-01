<%@ page language="java" contentType="image/jpeg"  pageEncoding="UTF-8"%>
<%@ page import="java.util.*,java.awt.*, java.awt.image.*, java.io.*, java.util.*,javax.imageio.*"  %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
  </head>
  
  <body>
    
<%
	
		Random  rand = new Random();
		//创建一个内存中真彩色图片，图片大小90*30,
		BufferedImage image = new BufferedImage(90,30,1 );
		Graphics2D g = (Graphics2D)image.getGraphics();
		g.setColor(Color.WHITE);//设置白色画笔
		//填充白色的背景色
		g.fillRect(0, 0, 90, 30);
		
		
		//为了避免被识别，增加一些干扰线
		for(int i=0;i<100;i++)
		{
			//为画笔设置颜色，点的颜色
			g.setColor(Color.BLACK);
			
			int x1=rand.nextInt(100);
			int y1=rand.nextInt(29);
								
			//绘制一条随机的点
			g.drawLine(x1, y1, x1, y1);
		}
		
		//定义一个字符串sb用来保存生成的字符串序列
		StringBuilder sb =new StringBuilder();
		
		//在图片上绘制4个随机的字母
		for(int i=0;i<4;i++)
		{
			char c  = (char) (rand.nextInt(26)+65);
			sb.append(c);
			//设置字符的颜色为蓝色
			g.setColor(Color.BLUE);
			//设置字体样式、大小等
			g.setFont(new Font("Arial Black",Font.ITALIC,20));
			
			g.drawString(c+"", i*21+6, 20);
				
		}
		 session.setAttribute("character",sb+""); 		
		 //ImageIO.write(image, "jpg", response.getOutputStream());	
		 out.clear(); 
		 out = pageContext.pushBody(); 
		 ImageIO.write(image, "jpg", response.getOutputStream());		 
		 %>


  </body>
</html>
