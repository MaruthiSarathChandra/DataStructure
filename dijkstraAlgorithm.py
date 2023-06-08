
matrix = {
    "A": {"B":2, "C": 4},
    "B": {"A": 2,"C": 1, "D": 7},
    "C": {"E": 3,"A":4,"B": 2},
    "D": {"F": 1, "B": 4,"E": 2},
    "E": {"D": 2, "F": 5},
    "F": {"D": 1,"E": 5}
}


#this dct dictonary is used to store shortest distance of each node
dct = dict()
#this visited dictonary is used to store whether the node is visited or not this will decrease the time complexity.without this it may lead to Exception maximum recursion
visited = dict()
for i in matrix.keys():
    dct[i] = float("inf")
    visited[i] = False
    
    
    
def dijkstraAlgorithm(node):
    if visited[node]:
        return node
    for i in matrix[node].items():
        if dct[i[0]] > dct[node] + i[1]:
            dct[i[0]] = dct[node] + i[1]
            visited[node] = True
        dijkstraAlgorithm(i[0])

dct["A"] = 0
dijkstraAlgorithm("A")


print(dct["F"])
