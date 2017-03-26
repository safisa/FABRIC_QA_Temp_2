//package com.k2view.cdbms.lu.JavaResTest;
package JavaResTest;

import org.apache.commons.io.IOUtils;
import java.util.*;
import java.sql.*;
import java.math.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
import com.k2view.cdbms.shared.*;
import com.k2view.cdbms.sync.*;
import com.k2view.cdbms.lut.*;
import com.k2view.cdbms.shared.logging.LogEntry.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class javaTest1 {
	static Logger log = LoggerFactory.getLogger((String)javaTest1.class.getName());
	
	public static void main(String[] args) throws IOException, URISyntaxException {
		//String s = JavaResTest.javaTest1.getSomeText("dd");
		String s = javaTest1.readResourceFile("resTest1.xml");
		System.out.println(s);
		
		String s1 = Demo1.Test.replaceAll("abc 123", "\\d+", "000");
	}

    public static String readResourceFile(String resFileName) throws IOException, URISyntaxException {
		String content = null;
		resFileName = "" + resFileName;
		log.info("resFileName: {}", resFileName);
		
		URL url = javaTest1.class.getClassLoader().getResource(resFileName);
		log.info("URI: {}", url.toURI());
		
		java.nio.file.Path s = java.nio.file.Paths.get(System.getProperty("java.io.tmpdir"), "tmp.txt");
		
		
		//File file = new File(javaTest1.class.getClassLoader().getResource(resFileName).getFile());
		//log.info("getAbsolutePath: " + file.getAbsolutePath());
		
//		List<String> lines = Files.readAllLines(Paths.get(file.getAbsolutePath()));
//        StringBuilder sb = new StringBuilder();
//        for (String line : lines) {
//            sb.append(line);
//        }
//        String contents = sb.toString();
//        log.info("contents: " + contents);
		

		try (InputStream inputStream = javaTest1.class.getClassLoader().getResourceAsStream(resFileName)){
	        if (inputStream == null) {
	            log.info("inputStream is null - {}", resFileName);
	        } else {
				content = IOUtils.toString(inputStream);
				log.info("content: " + content);
			}
		}
		return content;    
    }

    public static String getSomeText(String in) {
        return "javaTest1.getSomeText: " + in;
    }
}
