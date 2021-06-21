package Main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import parser.MiniJavaParser;
import parser.ParseException;
import parser.TokenMgrError;
import syntaxtree.*;
import visitor.*;

public class Main {
	   
	   public static void main(String [] args) throws FileNotFoundException {
	      try {
	    	 Node root = new MiniJavaParser(new FileInputStream("Factorial.minjava")).Goal();
	    	 
	    	 System.out.println("Análise sintática e léxica concluída!");
	         
	         Object table=root.accept(new GJDepthFirst(),null); // Your assignment part is invoked here.
	         root.accept(new GJDepthFirst(),table);
	      }
	      catch (ParseException e) {
	         System.out.println("Erro Sintático : \n"+ e.toString());
	      }
	      catch(TokenMgrError e) {
	    	  System.out.println("Erro Léxico : \n"+ e.toString());
	      }
	   }
	}
