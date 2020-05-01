from typing import Iterable, Generic, TypeVar, Set, List

S, A= TypeVar('S'),TypeVar('A')

class NFA(Generic[S, A]):
    def __init__(self, Q: Set[S]):
        self.Q = Q
        self.nodes = dict()

        for q in Q:
            self.nodes.update(
                {str(q): dict()}
            )

    def addTransition(self, q: S, a: A, p: S) -> None:
        temp = self.nodes.get(q)
        target = temp.get(a)

        if target:
            target.add(p)

        else:
            target = set()
            target.add(str(p))
            temp.update(
                { str(a): target }
            )
    
    def simulate(self, q: S, word: List[A]) -> Set[S]:
        temp = set()
        temp.add(str(q))

        for a in word:
            temp = self.step(temp, a)

        return temp

    def step(self, qset: Set[S], a: A) -> Set[S]:
        out = set()

        for p in qset:
            temp = self.nodes.get(p)
            if(temp != None and temp.get(a) != None):
               out = out.union(temp.get(a))
        
        return out

    