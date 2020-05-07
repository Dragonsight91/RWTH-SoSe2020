#!/bin/bash

function list_dirs {
    FLIST=$(find $1 -maxdepth 1 -type f | sed 's/.\//_\//')
    IFS='_'
    
    read -r FILES <<< "${FLIST}"
    for i in "${FILES[@]}";
    do
        echo "$i"
    done
    
}

if [[ -z $1 ]]; then
    list_dirs "./"
fi