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

mensch(X).

verheiratet(werner, monika).
verheiratet(gerd, renate).
verheiratet(klaus, susanne).

mutterVon(monika, karin).
mutterVon(monika, klaus).
mutterVon(renate, susanne).
mutterVon(renate, peter).
mutterVon(susanne, aline).
mutterVon(susanne, dominik).

%Regeln
vaterVon(V,K)    :- verheiratet(V,F), mutterVon(F,K).

elternteil(X,Y) :- mutterVon(X,Y).
elternteil(X,Y) :- vaterVon(X,Y).

vorfahre(V,X)    :- elternteil(V,X).
vorfahre(V,X)    :- elternteil(V,Y), vorfahre(Y,X).


