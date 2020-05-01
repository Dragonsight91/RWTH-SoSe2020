%Fakten ueber die Verwandtschafts-Problemwelt
weiblich(monika).
weiblich(karin). 
weiblich(renate). 
weiblich(susanne). 
weiblich(aline).    


maennlich(werner). 
maennlich(klaus). 
maennlich(gerd).
maennlich(peter).
maennlich(dominik).

mensch(_).

verheiratet(werner, monika).
verheiratet(gerd, renate). 
verheiratet(klaus, susanne).

mutterVon(monika, karin). 
mutterVon(monika, klaus). 
mutterVon(renate, susanne).
mutterVon(renate, peter).
mutterVon(susanne, aline). 
mutterVon(susanne, dominik). 

geboren(monika, datum(25,7,1972)).
geboren(werner, datum(12,7,1969)).

%Regeln
vaterVon(V,K)    :- verheiratet(V,F), mutterVon(F,K).

elternteil(X,Y) :- mutterVon(X,Y).
elternteil(X,Y) :- vaterVon(X,Y).

vorfahre(V,X)    :- elternteil(V,X).
vorfahre(V,X)    :- elternteil(V,Y), vorfahre(Y,X).


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Programm mit selbstdefinierter Datenstruktur fuer Zahlen
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

add(X, zero, X).
add(X, succ(Y), succ(Z)) :- add(X, Y, Z).
    
mult(X, zero, zero).
mult(X, succ(Y), Z) :- mult(X, Y, U), add(X,U,Z).



%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Programm mit selbstdefinierter Datenstruktur fuer Listen
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

len(nil, zero).
len(cons(Kopf, Rest), succ(N)) :- len(Rest, N).




%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Programm mit vordefinierter Datenstruktur fuer Listen
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

leng([], zero).
leng([Kopf | Rest], succ(N)) :- leng(Rest, N).
