class Solution {
    private StringBuilder path;
    private String ans;
    public String smallestFromLeaf(TreeNode root) {
        path = new StringBuilder();
        ans = String.valueOf((char)('z' + 1));
        dfs(root, path);
        return ans;
    }

    private void dfs(TreeNode root, StringBuilder path) {
        if(root != null) {
            path.append((char)('a' + root.val));
            if(root.left == null && root.right == null) {
                String t = path.reverse().toString();
                if(t.compareTo(ans)<0){
                    ans = t;
                }
                
                path.reverse();
            }
            dfs(root.left, path);
            dfs(root.right, path);
            path.deleteCharAt(path.length()-1);
        }
    }
}