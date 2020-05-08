
# 2.4 a)
# print files and file sizes only
# ls -sh -> list all files and directories with size
# grep -ve "^[total]" -> strip the total dir size
ls -sh | grep -ve "^[total]"


# 2.4 b)
# for ls and grep, see 2.4 a)
# awk '{ t = $1; $1 = $2; $2 = t; print; }' -> switch columns
ls -sh | grep -ve "^[total]" | awk '{ t = $1; $1 = $2; $2 = t; print; }'

# 2.4 c)
# GROUP=1 echo $() -> provide a variable to the command, set it to value 1-4 to get groupings of 1-3 people or the nullgroup
# sort teamnamen.txt | uniq -c -> initial setup, get all the teamnames grouped together, including empty
# awk '{print $1}' | sort -n | uniq -c -> get all groups of size n, to match anything else
# head -n $GROUP | tail -n 1 -> get the group we specified in GROUP
GROUP=1 echo $(sort teamnamen.txt | uniq -c | awk '{print $1}' | sort -n | uniq -c | head -n $GROUP | tail -n 1)

# 2.4 d)
# sort teamnamen.txt | uniq -c -> initial setup, get all the teamnames grouped together, including empty
# awk '{print $1}' | sort -n  | uniq -c -> get the amount of groups of size n and empty
# awk '{if ($2!="1" && $2!="2" && $2!="3") print "\n"$2, "Nullgroup"; else print $1, $2}' -> formatting & pretty printing
sort teamnamen.txt | uniq -c | awk '{print $1}' | sort -n | uniq -c | awk '{if ($2!="1" && $2!="2" && $2!="3") print "\n"$2, "Nullgroup"; else print $1, $2}'

