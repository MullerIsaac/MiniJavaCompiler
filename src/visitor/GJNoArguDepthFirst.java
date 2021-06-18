//
// Generated by JTB 1.3.2
//

package visitor;
import syntaxtree.*;
import java.util.*;

/**
 * Provides default methods which visit each node in the tree in depth-first
 * order.  Your visitors may extend this class.
 */
public class GJNoArguDepthFirst<R> implements GJNoArguVisitor<R> {
   //
   // Auto class visitors--probably don't need to be overridden.
   //
   public R visit(NodeList n) {
      R _ret=null;
      int _count=0;
      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
         e.nextElement().accept(this);
         _count++;
      }
      return _ret;
   }

   public R visit(NodeListOptional n) {
      if ( n.present() ) {
         R _ret=null;
         int _count=0;
         for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
            e.nextElement().accept(this);
            _count++;
         }
         return _ret;
      }
      else
         return null;
   }

   public R visit(NodeOptional n) {
      if ( n.present() )
         return n.node.accept(this);
      else
         return null;
   }

   public R visit(NodeSequence n) {
      R _ret=null;
      int _count=0;
      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
         e.nextElement().accept(this);
         _count++;
      }
      return _ret;
   }

   public R visit(NodeToken n) { return null; }

   //
   // User-generated visitor methods below
   //

   /**
    * f0 -> MainClass()
    * f1 -> ( ClassDeclaration() )*
    * f2 -> <EOF>
    */
   public R visit(Goal n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      return _ret;
   }

   /**
    * f0 -> <CLASS>
    * f1 -> Identifier()
    * f2 -> <LBRACE>
    * f3 -> <PUBLIC>
    * f4 -> <STATIC>
    * f5 -> <VOID>
    * f6 -> <MAIN>
    * f7 -> <LPAREN>
    * f8 -> <STRING>
    * f9 -> "["
    * f10 -> "]"
    * f11 -> Identifier()
    * f12 -> <RPAREN>
    * f13 -> <LBRACE>
    * f14 -> Statement()
    * f15 -> <RBRACE>
    * f16 -> <RBRACE>
    */
   public R visit(MainClass n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
      n.f5.accept(this);
      n.f6.accept(this);
      n.f7.accept(this);
      n.f8.accept(this);
      n.f9.accept(this);
      n.f10.accept(this);
      n.f11.accept(this);
      n.f12.accept(this);
      n.f13.accept(this);
      n.f14.accept(this);
      n.f15.accept(this);
      n.f16.accept(this);
      return _ret;
   }

   /**
    * f0 -> <CLASS>
    * f1 -> Identifier()
    * f2 -> [ <EXTENDS> Identifier() ]
    * f3 -> <LBRACE>
    * f4 -> ( VarDeclaration() )*
    * f5 -> ( MethodDeclaration() )*
    * f6 -> <RBRACE>
    */
   public R visit(ClassDeclaration n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
      n.f5.accept(this);
      n.f6.accept(this);
      return _ret;
   }

   /**
    * f0 -> <PUBLIC>
    * f1 -> Type()
    * f2 -> Identifier()
    * f3 -> <LPAREN>
    * f4 -> [ Type() Identifier() ( "," Type() Identifier() )* ]
    * f5 -> <RPAREN>
    * f6 -> <LBRACE>
    * f7 -> ( VarDeclaration() )*
    * f8 -> ( Statement() )*
    * f9 -> <RETURN>
    * f10 -> Expression()
    * f11 -> ";"
    * f12 -> <RBRACE>
    */
   public R visit(MethodDeclaration n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
      n.f5.accept(this);
      n.f6.accept(this);
      n.f7.accept(this);
      n.f8.accept(this);
      n.f9.accept(this);
      n.f10.accept(this);
      n.f11.accept(this);
      n.f12.accept(this);
      return _ret;
   }

   /**
    * f0 -> Type()
    * f1 -> Identifier()
    * f2 -> ";"
    */
   public R visit(VarDeclaration n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      return _ret;
   }

   /**
    * f0 -> ( <TYPE_INT> [ "[" "]" ] )
    *       | <TYPE_BOOL>
    *       | Identifier()
    */
   public R visit(Type n) {
      R _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> ( <LBRACE> ( Statement() )* <RBRACE> )
    *       | ( <IF> <LPAREN> Expression() <RPAREN> Statement() <ELSE> Statement() )
    *       | ( <WHILE> <LPAREN> Expression() <RPAREN> Statement() )
    *       | ( <PRINT> <LPAREN> Expression() <RPAREN> ";" )
    *       | ( Identifier() [ "[" Expression() "]" ] "=" Expression() ";" )
    */
   public R visit(Statement n) {
      R _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> ( <NEW> ( ( <TYPE_INT> "[" Expression() "]" ) | ( Identifier() <LPAREN> <RPAREN> ) ) | <INTEGER_LITERAL> | <BOOLEAN_LITERAL> | Identifier() | <THIS> | ( "!" Expression() ) | ( <LPAREN> Expression() <RPAREN> ) )
    * f1 -> ( ( ( "." ( <LENGTH> | ( Identifier() <LPAREN> [ Expression() ( "," Expression() )* ] <RPAREN> ) ) ) | ( "[" Expression() "]" ) | ( <OPERATOR> Expression() ) ) )*
    */
   public R visit(Expression n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> <IDENTIFIER>
    */
   public R visit(Identifier n) {
      R _ret=null;
      n.f0.accept(this);
      return _ret;
   }

}
