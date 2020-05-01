add(X, zero, X).
add(X, succ(Y), succ(Z)) :- add(X, Y, Z).

mutter(renate,susanne).
mutter(susanne,aline).

vorfahre(V,X) :- mutter(V,X).
vorfahre(V,X) :- mutter(V,Y), vorfahre(Y,X).

gleich(X,X).

memb(X, [Y|_]) :- X = Y.
memb(X, [_|L]) :- memb(X,L).

mem(X, [X|_]).
mem(X, [_|L]) :- mem(X,L).

leng([], zero).
leng([_ | Rest], succ(N)) :- leng(Rest, N).

len([], 0).
len([_ | Rest], M) :- len(Rest, N), M is N + 1.

