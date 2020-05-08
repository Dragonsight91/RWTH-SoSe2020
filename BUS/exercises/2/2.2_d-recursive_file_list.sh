#!/bin/bash
function list_dirs() {
    DIRLIST=$(find $1 -maxdepth 1 -type d) # get all subdirectories. 
    FLIST=$(find $1 -maxdepth 1 -type f)   # get all files in directory


    IFS=$'\n'
    # open all directories
    for i in $DIRLIST; do
        # are we trying to open ourselves?
        if [[ $1 != $i ]]; then

            # there's some weirdness going on
            printf "%$(($2 + 2))s\e[1m\e[4m\e[38;5;6mDIRECTORY:\e[0m $(echo $i) \n"

            # recursive open
            list_dirs "${i}" $(($2 + 2))
        else

            # if we are in the root directory, we can print that, otherwise we don't care
            if [[ $i == $PWD ]] | [[ $i == "." ]]; then
                printf "\n%${2}s\e[1m\e[4m\e[38;5;6mDIRECTORY:\e[0m $(echo $PWD | sed 's_^.^/\b__') \n"
            fi
            # list all files in directory
            for j in $FLIST; do
                # if it's not empty
                if [[ $j != -z ]]; then
                    # print the current file
                    printf "%$(($2 + 2))s\e[1mFILE:\e[0m \e[93m$(echo $j)\e[0m \n"
                fi
            done
        fi
    done
}

if [[ -z $1 ]]; then
    list_dirs $PWD 0
else
    list_dirs $1 0
fi
