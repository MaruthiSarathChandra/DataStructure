#testcase graph 1 
adjList = {
    "A": {"B":2, "C": 4},
    "B": {"A": 2,"C": 1, "D": 7},
    "C": {"E": 3,"A":4,"B": 2},
    "D": {"F": 1, "B": 4,"E": 2},
    "E": {"D": 2, "F": 5},
    "F": {"D": 1,"E": 5}
}

# testcase graph 2 
adjList_1 = {
    "A": {"B": 50, "D": 10, "C": 45},
    "B": {"D": 15, "C": 10},
    "C": {"E": 30},
    "D": {"A": 10, "E": 15},
    "E": {"B": 20, "C": 35},
    "F": {"E": 3}
}

#this dct dictonary is used to store shortest distance of each node
dct = dict()
for i in adjList_1.keys():
    dct[i] = float("inf")

def dijkstraAlgorithm(node):
    if node not in adjList_1.keys():
        return 
    for i in adjList_1[node].items():
        if dct[i[0]] > dct[node] + i[1]:
            dct[i[0]] = dct[node] + i[1]
            dijkstraAlgorithm(i[0])

dct["A"] = 0
dijkstraAlgorithm("A")

print(dct["B"]) 
#call the destination node u choose from dct dictonary which gives the shortest distance value from starting node to destination node after the exicution of dijkstraAlgorithm algorithm 

