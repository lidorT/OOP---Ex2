# Read Me

#### This is an object oriented programmin project which his main idea is based on Graphs. 

#### This project will be the base to a future navigation system project.

#### This project was wrriten by Zohar Meir & Lidor Tal during our Object Oriented Programming course at Ariel University with the guidance of Professor Boaz Ben Moshe all rights reserved to us ©.

#### This project contains an stdDraw interface which was created by Robert Sedgewick and Kevin Wayne ©.

#### On this project you will find three kinds of objects : 

**[Node -](https://github.com/lidorT/Ex1---OOP/wiki/Monom)** Node represents the vertexes of the graph.

**[Edge -](https://github.com/lidorT/Ex1---OOP/wiki/Polynom)** Edge represents an edge on the graph.

**[DGraph-](https://github.com/lidorT/Ex1---OOP/wiki/Complex-Function)** represents the graph itself.

* In order to search a vertex or an edge or simply to pull data from the Graph withing the lowest running time complexity we used HashMap data structure in order to do some activites at the most efficient way. 

* Our idea represented at the next form:

Each DGraph has vertexes (Nodes) and Edges, Each DGraph has a HashMap field of his Nodes and each Node has also a HashMap field which contatins each of his Edges.

for example to get a spesific edge we will search this edge inside the Nodes HashMap and for each node we will seach on his Edges HashMap. 

a DGraph can be initialize from a general Graph type and also represents his values on a GUI , DGraph can also be saved to text file or beeing loaded form one.

There is also a class Named Graph_Algo that suppourts someo actions such as "Is Connected" - checks if a graph is Strongly Connected , "Shortest Path" return the shortest path between two vertices, "TSP" that returns the Thrill Shorted Path between input nodes.

* In general this projcet is the base of future navigation system project which will be created later on.

example of the plot :

![ExampleOfPlot](https://media.giphy.com/media/U2F9HnI1Xqy2ypJaOb/giphy.gif)
