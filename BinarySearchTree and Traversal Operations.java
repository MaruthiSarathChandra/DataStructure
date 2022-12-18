public class BinarySearchTree {
    BinarySearchTree lchild;
    int root;
    BinarySearchTree rchild;
    BinarySearchTree(int data) {
        this.lchild = null;
        this.root = data;
        this.rchild = null;
    }
    public void Insert(BinarySearchTree self,int key) {
        if (self.root > key) {
            //this condition is to insert node at left-subtree of root(or)parent node
            if (self.lchild == null) {
                //this condition create a node(obj) and insert to last leaf of left-subtree
                BinarySearchTree new_node = new BinarySearchTree(key);
                self.lchild = new_node;
            } else {
                //this condition call insertion operation for the last visited node as 1st parameter and data is same as above
                Insert(self.lchild,key);
            }
        }else if (self.root < key) {
            //this condition is to insert node at right-subtree of root (or) parent node
            if (self.rchild == null) {
                //this condition create a node(obj) and insert to last leaf of right-subtree
                BinarySearchTree new_node = new BinarySearchTree(key);
                self.rchild = new_node;
            } else {
                //this condition call insertion operation for the last visited node as 1st parameter and data is same as above
                Insert(self.rchild,key);
            }
        } else {
            if (self.root == key) {
                //if the duplicate values are given then it check for if right subtree is empty then it goto if condition and creates an node and insert at last visited leaf node else
                // it calls insertion operation for the last visited node as 1st parameter and data as 2nd.
                if (self.rchild == null){
                    BinarySearchTree new_node = new BinarySearchTree(key);
                    self.rchild = new_node;
                } else {
                    Insert(self.rchild,key);
                }
            }
        }
    }
    public BinarySearchTree delete(BinarySearchTree self,int key,int root) {
        //self refers to root node,key refers to the which node we are going to delete or should delete,root refers to rootnode key value
        if (self.root > key) {
            if (self.lchild == null) {
                System.out.println("Element is not found l");
            } else {
                self.lchild = delete(self.lchild, key, root);
            }
        } else if (self.root < key) {
            if (self.rchild == null) {
                System.out.println("Element is not found r");
                //return self;
            } else {
                self.rchild = delete(self.rchild, key, root);
            }
        } else {
            if (self.root == key) {
                if (self.lchild == null) {
                    BinarySearchTree new_node = self.rchild;
                    if (self.root == root) {
                        self.root = self.rchild.root;
                        self.lchild = self.rchild.lchild;
                        self.rchild = self.rchild.rchild;
                        new_node = null;
                        return self;
                    }
                    self = null;
                    return new_node;
                }else if (self.rchild == null){
                    BinarySearchTree new_node = self.lchild;
                        if (self.root == root) {
                            self.root = self.lchild.root;
                            self.lchild = self.lchild.lchild;
                            self.rchild = self.lchild.rchild;
                            new_node = null;
                            return self;
                        }
                        self = null;
                        return new_node;
                } else {
                    self.root = max(self.rchild);
                    self.rchild = delete(self.rchild, self.root, root);
                    System.out.println(key + " Elements is deleted");
                }
            }
        }return self;
    }
    public void searching(BinarySearchTree self,int root) {
        if (self.root > root) {
            if (self.lchild == null) {
                System.out.println("Element not found");
                return;
            } else {
                searching(self.lchild,root);
            }
        } else if (self.root < root) {
            if (self.rchild == null) {
                System.out.println("Element not found");
                return;
            } else {
                searching(self.rchild,root);
            }
        } else {
            System.out.println("Element found"+self.root);
        }
    }
    public int max(BinarySearchTree self){
        if (self.lchild == null) {
            return self.root;
        } return max(self.lchild);
    }
    // this the function to traverse the bst in preorder
    public int preOrder(BinarySearchTree self){
        System.out.print(self.root+"--->");
        if (self.lchild != null) {
            inOrder(self.lchild);
        }
        if (self.rchild != null){
            inOrder(self.rchild);
        }return 0;
    }
    //this the function to traverse the bst in inorder
    public int inOrder(BinarySearchTree self) {
        if (self.lchild != null) {
            inOrder(self.lchild);
        } System.out.print(self.root+"--->");
        if (self.rchild != null){
            inOrder(self.rchild);
        } return 0;
    }
    //this the function to traverse the bst in postorder
    public int postOrder(BinarySearchTree self) {
        if (self.lchild != null) {
            postOrder(self.lchild);
        }
        if (self.rchild != null){
            postOrder(self.rchild);
        }
        System.out.print(self.root+"--->");
        return 0;
    }

    public static void main(String args[]) {
        BinarySearchTree obj = new BinarySearchTree(10);
        obj.Insert(obj,1);
        Integer[] list = {9,13,35,2,5,15,25,6,21,20,11,12,22,14,4};
        for(int i:list){
            obj.Insert(obj,i);
        }
        obj.inOrder(obj);
        System.out.println("");
        obj.delete(obj,10,obj.root);
        obj.searching(obj,100);
        System.out.println("preOrder");
        obj.preOrder(obj);
        System.out.println("");
        System.out.println("inOrder");
        obj.inOrder(obj);
        System.out.println("");
        System.out.println("postOrder");
        obj.postOrder(obj);
    }
}
