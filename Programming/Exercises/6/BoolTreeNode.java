class BoolTreeNode {

    //Attribute hier einfügen

    (access) BoolTreeNode(String variableInput) {

    }

    (access) BoolTreeNode(BoolTreeNode negated) {

    }

    (access) BoolTreeNode(BoolTreeNode conjunct1, BoolTreeNode conjunct2) {

    }

    (access) (static) BoolTreeNode boolTreeVariableNode(String variableInput) {

    }

    (access) (static) BoolTreeNode boolTreeAndNode(BoolTreeNode conjunct1, BoolTreeNode conjunct2) {

    }

    (access) (static) BoolTreeNode boolTreeNotNode(BoolTreeNode negated) {

    }

    (access) (static) BoolTreeNode boolTreeTrueNode() {

    }

    (access) (static) BoolTreeNode boolTreeFalseNode() {

    }

    public boolean evaluate(String... trueVars) {

    }

    public int depth() {

    }

    public boolean isLeaf() {

    }

    public boolean isTrueLeaf() {

    }

    public boolean isFalseLeaf() {

    }

    public boolean isNegation() {

    }

    public boolean isConjunction() {

    }

    public boolean removeDoubleNegations() {

    }

    public static void main(String[] args) {

    }
}
