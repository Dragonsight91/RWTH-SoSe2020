from nfa_simulate import NFA, LinkedList
import os
def run():
    workdir = os.path.dirname(os.path.abspath(__file__))
    
    states = tuple(range(1, 35)) # list of states 1 -> 34
    nfa = NFA(states)
    
    with open(os.path.join(workdir, "2020_H09.trans"), "r") as f:
        lines = f.readlines()
        for line in lines:
            transition = line.rstrip("\n").split(" ")
            nfa.add_transition(transition[0], transition[1], transition[2])

    word = LinkedList()
    with open(os.path.join(workdir, "2020_H09_input"), "r") as f:
        for i in "ababbbaababaa": # f.read().split("\n")[0]:
            word.add(i)
    print("Made linked list")

    out = nfa.simulate(7, word)
    print("")
    
    
    arr = set([i.state for i in out])
    print(arr)

if __name__ == "__main__":
    run()

# 