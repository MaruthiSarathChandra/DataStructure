# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def __init__(self):
        self.dct = dict()
        self.I = 1
    def lowestCommonAncestor(self, root, p, q):
        self.preOrder(root)
        #print(self.dct)
        Index_P = self.dct[p.val]
        Index_Q = self.dct[q.val]
        arr = []
        while Index_P != 0:
            arr.append(Index_P)
            Index_P = Index_P//2
        while Index_Q not in arr:
            Index_Q = Index_Q//2
        result = int(list(self.dct.keys())[list(self.dct.values()).index(Index_Q)])
        return result;
    def preOrder(self,root):
        #print(root.val,"value")
        self.dct[root.val] = self.I 
        if root.left != None:
            self.I = 2*self.I
            self.preOrder(root.left)
        if root.right != None:
            self.I = 2*self.I+1 
            self.preOrder(root.right)
        self.I = self.I//2
        
'''a = Solution()
b = [3,5,1,6,2,0,8,None,None,7,4]
a.lowestCommonAncestor(b,5,1)'''
