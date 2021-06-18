//
// Generated by JTB 1.3.2
//

package syntaxtree;

/**
 * Grammar production:
 * f0 -> ( <NEW> ( ( <TYPE_INT> "[" Expression() "]" ) | ( Identifier() <LPAREN> <RPAREN> ) ) | <INTEGER_LITERAL> | <BOOLEAN_LITERAL> | Identifier() | <THIS> | ( "!" Expression() ) | ( <LPAREN> Expression() <RPAREN> ) )
 * f1 -> ( ( ( "." ( <LENGTH> | ( Identifier() <LPAREN> [ Expression() ( "," Expression() )* ] <RPAREN> ) ) ) | ( "[" Expression() "]" ) | ( <OPERATOR> Expression() ) ) )*
 */
public class Expression implements Node {
   public NodeChoice f0;
   public NodeListOptional f1;

   public Expression(NodeChoice n0, NodeListOptional n1) {
      f0 = n0;
      f1 = n1;
   }

   public void accept(visitor.Visitor v) {
      v.visit(this);
   }
   public <R,A> R accept(visitor.GJVisitor<R,A> v, A argu) {
      return v.visit(this,argu);
   }
   public <R> R accept(visitor.GJNoArguVisitor<R> v) {
      return v.visit(this);
   }
   public <A> void accept(visitor.GJVoidVisitor<A> v, A argu) {
      v.visit(this,argu);
   }
}

