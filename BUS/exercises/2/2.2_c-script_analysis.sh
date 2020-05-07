S=0

# find and loop through all files in current 
# directory with the ".c" file extension
for f in $(find . -name "*.c"); do

    # wc -l $f          -> get the line count for the current file
    # awk '{ print $1 } -> get the bare number from piped command
    # $S + $(expr)      -> add var S and the value of expr
    # S=$(expr)         -> set S to value of expr


    # set S += the amount of lines in each file

    S=$( ( $S + $( wc -l $f | awk '{ print $1 }' ) ) )

done

# value of S is now the sum of file lengths in lines a

# print S to CLI
echo $S
