# Words and Languages

## What is a word, what is a language?

### An informal answer

- A word is a concatenation of symbols ![formula](https://render.githubusercontent.com/render/math?math=w) from a specified alphabet ![formula](https://render.githubusercontent.com/render/math?math=\sum)

- A language ![formula](https://render.githubusercontent.com/render/math?math=L) is a set of words defined by some pattern or formula, like  
![formula](https://render.githubusercontent.com/render/math?math=\lbrace%20a^{n^2}|n\geq0\rbrace%3d\lbrace\epsilon,a,aaaa,aaaaaaaaa,...\rbrace)

Words have a natural and intuitive mathematical structure. We can concatenate words, split a word, and parse sentences naturally. We can also get a section of the word and remove parts to get a new word.

Flughafen -> Flug || Hafen

Baumhaus -> Baum || Haus

It is important to define what Things are Mathematically.
Asking some random person on the street to prove ![formula](https://render.githubusercontent.com/render/math?math=1%2b1=2) would result in some amount of confusion, because we have to first define what numbers actually are.

Now our base set ![formula](https://render.githubusercontent.com/render/math?math=L) is words, our operation in this case concatenation. This can be compared to the set of basic Number operations ![formula](https://render.githubusercontent.com/render/math?math=\lbrace%2b,\times,\div,-\rbrace) which let us operate on numbers with the numbers as our base set.

Here our base set is a set of words ![formula](https://render.githubusercontent.com/render/math?math=W) over some alphabet ![formula](https://render.githubusercontent.com/render/math?math=\Sigma) and our operation is concatenation.

An alphabet ![formula](https://render.githubusercontent.com/render/math?math=\Sigma) is the set of symbols that can be used in the a word.

Therefore for any word ![formula](https://render.githubusercontent.com/render/math?math=w\in%20L) with ![formula](https://render.githubusercontent.com/render/math?math=L) as our language, our set of words, every symbol in ![formula](https://render.githubusercontent.com/render/math?math=s\in%20w), ![formula](https://render.githubusercontent.com/render/math?math=s\in\Sigma)
applies.

- In every language ![formula](https://render.githubusercontent.com/render/math?math=L) there exists an empty word, ![formula](https://render.githubusercontent.com/render/math?math=\epsilon).

- A Language can be finite or not


#### Examples

01, 101001, ![formula](https://render.githubusercontent.com/render/math?math=\epsilon) are words over the alphabet ![formula](https://render.githubusercontent.com/render/math?math=\lbrace0,1\rbrace)

![formula](https://render.githubusercontent.com/render/math?math=\lbrace0,1,101,1001\rbrace) and ![formula](https://render.githubusercontent.com/render/math?math=\lbrace\epsilon,0,1,00,01,10,11,000,001,...\rbrace) are Languages over the alphabet ![formula](https://render.githubusercontent.com/render/math?math=\lbrace0,1\rbrace)

### The Formal Definition

1. A Semigroup ![formula](https://render.githubusercontent.com/render/math?math=(H,\circ)) consists of a set ![formula](https://render.githubusercontent.com/render/math?math=H) and an associative relation ![formula](https://render.githubusercontent.com/render/math?math=\circ:H\times%20H\rightarrow%20H)
2. A _Monoid_ is a semigroup with a neutral element.
3. Let ![formula](https://render.githubusercontent.com/render/math?math=(M,\circ)) be a Monoid and ![formula](https://render.githubusercontent.com/render/math?math=E%20\subseteq%20M)

    ![formula](https://render.githubusercontent.com/render/math?math=E) is a generating system of ![formula](https://render.githubusercontent.com/render/math?math=(M,\circ)), if every ![formula](https://render.githubusercontent.com/render/math?math=m\in%20M) can be represented as ![formula](https://render.githubusercontent.com/render/math?math=m%3De_1\circ%20...\circ%20e_n) with ![formula](https://render.githubusercontent.com/render/math?math=e_i\in%20E)

A neutral element ![formula](https://render.githubusercontent.com/render/math?math=e) is left and right neutral. For every ![formula](https://render.githubusercontent.com/render/math?math=x) applies ![formula](https://render.githubusercontent.com/render/math?math=e\circ%20x%3Dx\circ%20e%3Dx)

Question: Is the neutral element in a monoid clear?

Yes, because ![formula](https://render.githubusercontent.com/render/math?math=e_1\circ%20e_2%3De_1) and ![formula](https://render.githubusercontent.com/render/math?math=e_1\circ%20e_2%3De_2).

#### Examples

- ![formula](https://render.githubusercontent.com/render/math?math=(Z,%2b)) is a monoid.

  ![formula](https://render.githubusercontent.com/render/math?math=\lbrace-1,1\rbrace) is a generating system

- ![formula](https://render.githubusercontent.com/render/math?math=(N_0,%2b)) is a monoid.

  ![formula](https://render.githubusercontent.com/render/math?math=\lbrace1\rbrace) is a generating system

- ![formula](https://render.githubusercontent.com/render/math?math=(Z_8,\cdotp)) is a monoid
  
  ![formula](https://render.githubusercontent.com/render/math?math=\lbrace2,3,5\rbrace) is a generating system

#### Question:

- Is ![formula](https://render.githubusercontent.com/render/math?math=\lbrace-16,17,18\rbrace) a generating system for ![formula](https://render.githubusercontent.com/render/math?math=(Z,%2b))?

  Yes, because: 
  
  ![formula](https://render.githubusercontent.com/render/math?math=-16%2b17%3d1\Rightarrow%20Z=\lbrace-16a%2b17b|a,b\in%20N\rbrace)

Is ![formula](https://render.githubusercontent.com/render/math?math=\lbrace3,5,7\rbrace) a generating system for ![formula](https://render.githubusercontent.com/render/math?math=(Z_8,\cdotp))?

