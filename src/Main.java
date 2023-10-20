// 10.10 Rank from Stream: Imagine you are reading in a stream of integers. Periodically, you wish to be able
//to look up the rank of a numberx (the number of values less than or equal to x). lmplementthe data
//structures and algorithms to support these operations. That is, implement the method track ( int
//x), which is called when each number is generated, and the method getRankOfNumber(int
//x), which returns the number of values less than or equal to x (not including x itself).
//EXAMPLE
//Stream (in order of appearance): 5, 1, 4, 4, 5, 9, 7, 13, 3
//getRankOfNumber(1) = 0
//getRankOfNumber(3) = 1
//getRankOfNumber(4) = 3



class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
    int leftCount;

    public TreeNode(int value) {
        this.value = value;
        this.leftCount = 0;
    }
}

class RankFromStream {
    private TreeNode root;

    public void track(int x) {
        root = insert(root, x);
    }

    private TreeNode insert(TreeNode node, int x) {
        if (node == null) {
            return new TreeNode(x);
        }

        if (x <= node.value) {
            node.left = insert(node.left, x);
            node.leftCount++;
        } else {
            node.right = insert(node.right, x);
        }

        return node;
    }

    public int getRankOfNumber(int x) {
        return getRank(root, x);
    }

    private int getRank(TreeNode node, int x) {
        if (node == null) {
            return 0;
        }

        if (x == node.value) {
            return node.leftCount;
        } else if (x < node.value) {
            if (node.left != null) {
                return getRank(node.left, x);
            } else {
                return 0;
            }
        } else {
            int rightRank = getRank(node.right, x);
            if (rightRank == 0) {
                return node.leftCount + 1;
            } else {
                return node.leftCount + 1 + rightRank;
            }
        }
    }

    public static void main(String[] args) {
        RankFromStream ranker = new RankFromStream();
        int[] stream = {5, 1, 4, 4, 5, 9, 7, 13, 3};

        for (int num : stream) {
            ranker.track(num);
        }

        System.out.println(ranker.getRankOfNumber(1)); // Output: 0
        System.out.println(ranker.getRankOfNumber(3)); // Output: 1
        System.out.println(ranker.getRankOfNumber(4)); // Output: 3
    }
}
