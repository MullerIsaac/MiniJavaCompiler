package Main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Iterator;

import parser.MiniJavaParser;
import parser.ParseException;
import parser.TokenMgrError;
import syntaxtree.*;
import visitor.*;
import types.*;

public class Main {
	
	   static PrintWriter IRprinter = new PrintWriter(System.out);
	   
	   public static void main(String [] args) throws FileNotFoundException {
	      try {
	    	 Node root = new MiniJavaParser(new FileInputStream("Factorial.minjava")).Goal();
	    	 
	    	 System.out.println("Análise sintática e léxica concluída!");
	         
	    	 //Aqui se cria a tabela de simbolos
	         Object table=root.accept(new GJDepthFirst(),null);
	         
	         //Aqui faz a checagem de tipos
	         root.accept(new GJDepthFirstSec(),table);
	         
	         MJType classes = new MJClasses();
	         root.accept(new GJFillTable(), classes);
	         
	         Translate translate = new Translate(new Mips.MipsFrame());
	         root.accept(translate, (MJClasses)classes);
	         
	         for (Iterator<visitor.Frag> frags = translate.getResults();
	        	     frags.hasNext(); ) {
	        	    
	        	    Frag f = frags.next();

	        	    if (f instanceof ProcFrag){
	        		Temp.TempMap tempmap
	        		   = new Temp.CombineMap(((ProcFrag)f).frame, 
	        					  new Temp.DefaultMap());

	        		IRprinter.println("Procedimento :" + ((ProcFrag)f).frame.name);

	        		if (((ProcFrag)f).body != null) 
	        		    new Tree.Print(IRprinter, tempmap, ((ProcFrag)f).body);
	        	    }
	        	}
	        	IRprinter.flush();
	      }
	      catch (ParseException e) {
	         System.out.println("Erro Sintático : \n"+ e.toString());
	      }
	      catch(TokenMgrError e) {
	    	  System.out.println("Erro Léxico : \n"+ e.toString());
	      }
	   }
	}
