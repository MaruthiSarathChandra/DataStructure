
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

queue = []
dct = {}
for _ in adjList.keys():
    dct[_] = False



#Depth-First-Search
def DFS(node,i):
    if node not in adjList.keys():
        return 
    
    dct[node] = True
    print(node,end="-->")
    
    for cur_node in adjList[node]:
        if dct[cur_node] == False:
            DFS(cur_node,i+1)
            
    if i==0:        
        for cur_node,bol in dct.items():
            if bol == False:
                DFS(cur_node,1)


                
 
#Breadth-First-Search 
def BFS(node,i):
    if node not in adjList_1.keys():
        return 
    
    if node not in queue:
        queue.append(node)
    dct[node] = False
    
    for _ in adjList_1[node]:
        if dct[_] == True and _ not in queue:
            queue.append(_)
    
    queue.remove(node)
    print(node,end="-->")
    
    if i == 0: 
        while queue != []:
            BFS(queue[0],i+1)
        for nodes,bol in dct.items():
            if bol == True:
                BFS(nodes,i+1)
    
DFS("A",0)
print()
BFS("A",0)


  
  
 '''
 
 --------Analysis of above algorithms---------
 
 1.Breadth-First-Search:
    Time Complexity:
    BestCase: O(n)
    WorstCase: Sum of all edges of each node + number of nodes
                O(n + n) = O(2n) => O(n)
    Space Complexity: O(|V|+|n|) = O(n)

'''
