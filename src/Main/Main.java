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
	    	 Node root = new MiniJavaParser(new FileInputStream("BinarySearch.minjava")).Goal();
	    	 
	    	 System.out.println("Análise sintática e léxica concluída!");
	         
	    	 //Aqui se cria a tabela de simbolos
	         Object table=root.accept(new GJDepthFirst(),null);
	         
	         //Aqui faz a checagem de tipos
	         root.accept(new GJDepthFirstSec(),table);
	      }
	      catch (ParseException e) {
	         System.out.println("Erro Sintático : \n"+ e.toString());
	      }
	      catch(TokenMgrError e) {
	    	  System.out.println("Erro Léxico : \n"+ e.toString());
	      }
	   }
	}
