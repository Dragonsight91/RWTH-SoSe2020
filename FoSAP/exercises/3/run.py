from nfa_simulate import NFA
import os
from time import time
def run():
    workdir = os.path.dirname(os.path.abspath(__file__))
    
    states = set(range(1, 35)) # list of states 1 -> 34
    nfa = NFA(states)
    
    with open(os.path.join(workdir, "2020_H09.trans"), "r") as f:
        lines = f.readlines()
        for line in lines:
            transition = line.rstrip("\n").split(" ")
            nfa.addTransition(transition[0], transition[1], transition[2])

    with open(os.path.join(workdir, "2020_H09_input"), "r") as f:
        words = f.read().split("\n")   

    

    for index, word in enumerate(words):
        print()
        start = time()
        out = nfa.simulate(7, word)
        print(f'Word {index}: {time()-start}s')
        print(f'Length: {len(word)}')
        print(f'Results: {str(out)}')

if __name__ == "__main__":
    run()