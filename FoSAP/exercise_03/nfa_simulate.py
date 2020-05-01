class NFA_Node:
    def __init__(self, state: any):
        self.state = state
        self.transitions = {}


    def add_transition(self, w: any, state) -> None:
        if not f'{w}_state' in self.transitions.keys():
            self.transitions[f'{w}_state'] = []

        self.transitions[f'{w}_state'].append(state)

    def get_transitions(self, w) -> list:
        try:
            return self.transitions[f'{w}_state']
        except:
            return None

    def __str__(self):
        return str(self.transitions)


class NFA(object):
    def __init__(self, states: tuple):
        self.nodes = {}
        self.__add_nodes(states)

    def __str__(self):
        return str(self.nodes)

    def __add_nodes(self, states: any) -> None:
        for state in states:
            self.nodes[f'{state}_node'] = NFA_Node(state)

    # q -> from state
    # w -> with word
    # p -> next state 
    def add_transition(self, q: any, w: any, p: any) -> None:
        self.nodes[f'{q}_node'].add_transition(w, self.nodes[f'{p}_node'])

    def simulate(self, q: any, input) -> list:
        out = list()

        linkList = input
        start = self.nodes[f'{q}_node']
        out = self.find_path(linkList.head, start.get_transitions(linkList.head.value))
        return out

    def find_path(self, input, nodeList: list):
        if not input.next:
            return nodeList

        if len(nodeList) == 0:
            return []

        out = []
        for node in nodeList:
            transitions = node.get_transitions(input.next.value)
            if transitions:
                temp = self.find_path(input.next, transitions)
    
                if temp:
                    out += temp 
        return out




# utility classes
class LinkedList(object):
    def __init__(self):
        self.head = None
        self.curr = None
        self.tail = None
    
    def next(self) -> any:
        out = self.curr
        self.curr = self.curr.next

        return out

    def add(self, val: any) -> None:
        if not self.head:
            self.head = ListNode(val)
            self.curr = self.head
            self.tail = self.head
        else:
            node = ListNode(val)
            self.tail.next = node
            self.tail = node

            

    def __str__(self):
        return str(self.head)

class ListNode(object):
    def __init__(self, value):
        self.value = value
        self.next = None

    def __str__(self):
        if self.next:
            return f'{self.value}, {self.next.__str__()}'
        else:
            return self.value