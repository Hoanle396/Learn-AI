def bfs(graph, start, goal):
    queue = []
    queue.append([start])
    while queue:
        current_path = queue.pop(0)
        node = current_path[-1]
        if node == goal:
            return current_path
        for adjacent in graph.get(node, []):
            new_path = list(current_path)
            new_path.append(adjacent)
            queue.append(new_path)

graph = {'A': set(['E', 'F','B']),
         'B': set(['A', 'C']),
         'C': set(['B','D', 'F']),
         'D': set(['C','G']),
         'E': set(['A', 'I']),
         'F': set(['A', 'C','J']),
         'G': set(['D', 'J','K','H']),
         'H': set(['G', 'O']),
         'I': set(['E', 'J', 'M','N']),
         'J': set(['I', 'F','G']),
         'K': set(['G', 'O']),
         'L': set(['P']),
         'M': set(['I']),
         'N': set(['I','O']),
         'O': set(['K','H','N','P']),
         'P': set(['L', 'O']),
         }
print(bfs(graph, 'A', 'L'))
