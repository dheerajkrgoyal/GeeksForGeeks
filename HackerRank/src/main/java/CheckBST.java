/**
 * Created by dheeraj on 20/1/17.
 */
public class CheckBST
{
    public boolean checkBST(Node root){
        check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public check(Node root, int min, int max){
        if(root == null){
            return true;
        }

        if(root.data<min || root.data>max){
            return false;
        }

        return check(root.left, min, root.data) && check(root.right, root.data, max);
    }
}
