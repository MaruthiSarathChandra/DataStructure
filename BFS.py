
#BFS testcase graph 1
adjList = {
    "A": ["B","C"],
    "B": ["A","C","D"],
    "C": ["E","A","B"],
    "D": ["B","E"], #"F"
    "E": ["D"], #"F"
    "F": [],
    "G": []
}

#BFS testcase graph 2
adjList_1 = {
    "A": ["B","D","C"],
    "B": ["D","C"],
    "C": ["E"],
    "D": ["A","E"],
    "E": ["B","C"],
    "F": ["E"],
    "G": []
}

 
class TraversalAlgorithm:
    def __init__(self,graph):
        self.queue = []
        self.dct = dict()
        self.graph = graph
        
        for _ in self.graph.keys():
            self.dct[_] = True
            
    def BFS(self,node,i):
        if node not in self.graph.keys():
            return 
    
        if node not in self.queue:
            self.queue.append(node)
        self.dct[node] = False
    
        for _ in self.graph[node]:                              #TimeComplexity = O(|V|)
            if self.dct[_] == True and _ not in self.queue:
                self.queue.append(_)
    
        self.queue.remove(node)
        print(node,end="-->")
    
        if i == 0: 
            while self.queue != []:                             #TimeComplexity = O(n) - isolated nodes
                self.BFS(self.queue[0],i+1)
            for nodes,bol in self.dct.items():                  #Timecomplexity = O(n)
                if bol == True:
                    self.BFS(nodes,i+1)
                    


obj = TraversalAlgorithm(adjList)
obj.BFS("A",0)
print()
obj = TraversalAlgorithm(adjList_1)
obj.BFS("D",0)
    
    
 '''
 --------Analysis of above algorithms---------
 
 1.Breadth-First-Search:
    Time Complexity:
        BestCase: O(n)
        WorstCase: Sum of all edges of each node + number of nodes
                O(|v|) + O(n-isolatedNodes) + O(n)
                => let v = n
                =>O(n+n+n) => O(3n) => O(n)
                
        Space Complexity: Space used by Queue + Space used by dct Dictonary
                => O(|n| + |n|)
                => O(n)
'''






'''
BELOW CODE MAY USEFUL TO U IF U DON'T UNDERSTAND ABOVE CODE:

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

# BFS testcase graph 1
adjList_1 = {
    "A": ["B","D","C"],
    "B": ["D","C"],
    "C": ["E"],
    "D": ["A","E"],
    "E": ["B","C"],
    "F": ["E"],
    "G": []
}

dct = {}
for _ in adjList.keys():
    dct[_] = False



#Depth-First-Search
def DFS(node,i):
    if node not in adjList.keys():
        return 
    
    dct[node] = True
    print(node,end="-->")
    
    for cur_node in adjList[node]:      #TimeComplexity = O(|V|) + O(n - isolatedNodes)
        if dct[cur_node] == False:
            DFS(cur_node,i+1)
            
    if i==0:        
        for cur_node,bol in dct.items():    #TimeComplexity = O(n)
            if bol == False:
                DFS(cur_node,1)
                


queue = []

#Breadth-First-Search 
def BFS(node,i):
    if node not in adjList_1.keys():
        return 
    
    if node not in queue:
        queue.append(node)
    dct[node] = False
    
    for _ in adjList_1[node]:               #TimeComplexity = O(|V|)
        if dct[_] == True and _ not in queue:
            queue.append(_)
    
    queue.remove(node)
    print(node,end="-->")
    
    if i == 0: 
        while queue != []:                  #TimeComplexity = O(n) - isolated nodes
            BFS(queue[0],i+1)
        for nodes,bol in dct.items():       #Timecomplexity = O(n)
            if bol == True:
                BFS(nodes,i+1)
    
DFS("A",0)
print()
BFS("A",0)


 '''
