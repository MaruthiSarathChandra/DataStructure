#DFS testcase graph 1
adjList = {
    "A": ["B","C"],
    "B": ["A","C","D"],
    "C": ["E","A","B"],
    "D": ["B","E"], #"F"
    "E": ["D"], #"F"
    "F": [],
    "G": []
}

# DFS testcase graph 2
adjList_1 = {
    "A": ["B","D","C"],
    "B": ["D","C"],
    "C": ["E"],
    "D": ["A","E"],
    "E": ["B","C"],
    "F": ["E"],
    "G": []
}

queue = []
dct = {}
for _ in adjList.keys():
    dct[_] = False


#Depth-First-Search
class TraversalAlgorithm:
    
    def __init__(self,graph):
        self.dct = dict()
        self.graph = graph
        
        for _ in self.graph.keys():
            self.dct[_] = False
        
    def DFS(self,node,i):
        if node not in self.graph.keys():
            return 
        
        self.dct[node] = True
        print(node,end="-->")
        
        for cur_node in self.graph[node]:      #TimeComplexity = O(|V|) + O(n - isolatedNodes)
            if self.dct[cur_node] == False:
                self.DFS(cur_node,i+1)
                
        if i==0:        
            for cur_node,bol in self.dct.items():    #TimeComplexity = O(n)
                if bol == False:
                    self.DFS(cur_node,1)
               

obj = TraversalAlgorithm(adjList)   
obj.DFS("A",0)
print()
obj = TraversalAlgorithm(adjList_1)
obj.DFS("G",0)



'''
 --------Analysis of above algorithms---------
 
1.Depth-First-Search:
    Time Complexity:
        BestCase: O(n)
        WorstCase: O(n)
    Space Complexity: Space used by dct Dictonary
                => O(n)
'''
