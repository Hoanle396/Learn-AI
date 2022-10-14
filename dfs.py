def dfs_paths(graph, start, goal):
    stack = [(start, [start])]
    visited = set()
    while stack:
        (vertex, path) = stack.pop()
        if vertex not in visited:
            if vertex == goal:
                return path
            visited.add(vertex)
            for neighbor in graph[vertex]:
                stack.append((neighbor, path + [neighbor]))
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

print (dfs_paths(graph, 'A', 'L'))