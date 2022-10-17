from itertools import combinations, permutations


def replacements():
    for comb in combinations(range(10), 8):
        for perm in permutations(comb):
            if perm[0] * perm[1] != 0:
                yield dict(zip('SMENDORY', perm))


a, b, c = 'SEND', 'MORE', 'MONEY'

for replacement in replacements():
    def f(x): return sum(replacement[e] * 10**i for i, e in enumerate(x[::-1]))
    if f(a) + f(b) == f(c):
        print('{} + {} = {}'.format(f(a), f(b), f(c)))
