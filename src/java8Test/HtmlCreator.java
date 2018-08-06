package java8Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HtmlCreator {
	
	
	static StringBuilder header;
	static StringBuilder closer;
	static StringBuilder nextPage;
	static StringBuilder footer;
	static int i;
	static int pageCount = 0;
	
	public static void main(String args[]) throws IOException{
		header = new StringBuilder();
		header.append("<html><head><title>Pale Goddess</title>" +
			"<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.0.0/jquery.min.js\"></script>");
		header.append(System.lineSeparator());
		header.append("<script async src=\"http://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js\"></script>");
		header.append(System.lineSeparator());
		header.append("<script> (adsbygoogle = window.adsbygoogle || []).push({ google_ad_client: \"ca-pub-2062482189218377\", enable_page_level_ads: true }); </script>");
		
		header.append(System.lineSeparator());
		header.append("<script src=\"jquery.unveil.js\"></script>");
		header.append(System.lineSeparator());
		header.append("<script>  $(function() { $(\"li img\").unveil(300); }); </script>");
		header.append(System.lineSeparator());
		header.append("<style> img{ max-width: 500px; max-height: 750px; } </style>");
		header.append(System.lineSeparator());
		header.append("</head>");
		header.append("<br/>");
		header.append(System.lineSeparator());
		header.append("<body> <ul>");
		header.append("<br/>");
		header.append(System.lineSeparator());

		closer = new StringBuilder();
		closer.append("<br/>");
		closer.append(System.lineSeparator());
		closer.append("</ul> ");
		
		footer = new StringBuilder();
		footer.append("</body> </html>");
		
		i = 0;
		StringBuilder imagesHtml = new StringBuilder();
		Files.walk(Paths.get("C:\\images\\images")).forEach(filePath -> {
		    if (Files.isRegularFile(filePath)) {
		    	imagesHtml.append("<li> "
		    			+ "<a href=\"" + filePath.toString().replace("C:\\images\\", "") + "\" target=\"_blank\"> "
		    			+ "<img src=\"load.jpg\" data-src=\"");
		    	imagesHtml.append(filePath.toString().replace("C:\\images\\", ""));
		    	imagesHtml.append("\" /> </a> </li>");
		    	imagesHtml.append("<br/>");
		    	imagesHtml.append(System.lineSeparator());
		    	
		    	i++;
		    	if(i >= 100){
		    		i = 0;
		    		try {
						saveHtml(imagesHtml.toString());
					} catch (Exception e) {
						e.printStackTrace();
					}
		    		
		    		imagesHtml.delete(0, imagesHtml.length());
		    	}
		    }
		});
	}
	
	private static void saveHtml(String content) throws FileNotFoundException{
		pageCount++;
		
		String append = "";
		if(pageCount ==2 )
			append = "<a href= \"C:\\images\\index" + ".html\">Previous Page </a>";
		if(pageCount  > 2 )
			append = "<a href= \"C:\\images\\index" + (pageCount-1) + ".html\">Previous Page </a>";
		
		if(pageCount == 1){
			try(  PrintWriter out = new PrintWriter( "C:\\images\\index" + ".html" )  ){
				out.println(header.toString() + content + 
						closer.toString() + "<a href= \"C:\\images\\index" + (pageCount+1) + ".html\">next Page </a>" + footer.toString());
			} 
		} else {
			try(  PrintWriter out = new PrintWriter( "C:\\images\\index" + pageCount + ".html" )  ){
				out.println(header.toString() + content + 
						closer.toString() + append + "<a href= \"C:\\images\\index" + (pageCount+1) + ".html\">next Page </a>" + footer.toString());
			} 
		}
			
		
		
	}

}
