from nfa_simulate import NFA
import os
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
        word = f.read().split("\n")[3]    

    print(len(word))
    out = nfa.simulate(7, word)

    print(str(out))

if __name__ == "__main__":
    run()

# 