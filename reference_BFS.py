import Queue

g = {
	'A': ['B', 'C','E'],
	'B': ['A','C', 'D'],
	'C': ['D'],
	'D': ['C'],
	'E': ['F','D'],
	'F': ['C']
	}

q = Queue.Queue()
def BFS(origin, destination):
	
	paths = []
	q.put([origin])
	
	while q.empty() == False:
		tmp_path = q.get()
		last_node = tmp_path[-1]

		if last_node == destination:
			#print "valid path : ",tmp_path
			paths.append(tmp_path)

		if g.get(str(last_node)) is not None:
			for link_node in g[last_node]:
				if link_node not in tmp_path:
					new_path = tmp_path + [link_node]
					q.put(new_path)

	for path in paths:
		print path

BFS("A","D")
