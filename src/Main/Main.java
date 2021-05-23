package Main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import parser.MiniJavaParser;
import parser.ParseException;
import parser.TokenMgrError;;

public class Main {
	   
	   public static void main(String [] args) throws FileNotFoundException {
	      try {
	    	 MiniJavaParser parser = new MiniJavaParser(new FileInputStream("Factorial.minjava"));
	    	 parser.Goal();
	         System.out.println("Análise Léxica e Sintática completa");
	      }
	      catch (ParseException e) {
	         System.out.println("Erro Sintático : \n"+ e.toString());
	      }
	      catch(TokenMgrError e) {
	    	  System.out.println("Erro Léxico : \n"+ e.toString());
	      }
	   }
	}
