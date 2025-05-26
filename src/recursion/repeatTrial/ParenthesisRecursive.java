package src.recursion.repeatTrial;

//Backtracking
//size = 4,
// generate all permutations of balanced parenthesis string of given size
public class ParenthesisRecursive {
    public static void main(String[] args) {
        int size=2;
        parenthesisGenerator("",0,0,size);
    }
    private static void parenthesisGenerator(String str, int left, int right,int size) {
        if(str.length()==size*2) {
            System.out.print(str+" ,");
            return;
        }
        if(left<size) {
            parenthesisGenerator(str+"(",left+1,right,size);
        }
        if(right<size && right<left)
            parenthesisGenerator(str+")", left, right+1, size);
    }
}
