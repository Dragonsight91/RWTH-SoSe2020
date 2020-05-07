#!/bin/bash

# test if argumaents were given
if [ -z $1 ] | [ -z $2 ]
then
    echo "The syntax is: command {PID} {TIME}"
    exit
fi

# save data to variables
PID=$1
TIME=$2

PROCESS="$(ps ${PID} | grep ${PID})"

# while process is running
while [[  -n  $PROCESS ]]; do
    
    echo "process ${PID} running"
    sleep $TIME
    PROCESS="$(ps ${PID} | grep ${PID})"

done

echo "Process not running"